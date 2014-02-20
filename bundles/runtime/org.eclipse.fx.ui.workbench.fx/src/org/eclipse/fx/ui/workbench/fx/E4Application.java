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
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;
import org.eclipse.fx.osgi.util.AbstractJFXApplication.JFXApp;
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
	
	private E4Workbench workbench;
	private Location instanceLocation;
	private IEclipseContext workbenchContext;
	private static final String EXIT_CODE = "e4.osgi.exit.code"; //$NON-NLS-1$

	static E4Application SELF;
	
	IApplicationContext applicationContext;
	Object returnValue;
	EventAdmin eventAdmin;
	private Stage primaryStage;
	private Application application;
	
	/**
	 * Dummy class for bootstrap
	 */
	public static class JFXApp extends Application {
		private E4Application osgiApp = SELF;
		private IApplicationContext applicationContext;
		
		@Override
		public void start(final Stage primaryStage) throws Exception {
			this.applicationContext = this.osgiApp.applicationContext;
			
			JFXRealm.createDefault();
			this.osgiApp.jfxStart(this.applicationContext,JFXApp.this,primaryStage);
			
			if( this.osgiApp.eventAdmin != null ) {
				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("name", value);
				this.osgiApp.eventAdmin.sendEvent(new Event("efxapp/applicationLaunched", map)); //$NON-NLS-1$
			}
		}
		
		@Override
		public void stop() throws Exception {
			super.stop();
			this.osgiApp.returnValue = this.osgiApp.jfxStop();
		}
	}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		SELF = this;
		this.applicationContext = context;
		this.applicationContext.applicationRunning();
		
		Bundle b = FrameworkUtil.getBundle(AbstractJFXApplication.class);
		BundleContext bundleContext = b.getBundleContext();
		ServiceReference<EventAdmin> ref = bundleContext.getServiceReference(EventAdmin.class);
		if( ref != null ) {
			this.eventAdmin = bundleContext.getService(ref);
		}
		
		// Looks like OS-X wants to have the context class loader to locate FX-Classes
		Thread.currentThread().setContextClassLoader(Application.class.getClassLoader());
		
		Application.launch(JFXApp.class);
		
		try {
			return this.returnValue == null ? IApplication.EXIT_OK : this.returnValue;
		} finally {
			this.returnValue = null;
		}
	}
	
	void jfxStart(IApplicationContext context, JFXApp jfxApp, Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.application = jfxApp;
		workbench = createE4Workbench(context);
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
				context.applicationRunning();
			}
		}
	}
	
	@Override
	protected void preLifecycle(IEclipseContext appContext) {
		super.preLifecycle(appContext);
		appContext.set(Application.class, application);
		appContext.set("primaryStage", primaryStage);
		appContext.set(GraphicsLoader.class,ContextInjectionFactory.make(GraphicsLoaderImpl.class, appContext));
	}

	Object jfxStop() {
		Object returnCode = null;
		try {
			if( workbenchContext != null && workbench != null ) {
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
		
		if( returnCode != null ) {
			return returnCode;
		} else {
			return IApplication.EXIT_OK;
		}
	}
	
	@Override
	public void stop() {
		// do nothing
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

}
