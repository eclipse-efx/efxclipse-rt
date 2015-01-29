package org.eclipse.fx.code.compensator.project.jdt.internal;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.AnnotationModelFactory;
import org.eclipse.jface.text.source.IAnnotationModel;

public class JDTAnnotationModelFactory implements AnnotationModelFactory {

	@Override
	public boolean applies(Input<?> input) {
		return input instanceof JDTServerInput;
	}

	@Override
	public Class<? extends IAnnotationModel> getAnnotationModelType() {
		return JDTAnnotationModel.class;
	}

}
