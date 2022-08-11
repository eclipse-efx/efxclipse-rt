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
package org.eclipse.fx.code.server.jdt.server;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode("org.eclipse.core.resources");
		node.putBoolean(ResourcesPlugin.PREF_LIGHTWEIGHT_AUTO_REFRESH, true);
		node.putBoolean(ResourcesPlugin.PREF_AUTO_REFRESH, true);
		node.sync();
		node.flush();
		
		System.err.println("START UP");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.err.println("SHUTDOWN");
		ResourcesPlugin.getWorkspace().save(true, null);
	}

}
