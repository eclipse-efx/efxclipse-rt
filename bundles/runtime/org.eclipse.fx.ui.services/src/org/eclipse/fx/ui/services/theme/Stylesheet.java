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
package org.eclipse.fx.ui.services.theme;

import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Stylesheet registered on a theme
 *
 * @since 1.2
 */
public interface Stylesheet {
	/**
	 * Check if the stylesheet applies to the given theme
	 *
	 * @param t
	 *            the theme
	 * @return <code>true</code> if the stylesheet applies
	 */
	public boolean appliesToTheme(Theme t);

	/**
	 * @return the url to the stylesheet
	 */
	public @NonNull URL getURL();
}
