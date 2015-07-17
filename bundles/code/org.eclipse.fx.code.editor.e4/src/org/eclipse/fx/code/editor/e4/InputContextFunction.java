package org.eclipse.fx.code.editor.e4;

import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.TextEditor;
import org.eclipse.fx.code.editor.services.InputTypeProvider;
import org.eclipse.fx.core.di.context.TypeProviderContextFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.Input"})
public class InputContextFunction extends TypeProviderContextFunction<String,Input<?>,InputTypeProvider> {

	public InputContextFunction() {
		super(TextEditor.DOCUMENT_URL);
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

		MPart part = context.get(MPart.class);
		context.set(TextEditor.DOCUMENT_URL, part.getPersistedState().get(TextEditor.DOCUMENT_URL));
		context.set(TextEditor.VCS_URL, part.getPersistedState().get(TextEditor.VCS_URL));
	}
}
