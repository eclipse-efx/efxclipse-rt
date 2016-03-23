package org.eclipse.fx.code.editor.services;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;

public interface InputContextLookup {
	public static final InputContext DEFAULT = new InputContext() {
		private final String ID = "__default_context";

		@Override
		public String getId() {
			return ID;
		}
	};
	public InputContext getContext(Input<?> input);
}
