/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.function.Supplier;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

@SuppressWarnings("javadoc")
public class NodeCachePane extends Pane {

	protected final ReuseCache<Node> cache;

	public NodeCachePane(Supplier<Node> nodeFactory) {
		this.cache = new ReuseCache<>(nodeFactory);
		this.cache.addOnActivate(node->{
			if (!getChildren().contains(node)) {
				getChildren().add(node);
			}
			node.setVisible(true);
		});
		this.cache.addOnRelease( node -> getChildren().remove(node)); // FIXME modified by Tom leads to more and more text instances in AnnotationOverlay
		this.cache.addOnClear( node -> getChildren().remove(node));
	}

	protected Node getNode() {
		return this.cache.getElement();
	}

	protected void releaseNode(Node node) {
		this.cache.releaseElement(node);
	}

	protected void cleanup() {
		this.cache.clearFreeElements();
	}


}
