/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.tool.event.spy.internal.util;

import org.eclipse.fx.tool.event.spy.internal.constants.Constants;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Utility class.
 */
public class PluginUtils {
	public static String getContributorURI() {
		return String.format("platform:/plugin/%s", Constants.PLUGIN_ID);
	}

	public static String getContributionURI(Class<?> contributionCls) {
		return String.format("bundleclass://%s/%s", Constants.PLUGIN_ID, contributionCls.getName());
	}

	public static String getBundleId(Class<?> cls) {
		Bundle bundle = FrameworkUtil.getBundle(cls);
		if (bundle == null) {
			throw new IllegalArgumentException("Cannot find bundle for class: " + cls.getName());
		}
		return bundle.getSymbolicName();
	}
}
