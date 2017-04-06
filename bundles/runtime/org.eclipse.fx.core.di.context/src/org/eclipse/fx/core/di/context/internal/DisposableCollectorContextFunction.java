package org.eclipse.fx.core.di.context.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.DisposableCollector;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("javadoc")
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.core.DisposableCollector"})
public class DisposableCollectorContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return ContextInjectionFactory.make(DisposableCollector.class, context);
	}
}
