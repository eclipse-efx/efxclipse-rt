package org.eclipse.fx.code.editor.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.services.SearchProvider;
import org.eclipse.fx.code.editor.services.SearchProviderTypeProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.services.SearchProvider"})
public class SearchProviderTypeProviderCF extends InputBasedContextFunction<SearchProvider, SearchProviderTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(SearchProviderTypeProvider service, Map<String, Object> properties) {
		super._registerService(service, properties);
	}

	public void unregisterService(SearchProviderTypeProvider service) {
		super._unregisterService(service);
	}
}
