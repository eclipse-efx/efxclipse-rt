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
package org.eclipse.fx.core.app;

import java.net.URL;
import java.util.Optional;

import javafx.geometry.Point2D;

/**
 * Context associated with the application
 *
 * @since 3.0
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
