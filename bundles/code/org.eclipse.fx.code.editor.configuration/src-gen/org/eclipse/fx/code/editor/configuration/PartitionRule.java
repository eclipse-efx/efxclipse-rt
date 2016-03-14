package org.eclipse.fx.code.editor.configuration;

public interface PartitionRule extends EditorBase {
	public Check getCheck();
	public Condition getCondition();

	public interface Builder {
		public Builder check(Check check);
		public Builder condition(Condition condition);
		public PartitionRule build();
	}
}
