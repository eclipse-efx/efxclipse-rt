package org.eclipse.jface.text.source;

import java.util.List;

import org.eclipse.fx.ui.services.resources.GraphicsLoader;

import javafx.scene.Node;

public interface AnnotationPresenter {
	public List<String> getTypes();
	public Node getPresentation(Annotation annotation, GraphicsLoader loader);
}
