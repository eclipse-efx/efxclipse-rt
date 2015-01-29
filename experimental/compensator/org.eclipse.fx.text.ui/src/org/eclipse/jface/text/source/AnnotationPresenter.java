package org.eclipse.jface.text.source;

import org.eclipse.fx.ui.services.resources.GraphicsLoader;

import javafx.scene.Node;

public interface AnnotationPresenter {
	public String getType();
	public Node getPresentation(Annotation annotation, GraphicsLoader loader);
}
