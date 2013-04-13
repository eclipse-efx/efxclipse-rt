package org.eclipse.fx.di;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public abstract class CachingContextFunction extends ContextFunction {
	private final Class<?> clazz;
	
	public CachingContextFunction(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Object compute(IEclipseContext context) {
		Object rv = context.get("cached_" + clazz.getName());
		if( rv == null ) {
			rv = ContextInjectionFactory.make(clazz, context);
			context.set("cached_" + clazz.getName(), rv);
		}
		return rv;
	}	
}