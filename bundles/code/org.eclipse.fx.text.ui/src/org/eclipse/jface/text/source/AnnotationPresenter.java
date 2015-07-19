package org.eclipse.jface.text.source;

import java.util.List;

import javafx.scene.Node;

public interface AnnotationPresenter {
	public List<String> getTypes();
	public Node getPresentation(Annotation annotation);
}
