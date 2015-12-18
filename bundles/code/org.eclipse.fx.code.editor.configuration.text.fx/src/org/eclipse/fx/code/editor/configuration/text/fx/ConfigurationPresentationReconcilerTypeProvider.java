package org.eclipse.fx.code.editor.configuration.text.fx;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationModelDependentTypeProvider;
import org.eclipse.fx.code.editor.configuration.text.ConfigurationModelProvider;
import org.eclipse.fx.code.editor.fx.services.PresentationReconcilerTypeProvider;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component
public class ConfigurationPresentationReconcilerTypeProvider extends ConfigurationModelDependentTypeProvider<PresentationReconciler> implements PresentationReconcilerTypeProvider {
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
	public Class<? extends PresentationReconciler> getType(Input<?> s) {
		return ConfigurationPresentationReconciler.class;
	}
}
