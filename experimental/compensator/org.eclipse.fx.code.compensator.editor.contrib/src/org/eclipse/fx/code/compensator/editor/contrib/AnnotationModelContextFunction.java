package org.eclipse.fx.code.compensator.editor.contrib;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.AnnotationModelFactory;
import org.eclipse.jface.text.source.IAnnotationModel;

public class AnnotationModelContextFunction extends ContextFunction {
	private List<AnnotationModelFactory> annotationModelFactory = new ArrayList<>();

	public void addAnnotationModelFactory(AnnotationModelFactory factory) {
		synchronized (annotationModelFactory) {
			this.annotationModelFactory.add(factory);
		}
	}

	public void removeAnnotationModelFactory(AnnotationModelFactory factory) {
		synchronized (this.annotationModelFactory) {
			this.annotationModelFactory.remove(factory);
		}
	}

	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		IAnnotationModel model = (IAnnotationModel) context.get("localAnnotationModel");
		if( model == null ) {
			Input<?> input = context.get(Input.class);

			if( input != null ) {
				Stream<Class<? extends IAnnotationModel>> map = annotationModelFactory.stream().filter(a -> a.applies(input)).map( a -> a.getAnnotationModelType());
				Optional<Class<? extends IAnnotationModel>> findFirst = map.findFirst();
				if( findFirst.isPresent() ) {
					model = ContextInjectionFactory.make(findFirst.get(), context);
					if( model != null ) {
						context.set("localAnnotationModel", model);
					}
				}
			}
		}

		return model;
	}
}
