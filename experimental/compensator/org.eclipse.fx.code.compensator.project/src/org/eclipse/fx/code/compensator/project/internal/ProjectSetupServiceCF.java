package org.eclipse.fx.code.compensator.project.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class ProjectSetupServiceCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		return ContextInjectionFactory.make(ProjectSetupServiceImpl.class, context);
	}
}
