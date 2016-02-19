package org.eclipse.fx.ui.controls.styledtext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Supplier;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class NodeCachePane extends Pane {

	protected final ReuseCache<Node> cache;

	public NodeCachePane(Supplier<Node> nodeFactory) {
		cache = new ReuseCache<>(nodeFactory);
		cache.addOnActivate(node->{
			if (!getChildren().contains(node)) {
				getChildren().add(node);
			}
			node.setVisible(true);
		});
		cache.addOnRelease( node -> getChildren().remove(node)); // FIXME modified by Tom leads to more and more text instances in AnnotationOverlay
		cache.addOnClear( node -> getChildren().remove(node));
	}

	protected Node getNode() {
		return cache.getElement();
	}

	protected void releaseNode(Node node) {
		cache.releaseElement(node);
	}

	protected void cleanup() {

		cache.clearFreeElements();
	}


}
