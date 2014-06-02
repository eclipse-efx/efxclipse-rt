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
package org.eclipse.fx.ui.workbench.base.internal;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

/**
 * the bundles activator
 */
public class Activator implements BundleActivator {

	private BundleContext context;
	private ServiceTracker<Location,Location> locationTracker;
	private static Activator activator;

	/**
	 * Get the default activator.
	 * 
	 * @return a BundleActivator
	 */
	public static Activator getDefault() {
		return activator;
	}

	/**
	 * @return this bundles context
	 */
	public BundleContext getContext() {
		return this.context;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		activator = this;
		this.context = context;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		this.context = null;
		activator = null;
	}

	/**
	 * @return get the bundle
	 */
	public @Nullable Bundle getBundle() {
		if (this.context == null)
			return null;
		return this.context.getBundle();
	}

	/**
	 * @return the instance Location service
	 */
	public Location getInstanceLocation() {
		if (this.locationTracker == null) {
			Filter filter = null;
			try {
				filter = this.context.createFilter(Location.INSTANCE_FILTER);
			} catch (InvalidSyntaxException e) {
				// ignore this. It should never happen as we have tested the
				// above format
			}
			this.locationTracker = new ServiceTracker<>(this.context, filter, null);
			this.locationTracker.open();
		}
		return (Location) this.locationTracker.getService();
	}

}
