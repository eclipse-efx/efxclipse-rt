package org.eclipse.fx.code.editor.configuration;

public interface CompositeCondition extends EditorBase, Condition {
	public boolean isAnd();
	public java.util.List<Condition> getElementList();
	public String getName();

	public interface Builder {
		public Builder and(boolean and);
		public Builder elementList(java.util.List<Condition> elementList);
		public Builder appendElementList(Condition elementList);
		public Builder elementList(java.util.function.Function<EditorGModel,java.util.List<Condition>> provider);
		public Builder appendElementList(java.util.function.Function<Condition.Builder,Condition> provider);
		public Builder name(String name);
		public CompositeCondition build();
	}
}
