package org.eclipse.fx.code.editor.e4;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.StringInput;
import org.osgi.service.component.annotations.Component;

@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.code.editor.StringInput"})
public class StringInputContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		Input<?> input = context.get(Input.class);
		if( input instanceof StringInput ) {
			return input;
		}
		return super.compute(context);
	}
}
