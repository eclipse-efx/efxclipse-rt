package org.eclipse.fx.text.ui.source;

import org.eclipse.jface.text.source.Annotation;

import javafx.scene.Node;

public interface IAnnotationPresenter {

	boolean isApplicable(Annotation annotation);
	Node createNode();
}
