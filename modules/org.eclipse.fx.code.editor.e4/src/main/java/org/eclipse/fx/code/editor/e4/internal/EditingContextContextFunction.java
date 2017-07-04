package org.eclipse.fx.code.editor.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.services.EditingContext;
import org.eclipse.fx.code.editor.services.EditingContextTypeProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.services.EditingContext"})
public class EditingContextContextFunction extends InputBasedContextFunction<EditingContext, EditingContextTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(EditingContextTypeProvider service, Map<String, Object> properties) {
		super._registerService(service, properties);
	}

	public void unregisterService(EditingContextTypeProvider service) {
		super._unregisterService(service);
	}
}
