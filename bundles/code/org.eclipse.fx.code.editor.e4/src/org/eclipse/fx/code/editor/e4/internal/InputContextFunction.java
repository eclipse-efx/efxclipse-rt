package org.eclipse.fx.code.editor.e4.internal;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.InputTypeProvider;
import org.eclipse.fx.core.di.context.TypeProviderContextFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.Input"})
public class InputContextFunction extends TypeProviderContextFunction<String,Input<?>,InputTypeProvider> {

	public InputContextFunction() {
		super(Constants.DOCUMENT_URL);
	}

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerService(InputTypeProvider service, java.util.Map<String,Object> properties) {
		super.registerService(service, properties);
	}

	public void unregisterService(InputTypeProvider service) {
		super.unregisterService(service);
	}

	@Override
	protected void preTypeCreation(IEclipseContext context) {
		super.preTypeCreation(context);

		MUIElement owner = context.get(MUIElement.class);

		while( owner != null && ! owner.getPersistedState().containsKey(Constants.DOCUMENT_URL) ) {
			owner = owner.getParent();
			if( owner instanceof MContext && ((MContext) owner).getContext() != null ) {
				context = ((MContext) owner).getContext();
			}
		}

		if( owner != null ) {
			if( ! context.containsKey(Constants.DOCUMENT_URL) ) {
				context.set(Constants.DOCUMENT_URL, owner.getPersistedState().get(Constants.DOCUMENT_URL));
				context.set(Constants.VCS_URL, owner.getPersistedState().get(Constants.VCS_URL));
			}
		} else {
			throw new IllegalStateException("Unable to detect element with " + Constants.DOCUMENT_URL);
		}
	}

	@Override
	protected void postInstanceCreation(Input<?> type, IEclipseContext context) {
		super.postInstanceCreation(type, context);
		type.getTransientData().put(Constants.CONTEXT, context);
	}
}
