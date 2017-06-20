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
package org.eclipse.fx.osgi.fxloader;

import org.eclipse.osgi.internal.hookregistry.HookConfigurator;
import org.eclipse.osgi.internal.hookregistry.HookRegistry;

/**
 * Hook configurator for classloading
 */
public class FXClassloaderConfigurator implements HookConfigurator {
	/**
	 * Debug switch
	 */
	public static final boolean DEBUG = Boolean.getBoolean("efxclipse.osgi.hook.debug"); //$NON-NLS-1$

	@Override
	public void addHooks(HookRegistry hookRegistry) {
		hookRegistry.addClassLoaderHook(new FXClassLoader());
	}

}
