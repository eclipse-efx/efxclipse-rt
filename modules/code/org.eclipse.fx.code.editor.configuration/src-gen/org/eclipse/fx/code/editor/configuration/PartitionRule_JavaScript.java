package org.eclipse.fx.code.editor.configuration;

public interface PartitionRule_JavaScript extends EditorBase, PartitionRule {
	public String getScript();
	public Check getCheck();
	public Condition getCondition();

	public interface Builder {
		public Builder script(String script);
		public Builder check(Check check);
		public Builder condition(Condition condition);
		public PartitionRule_JavaScript build();
	}
}
