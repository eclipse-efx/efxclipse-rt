package org.eclipse.fx.code.editor.e4;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DocumentFactory;
import org.eclipse.fx.core.di.context.ServiceFactoryContextFunction;
import org.eclipse.jface.text.IDocument;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.jface.text.IDocument"})
public class DocumentContextFunction extends ServiceFactoryContextFunction<Input<?>, IDocument, DocumentFactory> {

	public DocumentContextFunction() {
		super(Input.class.getName());
	}

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(DocumentFactory service, Map<String, Object> properties) {
		super.registerService(service, properties);
	}

	public void unregisterService(DocumentFactory service) {
		super.unregisterService(service);
	}
}
