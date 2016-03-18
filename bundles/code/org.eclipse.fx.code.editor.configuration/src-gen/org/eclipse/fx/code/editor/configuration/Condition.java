package org.eclipse.fx.code.editor.configuration;

public interface Condition extends EditorBase {
	public String getName();

	public interface Builder {
		public Builder name(String name);
		public Condition build();
	}
}
