/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.fx.themes;

import java.net.URL;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;


public abstract class EditorStylesheet implements Stylesheet {
	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

	@Override
	public URL getURL(Theme t) {
		URL url = null;
		if( "dark".equals(t.getId()) || "theme.dark".equals(t.getId()) ) {
			url = getClass().getClassLoader().getResource("css/dark-highlight.css");
		} else {
			url = getClass().getClassLoader().getResource("css/highlight.css");
		}
		return url;
	}
}
