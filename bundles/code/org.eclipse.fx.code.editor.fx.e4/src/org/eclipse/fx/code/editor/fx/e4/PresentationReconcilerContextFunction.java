package org.eclipse.fx.code.editor.fx.e4;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.fx.services.PresentationReconcilerTypeProvider;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.jface.text.presentation.PresentationReconciler"})
public class PresentationReconcilerContextFunction extends InputBasedContextFunction<PresentationReconciler, PresentationReconcilerTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(PresentationReconcilerTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	public void unregisterService(PresentationReconcilerTypeProvider service) {
		super.unregisterService(service);
	}
}
