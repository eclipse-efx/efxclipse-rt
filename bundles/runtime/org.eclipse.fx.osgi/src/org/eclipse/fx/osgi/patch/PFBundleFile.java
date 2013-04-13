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

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.baseadaptor.bundlefile.BundleEntry;
import org.eclipse.osgi.baseadaptor.bundlefile.BundleFile;
import org.eclipse.osgi.framework.internal.core.AbstractBundle;
import org.eclipse.osgi.internal.baseadaptor.DevClassPathHelper;
import org.osgi.framework.Bundle;
import org.osgi.service.packageadmin.PackageAdmin;

/**
 * A bundle file that wraps the content of another bundle file.
 * A list of bundle files is used to patch the content of the
 * wrapped bundle file.  The list of patches is searched 
 * before the wrapped bundle file.  This allows the 
 * content of the patches to override (or patch) the 
 * content of the wrapped bundle file.
 */
public class PFBundleFile extends BundleFile {
	/**
	 * The wrapped bundle file that is being patched
	 */
	private final BundleFile wrapped;
	/**
	 * The BaseData for the wrapped bundle file
	 */
	private final BaseData patchedData;
	/**
	 * The adaptor hook
	 */
	private final PFAdaptorHook pfAdaptorHook;
	/**
	 * Indicates that the list of patches is current and ready to use
	 */
	private boolean processed = false;
	/**
	 * The list of patch bundle files that are associated with this bundle file.
	 */
	private BundleFile[] patches;

	public PFBundleFile(BundleFile wrapped, BaseData patchedData, PFAdaptorHook pfAdaptorHook) {
		// use the base file from the wrapped bundle file
		super(wrapped.getBaseFile());
		this.wrapped = wrapped;
		this.patchedData = patchedData;
		this.pfAdaptorHook = pfAdaptorHook;
	}

	public void close() throws IOException {
		wrapped.close();
	}

	public boolean containsDir(String dir) {
		return wrapped.containsDir(dir);
	}

	public BundleEntry getEntry(String path) {
		// see if there are any patches available
		BundleFile[] patchFiles = getPatches();
		if (patchFiles == null) // none available just use the wrapped content
			return wrapped.getEntry(path);
		if ("META-INF/MANIFEST.MF".equals(path)) //$NON-NLS-1$
			return wrapped.getEntry(path); // don't patch manifest
		for (int i = 0; i < patchFiles.length; i++) {
			BundleEntry entry = patchFiles[i].getEntry(path);
			if (entry != null) { // found patched content; return it
				if (PFConfigurator.DEBUG)
					System.out.println("Found patch for \"" + path + "\" in \"" + patchFiles[i] + "\""); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				return entry;
			}
		}
		// no patched content found for the path; use the wrapped content
		return wrapped.getEntry(path);
	}

	public Enumeration getEntryPaths(String path) {
		// we simply call the wrapped bundle file here because
		// we do not want to return more entries than what the original content has
		return wrapped.getEntryPaths(path);
	}

	public File getFile(String path, boolean nativeCode) {
		// see if there are any patches available
		BundleFile[] patchFiles = getPatches();
		if (patchFiles == null) // none available just use the wrapped content
			return wrapped.getFile(path, nativeCode);
		for (int i = 0; i < patchFiles.length; i++) {
			File file = patchFiles[i].getFile(path, nativeCode);
			if (file != null) // found patched content; return it
				return file;
		}
		// no patched content found for the path; use the wrapped content
		return wrapped.getFile(path, nativeCode);
	}

	public void open() throws IOException {
		wrapped.open();
	}

	private synchronized BundleFile[] getPatches() {
		if (processed) // the patches list is current; return it
			return patches;
		Bundle bundle = patchedData.getBundle();
		if (bundle == null)
			// BundleFile objects are created before the Bundle object
			return null; // we don't know yet
		// bundle is not resolved; we can only patch after the bundle is resolved
		if (((Bundle.INSTALLED | Bundle.UNINSTALLED) & bundle.getState()) != 0)
			return null; // we can only patch if resolved;
		// bundle is resolved; now check package admin for patch fragments
		PackageAdmin pa = pfAdaptorHook.getPackageAdmin();
		if (pa == null)
			return null; // we cannot know without PA
		// collect a list of bundles we need to listen for UNRESOLVED/UNINSTALLED events
		Collection bundlesToListen = new ArrayList();
		try {
			if ((pa.getBundleType(bundle) & PackageAdmin.BUNDLE_TYPE_FRAGMENT) == 0)
				bundlesToListen.add(bundle); // Always listen to the host bundle
			else
				return null; // we don't patch fragments; no need to listen
			Bundle[] fragments = pa.getFragments(bundle);
			if (fragments == null)
				return null; // no fragments
			// search the fragments for patch fragments
			ArrayList patchList = new ArrayList(fragments.length);
			for (int i = 0; i < fragments.length; i++) {
				AbstractBundle fragment = (AbstractBundle) fragments[i];
				BaseData fragmentData = (BaseData) fragment.getBundleData();
				// The PFStorageHook knows if this is a patch fragment
				PFStorageHook storageHook = (PFStorageHook) fragmentData.getStorageHook(PFStorageHook.KEY);
				if (storageHook.isPatchFragment()) {
					if (PFConfigurator.DEBUG)
						System.out.println("Found patch fragment: " + fragmentData.toString()); //$NON-NLS-1$
					patchList.add(fragmentData.getBundleFile());
					// need to listen to this fragment
					bundlesToListen.add(fragment);
					// add in dev classpaths
					if (DevClassPathHelper.inDevelopmentMode()) {
						String[] devPath = DevClassPathHelper.getDevClassPath(fragmentData.getSymbolicName());
						if (devPath != null) {
							for (int j = 0; j < devPath.length; j++) {
								File devFile = fragmentData.getBundleFile().getFile(devPath[i], false);
								patchList.add(pfAdaptorHook.createDevClasspathBundleFile(devFile, fragmentData));
							}
						}
					}
				}
				patches = (BundleFile[]) patchList.toArray(new BundleFile[patchList.size()]);
			}
		} finally {
			// tell the listener about the list to listen
			pfAdaptorHook.listenToPatches(bundlesToListen, this);
			// mark the patches as processed
			processed = true;
		}
		return patches;
	}

	synchronized void resetPatches() {
		// reset the patches list so it will be re-computed.
		processed = false;
		patches = null;
	}

	public String toString() {
		return patchedData.toString();
	}
}
