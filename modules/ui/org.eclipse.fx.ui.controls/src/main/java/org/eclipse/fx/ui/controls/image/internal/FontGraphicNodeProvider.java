/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.internal;

import org.eclipse.fx.ui.controls.image.FontIconView;
import org.eclipse.fx.ui.controls.image.GraphicNodeProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Node;

/**
 * Font graphic
 */
@Component
public class FontGraphicNodeProvider implements GraphicNodeProvider {

	@Override
	public @NonNull String getName() {
		return "FontGraphic"; //$NON-NLS-1$
	}

	@Override
	public boolean handles(String url) {
		return url.startsWith("font:"); //$NON-NLS-1$
	}

	@Override
	public @NonNull Node getGraphicNode(String uri) {
		FontIconView v = new FontIconView();
		v.getStyleClass().add(uri.substring("font:".length())); //$NON-NLS-1$
		return v;
	}

}