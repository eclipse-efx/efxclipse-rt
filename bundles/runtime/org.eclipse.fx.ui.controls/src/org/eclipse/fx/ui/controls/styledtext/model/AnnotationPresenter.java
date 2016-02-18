package org.eclipse.fx.ui.controls.styledtext.model;

import java.util.Set;

import javafx.scene.Node;

public interface AnnotationPresenter {

	boolean isApplicable(Annotation annotation);


	Node createNode();
}
