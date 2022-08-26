/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.app;

import java.net.URL;
import java.util.Optional;

import javafx.geometry.Point2D;

/**
 * Context associated with the application
 * <p>This provisional API and subject to change</p>
 *
 * @since 3.0
 * @noimplement
 * @noreference
 */
public interface ApplicationContext {
	/**
	 * @return arguments passed on the command line when launching the
	 *         application
	 */
	String[] getApplicationArguments();

	/**
	 * Called when the application code has been entered (must be called on the
	 * same thread as the initial launching)
	 */
	void applicationRunning();

	/**
	 * @return information about a native splash screen if it exists
	 */
	Optional<Splash> getSplashImage();

	/**
	 * An application property
	 *
	 * @param key
	 *            the key
	 * @return the value
	 */
	Object getApplicationProperty(String key);

	Optional<ApplicationLocation> getInstanceLocation();

	/**
	 * Informations about the splash screen
	 */
	public interface Splash {
		/**
		 * @return the url
		 */
		public URL getUrl();

		/**
		 * @return the upper left corner
		 */
		public Point2D getLocation();
	}
}
