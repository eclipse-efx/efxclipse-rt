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
package org.eclipse.fx.osgi.fxloader;

import org.eclipse.osgi.baseadaptor.HookConfigurator;
import org.eclipse.osgi.baseadaptor.HookRegistry;

public class FXClassLoadingConfigurator implements HookConfigurator {
	public static final boolean DEBUG = Boolean.getBoolean("efxclipse.osgi.hook.debug");
	
	public FXClassLoadingConfigurator() {
		if( DEBUG ) {
			System.err.println("FXClassLoadingConfigurator - This is the classloading configurator");	
		}
		
	}
	
	@Override
	public void addHooks(HookRegistry hookRegistry) {
		if( DEBUG ) {
			System.err.println("FXClassLoadingConfigurator - Adding hooks for classloading");	
		}
		FXClassLoader cl = new FXClassLoader();
		hookRegistry.addAdaptorHook(cl);
		hookRegistry.addClassLoadingHook(cl);
		hookRegistry.addClassLoaderDelegateHook(new FXClassLoaderDelegate());
	}

}
