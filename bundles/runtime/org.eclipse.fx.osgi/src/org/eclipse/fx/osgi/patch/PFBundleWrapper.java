/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.patch;

import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.baseadaptor.bundlefile.BundleFile;
import org.eclipse.osgi.baseadaptor.hooks.BundleFileWrapperFactoryHook;

/**
 * Wraps bundle files so that they can be patched with content from
 * patch fragments.
 */
public class PFBundleWrapper implements BundleFileWrapperFactoryHook {
	private final PFAdaptorHook adaptorHook;

	/**
	 * @param adaptorHook
	 */
	public PFBundleWrapper(PFAdaptorHook adaptorHook) {
		this.adaptorHook = adaptorHook;
	}

	@Override
	public BundleFile wrapBundleFile(BundleFile bundleFile, Object content, BaseData data, boolean base) {
		if (data.getBundleID() == 0)
			// it is usually a bad idea to modify the behavior of the system.bundle file.
			return null;
		// at this point we do not know if the BaseData is a host or a fragment;
		// we just create a PFBundleFile for all bundles
		return new PFBundleFile(bundleFile, data, this.adaptorHook);
	}

}
