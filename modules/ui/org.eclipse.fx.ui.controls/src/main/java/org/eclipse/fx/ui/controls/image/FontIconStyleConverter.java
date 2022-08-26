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

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;

/**
 * Convert the string into an icon
 */
public class FontIconStyleConverter extends StyleConverter<String, FontIcon> {

	@Override
	public FontIcon convert(ParsedValue<String, FontIcon> value, Font font) {
		String v = value.getValue();
		if( v == null ) {
			return FontIcon.UNKNOWN;
		}
		return FontIcon.create(v).orElse(FontIcon.UNKNOWN);
	}


}
