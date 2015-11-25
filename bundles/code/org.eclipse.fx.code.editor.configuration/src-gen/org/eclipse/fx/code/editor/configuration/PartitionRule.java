package org.eclipse.fx.code.editor.configuration;

public interface PartitionRule extends EditorBase {
	public Check getCheck();

	public interface Builder {
		public Builder check(Check check);
		public PartitionRule build();
	}
}
