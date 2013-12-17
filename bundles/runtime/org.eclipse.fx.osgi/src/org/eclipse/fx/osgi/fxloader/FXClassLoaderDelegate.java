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

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.osgi.framework.adaptor.BundleClassLoader;
import org.eclipse.osgi.framework.adaptor.BundleData;
import org.eclipse.osgi.framework.adaptor.ClassLoaderDelegateHook;

/*
 * Remember the classloader for use in post look ups because of native classloading by javafx' native code
 * See http://javafx-jira.kenai.com/browse/RT-20883
 */
/**
 * Final resort delegate for FX
 */
public class FXClassLoaderDelegate implements ClassLoaderDelegateHook {
	private boolean flag;
	
	@Override
	public Class<?> preFindClass(String name, BundleClassLoader classLoader, BundleData data) throws ClassNotFoundException {
		return null;
	}

	@Override
	public Class<?> postFindClass(String name, BundleClassLoader classLoader, BundleData data) throws ClassNotFoundException {
		if ("org.eclipse.swt".equals(data.getSymbolicName())) { //$NON-NLS-1$
			if (FXClassLoader.LOADER != null && name.startsWith("com.sun.glass") && !this.flag) { //$NON-NLS-1$
				try {
					// Avoid endless loop
					this.flag = true;
					return FXClassLoader.LOADER.loadClass(name);
				} catch (Throwable t) {
					t.printStackTrace();
				} finally {
					this.flag = false;
				}
			}
		}
		return null;
	}

	@Override
	public URL preFindResource(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public URL postFindResource(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public Enumeration<URL> preFindResources(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public Enumeration<URL> postFindResources(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public String preFindLibrary(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public String postFindLibrary(String name, BundleClassLoader classLoader, BundleData data) {
		return null;
	}

}
