package org.eclipse.fx.code.editor.configuration;

public interface Equals extends EditorBase, Check {
	public int getValue();

	public interface Builder {
		public Builder value(int value);
		public Equals build();
	}
}
