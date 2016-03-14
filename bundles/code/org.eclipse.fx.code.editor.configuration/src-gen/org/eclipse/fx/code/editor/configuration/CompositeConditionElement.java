package org.eclipse.fx.code.editor.configuration;

public interface CompositeConditionElement extends EditorBase, Condition {
	public boolean isAnd();
	public CompositeConditionElement getCondition();
	public String getName();

	public interface Builder {
		public Builder and(boolean and);
		public Builder condition(CompositeConditionElement condition);
		public Builder name(String name);
		public CompositeConditionElement build();
	}
}
