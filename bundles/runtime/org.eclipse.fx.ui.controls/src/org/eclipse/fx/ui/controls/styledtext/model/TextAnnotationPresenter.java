package org.eclipse.fx.ui.controls.styledtext.model;

import javafx.scene.Node;

public interface TextAnnotationPresenter extends AnnotationPresenter {

	boolean isVisible(Annotation annotation);
	void updateNode(Node node, Annotation annotation);
}
