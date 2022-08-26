/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.app;

import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.prefs.BackingStoreException;

public class TogglePresentationModeHandler {
	static class PresentationModeStylesheet implements Stylesheet {

		@Override
		public boolean appliesToTheme(Theme t) {
			return true;
		}

		@Override
		public @NonNull URL getURL(Theme t) {
			return getClass().getClassLoader().getResource("css/presentationMode.css");
		}

	}
	
	private static PresentationModeStylesheet STYLESHEET = new PresentationModeStylesheet();
	private static ServiceRegistration<Stylesheet> SERVICE_REG;
	
	@Execute
	public void execute(@Service List<Theme> themes, @Preference() IEclipsePreferences preferences) {
		if( ! preferences.getBoolean("presentationMode", false) && SERVICE_REG == null ) {
			enablePresentationMode();
		} else {
			disenablePresentationMode();
		}
		
		try {
			preferences.putBoolean("presentationMode",preferences.getBoolean("presentationMode", false));
			preferences.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void enablePresentationMode() {
		BundleContext bundleContext = FrameworkUtil.getBundle(TogglePresentationModeHandler.class).getBundleContext();
		SERVICE_REG = bundleContext.registerService(Stylesheet.class, STYLESHEET, new Hashtable<>());
	}
	
	public static void disenablePresentationMode() {
		if( SERVICE_REG != null ) {
			SERVICE_REG.unregister();
			SERVICE_REG = null;
		}
	}
}