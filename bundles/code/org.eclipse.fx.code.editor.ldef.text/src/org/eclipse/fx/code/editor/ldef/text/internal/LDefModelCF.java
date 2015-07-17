package org.eclipse.fx.code.editor.ldef.text.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.ldef.text.LDefModelProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.ldef.lDef.LDef"})
public class LDefModelCF extends ContextFunction {
	private List<LDefModelProvider> providerList = new ArrayList<>();

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerProvider(LDefModelProvider provider) {
		synchronized (providerList) {
			providerList.add(provider);
		}
	}

	public void unregisterProvider(LDefModelProvider provider) {
		synchronized (providerList) {
			providerList.remove(provider);
		}
	}

	@Override
	public Object compute(IEclipseContext context) {
		List<LDefModelProvider> list;

		synchronized (providerList) {
			list = new ArrayList<>(providerList);
		}

		Input<?> input = context.get(Input.class);

		return list.stream()
						.filter( p -> p.applies(input))
						.findFirst()
						.map( p -> p.getModel(input)).orElse(null);
	}
}
