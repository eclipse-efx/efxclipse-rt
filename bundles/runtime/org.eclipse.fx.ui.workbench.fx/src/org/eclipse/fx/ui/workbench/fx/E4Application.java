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

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.SystemUtils;
import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.core.app.ApplicationContext.Splash;
import org.eclipse.fx.core.app.ApplicationInstance;
import org.eclipse.fx.core.app.ApplicationLocation;
import org.eclipse.fx.core.app.ExitStatus;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.core.event.EventBus;
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
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.prefs.BackingStoreException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * default e4 application
 */
@SuppressWarnings("restriction")
public class E4Application extends AbstractE4Application implements IApplication, ApplicationInstance {

	static org.eclipse.fx.core.log.Logger LOGGER = LoggerCreator.createLogger(E4Application.class);

	E4Workbench workbench;
	ApplicationLocation instanceLocation;
	IEclipseContext workbenchContext;

	private static final String PRIMARY_STAGE_KEY = "primaryStage"; //$NON-NLS-1$
	private static final String CREATE_WORKBENCH_ON_NON_UI_THREAD_ARG = "createWorkbenchOnNonUIThread"; //$NON-NLS-1$
	private static final String NO_IMPLICIT_EXIT = "noImplicitExit"; //$NON-NLS-1$

	static E4Application SELF;

	ApplicationContext applicationContext;
	ExitStatus returnValue;
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
	public CompletableFuture<ExitStatus> launch(ApplicationContext context) {
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
			this.startupService.applicationLaunched(this.applicationContext);
		} else {
			// if the service is not available we make sure to bring the splash down
			this.applicationContext.applicationRunning();
		}

		CompletableFuture<ExitStatus> rv = CompletableFuture.supplyAsync( () -> {
			try {
				launchE4JavaFxApplication();
			} catch (Exception e) {
				if( e instanceof RuntimeException ) {
					throw (RuntimeException)e;
				} else {
					throw new RuntimeException(e);
				}
			}

			try {
				return this.returnValue == null ? ExitStatus.OK : this.returnValue;
			} finally {
				this.returnValue = null;
			}
		},Executors.newSingleThreadExecutor());

		return rv;
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		SELF = this;
		this.applicationContext = new ApplicationContextImpl(context);

		Bundle b = FrameworkUtil.getBundle(AbstractJFXApplication.class);
		BundleContext bundleContext = b.getBundleContext();
		ServiceReference<EventAdmin> ref = bundleContext.getServiceReference(EventAdmin.class);
		if (ref != null) {
			this.eventAdmin = bundleContext.getService(ref);
		}

		ServiceReference<StartupProgressTrackerService> serviceReference = bundleContext.getServiceReference(StartupProgressTrackerService.class);
		if( serviceReference != null ) {
			this.startupService = bundleContext.getService(serviceReference);
			this.startupService.applicationLaunched(this.applicationContext);
		} else {
			// if the service is not available we make sure to bring the splash down
			this.applicationContext.applicationRunning();
		}

		launchE4JavaFxApplication();

		if( this.returnValue == null ) {
			return IApplication.EXIT_OK;
		} else {
			if( this.returnValue == ExitStatus.OK ) {
				return IApplication.EXIT_OK;
			} else {
				return IApplication.EXIT_RESTART;
			}
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
	public void jfxStart(ApplicationContext context, Application jfxApplication, Stage primaryStage) {
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
					E4Application.this.instanceLocation = (ApplicationLocation) wbContext.get(E4Workbench.INSTANCE_LOCATION);
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
				result = ExitStatus.RESTART;
			}
		}
		if (result != null && result instanceof ExitStatus) {
			this.returnValue = (ExitStatus) result;
		} else if( this.returnValue == null ) {
			this.returnValue = ExitStatus.OK;
		}
	}

	@Override
	public void stop(ExitStatus status) {
		this.returnValue = status;
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
	@SuppressWarnings("deprecation")
	public boolean initE4Workbench(final ApplicationContext context, Application jfxApplication, final Stage primaryStage) {
		this.workbenchContext = createApplicationContext();

		if( Boolean.parseBoolean(getArgValue(NO_IMPLICIT_EXIT, this.applicationContext, true))) {
			Platform.setImplicitExit(false);
			this.workbenchContext.get(EventBus.class).subscribe(UIEvents.UILifeCycle.APP_SHUTDOWN_STARTED, e -> {
				Platform.exit();
			});
		}
		// It is the very first time when the javaFX Application appears. It
		// will be used to render the UI.
		// Add following objects to the context since they might be needed by
		// life-cycle manager and
		// @PostContextCreate implementations.
		this.workbenchContext.set(Application.class, jfxApplication);
		this.workbenchContext.set(ApplicationContext.class, context);
		this.workbenchContext.set(PRIMARY_STAGE_KEY, primaryStage);
		this.workbench = createE4Workbench(context, this.workbenchContext);
		return this.workbench != null;
	}

	/**
	 * @return the {@link IApplicationContext}.
	 */
	public ApplicationContext getApplicationContext() {
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
	protected void postJfxStarted(final ApplicationContext context) {
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

	static class ApplicationContextImpl implements ApplicationContext {
		private final IApplicationContext application;

		public ApplicationContextImpl(IApplicationContext application) {
			this.application = application;
		}

		@Override
		public void applicationRunning() {
			this.application.applicationRunning();
		}

		@Override
		public Optional<Splash> getSplashImage() {
			Bundle bundle = this.application.getBrandingBundle();
			if( bundle != null ) {
				URL url = bundle.getResource("splash.bmp"); //$NON-NLS-1$
				if( url != null ) {
					return Optional.of(new SplashImpl(url));
				}
			}

			return Optional.empty();
		}

		@Override
		public String[] getApplicationArguments() {
			return (String[]) this.application.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		}

		@Override
		public Object getApplicationProperty(String key) {
			return this.application.getBrandingProperty(key);
		}

		@Override
		public Optional<ApplicationLocation> getInstanceLocation() {
			BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
			try {
				Collection<ServiceReference<@NonNull Location>> references = context.getServiceReferences(Location.class, Location.INSTANCE_FILTER);
				if( ! references.isEmpty() ) {
					return Optional.of(new ApplicationLocationImpl(context.getService(references.iterator().next())));
				} else {
					LoggerCreator.createLogger(getClass()).error("Could not find an instance location service"); //$NON-NLS-1$
				}
			} catch (InvalidSyntaxException e) {
				LoggerCreator.createLogger(getClass()).error("Failed to create a filter '"+Location.INSTANCE_FILTER+"'", e);  //$NON-NLS-1$//$NON-NLS-2$
			}
			return Optional.empty();
		}
	}

	static class ApplicationLocationImpl implements ApplicationLocation, Location {
		private final Location location;

		public ApplicationLocationImpl(Location location) {
			this.location = location;
		}

		@Override
		public boolean lock() throws IOException {
			return this.location.lock();
		}

		@Override
		public void release() {
			this.location.release();
		}

		@Override
		public Path getPath() {
			URL url = this.location.getURL();
			try {
				return Paths.get(url.toURI());
			} catch (URISyntaxException e) {
				LoggerCreator.createLogger(getClass()).error("Failed to get the path for '"+url+"'", e);  //$NON-NLS-1$//$NON-NLS-2$
			}
			return null;
		}

		@Override
		public URL getURL() {
			return this.location.getURL();
		}

		@Override
		public boolean isReadOnly() {
			return this.location.isReadOnly();
		}

		@Override
		public boolean allowsDefault() {
			return this.location.allowsDefault();
		}

		@Override
		public URL getDefault() {
			return this.location.getDefault();
		}

		@Override
		public Location getParentLocation() {
			return this.location.getParentLocation();
		}

		@Override
		public boolean isSet() {
			return this.location.isSet();
		}

		@Override
		public boolean setURL(URL value, boolean lock) throws IllegalStateException {
			return this.location.setURL(value, lock);
		}

		@Override
		public boolean set(URL value, boolean lock) throws IllegalStateException, IOException {
			return this.location.set(value, lock);
		}

		@Override
		public boolean set(URL value, boolean lock, String lockFilePath) throws IllegalStateException, IOException {
			return this.location.set(value, lock, lockFilePath);
		}

		@Override
		public boolean isLocked() throws IOException {
			return this.location.isLocked();
		}

		@Override
		public Location createLocation(Location parent, URL defaultValue, boolean readonly) {
			return this.location.createLocation(parent, defaultValue, readonly);
		}

		@Override
		public URL getDataArea(String path) throws IOException {
			return this.location.getDataArea(path);
		}
	}

	static class SplashImpl implements Splash {
		private final URL url;
		private Point2D location;

		public SplashImpl(URL url) {
			this.url = url;
		}

		@Override
		public URL getUrl() {
			return this.url;
		}

		@Override
		public Point2D getLocation() {
			if( this.location == null ) {
				Image img = new Image(getUrl().toExternalForm());
				double x = SystemUtils.isMacOS() ? Screen.getPrimary().getVisualBounds().getWidth() / 2 - img.getWidth() / 2 - 1 : Screen.getPrimary().getBounds().getWidth() / 2 - img.getWidth() / 2 - 1;
				double y = SystemUtils.isMacOS() ? 227 : Screen.getPrimary().getBounds().getHeight() / 2 - img.getHeight() / 2;
				this.location = new Point2D(x, y);
			}
			return this.location;
		}
	}
}
