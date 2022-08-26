/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.ui.services.theme;

import java.net.URL;

import org.eclipse.jdt.annotation.Nullable;

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
	 * @param t
	 *            the theme
	 * @return the url to the stylesheet
	 */
	public @Nullable URL getURL(Theme t);
}
