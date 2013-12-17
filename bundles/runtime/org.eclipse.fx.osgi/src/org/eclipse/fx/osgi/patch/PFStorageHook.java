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

import java.io.*;
import java.util.Dictionary;

import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.baseadaptor.hooks.StorageHook;
import org.eclipse.osgi.framework.util.KeyedElement;
import org.osgi.framework.Constants;

/**
 * A storage hook that records if a bundle is a 
 * patch fragment or not.
 */
public class PFStorageHook implements StorageHook {
	/**
	 * The convention is to use the class name as the key for the keyed element
	 * for storage hooks
	 */
	public static final String KEY = PFStorageHook.class.getName();
	/**
	 * The key hash code is constant
	 */
	public static final int HASHCODE = KEY.hashCode();
	/**
	 * The header used to specify a patch fragment
	 */
	public static final String BUNDLE_TYPE_HEADER = "Equinox-BundleType"; //$NON-NLS-1$
	/**
	 * The value of the {@link #BUNDLE_TYPE_HEADER} that indicates a patch fragment
	 */
	public static final String BUNDLE_TYPE_PATCH = "fxpatch.fragment"; //$NON-NLS-1$

	/**
	 * Indicates if this storage hook is for a patch fragment
	 */
	private volatile boolean patchFragment = false;

	@Override
	public void copy(StorageHook storageHook) {
		// nothing; Equinox-BundleType will be reread
	}

	@Override
	public StorageHook create(BaseData bundledata) {
		return new PFStorageHook();
	}

	@Override
	public boolean forgetStartLevelChange(int startlevel) {
		// nothing
		return false;
	}

	@Override
	public boolean forgetStatusChange(int status) {
		// nothing
		return false;
	}

	@Override
	public Dictionary<String, String> getManifest(boolean firstLoad) {
		// nothing
		return null;
	}

	@Override
	public int getStorageVersion() {
		return 0;
	}

	/**
	 * Checks the manifest for a patch fragment
	 */
	@Override
	public void initialize(Dictionary<String, String> manifest) {
		// make sure this is a fragment manifest
		if (manifest.get(Constants.FRAGMENT_HOST) == null)
			return; // not a fragment;
		String type = (String) manifest.get(BUNDLE_TYPE_HEADER);
		this.patchFragment = BUNDLE_TYPE_PATCH.equals(type);
	}

	/**
	 * Loads a PFStorageHook from an input stream.  The only data stored
	 * is a boolean to indicate if the storage hook is a patch fragment.
	 */
	@Override
	public StorageHook load(BaseData bundledata, DataInputStream is) throws IOException {
		// This method should always create a new storage hook object to load the data into
		PFStorageHook loadHook = new PFStorageHook();
		loadHook.patchFragment = is.readBoolean();
		return loadHook;
	}

	/**
	 * @param pattern
	 * @return always false
	 */
	public static boolean matchDNChain(String pattern) {
		// nothing
		return false;
	}

	/**
	 * Saves the patch fragment.  The only data stored is a boolean
	 * to indicate if the storage hook is a patch fragment.
	 */
	@Override
	public void save(DataOutputStream os) throws IOException {
		os.writeBoolean(this.patchFragment);
	}

	@Override
	public void validate() throws IllegalArgumentException {
		// nothing
	}

	@Override
	public int getKeyHashCode() {
		return HASHCODE;
	}

	@Override
	public boolean compare(KeyedElement other) {
		return other.getKey() == KEY;
	}

	@Override
	public Object getKey() {
		return KEY;
	}

	/**
	 * Indicates if this storage hook is for a patch fragment
	 * @return true if this storage hook is for a patch fragment
	 */
	boolean isPatchFragment() {
		return this.patchFragment;
	}
}
