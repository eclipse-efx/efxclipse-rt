/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Representation of a font icon
 */
public interface FontIcon {
	/**
	 * @return the icon code
	 */
	public char getIconCode();

	/**
	 * @return the icon name
	 */
	public @NonNull String getIconName();

	/**
	 * Create an icon with the given code
	 * 
	 * @param iconCode
	 *            the icon code
	 * @return the icon instance
	 */
	public static FontIcon create(final char iconCode) {
		return new FontIcon() {
			@Override
			public char getIconCode() {
				return iconCode;
			}

			@Override
			public String getIconName() {
				return ""; //$NON-NLS-1$
			}
		};
	}

	/**
	 * Create an icon with the given name
	 * 
	 * @param iconName
	 *            the icon name
	 * @return the icon instance
	 */
	public static FontIcon create(@NonNull final String iconName) {
		return new FontIcon() {
			@Override
			public char getIconCode() {
				return '0';
			}

			@Override
			public String getIconName() {
				return iconName;
			}
		};
	}
}
