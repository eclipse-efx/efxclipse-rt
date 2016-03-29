package org.eclipse.fx.code.editor.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DelegatingEditingContext;
import org.eclipse.fx.code.editor.services.EditingContext;
import org.eclipse.fx.code.editor.services.EditingContextTypeProvider;
import org.osgi.service.component.annotations.Component;

@Component
public class DelegatingEditingContextTypeProvider implements EditingContextTypeProvider {

	@Override
	public Class<? extends EditingContext> getType(Input<?> s) {
		return DelegatingEditingContext.class;
	}

	@Override
	public boolean test(Input<?> t) {
		return true;
	}

}
