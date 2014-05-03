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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;
import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.base.AbstractE4Application;
import org.eclipse.fx.ui.workbench.fx.internal.GraphicsLoaderImpl;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

@SuppressWarnings("restriction")
public class E4Application extends AbstractE4Application {

	private static org.eclipse.fx.core.log.Logger LOGGER = LoggerCreator.createLogger(E4Application.class);

	private E4Workbench workbench;
	private Location instanceLocation;
	private IEclipseContext workbenchContext;
	private static final String EXIT_CODE = "e4.osgi.exit.code"; //$NON-NLS-1$

	static E4Application SELF;

	IApplicationContext applicationContext;
	Object returnValue;
	protected EventAdmin eventAdmin;
	private Stage primaryStage;
	private Application application;

	/**
	 * Gets the {@link E4Application}.
	 * <p>
	 * The {@link E4Application} is not available prior to calling the
	 * {@link #start(IApplicationContext)} by the equinox's launcher.
	 *
	 * @return the instance of the {@link E4Application}.
	 */
	public static E4Application getE4Application() {
		return SELF;
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		SELF = this;
		this.applicationContext = context;
		this.applicationContext.applicationRunning();

		Bundle b = FrameworkUtil.getBundle(AbstractJFXApplication.class);
		BundleContext bundleContext = b.getBundleContext();
		ServiceReference<EventAdmin> ref = bundleContext.getServiceReference(EventAdmin.class);
		if (ref != null) {
			this.eventAdmin = bundleContext.getService(ref);
		}

		// Looks like OS-X wants to have the context class loader to locate
		// FX-Classes
		Thread.currentThread().setContextClassLoader(Application.class.getClassLoader());

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
		if (workbench == null) {
			initE4Workbench(context, jfxApplication, primaryStage);
		}

		instanceLocation = (Location) workbench.getContext().get(E4Workbench.INSTANCE_LOCATION);

		try {
			if (!checkInstanceLocation(instanceLocation))
				return;

			workbenchContext = workbench.getContext();

			// Create and run the UI (if any)
			workbench.createAndRunUI(workbench.getApplication());

			return;
		} finally {
			postJfxStarted(context);
		}
	}

	@Override
	protected void preLifecycle(IEclipseContext appContext) {
		super.preLifecycle(appContext);
		appContext.set(GraphicsLoader.class, ContextInjectionFactory.make(GraphicsLoaderImpl.class, appContext));
	}

	/**
	 * Stops the application.
	 *
	 * @return the exit code.
	 */
	public Object jfxStop() {
		Object returnCode = null;
		try {
			if (workbenchContext != null && workbench != null) {
				returnCode = workbenchContext.get(EXIT_CODE);
				// Save the model into the targetURI
				if (getLifecycleManager() != null) {
					ContextInjectionFactory.invoke(getLifecycleManager(), PreSave.class, workbenchContext, null);
				}
				saveModel();
				workbench.close();
			}
		} finally {
			if (instanceLocation != null)
				instanceLocation.release();
		}

		if (returnCode != null) {
			return returnCode;
		} else {
			return IApplication.EXIT_OK;
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
	 */
	public void initE4Workbench(final IApplicationContext context, Application jfxApplication, final Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.application = jfxApplication;

		final IEclipseContext workbenchContext = createApplicationContext();

		// It is the very first time when the javaFX Application appears. It
		// will be used to render the UI.
		// Add following objects to the context since they might be needed by
		// life-cycle manager and
		// @PostContextCreate implementations.
		workbenchContext.set(Application.class, jfxApplication);
		workbenchContext.set("primaryStage", primaryStage);
		workbench = createE4Workbench(context, workbenchContext);
	}

	/**
	 * @return the {@link IApplicationContext}.
	 */
	public IApplicationContext getApplicationContext() {
		return applicationContext;
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
		context.applicationRunning();

		final Map<String, Object> map = new HashMap<String, Object>();
		sendEvent("efxapp/applicationLaunched", map);
	}

	@Override
	protected UISynchronize createSynchronizer(IEclipseContext appContext) {
		return new UISynchronize() {

			@Override
			public void syncExec(final Runnable runnable) {
				if (javafx.application.Platform.isFxApplicationThread()) {
					runnable.run();
				} else {
					RunnableFuture<?> task = new FutureTask<Void>(runnable, null);

					javafx.application.Platform.runLater(task);

					try {
						// wait for task to complete
						task.get();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						task.cancel(true);
					}
				}
			}

			@Override
			public void asyncExec(Runnable runnable) {
				javafx.application.Platform.runLater(runnable);
			}
		};
	}

	@Override
	protected Realm createRealm(IEclipseContext appContext) {
		JFXRealm.createDefault();
		return JFXRealm.getDefault();
	}

	@Override
	protected IResourceUtilities createResourceUtility(final IEclipseContext appContext) {
		return new IResourceUtilities<Image>() {
			public Image imageDescriptorFromURI(URI iconPath) {
				GraphicsLoader l = appContext.get(GraphicsLoader.class);
				return l.getImage(iconPath);
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
		if (eventAdmin != null) {
			eventAdmin.sendEvent(new Event(topic, map));
		} else {
			LOGGER.warningf("Could not send the %s event. EventAdmin is missing.", topic);
		}
	}
}
