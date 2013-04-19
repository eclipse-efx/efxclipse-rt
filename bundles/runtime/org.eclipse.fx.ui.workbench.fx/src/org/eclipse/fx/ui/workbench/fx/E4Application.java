/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.internal.services.EclipseAdapter;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.core.services.translation.TranslationProviderFactory;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.internal.workbench.ActiveChildLookupFunction;
import org.eclipse.e4.ui.internal.workbench.ActivePartLookupFunction;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.internal.workbench.ExceptionHandler;
import org.eclipse.e4.ui.internal.workbench.ModelServiceImpl;
import org.eclipse.e4.ui.internal.workbench.PlaceholderResolver;
import org.eclipse.e4.ui.internal.workbench.ReflectionContributionFactory;
import org.eclipse.e4.ui.internal.workbench.ResourceHandler;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.IExceptionHandler;
import org.eclipse.e4.ui.workbench.IModelResourceHandler;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessRemovals;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPlaceholderResolver;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.fx.ui.application.AbstractJFXApplication;
import org.eclipse.fx.ui.workbench.fx.internal.LoggerProviderImpl;
import org.eclipse.fx.ui.workbench.fx.internal.WorkbenchJFXActivator;
import org.eclipse.osgi.service.datalocation.Location;

@SuppressWarnings("restriction")
public class E4Application extends AbstractJFXApplication {
	public static final String THEME_ID = "cssTheme";

	public static final String METADATA_FOLDER = ".metadata"; //$NON-NLS-1$
	private static final String VERSION_FILENAME = "version.ini"; //$NON-NLS-1$
	private static final String WORKSPACE_VERSION_KEY = "org.eclipse.core.runtime"; //$NON-NLS-1$
	private static final String WORKSPACE_VERSION_VALUE = "2"; //$NON-NLS-1$
	private static final String EXIT_CODE = "e4.osgi.exit.code";
	
	private String[] args;
	private Object lcManager;
	private E4Workbench workbench = null;
	private IModelResourceHandler handler;

	private IEclipseContext workbenchContext;

	private Location instanceLocation;

	org.eclipse.fx.core.log.Logger logger = LoggerCreator.createLogger(getClass());
	
	@Override
	protected void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
		workbench = createE4Workbench(applicationContext, jfxApplication, primaryStage);
		if( workbench != null ) {
			instanceLocation = (Location) workbench.getContext().get(E4Workbench.INSTANCE_LOCATION);

			try {
				if (!checkInstanceLocation(instanceLocation))
					return;

				workbenchContext = workbench.getContext();

				// Create and run the UI (if any)
				workbench.createAndRunUI(workbench.getApplication());

				return;
			} finally {
				
			}
		}
	}

	@Override
	protected Object jfxStop() {
		Object returnCode = null;
		try {
			if( workbenchContext != null && workbench != null ) {
				returnCode = workbenchContext.get(EXIT_CODE);
				// Save the model into the targetURI
				if (lcManager != null) {
					ContextInjectionFactory.invoke(lcManager, PreSave.class, workbenchContext, null);
				}
				saveModel();
				workbench.close();	
			}
		} finally {
			if (instanceLocation != null)
				instanceLocation.release();
		}
		
		if( returnCode != null ) {
			return returnCode;
		} else {
			return super.jfxStop();	
		}
	}

	public E4Workbench createE4Workbench(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
		args = (String[]) applicationContext.getArguments().get(IApplicationContext.APPLICATION_ARGS);

		IEclipseContext appContext = createDefaultContext();
		
		//FIXME We need to fix this later on see ticket 256
//		ContextInjectionFactory.setDefault(appContext);
		try {
			Method m = ContextInjectionFactory.class.getMethod("setDefault", IEclipseContext.class);
			m.invoke(null, appContext);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			System.err.println("WARNING: You are running on an old and buggy DI container which is fixed in 4.2.2 builds. Consider upgradeing.");
		}
		

		
		appContext.set(Application.class, jfxApplication);
		appContext.set("primaryStage", primaryStage);
		// appContext.set(Realm.class, SWTObservables.getRealm(display));
		appContext.set(UISynchronize.class, new UISynchronize() {

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

			public void asyncExec(Runnable runnable) {
				javafx.application.Platform.runLater(runnable);
			}
		});
		appContext.set(IApplicationContext.class, applicationContext);
		appContext.set(IResourceUtilities.class, new IResourceUtilities<Image>() {
			private WeakHashMap<URI, WeakReference<Image>> imageCache = new WeakHashMap<URI, WeakReference<Image>>();
			
			public Image imageDescriptorFromURI(URI iconPath) {
				WeakReference<Image> r = imageCache.get(iconPath);
				Image img = null;
				if( r != null ) {
					img = r.get();
				}
				
				if( img == null ) {
					try {
						InputStream in = new URL(iconPath.toString()).openStream();
						img = new Image(in);
						in.close();
						imageCache.put(iconPath, new WeakReference<Image>(img));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						logger.warning("could not find icon at: " + iconPath,e);
					}
				}
				
				return img;
			}
		});

		// Check if DS is running
		if (!appContext.containsKey("org.eclipse.e4.ui.workbench.modeling.EModelService")) {
			throw new IllegalStateException("Core services not available. Please make sure that a declarative service implementation (such as the bundle 'org.eclipse.equinox.ds') is available!");
		}

		// Get the factory to create DI instances with
		IContributionFactory factory = (IContributionFactory) appContext.get(IContributionFactory.class.getName());

		// Install the life-cycle manager for this session if there's one
		// defined
		String lifeCycleURI = getArgValue(E4Workbench.LIFE_CYCLE_URI_ARG, applicationContext, false);
		if (lifeCycleURI != null) {
			lcManager = factory.create(lifeCycleURI, appContext);
			if (lcManager != null) {
				// Let the manager manipulate the appContext if desired
				Boolean rv = (Boolean) ContextInjectionFactory.invoke(lcManager, PostContextCreate.class, appContext, Boolean.TRUE);
				if( rv != null && ! rv.booleanValue() ) {
					return null;
				}
			}
		}
		// Create the app model and its context
		MApplication appModel = loadApplicationModel(applicationContext, appContext);
		appModel.setContext(appContext);

		// Set the app's context after adding itself
		appContext.set(MApplication.class.getName(), appModel);

		// let the life cycle manager add to the model
		if (lcManager != null) {
			ContextInjectionFactory.invoke(lcManager, ProcessAdditions.class, appContext, null);
			ContextInjectionFactory.invoke(lcManager, ProcessRemovals.class, appContext, null);
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
		String xmiURI = getArgValue(E4Workbench.XMI_URI_ARG, applicationContext, false);
		appContext.set(E4Workbench.XMI_URI_ARG, xmiURI);

		String themeId = getArgValue(E4Application.THEME_ID, applicationContext, false);
		appContext.set(E4Application.THEME_ID, themeId);
		appContext.set(E4Workbench.RENDERER_FACTORY_URI, getArgValue(E4Workbench.RENDERER_FACTORY_URI, applicationContext, false));

		// This is a default arg, if missing we use the default rendering engine
		String presentationURI = getArgValue(E4Workbench.PRESENTATION_URI_ARG, applicationContext, false);
		if (presentationURI == null) {
			presentationURI = PartRenderingEngine.engineURI;
		}
		appContext.set(E4Workbench.PRESENTATION_URI_ARG, presentationURI);

		// Instantiate the Workbench (which is responsible for
		// 'running' the UI (if any)...
		return workbench = new E4Workbench(appModel, appContext);
	}

	private MApplication loadApplicationModel(IApplicationContext appContext, IEclipseContext eclipseContext) {
		MApplication theApp = null;

		Location instanceLocation = WorkbenchJFXActivator.getDefault().getInstanceLocation();

		String appModelPath = getArgValue(E4Workbench.XMI_URI_ARG, appContext, false);
		Assert.isNotNull(appModelPath, E4Workbench.XMI_URI_ARG + " argument missing"); //$NON-NLS-1$
		final URI initialWorkbenchDefinitionInstance = URI.createPlatformPluginURI(appModelPath, true);

		eclipseContext.set(E4Workbench.INITIAL_WORKBENCH_MODEL_URI, initialWorkbenchDefinitionInstance);
		eclipseContext.set(E4Workbench.INSTANCE_LOCATION, instanceLocation);

		// Save and restore
		boolean saveAndRestore;
		String value = getArgValue(E4Workbench.PERSIST_STATE, appContext, false);

		saveAndRestore = value == null || Boolean.parseBoolean(value);

		eclipseContext.set(E4Workbench.PERSIST_STATE, Boolean.valueOf(saveAndRestore));

		// Persisted state
		boolean clearPersistedState;
		value = getArgValue(E4Workbench.CLEAR_PERSISTED_STATE, appContext, true);
		clearPersistedState = value != null && Boolean.parseBoolean(value);
		eclipseContext.set(E4Workbench.CLEAR_PERSISTED_STATE, Boolean.valueOf(clearPersistedState));

		// Delta save and restore
		boolean deltaRestore;
		value = getArgValue(E4Workbench.DELTA_RESTORE, appContext, false);
		deltaRestore = value == null || Boolean.parseBoolean(value);
		eclipseContext.set(E4Workbench.DELTA_RESTORE, Boolean.valueOf(deltaRestore));

		String resourceHandler = getArgValue(E4Workbench.MODEL_RESOURCE_HANDLER, appContext, false);

		if (resourceHandler == null) {
			resourceHandler = "bundleclass://org.eclipse.e4.ui.workbench/" + ResourceHandler.class.getName();
		}

		IContributionFactory factory = eclipseContext.get(IContributionFactory.class);

		handler = (IModelResourceHandler) factory.create(resourceHandler, eclipseContext);

		Resource resource = handler.loadMostRecentModel();
		theApp = (MApplication) resource.getContents().get(0);

		return theApp;
	}
	
	private String getArgValue(String argName, IApplicationContext appContext, boolean singledCmdArgValue) {
		// Is it in the arg list ?
		if (argName == null || argName.length() == 0)
			return null;

		if (singledCmdArgValue) {
			for (int i = 0; i < args.length; i++) {
				if (("-" + argName).equals(args[i]))
					return "true";
			}
		} else {
			for (int i = 0; i < args.length; i++) {
				if (("-" + argName).equals(args[i]) && i + 1 < args.length)
					return args[i + 1];
			}
		}

		final String brandingProperty = appContext.getBrandingProperty(argName);
		return brandingProperty == null ? System.getProperty(argName) : brandingProperty;
	}

	// TODO This should go into a different bundle
	public static IEclipseContext createDefaultHeadlessContext() {
			IEclipseContext serviceContext = E4Workbench.getServiceContext();

			IExtensionRegistry registry = RegistryFactory.getRegistry();
			ExceptionHandler exceptionHandler = new ExceptionHandler();
			ReflectionContributionFactory contributionFactory = new ReflectionContributionFactory(
					registry);
			serviceContext.set(IContributionFactory.class, contributionFactory);
			serviceContext.set(IExceptionHandler.class, exceptionHandler);
			serviceContext.set(IExtensionRegistry.class, registry);

			// translation
			String locale = Locale.getDefault().toString();
			serviceContext.set(TranslationService.LOCALE, locale);
			TranslationService bundleTranslationProvider = TranslationProviderFactory
					.bundleTranslationService(serviceContext);
			serviceContext.set(TranslationService.class, bundleTranslationProvider);

			serviceContext.set(Adapter.class, ContextInjectionFactory.make(
					EclipseAdapter.class, serviceContext));

			// No default log provider available
			if (serviceContext.get(ILoggerProvider.class) == null) {
				serviceContext.set(ILoggerProvider.class, ContextInjectionFactory.make(LoggerProviderImpl.class, serviceContext));
			}

			return serviceContext;
	}

	public static IEclipseContext createDefaultContext() {
		IEclipseContext serviceContext = E4Workbench.getServiceContext();
		final IEclipseContext appContext = serviceContext.createChild("WorkbenchContext");
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

	private boolean checkInstanceLocation(Location instanceLocation) {
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
				logger.error("Could not create instance location", e);
				// MessageDialog.openError(shell,
				// WorkbenchSWTMessages.InternalError, e.getMessage());
			}
			return false;
		}

		return false;
	}

	private boolean checkValidWorkspace(URL url) {
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
			FileInputStream is = new FileInputStream(versionFile);
			try {
				props.load(is);
			} finally {
				is.close();
			}

			return props.getProperty(WORKSPACE_VERSION_KEY);
		} catch (IOException e) {
			LoggerCreator.createLogger(E4Application.class).error("Unable to create workspace", e);
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

		OutputStream output = null;
		try {
			String versionLine = WORKSPACE_VERSION_KEY + '=' + WORKSPACE_VERSION_VALUE;

			output = new FileOutputStream(versionFile);
			output.write(versionLine.getBytes("UTF-8")); //$NON-NLS-1$
		} catch (IOException e) {
			LoggerCreator.createLogger(E4Application.class).error("Unable to write workspace version", e);
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				// do nothing
			}
		}
	}

	public void saveModel() {
		try {
			handler.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
