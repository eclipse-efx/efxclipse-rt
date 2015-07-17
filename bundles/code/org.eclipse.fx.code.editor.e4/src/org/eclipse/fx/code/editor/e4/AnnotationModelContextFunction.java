package org.eclipse.fx.code.editor.e4;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.services.AnnotationModelTypeProvider;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.jface.text.source.IAnnotationModel"})
public class AnnotationModelContextFunction extends InputBasedContextFunction<IAnnotationModel, AnnotationModelTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	protected void registerService(AnnotationModelTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	@Override
	protected void unregisterService(AnnotationModelTypeProvider service) {
		super.unregisterService(service);
	}
}
