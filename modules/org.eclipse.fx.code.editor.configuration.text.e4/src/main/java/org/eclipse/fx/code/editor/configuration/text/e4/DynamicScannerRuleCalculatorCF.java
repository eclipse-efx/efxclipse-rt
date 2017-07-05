package org.eclipse.fx.code.editor.configuration.text.e4;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.configuration.text.DynamicScannerRuleCalculator;
import org.eclipse.fx.code.editor.configuration.text.DynamicScannerRuleCalculatorTypeProvider;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;


@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property="service.context.key=org.eclipse.fx.code.editor.configuration.text.DynamicScannerRuleCalculator")
public class DynamicScannerRuleCalculatorCF extends InputBasedContextFunction<DynamicScannerRuleCalculator,DynamicScannerRuleCalculatorTypeProvider> {
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	protected void registerService(DynamicScannerRuleCalculatorTypeProvider service, Map<String, Object> properties) {
		super._registerService(service, properties);
	}

	protected void unregisterService(DynamicScannerRuleCalculatorTypeProvider service) {
		super._unregisterService(service);
	}
}
