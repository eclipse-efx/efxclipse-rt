package org.eclipse.fx.code.editor.e4.internal;

import java.util.Map;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.fx.code.editor.e4.InputBasedContextFunction;
import org.eclipse.fx.code.editor.services.DocumentPartitionerTypeProvider;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.jface.text.IDocumentPartitioner"})
public class DocumentPartitionerContextFunction extends InputBasedContextFunction<IDocumentPartitioner,DocumentPartitionerTypeProvider> {

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(DocumentPartitionerTypeProvider provider, Map<String, Object> properties) {
		super._registerService(provider, properties);
	}

	public void unregisterService(DocumentPartitionerTypeProvider provider) {
		super._unregisterService(provider);
	}
}
