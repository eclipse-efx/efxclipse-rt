package org.eclipse.fx.code.editor.hsl;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;

public interface HSLModelProvider {
	public boolean applies(Input<?> input);
	public Model getModel(Input<?> input);
}
