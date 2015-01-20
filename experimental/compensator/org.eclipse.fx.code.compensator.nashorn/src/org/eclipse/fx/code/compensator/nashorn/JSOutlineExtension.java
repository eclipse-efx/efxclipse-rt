package org.eclipse.fx.code.compensator.nashorn;

import jdk.nashorn.internal.ir.FunctionNode;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline.OutlineItem;

public interface JSOutlineExtension {
	public boolean applies(Input<?> input);
	public OutlineItem createOutline(FunctionNode node, Input<?> input);
}
