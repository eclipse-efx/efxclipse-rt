/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.internal;

import org.eclipse.fx.ui.controls.image.GraphicNodeProvider;
import org.eclipse.fx.ui.controls.image.ImageClipNode;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Node;

/**
 * Image clip node provider
 *
 * @since 3.0
 */
@Component
public class ImageClipNodeProvider implements GraphicNodeProvider {

	@Override
	public @NonNull String getName() {
		return "Image Clip"; //$NON-NLS-1$
	}

	@Override
	public boolean handles(String url) {
		return url.startsWith("image-clip:"); //$NON-NLS-1$
	}

	@Override
	public @NonNull Node getGraphicNode(String uri) {
		ImageClipNode node = new ImageClipNode();
		node.getStyleClass().add(uri.substring("image-clip:".length())); //$NON-NLS-1$
		return node;
	}

}
