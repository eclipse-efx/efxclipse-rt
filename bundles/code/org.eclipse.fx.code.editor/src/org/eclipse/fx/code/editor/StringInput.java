package org.eclipse.fx.code.editor;

public interface StringInput extends Input<String> {
	public void updateData(int offset, int length, String replacement);
}
