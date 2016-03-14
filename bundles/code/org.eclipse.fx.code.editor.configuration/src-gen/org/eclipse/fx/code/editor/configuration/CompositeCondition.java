package org.eclipse.fx.code.editor.configuration;

public interface CompositeCondition extends EditorBase, Condition {
	public boolean isAnd();
	public Condition getPrimary();
	public java.util.List<CompositeConditionElement> getElementList();
	public String getName();

	public interface Builder {
		public Builder and(boolean and);
		public Builder primary(Condition primary);
		public Builder elementList(java.util.List<CompositeConditionElement> elementList);
		public Builder appendElementList(CompositeConditionElement elementList);
		public Builder elementList(java.util.function.Function<EditorGModel,java.util.List<CompositeConditionElement>> provider);
		public Builder appendElementList(java.util.function.Function<CompositeConditionElement.Builder,CompositeConditionElement> provider);
		public Builder name(String name);
		public CompositeCondition build();
	}
}
