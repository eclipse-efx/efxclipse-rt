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
package org.eclipse.fx.osgi.threex;

import org.eclipse.osgi.baseadaptor.HookConfigurator;
import org.eclipse.osgi.baseadaptor.HookRegistry;

/**
 * Configurations for FX
 */
public class FXClassLoadingConfigurator implements HookConfigurator {
	/**
	 * Debug enabled
	 */
	public static final boolean DEBUG = Boolean.getBoolean("efxclipse.osgi.hook.debug"); //$NON-NLS-1$

	/**
	 *
	 */
	public FXClassLoadingConfigurator() {
		if( DEBUG ) {
			System.err.println("FXClassLoadingConfigurator - This is the classloading configurator");	 //$NON-NLS-1$
		}

	}

	@Override
	public void addHooks(HookRegistry hookRegistry) {
		if( DEBUG ) {
			System.err.println("FXClassLoadingConfigurator - Adding hooks for classloading");	 //$NON-NLS-1$
		}
		FXClassLoaderDelegate cl = new FXClassLoaderDelegate();
		hookRegistry.addAdaptorHook(cl);
		hookRegistry.addClassLoaderDelegateHook(cl);
	}

}