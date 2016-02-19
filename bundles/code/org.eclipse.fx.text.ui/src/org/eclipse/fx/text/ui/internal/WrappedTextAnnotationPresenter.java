package org.eclipse.fx.text.ui.internal;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.fx.text.ui.source.ITextAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import javafx.scene.Node;

public class WrappedTextAnnotationPresenter implements TextAnnotationPresenter {

	private ITextAnnotationPresenter wrapped;

	public WrappedTextAnnotationPresenter(ITextAnnotationPresenter wrapped) {
		this.wrapped = wrapped;
	}

	private org.eclipse.jface.text.source.Annotation unwrap(Annotation annotation) {
		return ((WrappedAnnotation) annotation).getAnnotation();
	}

	private Set<org.eclipse.jface.text.source.Annotation> unwrap(Set<Annotation> annotations) {
		return annotations.stream().map(this::unwrap).collect(Collectors.toSet());
	}

	@Override
	public boolean isApplicable(Annotation annotation) {
		if (annotation instanceof WrappedAnnotation) {
			return wrapped.isApplicable(unwrap(annotation));
		}
		return false;
	}

	@Override
	public Node createNode() {
		return wrapped.createNode();
	}

	@Override
	public boolean isVisible(Annotation annotation) {
		return true;
	}

	@Override
	public void updateNode(Node node, Annotation annotation) {
		wrapped.updateNode(node, unwrap(annotation));
	}

}
