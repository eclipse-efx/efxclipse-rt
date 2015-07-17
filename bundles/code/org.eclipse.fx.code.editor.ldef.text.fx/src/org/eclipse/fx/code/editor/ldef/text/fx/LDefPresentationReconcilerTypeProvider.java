package org.eclipse.fx.code.editor.ldef.text.fx;

import java.util.Map;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.ldef.text.LDefModelProvider;
import org.eclipse.fx.code.editor.ldef.text.ModelDependentTypeProvider;
import org.eclipse.fx.code.editor.ldef.text.fx.internal.LDefPresentationReconciler;
import org.eclipse.fx.code.editor.services.PresentationReconcilerTypeProvider;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component
public class LDefPresentationReconcilerTypeProvider extends ModelDependentTypeProvider<PresentationReconciler> implements PresentationReconcilerTypeProvider {
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
	public Class<? extends PresentationReconciler> getType(Input<?> s) {
		return LDefPresentationReconciler.class;
	}
}
