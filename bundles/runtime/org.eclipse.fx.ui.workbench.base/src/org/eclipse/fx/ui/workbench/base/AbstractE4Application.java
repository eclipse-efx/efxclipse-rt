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
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.internal.services.EclipseAdapter;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
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
import org.eclipse.e4.ui.internal.workbench.ResourceHandler;
import org.eclipse.e4.ui.internal.workbench.SelectionAggregator;
import org.eclipse.e4.ui.internal.workbench.SelectionServiceImpl;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.MApplication;
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
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.restart.LifecycleRV;
import org.eclipse.fx.ui.services.restart.RestartService;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.fx.ui.workbench.base.internal.Activator;
import org.eclipse.fx.ui.workbench.base.internal.LoggerProviderImpl;
import org.eclipse.fx.ui.workbench.base.restart.RestartPreferenceUtil;
import org.eclipse.fx.ui.workbench.base.restart.RestartServiceImpl;
import org.eclipse.fx.ui.workbench.services.EModelStylingService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.osgi.service.datalocation.Location;

/**
 * Basic implementation of the e4 bootstrap
 */
@SuppressWarnings("restriction")
public abstract class AbstractE4Application implements IApplication {
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

	Object lcManager;
	private IModelResourceHandler handler;

	private static org.eclipse.fx.core.log.Logger LOGGER = LoggerCreator.createLogger(AbstractE4Application.class);

	/**
	 * Create a synchronizer instance who synchronizes between UI and none-UI
	 * threads
	 * 
	 * @param context
	 *            the context
	 * @return the instance
	 */
	protected abstract @NonNull UISynchronize createSynchronizer(@NonNull IEclipseContext context);

	/**
	 * Create a databinding realm
	 * 
	 * @param context
	 *            the context
	 * @return the realm
	 */
	protected abstract @NonNull Realm createRealm(@NonNull IEclipseContext context);

	/**
	 * Create the utility to handle resources
	 * 
	 * @param context
	 *            the context
	 * @return the instance
	 */
	protected abstract @NonNull IResourceUtilities<?> createResourceUtility(@NonNull IEclipseContext context);

	/**
	 * Get the uri of the presentation engine
	 * 
	 * @param context
	 *            the context
	 * @return the uri
	 */
	protected abstract @NonNull String getDefaultPresentationEngineURI(@NonNull IEclipseContext context);

	/**
	 * Extract an application arguments
	 * 
	 * @param applicationContext
	 *            the application context
	 * @return arguments
	 */
	protected static String[] getApplicationArguments(IApplicationContext applicationContext) {
		return (String[]) applicationContext.getArguments().get(IApplicationContext.APPLICATION_ARGS);
	}

	/**
	 * Create the workbench instance
	 * 
	 * @param applicationContext
	 *            the OSGi application context
	 * @param appContext
	 *            the application context
	 * @return the workbench instance
	 */
	@SuppressWarnings("null")
	@Nullable
	public E4Workbench createE4Workbench(IApplicationContext applicationContext, final IEclipseContext appContext) {
		ContextInjectionFactory.setDefault(appContext);

		@NonNull
		UISynchronize uiSync = createSynchronizer(appContext);
		appContext.set(org.eclipse.e4.ui.di.UISynchronize.class, (org.eclipse.e4.ui.di.UISynchronize) uiSync);
		appContext.set(UISynchronize.class, uiSync);
		appContext.set(Realm.class, createRealm(appContext));
		appContext.set(IApplicationContext.class, applicationContext);
		appContext.set(EModelStylingService.class, new EModelStylingService() {
			private static final String PREFIX = "efx_styleclass:"; //$NON-NLS-1$
			@Override
			public void addStyles(MUIElement element, String... tags) {
				List<String> toAdd = Stream.of(tags).map(t -> PREFIX + t)
					.filter(t -> !element.getTags().contains(t))
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
				return tags.stream().filter((t) -> t.startsWith(PREFIX))
						.map(t -> t.substring(PREFIX.length()))
						.collect(Collectors.toList());
			}
		});
		appContext.set(IResourceUtilities.class, createResourceUtility(appContext));

		// Check if DS is running
		if (!appContext.containsKey("org.eclipse.e4.ui.workbench.modeling.EModelService")) { //$NON-NLS-1$
			throw new IllegalStateException("Core services not available. Please make sure that a declarative service implementation (such as the bundle 'org.eclipse.equinox.ds') is available!"); //$NON-NLS-1$
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
		switch (rv) {
		case RESTART_CLEAR_STATE:
			RestartPreferenceUtil prefUtil = ContextInjectionFactory.make(RestartPreferenceUtil.class, appContext);
			prefUtil.setClearPersistedStateOnRestart(true);
		case RESTART:
			appContext.set(EXIT_CODE, IApplication.EXIT_RESTART);
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

		// Create the app model and its context
		MApplication appModel = loadApplicationModel(applicationContext, appContext);
		appModel.setContext(appContext);

		// Set the app's context after adding itself
		appContext.set(MApplication.class.getName(), appModel);

		initializeServices(appModel);

		// let the life cycle manager add to the model
		if (this.lcManager != null) {
			ContextInjectionFactory.invoke(this.lcManager, ProcessAdditions.class, appContext, null);
			ContextInjectionFactory.invoke(this.lcManager, ProcessRemovals.class, appContext, null);
		}

		// Create the addons
		IEclipseContext addonStaticContext = EclipseContextFactory.create();
		for (MAddon addon : appModel.getAddons()) {
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
		appContext.set(E4Workbench.RENDERER_FACTORY_URI, getArgValue(E4Workbench.RENDERER_FACTORY_URI, applicationContext, false));
		// This is a default arg, if missing we use the default rendering engine
		String presentationURI = getArgValue(IWorkbench.PRESENTATION_URI_ARG, applicationContext, false);
		if (presentationURI == null) {
			presentationURI = getDefaultPresentationEngineURI(appContext);
		}
		appContext.set(IWorkbench.PRESENTATION_URI_ARG, presentationURI);

		preCreateWorkbench(appContext);

		// Instantiate the Workbench (which is responsible for 'running' the UI
		// (if any)...
		E4Workbench workbench = new E4Workbench(appModel, appContext);

		// Workbench dependendent services
		appContext.set(RestartService.class, ContextInjectionFactory.make(RestartServiceImpl.class, appContext));

		return workbench;
	}

	private LifecycleRV invokePostContextCreate(IEclipseContext appContext) {
		UISynchronize uiSynchronize = appContext.get(UISynchronize.class);
		Object rv = uiSynchronize.syncExec(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return ContextInjectionFactory.invoke(AbstractE4Application.this.lcManager, PostContextCreate.class, appContext, Boolean.TRUE);
			}
		}, null);
		
		if (rv == null) {
			return LifecycleRV.CONTINUE;
		} else if (rv instanceof Boolean) {
			return ((Boolean)rv).booleanValue() ? LifecycleRV.CONTINUE : LifecycleRV.SHUTDOWN;
		} else if (rv instanceof LifecycleRV) {
			return (LifecycleRV)rv;
		} else {
			LOGGER.warning("Unrecognised return value type from @PostContextCreate. The expected types are Boolean or LifecycleRV."); //$NON-NLS-1$
		}
		return LifecycleRV.CONTINUE;
	}

	/**
	 * save the model
	 */
	public void saveModel() {
		try {
			this.handler.save();
		} catch (IOException e) {
			LOGGER.error("Unable to persist the model", e); //$NON-NLS-1$
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
	 * @param appContext
	 *            the application context
	 */
	protected void preLifecycle(IEclipseContext appContext) {
		// Nothing by default
	}

	/**
	 * Called before the workbench is created
	 * 
	 * @param appContext
	 *            the context
	 */
	protected void preCreateWorkbench(IEclipseContext appContext) {
		// Nothing by default
	}

	private MApplication loadApplicationModel(IApplicationContext appContext, IEclipseContext eclipseContext) {
		MApplication theApp = null;

		Location instanceLocation = Activator.getDefault().getInstanceLocation();

		String appModelPath = getArgValue(IWorkbench.XMI_URI_ARG, appContext, false, eclipseContext);
		Assert.isNotNull(appModelPath, IWorkbench.XMI_URI_ARG + " argument missing"); //$NON-NLS-1$
		final URI initialWorkbenchDefinitionInstance = URI.createPlatformPluginURI(appModelPath, true);

		eclipseContext.set(E4Workbench.INITIAL_WORKBENCH_MODEL_URI, initialWorkbenchDefinitionInstance);
		eclipseContext.set(E4Workbench.INSTANCE_LOCATION, instanceLocation);

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
			resourceHandler = "bundleclass://org.eclipse.e4.ui.workbench/" + ResourceHandler.class.getName(); //$NON-NLS-1$
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

	private static String getArgValue(String argName, IApplicationContext applicationContext, boolean singledCmdArgValue, IEclipseContext eclipseContext) {
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
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		ExceptionHandler exceptionHandler = new ExceptionHandler();
		ReflectionContributionFactory contributionFactory = new ReflectionContributionFactory(registry);
		appContext.set(IContributionFactory.class.getName(), contributionFactory);

		// No default log provider available
		if (appContext.get(ILoggerProvider.class) == null) {
			serviceContext.set(ILoggerProvider.class, ContextInjectionFactory.make(LoggerProviderImpl.class, serviceContext));
		}

		appContext.set(Logger.class.getName(), serviceContext.get(ILoggerProvider.class).getClassLogger(E4Workbench.class));

		appContext.set(EModelService.class, new ModelServiceImpl(appContext));
		appContext.set(EPlaceholderResolver.class, new PlaceholderResolver());

		// translation
		String locale = Locale.getDefault().toString();
		appContext.set(TranslationService.LOCALE, locale);
		TranslationService bundleTranslationProvider = TranslationProviderFactory.bundleTranslationService(appContext);
		appContext.set(TranslationService.class, bundleTranslationProvider);

		appContext.set(Adapter.class.getName(), ContextInjectionFactory.make(EclipseAdapter.class, appContext));

		appContext.set(IServiceConstants.ACTIVE_PART, new ActivePartLookupFunction());
		appContext.set(IExceptionHandler.class.getName(), exceptionHandler);
		appContext.set(IExtensionRegistry.class.getName(), registry);

		appContext.set(IServiceConstants.ACTIVE_SHELL, new ActiveChildLookupFunction(IServiceConstants.ACTIVE_SHELL, E4Workbench.LOCAL_ACTIVE_SHELL));

		appContext.set(IExtensionRegistry.class.getName(), registry);
		appContext.set(IContributionFactory.class.getName(), contributionFactory);

		return appContext;
	}

	/**
	 * Initialize the services
	 * 
	 * @param appModel
	 *            the application model
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
	 * @param appContext
	 *            the application context
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
	}

	/**
	 * Initialize the window services
	 * 
	 * @param childWindow
	 *            the window
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
	 * @param windowContext
	 *            the window context
	 */
	@SuppressWarnings("static-method")
	protected void initWindowContext(IEclipseContext windowContext) {
		if (windowContext == null)
			return;
		SelectionAggregator selectionAggregator = ContextInjectionFactory.make(SelectionAggregator.class, windowContext);
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
	 * @param argName
	 *            the argument name
	 * @param applicationContext
	 *            the application context
	 * @param singledCmdArgValue
	 *            <code>true</code> if the argument is single valued
	 * @return the value or <code>null</code>
	 */
	protected static @Nullable String getArgValue(String argName, IApplicationContext applicationContext, boolean singledCmdArgValue) {
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

		final String brandingProperty = applicationContext.getBrandingProperty(argName);
		return brandingProperty == null ? System.getProperty(argName) : brandingProperty;
	}

	/**
	 * Check the instance location
	 * 
	 * @param instanceLocation
	 *            the location to check
	 * @param context
	 *            the context
	 * @return <code>true</code> if the location is fine
	 */
	@SuppressWarnings("static-method")
	public boolean checkInstanceLocation(@Nullable Location instanceLocation, @NonNull IEclipseContext context) {
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
		if (instanceLocation.isSet()) {
			// make sure the meta data version is compatible (or the user has
			// chosen to overwrite it).
			if (!checkValidWorkspace(instanceLocation.getURL())) {
				return false;
			}

			// at this point its valid, so try to lock it and update the
			// metadata version information if successful
			try {
				if (instanceLocation.lock()) {
					writeWorkspaceVersion();
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
		}

		return false;
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

	private static void writeWorkspaceVersion() {
		Location instanceLoc = Platform.getInstanceLocation();
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
