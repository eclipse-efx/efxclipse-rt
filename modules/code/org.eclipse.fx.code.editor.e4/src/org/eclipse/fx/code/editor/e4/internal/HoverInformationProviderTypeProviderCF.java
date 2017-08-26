package org.eclipse.fx.code.editor.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.services.HoverInformationProvider;
import org.eclipse.fx.code.editor.services.HoverInformationProviderTypeProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.services.HoverInformationProvider"})
public class HoverInformationProviderTypeProviderCF extends InputBasedContextFunction<HoverInformationProvider, HoverInformationProviderTypeProvider> {

	@Override
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(HoverInformationProviderTypeProvider service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	@Override
	public void unregisterService(HoverInformationProviderTypeProvider service) {
		super.unregisterService(service);
	}
}
