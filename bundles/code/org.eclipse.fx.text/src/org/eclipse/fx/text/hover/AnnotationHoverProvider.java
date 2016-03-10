package org.eclipse.fx.text.hover;

import org.eclipse.jface.text.source.Annotation;

public interface AnnotationHoverProvider {
	boolean isApplicable(Class<? extends Annotation> annotationType);
	HoverInfo getHoverInfo(Annotation annotation);
}
