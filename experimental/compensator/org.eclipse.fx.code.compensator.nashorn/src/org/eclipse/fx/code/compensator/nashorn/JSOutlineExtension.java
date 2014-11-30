package org.eclipse.fx.code.compensator.nashorn;

import jdk.nashorn.internal.ir.FunctionNode;

import org.eclipse.fx.code.compensator.editor.Input;

public interface JSOutlineExtension {
	public boolean applies(Input<?> input);
	public JSOutline createOutline(FunctionNode node);
}
