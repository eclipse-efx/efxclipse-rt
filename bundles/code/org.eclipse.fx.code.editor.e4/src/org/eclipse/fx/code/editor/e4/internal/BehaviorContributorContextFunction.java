package org.eclipse.fx.code.editor.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.services.AnnotationModelTypeProvider;
import org.eclipse.fx.code.editor.services.BehaviorContributor;
import org.eclipse.fx.code.editor.services.BehaviorContributorTypeProvider;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.services.BehaviorContributor"})
public class BehaviorContributorContextFunction extends InputBasedContextFunction<BehaviorContributor, BehaviorContributorTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	protected void registerService(BehaviorContributorTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	@Override
	protected void unregisterService(BehaviorContributorTypeProvider service) {
		super.unregisterService(service);
	}
}
