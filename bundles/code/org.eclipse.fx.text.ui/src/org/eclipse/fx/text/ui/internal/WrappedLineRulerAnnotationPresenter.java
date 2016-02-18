package org.eclipse.fx.text.ui.internal;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.fx.text.ui.source.ILineRulerAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;

public class WrappedLineRulerAnnotationPresenter implements LineRulerAnnotationPresenter {

	private ILineRulerAnnotationPresenter wrapped;

	public WrappedLineRulerAnnotationPresenter(ILineRulerAnnotationPresenter wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public LayoutHint getLayoutHint() {
		return LayoutHint.valueOf(wrapped.getLayoutHint().toString());
	}

	@Override
	public int getOrder() {
		return wrapped.getOrder();
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

	DoubleProperty TODO = new SimpleDoubleProperty(16);
	@Override
	public DoubleProperty getWidth() {
		// TODO
		return TODO;
	}

	@Override
	public boolean isVisible(Set<Annotation> annotation) {
		return true;
	}

	@Override
	public void updateNode(Node node, Set<Annotation> annotation) {
		wrapped.updateNode(node, unwrap(annotation));
	}

}
