package org.eclipse.fx.code.editor.configuration.text.internal;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationModelProvider;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationPartitioner;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationModelDependentTypeProvider;
import org.eclipse.fx.code.editor.services.DocumentPartitionerTypeProvider;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component
public class ConfigurationDocumentPartitionerProvider extends ConfigurationModelDependentTypeProvider<IDocumentPartitioner> implements DocumentPartitionerTypeProvider {
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	@Override
	public void registerModelProvider(ConfigurationModelProvider provider, Map<String, Object> properties) {
		super.registerModelProvider(provider, properties);
	}

	@Override
	public void unregisterModelProvider(ConfigurationModelProvider provider) {
		super.unregisterModelProvider(provider);
	}

	@Override
	public Class<? extends IDocumentPartitioner> getType(Input<?> input) {
		return ConfigurationPartitioner.class;
	}

}
