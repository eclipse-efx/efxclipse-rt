/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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
package org.eclipse.fx.ui.services.resources.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.image.GraphicNode;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Node;

/**
 * Provides a graphic node
 */
@Component
public class GraphicNodeNodeProvider implements GraphicNodeProvider {

	@Override
	public @NonNull String getName() {
		return "fx.graphic-node-provider"; //$NON-NLS-1$
	}

	@Override
	public @NonNull List<@NonNull String> getFileSuffix() {
		return Collections.singletonList("gnode"); //$NON-NLS-1$
	}

	@Override
	public @NonNull Node getGraphicNode(URI uri) throws IOException {
		GraphicNode node = new GraphicNode();
		String lastSegment = uri.lastSegment();
		int idx;
		if( lastSegment != null && (idx = lastSegment.indexOf('.')) != -1 ) {
			String cssClass = lastSegment.substring(0, idx);
			node.getStyleClass().add(cssClass);
		}
		return node;
	}

}
