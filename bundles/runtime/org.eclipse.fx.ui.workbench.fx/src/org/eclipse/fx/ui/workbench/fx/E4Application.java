/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService.DefaultProgressState;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService.ProgressState;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.fx.ui.workbench.base.AbstractE4Application;
import org.eclipse.fx.ui.workbench.fx.internal.GraphicsLoaderImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.prefs.BackingStoreException;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * default e4 application
 */
@SuppressWarnings("restriction")
public class E4Application extends AbstractE4Application {

	static org.eclipse.fx.core.log.Logger LOGGER = LoggerCreator.createLogger(E4Application.class);

	E4Workbench workbench;
	Location instanceLocation;
	IEclipseContext workbenchContext;

	private static final String PRIMARY_STAGE_KEY = "primaryStage"; //$NON-NLS-1$
	private static final String CREATE_WORKBENCH_ON_NON_UI_THREAD_ARG = "createWorkbenchOnNonUIThread"; //$NON-NLS-1$

	static E4Application SELF;

	IApplicationContext applicationContext;
	Object returnValue;
	protected EventAdmin eventAdmin;

	StartupProgressTrackerService startupService;

	/**
	 * Gets the {@link E4Application}.
	 * <p>
	 * The {@link E4Application} is not available prior to calling the
	 * {@link #start(IApplicationContext)} by the equinox's launcher.
	 *
	 * @return the instance of the {@link E4Application}.
	 */
	public static @NonNull E4Application getE4Application() {
		E4Application self = SELF;
		if( self == null ) {
			throw new IllegalStateException("Application not yet initialized"); //$NON-NLS-1$
		}
		return self;
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		SELF = this;
		this.applicationContext = context;

		Bundle b = FrameworkUtil.getBundle(AbstractJFXApplication.class);
		BundleContext bundleContext = b.getBundleContext();
		ServiceReference<EventAdmin> ref = bundleContext.getServiceReference(EventAdmin.class);
		if (ref != null) {
			this.eventAdmin = bundleContext.getService(ref);
		}

		ServiceReference<StartupProgressTrackerService> serviceReference = bundleContext.getServiceReference(StartupProgressTrackerService.class);
		if( serviceReference != null ) {
			this.startupService = bundleContext.getService(serviceReference);
			this.startupService.osgiApplicationLaunched(this.applicationContext);
		} else {
			// if the service is not available we make sure to bring the splash down
			this.applicationContext.applicationRunning();
		}

		launchE4JavaFxApplication();

		try {
			return this.returnValue == null ? IApplication.EXIT_OK : this.returnValue;
		} finally {
			this.returnValue = null;
		}
	}

	/**
	 * Binds the given {@link Application} to the {@link E4Workbench} and
	 * launches the application.
	 * <p>
	 * If the {@link E4Workbench} has not been initialized yet then the
	 * {@link #initE4Workbench(IApplicationContext, Application, Stage)
	 * initE4Workbench} method will be called before launching the application.
	 *
	 * @param context
	 *            the {@link IApplicationContext}.
	 * @param jfxApplication
	 *            the {@link Application}.
	 * @param primaryStage
	 *            the primary stage associated with the given
	 *            {@link Application}.
	 */
	public void jfxStart(IApplicationContext context, Application jfxApplication, Stage primaryStage) {
		updateStartupState(DefaultProgressState.JAVAFX_INITIALIZED);

		Runnable startRunnable = new Runnable() {
			@Override
			public void run() {
				if (E4Application.this.workbench == null) {
					if(! initE4Workbench(context, jfxApplication, primaryStage) ) {
						calculateReturnValue();
						return;
					}
				}

				E4Workbench workbench = E4Application.this.workbench;
				if( workbench == null ) {
					throw new IllegalStateException("Not workbench instance yet available"); //$NON-NLS-1$
				}

				IEclipseContext wbContext = workbench.getContext();
				if( wbContext == null ) {
					throw new IllegalStateException("The workbench has no context assigned"); //$NON-NLS-1$
				}

				UISynchronize uiSync = workbench.getContext().get(UISynchronize.class);
				uiSync.syncExec(() -> {
					E4Application.this.instanceLocation = (Location) wbContext.get(E4Workbench.INSTANCE_LOCATION);
					try {
						if (!checkInstanceLocation(E4Application.this.instanceLocation, wbContext)) {
							updateStartupState(DefaultProgressState.LOCATION_CHECK_FAILED);
							return;
						}

						// Create and run the UI (if any)
						workbench.createAndRunUI(E4Application.this.workbench.getApplication());
					} finally {
						postJfxStarted(context);
					}
				});
			}
		};

		if (getArgValue(CREATE_WORKBENCH_ON_NON_UI_THREAD_ARG, context, true) != null) {
			Thread t = new Thread(startRunnable);
			t.start();
		} else {
			startRunnable.run();
		}
	}

	@Override
	protected void preLifecycle(IEclipseContext appContext) {
		super.preLifecycle(appContext);
		appContext.set(GraphicsLoader.class, ContextInjectionFactory.make(GraphicsLoaderImpl.class, appContext));
	}

	/**
	 * Stops the application.
	 */
	public void jfxStop() {
		calculateReturnValue();
		try {
			if (this.workbenchContext != null && this.workbench != null) {
				// Save the model into the targetURI
				if (getLifecycleManager() != null) {
					ContextInjectionFactory.invoke(getLifecycleManager(), PreSave.class, this.workbenchContext, null);
				}
				ThemeManager manager = this.workbenchContext.get(ThemeManager.class);
				Theme theme = manager.getCurrentTheme();
				if( theme != null ) {
					IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.fx.ui.workbench.fx"); //$NON-NLS-1$
					node.put(AbstractE4Application.THEME_ID, theme.getId());
					try {
						node.flush();
					} catch (BackingStoreException e) {
						LOGGER.error("Failed to remember the theme id", e); //$NON-NLS-1$
					}
				}

				this.workbench.close();

				// save after the shutdown see Bug 446933
				saveModel();
			}
		} finally {
			if (this.instanceLocation != null)
				this.instanceLocation.release();
		}
	}

	void calculateReturnValue() {
		Object result = null;
		if (this.workbenchContext != null) {
			result = this.workbenchContext.get(EXIT_CODE);
			if (result == null && this.workbench != null && this.workbench.isRestart()) {
				result = IApplication.EXIT_RESTART;
			}
		}
		if (result != null) {
			this.returnValue = result;
		}
	}

	@Override
	public void stop() {
		// do nothing
	}

	/**
	 * Initializes the {@link E4Workbench}.
	 * <p>
	 * By calling this method the {@link E4Workbench} is initialized but the UI
	 * is not displayed yet. By combining calling this method and the
	 * {@link #jfxStart(IApplicationContext, Application, Stage) jfxStart}
	 * method the developer can create a custom initializer which might do
	 * additional actions between creating {@link IWorkbench} and showing the
	 * UI.
	 *
	 * @param context
	 *            the {@link IApplicationContext}.
	 * @param jfxApplication
	 *            the application which is going to be launched.
	 * @param primaryStage
	 *            the primary stage.
	 * @return <code>true</code> if the workbench was initialized successfully
	 */
	public boolean initE4Workbench(final IApplicationContext context, Application jfxApplication, final Stage primaryStage) {
		this.workbenchContext = createApplicationContext();

		// It is the very first time when the javaFX Application appears. It
		// will be used to render the UI.
		// Add following objects to the context since they might be needed by
		// life-cycle manager and
		// @PostContextCreate implementations.
		this.workbenchContext.set(Application.class, jfxApplication);
		this.workbenchContext.set(IApplicationContext.class, context);
		this.workbenchContext.set(PRIMARY_STAGE_KEY, primaryStage);
		this.workbench = createE4Workbench(context, this.workbenchContext);
		return this.workbench != null;
	}

	/**
	 * @return the {@link IApplicationContext}.
	 */
	public IApplicationContext getApplicationContext() {
		return this.applicationContext;
	}

	/**
	 * Launches the JavaFX application by calling the
	 * {@link Application#launch(Class, String...)} method.
	 * <p>
	 * <b>NOTE</b>: this method is intended to be overridden by subclasses of
	 * the {@link E4Application} that would like provide a custom application
	 * launcher.
	 *
	 * @throws Exception
	 *             when the application could not be started.
	 */
	protected void launchE4JavaFxApplication() throws Exception {
		Application.launch(getJfxApplicationClass());
	}

	/**
	 * Gets the class which should be launched. It must be a subclass of the
	 * JavaFX's {@link Application}.
	 * <p>
	 * <b>NOTE</b>: this method is intended to be overridden by subclasses of
	 * the {@link E4Application} that would like to provide a custom
	 * implementation of the {@link Application} class.
	 *
	 * @return the Class which should be launched.
	 */
	@SuppressWarnings("static-method")
	protected Class<? extends Application> getJfxApplicationClass() {
		return DefaultJFXApp.class;
	}

	/**
	 * Performs additional actions just after staring the application.
	 *
	 * @param context
	 *            the {@link IApplicationContext}.
	 */
	protected void postJfxStarted(final IApplicationContext context) {
		final Map<String, Object> map = new HashMap<String, Object>();
		sendEvent(Constants.APPLICATION_LAUNCHED, map);
		updateStartupState(DefaultProgressState.WORKBENCH_GUI_SHOWING);
	}

	@Override
	protected Realm createRealm(IEclipseContext appContext) {
		return JFXRealm.createDefault();
	}

	/**
	 * Update the startup progress state
	 * @param progressState
	 */
	protected void updateStartupState(ProgressState progressState) {
		if( this.startupService != null ) {
			this.startupService.stateReached(progressState);
		}
	}

	@Override
	protected IResourceUtilities<Image> createResourceUtility(final IEclipseContext appContext) {
		return new IResourceUtilities<Image>() {
			@Override
			public Image imageDescriptorFromURI(URI iconPath) {
				if( iconPath == null ) {
					return null;
				}
				GraphicsLoader l = appContext.get(GraphicsLoader.class);
				return l.getImage(new EMFUri(iconPath));
			}
		};
	}

	@Override
	protected String getDefaultPresentationEngineURI(IEclipseContext appContext) {
		return PartRenderingEngine.engineURI;
	}

	/**
	 * Sends the event.
	 *
	 * @param topic
	 *            the topic.
	 * @param map
	 *            the payload data.
	 */
	protected void sendEvent(final String topic, final Map<String, Object> map) {
		if (this.eventAdmin != null) {
			this.eventAdmin.sendEvent(new Event(topic, map));
		} else {
			LOGGER.warningf("Could not send the %s event. EventAdmin is missing.", topic); //$NON-NLS-1$
		}
	}
}
