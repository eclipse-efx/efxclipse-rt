package org.eclipse.fx.code.editor.configuration;

public interface ExistsCondition extends EditorBase, Condition {
	public String getName();

	public interface Builder {
		public Builder name(String name);
		public ExistsCondition build();
	}
}
