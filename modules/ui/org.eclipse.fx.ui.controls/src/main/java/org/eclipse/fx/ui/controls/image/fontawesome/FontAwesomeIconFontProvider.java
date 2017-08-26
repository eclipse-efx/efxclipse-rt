/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.fontawesome;

import org.eclipse.fx.ui.controls.image.FontAwesomeIcons;
import org.eclipse.fx.ui.controls.image.FontIconProvider;
import org.osgi.service.component.annotations.Component;

import javafx.scene.text.Font;

/**
 * Provider for font-awesome
 */
@Component(service=FontIconProvider.class)
public class FontAwesomeIconFontProvider extends FontIconProvider {

	private static final Font font = Font.loadFont(FontAwesomeIconFontProvider.class.getResourceAsStream("FontAwesome.otf"), 24); //$NON-NLS-1$

	@Override
	public String getNamespace() {
		return "fa"; //$NON-NLS-1$
	}

	@Override
	@SuppressWarnings("null")
	public Font getFont() {
		return font;
	}

	@Override
	public String getName() {
		return font.getName();
	}

	@Override
	public char map(String name) {
		return FontAwesomeIcons.getCharacter(name);
	}
}
