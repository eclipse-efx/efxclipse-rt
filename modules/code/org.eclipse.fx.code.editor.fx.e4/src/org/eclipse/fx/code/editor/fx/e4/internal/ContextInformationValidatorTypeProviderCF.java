package org.eclipse.fx.code.editor.fx.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.fx.services.ContextInformationValidatorTypeProvider;
import org.eclipse.fx.text.ui.contentassist.IContextInformationValidator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.text.ui.contentassist.IContextInformationValidator"})
public class ContextInformationValidatorTypeProviderCF extends InputBasedContextFunction<IContextInformationValidator, ContextInformationValidatorTypeProvider> {
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(ContextInformationValidatorTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	public void unregisterService(ContextInformationValidatorTypeProvider service) {
		super.unregisterService(service);
	}
}
