package org.eclipse.fx.text.ui.source;

import org.eclipse.jface.text.source.Annotation;

import javafx.scene.Node;

public interface ITextAnnotationPresenter extends IAnnotationPresenter {

	/**
	 * <p>Performance Hint:
	 *     try to prevent adding nodes here!
	 * </p>
	 * @param node
	 * @param annotation
	 */
	void updateNode(Node node, Annotation annotation);

}
