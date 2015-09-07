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
package org.eclipse.fx.ui.controls.image.spi;

import java.util.Iterator;

import org.eclipse.fx.core.Util;

import javafx.scene.text.Font;

/**
 * Icon look up
 */
public class IconFontLookup {

	/**
	 * Get a provider for the given font
	 *
	 * @param font
	 *            the font
	 * @return the provider
	 */
	public static IconFontProvider getProviderForFont(Font font) {
		// System.err.println("getProviderForFontSPI " + font);
		IconFontProvider result = null;

		Iterator<IconFontProvider> it = Util.lookupServiceList(IconFontProvider.class).iterator();
		while (it.hasNext()) {
			IconFontProvider sup = it.next();
			if (sup.getName().equals(font.getName())) {
				result = sup;
				break;
			}
		}

		// System.err.println("getProviderForFontSPI => " + result);
		return result;

	}
}
