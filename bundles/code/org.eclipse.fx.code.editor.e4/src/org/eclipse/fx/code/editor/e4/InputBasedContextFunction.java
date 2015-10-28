package org.eclipse.fx.code.editor.e4;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.core.TypeProviderService;
import org.eclipse.fx.core.di.context.TypeProviderContextFunction;

@SuppressWarnings("restriction")
public abstract class InputBasedContextFunction<T,P extends TypeProviderService<Input<?>,T>> extends TypeProviderContextFunction<Input<?>, T, P> {

	public InputBasedContextFunction() {
		super(Input.class.getName());
	}

}
