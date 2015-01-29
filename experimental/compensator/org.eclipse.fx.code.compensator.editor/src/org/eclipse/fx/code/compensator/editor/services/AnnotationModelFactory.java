package org.eclipse.fx.code.compensator.editor.services;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.jface.text.source.IAnnotationModel;

public interface AnnotationModelFactory {
	public boolean applies(Input<?> input);
	public Class<? extends IAnnotationModel> getAnnotationModelType();
}
