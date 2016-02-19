package org.eclipse.fx.text.ui.internal;

import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import javafx.scene.Node;

public class TextAnnotationPresenterWrapper implements TextAnnotationPresenter {

	@Override
	public boolean isApplicable(Annotation annotation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node createNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisible(Annotation annotation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateNode(Node node, Annotation annotation) {
		// TODO Auto-generated method stub

	}

}
