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
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

public class PatchListener implements SynchronousBundleListener {
	private final HashMap patches = new HashMap();

	public void bundleChanged(BundleEvent event) {
		if ((event.getType() & (BundleEvent.UNINSTALLED | BundleEvent.UNRESOLVED)) == 0)
			return; // only reset on resolved/unresolved and uninstalled events
		synchronized (patches) {
			for (Iterator entries = patches.entrySet().iterator(); entries.hasNext();) {
				Map.Entry entry = (Entry) entries.next();
				Collection bundles = (Collection) entry.getValue();
				if (bundles.contains(event.getBundle())) {
					PFBundleFile bundleFile = (PFBundleFile) entry.getKey();
					bundleFile.resetPatches();
					entries.remove();
				}
			}
		}
	}

	public void listenToPatches(Collection bundles, PFBundleFile patched) {
		synchronized (patches) {
			patches.put(patched, bundles);
		}
	}
}
