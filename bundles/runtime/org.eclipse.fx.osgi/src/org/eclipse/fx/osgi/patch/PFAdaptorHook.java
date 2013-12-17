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
import java.net.URLConnection;
import java.util.Collection;
import java.util.Properties;

import org.eclipse.osgi.baseadaptor.BaseAdaptor;
import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.baseadaptor.bundlefile.BundleFile;
import org.eclipse.osgi.baseadaptor.hooks.AdaptorHook;
import org.eclipse.osgi.framework.log.FrameworkLog;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;

/**
 * AdaptorHook hook into the lifecycle of the BaseAdaptor.  This hook 
 * is needed to access the system.bundle BundleContext to track 
 * PackageAdmin and add a BundleListener.
 */
@SuppressWarnings("deprecation")
public class PFAdaptorHook implements AdaptorHook {
	/**
	 * Tracks PackageAdmin
	 */
	private volatile ServiceTracker<?,PackageAdmin> paTracker;
	/**
	 * The BaseAdpator
	 */
	private volatile BaseAdaptor baseAdaptor;
	/**
	 * A BundleListener that listens for when patched content becomes uninstalled or unresolved
	 */
	private volatile PatchListener patchListener;

	@Override
	public void addProperties(Properties properties) {
		// nothing
	}

	@Override
	public FrameworkLog createFrameworkLog() {
		// nothing
		return null;
	}

	/**
	 * Opens the ServiceTracker for PackageAdmin and registers the PatchListener.
	 */
	@Override
	public void frameworkStart(BundleContext context) {
		this.paTracker = new ServiceTracker<>(context, PackageAdmin.class.getName(), null);
		this.paTracker.open();
		this.patchListener = new PatchListener();
		context.addBundleListener(this.patchListener);
	}

	/**
	 * Removes the PatchListener and closes the PackageAdmin ServiceTracker.
	 */
	@Override
	public void frameworkStop(BundleContext context) {
		context.removeBundleListener(this.patchListener);
		this.patchListener = null;
		this.paTracker.close();
		this.paTracker = null;
	}

	@Override
	public void frameworkStopping(BundleContext context) {
		// nothing
	}

	@Override
	public void handleRuntimeError(Throwable error) {
		// nothing
	}

	@Override
	public void initialize(BaseAdaptor adaptor) {
		this.baseAdaptor = adaptor;
	}

	@Override
	public URLConnection mapLocationToURLConnection(String location) {
		// nothing
		return null;
	}

	/**
	 * @param pattern
	 * @param dnChain
	 * @return always <code>false</code>
	 */
	public static boolean matchDNChain(String pattern, String[] dnChain) { 
		// nothing
		return false;
	}

	/**
	 * Gets the PackageAdmin service from the tracker
	 * @return the PackageAdmin service or null if it is not available
	 */
	PackageAdmin getPackageAdmin() {
		ServiceTracker<?,PackageAdmin> tracker = this.paTracker;
		if (tracker == null)
			return null;
		return tracker.getService();
	}

	/**
	 * Convenience method for creating dev classpath BundleFiles
	 * @param devFile the dev classpath file
	 * @param fragmentData the fragment for the dev classpath
	 * @return a BundleFile to be used for a dev classpath.
	 */
	BundleFile createDevClasspathBundleFile(File devFile, BaseData fragmentData) {
		BaseAdaptor adaptor = this.baseAdaptor;
		if (adaptor == null)
			return null;
		try {
			return adaptor.createBundleFile(devFile, fragmentData);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Associates the list of bundles with a PFBundleFile.
	 * If any of the bundles in the list become unresolved then the PFBundleFile
	 * is reset.
	 * @param bundlesToListen the bundles to listen for
	 * @param bundleFile the PFBundleFile associated with the bundles.
	 */
	void listenToPatches(Collection<Bundle> bundlesToListen, PFBundleFile bundleFile) {
		PatchListener listener = this.patchListener;
		if (listener == null)
			return;
		listener.listenToPatches(bundlesToListen, bundleFile);
	}
}
