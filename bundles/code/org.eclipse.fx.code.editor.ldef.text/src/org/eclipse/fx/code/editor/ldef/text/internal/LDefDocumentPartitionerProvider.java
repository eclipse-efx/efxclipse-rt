package org.eclipse.fx.code.editor.ldef.text.internal;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.ldef.text.LDefModelProvider;
import org.eclipse.fx.code.editor.ldef.text.LDefPartitioner;
import org.eclipse.fx.code.editor.ldef.text.ModelDependentTypeProvider;
import org.eclipse.fx.code.editor.services.DocumentPartitionerTypeProvider;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component
public class LDefDocumentPartitionerProvider extends ModelDependentTypeProvider<IDocumentPartitioner> implements DocumentPartitionerTypeProvider {
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	public void registerModelProvider(LDefModelProvider provider, Map<String, Object> properties) {
		super.registerModelProvider(provider, properties);
	}

	@Override
	public void unregisterModelProvider(LDefModelProvider provider) {
		super.unregisterModelProvider(provider);
	}

	@Override
	public Class<? extends IDocumentPartitioner> getType(Input<?> input) {
		return LDefPartitioner.class;
	}

}
