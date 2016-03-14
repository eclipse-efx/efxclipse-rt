package org.eclipse.fx.code.editor.configuration;

public interface EqualsCondition extends EditorBase, Condition {
	public String getValue();
	public String getName();

	public interface Builder {
		public Builder value(String value);
		public Builder name(String name);
		public EqualsCondition build();
	}
}
