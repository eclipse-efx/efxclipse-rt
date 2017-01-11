package org.eclipse.fx.core.di.context.internal;

import java.util.Optional;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ContextScope;
import org.eclipse.fx.core.di.context.ScopeCalculator;
import org.osgi.service.component.annotations.Component;

@Component
public class DefaultScopeCalculator implements ScopeCalculator {

	@Override
	public Optional<IEclipseContext> getContext(IEclipseContext localContext, ContextScope scope) {
		if( scope == ContextScope.APPLICATION ) {
			IEclipseContext c = localContext;
			while( c.getParent() != null ) {
				c = localContext.getParent();
			}
			return Optional.of(c);
		}

		return Optional.empty();
	}

}
