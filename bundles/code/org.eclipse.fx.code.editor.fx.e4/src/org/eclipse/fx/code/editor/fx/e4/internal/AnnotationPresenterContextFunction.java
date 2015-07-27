package org.eclipse.fx.code.editor.fx.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.fx.services.AnnotationPresenterTypeProvider;
import org.eclipse.jface.text.source.AnnotationPresenter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.jface.text.source.AnnotationPresenter"})
public class AnnotationPresenterContextFunction extends InputBasedContextFunction<AnnotationPresenter, AnnotationPresenterTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(AnnotationPresenterTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	public void unregisterService(AnnotationPresenterTypeProvider service) {
		super.unregisterService(service);
	}
}
