package org.eclipse.fx.code.editor.services;

import java.util.function.Predicate;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;

public interface InputContextProvider extends Predicate<Input<?>> {
	public InputContext getContext(Input<?> input);
}
