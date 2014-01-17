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

import java.util.*;
import java.util.Map.Entry;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

/**
 * Listener to patch a bundle
 */
public class PatchListener implements SynchronousBundleListener {
	private final HashMap<PFBundleFile,Collection<Bundle>> patches = new HashMap<PFBundleFile,Collection<Bundle>>();

	@Override
	public void bundleChanged(BundleEvent event) {
		if ((event.getType() & (BundleEvent.UNINSTALLED | BundleEvent.UNRESOLVED)) == 0)
			return; // only reset on resolved/unresolved and uninstalled events
		synchronized (this.patches) {
			for (Iterator<Entry<PFBundleFile,Collection<Bundle>>> entries = this.patches.entrySet().iterator(); entries.hasNext();) {
				Entry<PFBundleFile,Collection<Bundle>> entry = entries.next();
				Collection<Bundle> bundles = entry.getValue();
				if (bundles.contains(event.getBundle())) {
					PFBundleFile bundleFile = (PFBundleFile) entry.getKey();
					bundleFile.resetPatches();
					entries.remove();
				}
			}
		}
	}

	/**
	 * @param bundles
	 * @param patched
	 */
	public void listenToPatches(Collection<Bundle> bundles, PFBundleFile patched) {
		synchronized (this.patches) {
			this.patches.put(patched, bundles);
		}
	}
}
