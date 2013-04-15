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
package org.eclipse.fx.ui.application;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.databinding.JFXRealm;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public abstract class AbstractJFXApplication implements IApplication {
	private static AbstractJFXApplication SELF;
	
	private IApplicationContext applicationContext;
	private Object returnValue;
	private EventAdmin eventAdmin;
	
	public static class JFXApp extends Application {
		private AbstractJFXApplication osgiApp = SELF;
		private IApplicationContext applicationContext;
		
		@Override
		public void start(final Stage primaryStage) throws Exception {
			this.applicationContext = osgiApp.applicationContext;
			
			JFXRealm.createDefault();
			osgiApp.jfxStart(applicationContext,JFXApp.this,primaryStage);
			
			if( osgiApp.eventAdmin != null ) {
				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("name", value);
				osgiApp.eventAdmin.sendEvent(new Event("efxapp/applicationLaunched", map));
			}
		}
		
		@Override
		public void stop() throws Exception {
			super.stop();
			osgiApp.returnValue = osgiApp.jfxStop();
		}
	}
	
	@Override
	public final Object start(IApplicationContext context) throws Exception {
		SELF = this;
		this.applicationContext = context;
		this.applicationContext.applicationRunning();
		
		Bundle b = FrameworkUtil.getBundle(AbstractJFXApplication.class);
		BundleContext bundleContext = b.getBundleContext();
		ServiceReference<EventAdmin> ref = bundleContext.getServiceReference(EventAdmin.class);
		if( ref != null ) {
			eventAdmin = bundleContext.getService(ref);
		}
		
		// Looks like OS-X wants to have the context class loader to locate FX-Classes
		Thread.currentThread().setContextClassLoader(Application.class.getClassLoader());
		
		Application.launch(JFXApp.class);
		
		try {
			return returnValue == null ? IApplication.EXIT_OK : returnValue;
		} finally {
			returnValue = null;
		}
	}

	@Override
	public final void stop() {
		
	}

	protected abstract void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage);
	
	protected Object jfxStop() {
		return IApplication.EXIT_OK;
	}
}
