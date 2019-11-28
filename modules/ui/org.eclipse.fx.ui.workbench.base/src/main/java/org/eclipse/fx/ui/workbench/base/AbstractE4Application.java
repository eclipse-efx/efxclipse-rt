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
package org.eclipse.fx.ui.workbench.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.internal.services.EclipseAdapter;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.core.services.translation.TranslationProviderFactory;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.internal.workbench.ActiveChildLookupFunction;
import org.eclipse.e4.ui.internal.workbench.ActivePartLookupFunction;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.internal.workbench.ExceptionHandler;
import org.eclipse.e4.ui.internal.workbench.ModelServiceImpl;
import org.eclipse.e4.ui.internal.workbench.PlaceholderResolver;
import org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory;
import org.eclipse.e4.ui.internal.workbench.SelectionAggregator;
import org.eclipse.e4.ui.internal.workbench.SelectionServiceImpl;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicPackageImpl;
import org.eclipse.e4.ui.model.application.ui.impl.UiPackageImpl;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.IExceptionHandler;
import org.eclipse.e4.ui.workbench.IModelResourceHandler;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessRemovals;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPlaceholderResolver;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.fx.core.SystemUtils;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.core.app.ApplicationLocation;
import org.eclipse.fx.core.app.ExitStatus;
import org.eclipse.fx.core.geom.Bounds;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.restart.LifecycleRV;
import org.eclipse.fx.ui.services.restart.RestartService;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService.DefaultProgressState;
import org.eclipse.fx.ui.workbench.base.internal.CommandEventDispatcher;
import org.eclipse.fx.ui.workbench.base.internal.EFX_ResourceHandler;
import org.eclipse.fx.ui.workbench.base.internal.LoggerProviderImpl;
import org.eclipse.fx.ui.workbench.base.rendering.ElementRenderer;
import org.eclipse.fx.ui.workbench.base.restart.RestartPreferenceUtil;
import org.eclipse.fx.ui.workbench.base.restart.RestartServiceImpl;
import org.eclipse.fx.ui.workbench.services.EModelStylingService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Basic implementation of the e4 bootstrap
 */
@SuppressWarnings("restriction")
public abstract class AbstractE4Application {
	/**
	 * Informations about the screen
	 */
	public static final class ScreenStruct {
		final boolean primary;
		final int x;
		final int y;
		final int width;
		final int height;

		/**
		 * Create new screen
		 * 
		 * @param primary <code>true</code> if the primary screen
		 * @param x       the x value of the screen
		 * @param y       the y value of the screen
		 * @param width   the width
		 * @param height  the height
		 */
		public ScreenStruct(boolean primary, int x, int y, int width, int height) {
			super();
			this.primary = primary;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
	}

	/**
	 * Context-Key name for the theme-id slot
	 */
	public static final String THEME_ID = "cssTheme"; //$NON-NLS-1$
	private static final String WORKSPACE_VERSION_KEY = "org.eclipse.core.runtime"; //$NON-NLS-1$
	private static final String WORKSPACE_VERSION_VALUE = "2"; //$NON-NLS-1$
	private static final String METADATA_FOLDER = ".metadata"; //$NON-NLS-1$
	private static final String VERSION_FILENAME = "version.ini"; //$NON-NLS-1$

	/**
	 * Set the return value of the application in the context with this key
	 */
	protected static final String EXIT_CODE = "e4.osgi.exit.code"; //$NON-NLS-1$

	private static final String SCREEN_SETUP = "efx.screensetup"; //$NON-NLS-1$
	
	private static final String RESTORE_SIZE = "efx.restore-size"; //$NON-NLS-1$

	Object lcManager;
	private IModelResourceHandler handler;

	private static org.eclipse.fx.core.log.Logger LOGGER = LoggerCreator.createLogger(AbstractE4Application.class);
	private MApplication applicationModel;
	private EModelService modelService;

	/**
	 * Create a databinding realm
	 *
	 * @param context the context
	 * @return the realm
	 */
	protected abstract @NonNull Realm createRealm(@NonNull IEclipseContext context);

	/**
	 * Create the utility to handle resources
	 *
	 * @param context the context
	 * @return the instance
	 */
	protected abstract @NonNull IResourceUtilities<?> createResourceUtility(@NonNull IEclipseContext context);

	/**
	 * Get the uri of the presentation engine
	 *
	 * @param context the context
	 * @return the uri
	 */
	protected abstract @NonNull String getDefaultPresentationEngineURI(@NonNull IEclipseContext context);

	/**
	 * @return the screen setup
	 */
	@SuppressWarnings("static-method")
	protected List<ScreenStruct> getScreensetup() {
		return Collections.emptyList();
	}

	/**
	 * @return the application model
	 * @since 3.6.0
	 */
	protected final Optional<MApplication> getApplicationModel() {
		return Optional.ofNullable(this.applicationModel);
	}

	/**
	 * Extract an application arguments
	 *
	 * @param applicationContext the application context
	 * @return arguments
	 */
	protected static String[] getApplicationArguments(ApplicationContext applicationContext) {
		return applicationContext.getApplicationArguments();
	}

	/**
	 * Create the workbench instance
	 *
	 * @param applicationContext the OSGi application context
	 * @param appContext         the application context
	 * @return the workbench instance
	 */
	@SuppressWarnings("null")
	@Nullable
	public E4Workbench createE4Workbench(ApplicationContext applicationContext, final IEclipseContext appContext) {
		ContextInjectionFactory.setDefault(appContext);
		
		this.modelService = appContext.get(EModelService.class);

		appContext.set(Realm.class, createRealm(appContext));
		appContext.set(ApplicationContext.class, applicationContext);
		appContext.set(EModelStylingService.class, new EModelStylingService() {
			private static final String PREFIX = "efx_styleclass:"; //$NON-NLS-1$

			@Override
			public void addStyles(MUIElement element, String... tags) {
				List<String> toAdd = Stream.of(tags).map(t -> PREFIX + t).filter(t -> !element.getTags().contains(t))
						.collect(Collectors.toList());
				element.getTags().addAll(toAdd);
			}

			@Override
			public void removeStyles(MUIElement element, String... tags) {
				List<String> cssTags = Stream.of(tags).map(t -> PREFIX + t).collect(Collectors.toList());
				element.getTags().removeAll(cssTags);
			}

			@Override
			public List<String> getStyles(MUIElement element) {
				return getStylesFromTags(element.getTags());
			}

			@Override
			public List<String> getStylesFromTags(List<String> tags) {
				return tags.stream().filter((t) -> t.startsWith(PREFIX)).map(t -> t.substring(PREFIX.length()))
						.collect(Collectors.toList());
			}
		});
		appContext.set(IResourceUtilities.class, createResourceUtility(appContext));

		// Check if DS is running
		if (!appContext.containsKey("org.eclipse.e4.ui.workbench.modeling.EModelService")) { //$NON-NLS-1$
			throw new IllegalStateException(
					"Core services not available. Please make sure that a declarative service implementation (such as the bundle 'org.eclipse.equinox.ds') is available!"); //$NON-NLS-1$
		}

		StartupProgressTrackerService startupProgressTrackerService = appContext
				.get(StartupProgressTrackerService.class);
		if (startupProgressTrackerService != null) {
			try {
				ContextInjectionFactory.inject(startupProgressTrackerService, appContext);
			} catch (Throwable t) {
				LOGGER.error("Could not fully initialize the startup tracker", t); //$NON-NLS-1$
			}

			startupProgressTrackerService.stateReached(DefaultProgressState.DI_SYSTEM_INITIALIZED);
			appContext.get(IEventBroker.class).subscribe(ElementRenderer.TOPIC_WINDOW_SHOWN, e -> {
				startupProgressTrackerService.stateReached(DefaultProgressState.WORKBENCH_GUI_SHOWN);
			});
		}

		// Get the factory to create DI instances with
		IContributionFactory factory = (IContributionFactory) appContext.get(IContributionFactory.class.getName());

		preLifecycle(appContext);

		// Install the life-cycle manager for this session if there's one defined
		LifecycleRV rv = LifecycleRV.CONTINUE;
		String lifeCycleURI = getArgValue(IWorkbench.LIFE_CYCLE_URI_ARG, applicationContext, false);
		if (lifeCycleURI != null) {
			this.lcManager = factory.create(lifeCycleURI, appContext);
			if (this.lcManager != null) {
				rv = invokePostContextCreate(appContext);
			}
		}

		if (startupProgressTrackerService != null) {
			startupProgressTrackerService.stateReached(DefaultProgressState.POST_CONTEXT_LF_FINISHED);
		}

		switch (rv) {
		case RESTART_CLEAR_STATE:
			RestartPreferenceUtil prefUtil = ContextInjectionFactory.make(RestartPreferenceUtil.class, appContext);
			prefUtil.setClearPersistedStateOnRestart(true);
		case RESTART:
			appContext.set(EXIT_CODE, ExitStatus.RESTART);
		case SHUTDOWN:
			return null;
		case CONTINUE:
			break;
		default:
			break;
		}

		String toolItemTimer = getArgValue(Constants.TOOLITEM_TIMER, applicationContext, false);
		if (toolItemTimer != null) {
			try {
				appContext.set(Constants.TOOLITEM_TIMER, Long.valueOf(toolItemTimer));
			} catch (NumberFormatException e) {
				LOGGER.error("Unable to parse '" + Constants.TOOLITEM_TIMER + "' value '" + toolItemTimer + "'", e); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
			}

		}

		this.applicationModel = loadApplicationModel(applicationContext, appContext);
		this.applicationModel.setContext(appContext);
		
		ThreadSynchronize threadSync = appContext.get(ThreadSynchronize.class);
		threadSync.syncExec( () -> handleOffscreenWindows(appContext) );

		// Set the app's context after adding itself
		Util.setup(this.applicationModel, appContext);

		initializeServices(this.applicationModel);

		// let the life cycle manager add to the model
		if (this.lcManager != null) {
			ContextInjectionFactory.invoke(this.lcManager, ProcessAdditions.class, appContext, null);
			ContextInjectionFactory.invoke(this.lcManager, ProcessRemovals.class, appContext, null);
		}

		// Create the addons
		IEclipseContext addonStaticContext = EclipseContextFactory.create();
		for (MAddon addon : this.applicationModel.getAddons()) {
			addonStaticContext.set(MAddon.class, addon);
			Object obj = factory.create(addon.getContributionURI(), appContext, addonStaticContext);
			addon.setObject(obj);
		}

		// Parse out parameters from both the command line and/or the product
		// definition (if any) and put them in the context
		String xmiURI = getArgValue(IWorkbench.XMI_URI_ARG, applicationContext, false);
		appContext.set(IWorkbench.XMI_URI_ARG, xmiURI);

		String themeId = getArgValue(THEME_ID, applicationContext, false);
		appContext.set(THEME_ID, themeId);
		appContext.set(E4Workbench.RENDERER_FACTORY_URI,
				getArgValue(E4Workbench.RENDERER_FACTORY_URI, applicationContext, false));
		// This is a default arg, if missing we use the default rendering engine
		String presentationURI = getArgValue(IWorkbench.PRESENTATION_URI_ARG, applicationContext, false);
		if (presentationURI == null) {
			presentationURI = getDefaultPresentationEngineURI(appContext);
		}
		appContext.set(IWorkbench.PRESENTATION_URI_ARG, presentationURI);

		preCreateWorkbench(appContext);

		// Instantiate the Workbench (which is responsible for 'running' the UI
		// (if any)...
		E4Workbench workbench = new E4Workbench(this.applicationModel, appContext);

		// Workbench dependendent services
		appContext.set(RestartService.class, ContextInjectionFactory.make(RestartServiceImpl.class, appContext));

		return workbench;
	}
	
	private void handleOffscreenWindows(IEclipseContext appContext) {
		EModelService service = appContext.get(EModelService.class);
		List<MWindow> windows = service.findElements(this.applicationModel, null, MWindow.class, Collections.emptyList());
		
		List<ScreenStruct> screens = getScreensetup();
		List<Bounds> bounds = screens.stream()
			.map( s -> new Bounds(s.x, s.y, s.width, s.height))
			.collect(Collectors.toList());
		
		for( MWindow w : windows ) {
			String restoreSize = w.getPersistedState().get(RESTORE_SIZE);
			Bounds b = new Bounds(w.getX(), w.getY(), w.getWidth(), w.getHeight());
			if( bounds.stream().noneMatch( v -> v.intersects(b))) {
				// Move 50 because eg on OS-X there might be the menubar in the top 
				int x = 50;
				int y = 50;
				int width = 800;
				int height = 600;
				if( restoreSize != null && ! screens.isEmpty() ) {
					ScreenStruct screen = screens.stream()
						.filter(s -> s.primary)
						.findFirst()
						.orElse( screens.get(0));
					x = screen.x;
					y = screen.y;
				} else {
					if( restoreSize != null ) {
						try {
							String[] parts = restoreSize.split(" "); //$NON-NLS-1$
							if( parts.length == 4 ) {
								x = Integer.parseInt(parts[0]);
								y = Integer.parseInt(parts[1]);
								width = Integer.parseInt(parts[2]);
								height = Integer.parseInt(parts[3]);
							}
						} catch (Exception e) {
							LOGGER.errorf("Unable to parse restore size %s",e, restoreSize); //$NON-NLS-1$
						}
					}
				}
				
				w.setX(x);
				w.setY(y);
				
				if( SystemUtils.isWindows() ) {
					if( w.getHeight() < 50 ) {
						w.setWidth(width);
						w.setHeight(height);
					}
				}
			}
			
			if( restoreSize == null ) {
				w.getPersistedState().put(RESTORE_SIZE, String.format("%s %s %s %s", //$NON-NLS-1$
						Integer.valueOf(w.getX()), 
						Integer.valueOf(w.getY()), 
						Integer.valueOf(w.getWidth()), 
						Integer.valueOf(w.getHeight()))); 
			}
		}
	}

	private LifecycleRV invokePostContextCreate(IEclipseContext appContext) {
		ThreadSynchronize uiSynchronize = appContext.get(ThreadSynchronize.class);
		Object rv = uiSynchronize.syncExec(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return ContextInjectionFactory.invoke(AbstractE4Application.this.lcManager, PostContextCreate.class,
						appContext, Boolean.TRUE);
			}
		}, null);

		if (rv == null) {
			return LifecycleRV.CONTINUE;
		} else if (rv instanceof Boolean) {
			return ((Boolean) rv).booleanValue() ? LifecycleRV.CONTINUE : LifecycleRV.SHUTDOWN;
		} else if (rv instanceof LifecycleRV) {
			return (LifecycleRV) rv;
		} else {
			LOGGER.warning(
					"Unrecognised return value type from @PostContextCreate. The expected types are Boolean or LifecycleRV."); //$NON-NLS-1$
		}
		return LifecycleRV.CONTINUE;
	}

	/**
	 * save the model
	 */
	public void saveModel() {
		try {
			if( this.modelService != null ) {
				this.modelService.findElements(this.applicationModel, null, MElementContainer.class, null, EModelService.ANYWHERE).forEach(AbstractE4Application::sanitizeContainer);
			}
			this.handler.save();
		} catch (IOException e) {
			LOGGER.error("Unable to persist the model", e); //$NON-NLS-1$
		}
	}
	
	private static void sanitizeContainer(MElementContainer<MUIElement> container) {
		if( container.getSelectedElement() != null && ! container.getSelectedElement().isToBeRendered() ) {
			MUIElement selectedElement = container.getChildren().stream().filter(MUIElement::isToBeRendered).findFirst().orElse(null);
			container.setSelectedElement(selectedElement);
		}
	}

	/**
	 * @return the current lifecycle handler
	 */
	@Nullable
	protected Object getLifecycleManager() {
		return this.lcManager;
	}

	/**
	 * Called before the lifecycle handler is created
	 *
	 * @param appContext the application context
	 */
	protected void preLifecycle(IEclipseContext appContext) {
		// Nothing by default
	}

	/**
	 * Called before the workbench is created
	 *
	 * @param appContext the context
	 */
	protected void preCreateWorkbench(IEclipseContext appContext) {
		// Nothing by default
	}

	private MApplication loadApplicationModel(ApplicationContext appContext, IEclipseContext eclipseContext) {
		MApplication theApp = null;

		String appModelPath = getArgValue(IWorkbench.XMI_URI_ARG, appContext, false, eclipseContext);
		Assert.isNotNull(appModelPath, IWorkbench.XMI_URI_ARG + " argument missing"); //$NON-NLS-1$
		final URI initialWorkbenchDefinitionInstance = URI.createPlatformPluginURI(appModelPath, true);

		eclipseContext.set(E4Workbench.INITIAL_WORKBENCH_MODEL_URI, initialWorkbenchDefinitionInstance);
		eclipseContext.set(E4Workbench.INSTANCE_LOCATION, appContext.getInstanceLocation().orElse(null));

		// Save and restore
		boolean saveAndRestore;
		String value = getArgValue(IWorkbench.PERSIST_STATE, appContext, false, eclipseContext);

		saveAndRestore = value == null || Boolean.parseBoolean(value);

		eclipseContext.set(IWorkbench.PERSIST_STATE, Boolean.valueOf(saveAndRestore));

		// Persisted state
		boolean clearPersistedState;
		value = getArgValue(IWorkbench.CLEAR_PERSISTED_STATE, appContext, true, eclipseContext);
		clearPersistedState = value != null && Boolean.parseBoolean(value);
		RestartPreferenceUtil restartUtil = ContextInjectionFactory.make(RestartPreferenceUtil.class, eclipseContext);
		if (!clearPersistedState) {
			clearPersistedState = restartUtil.isClearPersistedStateOnRestart();
		}
		eclipseContext.set(IWorkbench.CLEAR_PERSISTED_STATE, Boolean.valueOf(clearPersistedState));

		// Delta save and restore
		boolean deltaRestore;
		// E4Workbench.DELTA_RESTORE
		String deltaRestoreKey = "deltaRestore"; //$NON-NLS-1$
		value = getArgValue(deltaRestoreKey, appContext, false, eclipseContext);
		deltaRestore = value == null || Boolean.parseBoolean(value);
		eclipseContext.set(deltaRestoreKey, Boolean.valueOf(deltaRestore));

		String resourceHandler = getArgValue(IWorkbench.MODEL_RESOURCE_HANDLER, appContext, false, eclipseContext);

		if (resourceHandler == null) {
			resourceHandler = "bundleclass://org.eclipse.fx.ui.workbench.base/" + EFX_ResourceHandler.class.getName(); //$NON-NLS-1$
		}

		IContributionFactory factory = eclipseContext.get(IContributionFactory.class);

		this.handler = (IModelResourceHandler) factory.create(resourceHandler, eclipseContext);

		Resource resource = this.handler.loadMostRecentModel();
		theApp = (MApplication) resource.getContents().get(0);

		// Reset the restart-flag in the preferences regardless of it being used
		// or not, otherwise it would
		// hang around if -clearPersistedState was also set
		restartUtil.setClearPersistedStateOnRestart(false);

		return theApp;
	}

	private static String getArgValue(String argName, ApplicationContext applicationContext, boolean singledCmdArgValue,
			IEclipseContext eclipseContext) {
		Object value = eclipseContext.get(argName);
		if (value != null) {
			return value.toString();
		}
		return getArgValue(argName, applicationContext, singledCmdArgValue);
	}

	/**
	 * Setup the application context
	 *
	 * @return the context
	 */
	@SuppressWarnings("static-method")
	protected IEclipseContext createApplicationContext() {
		IEclipseContext serviceContext = E4Workbench.getServiceContext();
		final IEclipseContext appContext = serviceContext.createChild("WorkbenchContext"); //$NON-NLS-1$
		appContext.set(IWorkbench.APPLICATION_CONTEXT_KEY, appContext);
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		ExceptionHandler exceptionHandler = new ExceptionHandler();
		ReflectionContributionFactory contributionFactory = new ReflectionContributionFactory(registry);
		appContext.set(IContributionFactory.class.getName(), contributionFactory);
		appContext.set(IExtensionRegistry.class.getName(), registry);
		appContext.set(IExceptionHandler.class.getName(), exceptionHandler);
		appContext.set(TranslationService.LOCALE, Locale.getDefault());

		// No default log provider available
		if (appContext.get(ILoggerProvider.class) == null) {
			serviceContext.set(ILoggerProvider.class,
					ContextInjectionFactory.make(LoggerProviderImpl.class, serviceContext));
		}

		appContext.set(Logger.class.getName(),
				serviceContext.get(ILoggerProvider.class).getClassLogger(E4Workbench.class));

		appContext.set(EModelService.class, new ModelServiceImpl(appContext));
		appContext.set(EPlaceholderResolver.class, new PlaceholderResolver());

		TranslationService bundleTranslationProvider = TranslationProviderFactory.bundleTranslationService(appContext);
		appContext.set(TranslationService.class, bundleTranslationProvider);

		appContext.set(Adapter.class.getName(), ContextInjectionFactory.make(EclipseAdapter.class, appContext));

		appContext.set(IServiceConstants.ACTIVE_PART, new ActivePartLookupFunction());
		appContext.set(IServiceConstants.ACTIVE_SHELL,
				new ActiveChildLookupFunction(IServiceConstants.ACTIVE_SHELL, E4Workbench.LOCAL_ACTIVE_SHELL));

		return appContext;
	}

	/**
	 * Initialize the services
	 *
	 * @param appModel the application model
	 */
	protected void initializeServices(MApplication appModel) {
		IEclipseContext appContext = appModel.getContext();
		// // make sure we only add trackers once
		// if (appContext.containsKey(CONTEXT_INITIALIZED))
		// return;
		// appContext.set(CONTEXT_INITIALIZED, "true");
		initializeApplicationServices(appContext);
		List<MWindow> windows = appModel.getChildren();
		for (MWindow childWindow : windows) {
			initializeWindowServices(childWindow);
		}
		((EObject) appModel).eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getFeatureID(MApplication.class) != UiPackageImpl.ELEMENT_CONTAINER__CHILDREN)
					return;
				if (notification.getEventType() != Notification.ADD)
					return;
				MWindow childWindow = (MWindow) notification.getNewValue();
				initializeWindowServices(childWindow);
			}
		});
	}

	/**
	 * Initialize the application services
	 *
	 * @param appContext the application context
	 */
	@SuppressWarnings("static-method")
	protected void initializeApplicationServices(IEclipseContext appContext) {
		final IEclipseContext theContext = appContext;
		// we add a special tracker to bring up current selection from
		// the active window to the application level
		appContext.runAndTrack(new RunAndTrack() {
			@Override
			public boolean changed(IEclipseContext context) {
				IEclipseContext activeChildContext = context.getActiveChild();
				if (activeChildContext != null) {
					Object selection = activeChildContext.get(IServiceConstants.ACTIVE_SELECTION);
					theContext.set(IServiceConstants.ACTIVE_SELECTION, selection);
				}
				return true;
			}
		});

		// we create a selection service handle on every node that we are asked
		// about as handle needs to know its context
		appContext.set(ESelectionService.class.getName(), new ContextFunction() {
			@Override
			public Object compute(IEclipseContext context, String contextKey) {
				return ContextInjectionFactory.make(SelectionServiceImpl.class, context);
			}
		});
		ContextInjectionFactory.make(CommandEventDispatcher.class, appContext);
	}

	/**
	 * Initialize the window services
	 *
	 * @param childWindow the window
	 */
	protected void initializeWindowServices(MWindow childWindow) {
		IEclipseContext windowContext = childWindow.getContext();
		initWindowContext(windowContext);
		// Mostly MWindow contexts are lazily created by renderers and is not
		// set at this point.
		((EObject) childWindow).eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getFeatureID(MWindow.class) != BasicPackageImpl.WINDOW__CONTEXT)
					return;
				IEclipseContext windowContext = (IEclipseContext) notification.getNewValue();
				initWindowContext(windowContext);
			}
		});
	}

	/**
	 * Initialize the window context
	 *
	 * @param windowContext the window context
	 */
	@SuppressWarnings("static-method")
	protected void initWindowContext(IEclipseContext windowContext) {
		if (windowContext == null)
			return;
		SelectionAggregator selectionAggregator = ContextInjectionFactory.make(SelectionAggregator.class,
				windowContext);
		windowContext.set(SelectionAggregator.class, selectionAggregator);
	}

	/**
	 * Try to access the argument value from different sources:
	 * <ul>
	 * <li>The application arguments</li>
	 * <li>The product extension point</li>
	 * <li>The System-Properties</li>
	 * </ul>
	 *
	 * @param argName            the argument name
	 * @param applicationContext the application context
	 * @param singledCmdArgValue <code>true</code> if the argument is single valued
	 * @return the value or <code>null</code>
	 */
	protected static @Nullable String getArgValue(String argName, ApplicationContext applicationContext,
			boolean singledCmdArgValue) {
		// Is it in the arg list ?
		if (argName == null || argName.length() == 0)
			return null;

		String[] args = getApplicationArguments(applicationContext);
		if (singledCmdArgValue) {
			for (int i = 0; i < args.length; i++) {
				if (("-" + argName).equals(args[i])) //$NON-NLS-1$
					return "true"; //$NON-NLS-1$
			}
		} else {
			for (int i = 0; i < args.length; i++) {
				if (("-" + argName).equals(args[i]) && i + 1 < args.length) //$NON-NLS-1$
					return args[i + 1];
			}
		}

		final String brandingProperty = (String) applicationContext.getApplicationProperty(argName);
		return brandingProperty == null ? System.getProperty(argName) : brandingProperty;
	}

	/**
	 * Check the instance location
	 *
	 * @param instanceLocation the location to check
	 * @param context          the context
	 * @return <code>true</code> if the location is fine
	 */
	@SuppressWarnings("static-method")
	public boolean checkInstanceLocation(@Nullable ApplicationLocation instanceLocation,
			@NonNull IEclipseContext context) {
		// Eclipse has been run with -data @none or -data @noDefault options so
		// we don't need to validate the location
		if (instanceLocation == null && Boolean.FALSE.equals(context.get(IWorkbench.PERSIST_STATE))) {
			return true;
		}

		if (instanceLocation == null) {
			// MessageDialog
			// .openError(
			// shell,
			// WorkbenchSWTMessages.IDEApplication_workspaceMandatoryTitle,
			// WorkbenchSWTMessages.IDEApplication_workspaceMandatoryMessage);
			return false;
		}

		// -data "/valid/path", workspace already set
//		if (instanceLocation.isSet()) {
		// make sure the meta data version is compatible (or the user has
		// chosen to overwrite it).
		if (!checkValidWorkspace(instanceLocation.getURL())) {
			return false;
		}

		// at this point its valid, so try to lock it and update the
		// metadata version information if successful
		try {
			if (instanceLocation.lock()) {
				writeWorkspaceVersion(instanceLocation);
				return true;
			}

			// we failed to create the directory.
			// Two possibilities:
			// 1. directory is already in use
			// 2. directory could not be created
			File workspaceDirectory = new File(instanceLocation.getURL().getFile());
			if (workspaceDirectory.exists()) {
				// MessageDialog
				// .openError(
				// shell,
				// WorkbenchSWTMessages.IDEApplication_workspaceCannotLockTitle,
				// WorkbenchSWTMessages.IDEApplication_workspaceCannotLockMessage);
			} else {
				// MessageDialog
				// .openError(
				// shell,
				// WorkbenchSWTMessages.IDEApplication_workspaceCannotBeSetTitle,
				// WorkbenchSWTMessages.IDEApplication_workspaceCannotBeSetMessage);
			}
		} catch (IOException e) {
			LOGGER.error("Could not create instance location", e); //$NON-NLS-1$
			// MessageDialog.openError(shell,
			// WorkbenchSWTMessages.InternalError, e.getMessage());
		}
		return false;
//		}
//
//		return false;
	}

	private static boolean checkValidWorkspace(URL url) {
		// a null url is not a valid workspace
		if (url == null) {
			return false;
		}

		String version = readWorkspaceVersion(url);

		// if the version could not be read, then there is not any existing
		// workspace data to trample, e.g., perhaps its a new directory that
		// is just starting to be used as a workspace
		if (version == null) {
			return true;
		}

		final int ide_version = Integer.parseInt(WORKSPACE_VERSION_VALUE);
		int workspace_version = Integer.parseInt(version);

		// equality test is required since any version difference (newer
		// or older) may result in data being trampled
		if (workspace_version == ide_version) {
			return true;
		}

		// At this point workspace has been detected to be from a version
		// other than the current ide version -- find out if the user wants
		// to use it anyhow.
		// String title = WorkbenchSWTMessages.IDEApplication_versionTitle;
		// String message = NLS.bind(
		// WorkbenchSWTMessages.IDEApplication_versionMessage,
		// url.getFile());
		//
		// MessageBox mbox = new MessageBox(shell, SWT.OK | SWT.CANCEL
		// | SWT.ICON_WARNING | SWT.APPLICATION_MODAL);
		// mbox.setText(title);
		// mbox.setMessage(message);
		// return mbox.open() == SWT.OK;
		return true;
	}

	private static String readWorkspaceVersion(URL workspace) {
		File versionFile = getVersionFile(workspace, false);
		if (versionFile == null || !versionFile.exists()) {
			return null;
		}

		try {
			// Although the version file is not spec'ed to be a Java properties
			// file, it happens to follow the same format currently, so using
			// Properties to read it is convenient.
			Properties props = new Properties();
			try (FileInputStream is = new FileInputStream(versionFile)) {
				props.load(is);
			}

			return props.getProperty(WORKSPACE_VERSION_KEY);
		} catch (IOException e) {
			LOGGER.error("Unable to create workspace", e); //$NON-NLS-1$
			return null;
		}
	}

	private static File getVersionFile(URL workspaceUrl, boolean create) {
		if (workspaceUrl == null) {
			return null;
		}

		try {
			// make sure the directory exists
			File metaDir = new File(workspaceUrl.getPath(), METADATA_FOLDER);
			if (!metaDir.exists() && (!create || !metaDir.mkdir())) {
				return null;
			}

			// make sure the file exists
			File versionFile = new File(metaDir, VERSION_FILENAME);
			if (!versionFile.exists() && (!create || !versionFile.createNewFile())) {
				return null;
			}

			return versionFile;
		} catch (IOException e) {
			// cannot log because instance area has not been set
			return null;
		}
	}

	private static void writeWorkspaceVersion(ApplicationLocation instanceLoc) {
		if (instanceLoc == null || instanceLoc.isReadOnly()) {
			return;
		}

		File versionFile = getVersionFile(instanceLoc.getURL(), true);
		if (versionFile == null) {
			return;
		}

		String versionLine = WORKSPACE_VERSION_KEY + '=' + WORKSPACE_VERSION_VALUE;
		try (OutputStream output = new FileOutputStream(versionFile)) {
			output.write(versionLine.getBytes("UTF-8")); //$NON-NLS-1$
		} catch (IOException e) {
			LOGGER.error("Unable to write workspace version", e); //$NON-NLS-1$
		}
	}
}
