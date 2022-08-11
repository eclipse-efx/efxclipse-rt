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
package org.eclipse.fx.code.compensator.editor.internal;

import java.net.URL;

import org.eclipse.fx.code.compensator.editor.spi.EditorStylesheet;
import org.eclipse.fx.ui.services.theme.Theme;

public class StylesheetImpl extends EditorStylesheet {
	@Override
	public URL getURL(Theme t) {
		URL url = super.getURL(t);
		return url;
	}
}
