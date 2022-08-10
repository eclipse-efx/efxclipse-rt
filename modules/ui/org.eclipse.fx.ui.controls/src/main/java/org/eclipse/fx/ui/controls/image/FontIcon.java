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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.text.Font;

/**
 * Representation of a font icon
 */
public abstract class FontIcon {
	/**
	 * @return the icon code
	 */
	public abstract char getIconCode();

	/**
	 * @return the icon name
	 */
	public abstract @NonNull String getIconName();

	/**
	 * @return the font
	 */
	public abstract @NonNull Font getFont();

	private static Map<String, FontIconProvider> PROVIDER_MAP = new HashMap<>();

	static
	{
		PROVIDER_MAP.putAll(ServiceUtils.getServiceList(FontIconProvider.class).stream().collect(Collectors.toMap(FontIconProvider::getNamespace, p -> p)));
	}

	/**
	 * FontIcon used if no matching icon can be found
	 */
	public static final FontIcon UNKNOWN = new FontIcon() {

		@Override
		public @NonNull String getIconName() {
			return "unknown"; //$NON-NLS-1$
		}

		@Override
		public char getIconCode() {
			return '?';
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull Font getFont() {
			return Font.getDefault();
		}
	};

	FontIcon() {
	}

	/**
	 * Create an icon with the given name
	 *
	 * @param iconName
	 *            the icon name
	 * @return the icon instance
	 */
	public static Optional<FontIcon> create(@NonNull final String iconName) {
		int idx = iconName.indexOf('-');
		if( idx > 0 ) {
			FontIconProvider iconProvider = PROVIDER_MAP.get(iconName.substring(0,idx));
			if( iconProvider != null ) {
				return Optional.of(new FontIcon() {
					@Override
					public @NonNull Font getFont() {
						return iconProvider.getFont();
					}

					@Override
					public char getIconCode() {
						return iconProvider.map(iconName);
					}

					@Override
					public String getIconName() {
						return iconName;
					}
				});
			}
		}
		return Optional.empty();
	}
}
