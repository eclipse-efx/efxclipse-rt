package org.eclipse.fx.code.editor.configuration;

public interface ExitsCondition extends EditorBase, Condition {
	public String getName();

	public interface Builder {
		public Builder name(String name);
		public ExitsCondition build();
	}
}
