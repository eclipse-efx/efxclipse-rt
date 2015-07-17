package org.eclipse.fx.code.editor.ldef.text;

import static org.eclipse.fx.core.RankedObjectRegistry.getOSGiServiceRank;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.InputDependentTypeProviderService;
import org.eclipse.fx.core.RankedObjectRegistry;

public abstract class ModelDependentTypeProvider<T> implements InputDependentTypeProviderService<T> {
	private RankedObjectRegistry<LDefModelProvider> modelProviders = new RankedObjectRegistry<>();

	public void registerModelProvider(LDefModelProvider provider, Map<String, Object> properties) {
		modelProviders.registerObject(getOSGiServiceRank(properties), provider);
	}

	public void unregisterModelProvider(LDefModelProvider provider) {
		modelProviders.unregisterObject(provider);
	}

	@Override
	public boolean test(Input<?> s) {
		synchronized (modelProviders) {
			return modelProviders.unsynchronizedStream().filter( m -> m.applies(s)).findFirst().isPresent();
		}
	}

}
