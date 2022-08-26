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
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image;

import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.text.Font;

/**
 * An icon provider which translate a symbolic name to a char-code
 */
public abstract class FontIconProvider {
	/**
	 * @return the provider name
	 */
	public abstract String getName();

	/**
	 * @return the namespace for this font
	 */
	public abstract String getNamespace();

	/**
	 * Method to map a symbolic name to a char
	 *
	 * @param id
	 *            the id
	 * @return the char
	 */
	public abstract char map(@NonNull String id);

	/**
	 * @return the font
	 */
	public abstract @NonNull Font getFont();
}
