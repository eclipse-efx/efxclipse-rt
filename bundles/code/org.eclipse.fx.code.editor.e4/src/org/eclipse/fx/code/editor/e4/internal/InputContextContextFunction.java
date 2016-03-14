package org.eclipse.fx.code.editor.e4.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.InputContextLookup;
import org.osgi.service.component.annotations.Component;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.InputContext"})
public class InputContextContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return context.get(InputContextLookup.class).getContext(context.get(Input.class));
	}
}
