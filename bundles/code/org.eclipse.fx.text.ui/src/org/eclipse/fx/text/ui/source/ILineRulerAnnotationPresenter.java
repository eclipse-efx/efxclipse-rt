package org.eclipse.fx.text.ui.source;

import java.util.Set;

import org.eclipse.jface.text.source.Annotation;

import javafx.scene.Node;

public interface ILineRulerAnnotationPresenter extends IAnnotationPresenter {

	enum LayoutHint {
		ALIGN_LEFT,
		ALIGN_RIGHT,
		ALIGN_CENTER;
	}

	int getOrder();

	void updateNode(Node node, Set<Annotation> annotation);

	LayoutHint getLayoutHint();
}
