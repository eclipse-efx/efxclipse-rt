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

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;

//import com.sun.javafx.Utils;

/**
 * Convert the string into an icon
 */
@SuppressWarnings("restriction")
public class FontIconStyleConverter extends StyleConverter<String, FontIcon> {

	@Override
	public FontIcon convert(ParsedValue<String, FontIcon> value, Font font) {
		String v = value.getValue();
//		v = Utils.convertUnicode(v);
		
		if (v.length() == 1) {
			char c = v.charAt(0);
			return FontIcon.create(c);
		}
		else {
			return FontIcon.create(v);
		}
	}
	
	
}
