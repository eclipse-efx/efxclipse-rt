package org.eclipse.fx.code.editor.services;

import java.util.UUID;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;

public interface InputContextLookup {
	public static final InputContext DEFAULT = new InputContext() {
		private final String ID = UUID.randomUUID().toString();

		@Override
		public String getId() {
			return ID;
		}
	};
	public InputContext getContext(Input<?> input);
}
