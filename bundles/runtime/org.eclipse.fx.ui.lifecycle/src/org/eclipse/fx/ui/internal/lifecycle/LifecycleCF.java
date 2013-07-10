package org.eclipse.fx.ui.internal.lifecycle;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class LifecycleCF extends ContextFunction {
	
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		return ContextInjectionFactory.make(LifecycleServiceImpl.class, context);
	}

}