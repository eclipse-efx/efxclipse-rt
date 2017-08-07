package org.eclipse.fx.core.di.context;

import java.util.Optional;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.di.ContextScope;

public interface ScopeCalculator {
	public Optional<IEclipseContext> getContext(IEclipseContext localContext, ContextScope scope);
}
