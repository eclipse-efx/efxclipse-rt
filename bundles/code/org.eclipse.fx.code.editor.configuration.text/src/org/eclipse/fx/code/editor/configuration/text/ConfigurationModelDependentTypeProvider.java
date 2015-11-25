package org.eclipse.fx.code.editor.configuration.text;

import static org.eclipse.fx.core.RankedObjectRegistry.getOSGiServiceRank;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.InputDependentTypeProviderService;
import org.eclipse.fx.core.RankedObjectRegistry;

@SuppressWarnings("restriction")
public abstract class ConfigurationModelDependentTypeProvider<T> implements InputDependentTypeProviderService<T> {
	private RankedObjectRegistry<ConfigurationModelProvider> modelProviders = new RankedObjectRegistry<>();

	public void registerModelProvider(ConfigurationModelProvider provider, Map<String, Object> properties) {
		modelProviders.registerObject(getOSGiServiceRank(properties), provider);
	}

	public void unregisterModelProvider(ConfigurationModelProvider provider) {
		modelProviders.unregisterObject(provider);
	}

	@Override
	public boolean test(Input<?> s) {
		synchronized (modelProviders) {
			return modelProviders.unsynchronizedStream().filter( m -> m.applies(s)).findFirst().isPresent();
		}
	}

}
