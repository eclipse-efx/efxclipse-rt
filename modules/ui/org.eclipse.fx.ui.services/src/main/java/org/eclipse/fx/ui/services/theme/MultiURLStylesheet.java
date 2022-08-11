/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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

import javafx.collections.ObservableList;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A stylesheet that is made up of multiple (potentially changeing) urls
 * 
 * @since 2.0
 */
public interface MultiURLStylesheet {
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
	public @NonNull ObservableList<@NonNull URL> getURL(Theme t);
}
