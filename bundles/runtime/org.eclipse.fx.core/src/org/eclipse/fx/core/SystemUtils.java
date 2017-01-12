/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import java.util.Optional;

import org.eclipse.fx.core.log.LoggerCreator;

/**
 * System utilities
 *
 * @since 3.0
 */
public class SystemUtils {
	private static Boolean isOSGi;

	/**
	 * @return <code>true</code> if we are on JavaFX 2
	 */
	public static boolean isFX2() {
		return System.getProperty("javafx.version") != null && System.getProperty("javafx.version").startsWith("2"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * @return <code>true</code> if we are on JavaFX 9
	 * @since 2.2.0
	 */
	public static boolean isFX9() {
		return System.getProperty("javafx.version") != null && System.getProperty("javafx.version").startsWith("9"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
	}

	/**
	 * @return <code>true</code> if we are on JavaFX 8
	 * @since 2.2.0
	 */
	public static boolean isFX8() {
		return System.getProperty("javafx.version") != null && System.getProperty("javafx.version").startsWith("8"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
	}

	/**
	 * @return <code>true</code> if running on OSGi
	 */
	public static boolean isOsgiEnv() {
		if (isOSGi == null) {
			isOSGi = Boolean.FALSE;
			try {
				Class.forName("org.osgi.framework.FrameworkUtil"); //$NON-NLS-1$
				if (org.osgi.framework.FrameworkUtil.getBundle(SystemUtils.class) != null) {
					isOSGi = Boolean.TRUE;
				}
			} catch (Throwable e) {
				// nothing
			}
		}
		return isOSGi.booleanValue();
	}

	/**
	 * @return <code>true</code> if running on OS-X
	 * @since 2.2.0
	 */
	public static boolean isMacOS() {
		return "Mac OS X".equals(System.getProperty("os.name")); //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * @return <code>true</code> if running on windows
	 * @since 2.2.0
	 */
	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("windows"); //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * @return get the version of current java runtime
	 * @since 3.0.0
	 */
	public static Optional<Version> getJavaVersion() {
		String version = System.getProperty("java.runtime.version"); //$NON-NLS-1$
		// pre java 9
		if (version.startsWith("1.")) { //$NON-NLS-1$
			String v = version.substring(2).replaceFirst("_", "."); //$NON-NLS-1$//$NON-NLS-2$
			try {
				return Optional.of(Version.createVersion(v));
			} catch (Throwable t) {
				LoggerCreator.createLogger(Util.class).error("Failed to create version from " + version, t); //$NON-NLS-1$
				return Optional.empty();
			}
		}
		return Optional.empty();
	}
}
