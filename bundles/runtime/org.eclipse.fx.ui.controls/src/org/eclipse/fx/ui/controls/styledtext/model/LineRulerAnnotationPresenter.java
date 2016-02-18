package org.eclipse.fx.ui.controls.styledtext.model;

import java.util.Set;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;

// TODO add some kind of layout hinting to position node for example on the right side
public interface LineRulerAnnotationPresenter extends AnnotationPresenter {

	enum LayoutHint {
		ALIGN_RIGHT,
		ALIGN_LEFT,
		ALIGN_CENTER;
	}

	LayoutHint getLayoutHint();

	DoubleProperty getWidth();

	int getOrder();

	// TODO use me or remove me
	boolean isVisible(Set<Annotation> annotation);


	void updateNode(Node node, Set<Annotation> annotation);
}
