/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
 * A theme definition
 */
public interface Theme {
	/**
	 * @return unique theme id
	 */
	@NonNull
	public String getId();
	/**
	 * @return human readable name
	 */
	@NonNull
	public String getName();
	/**
	 * @return the stylesheets
	 * 
	 * @since 2.0
	 */
	@NonNull
	public ObservableList<@NonNull URL> getStylesheetURL();
}
