package org.eclipse.fx.code.editor;

public interface StringInput extends Input<String> {
	@Override
	public default String getText() {
		return getData();
	}

	@Override
	public default void setText(String text) {
		setData(text);
	}
}
