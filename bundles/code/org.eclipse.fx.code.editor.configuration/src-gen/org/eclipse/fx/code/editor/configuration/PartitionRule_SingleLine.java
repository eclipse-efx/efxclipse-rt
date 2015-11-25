package org.eclipse.fx.code.editor.configuration;

public interface PartitionRule_SingleLine extends EditorBase, PartitionRule {
	public String getStartSeq();
	public String getEndSeq();
	public String getEscapedBy();
	public Check getCheck();

	public interface Builder {
		public Builder startSeq(String startSeq);
		public Builder endSeq(String endSeq);
		public Builder escapedBy(String escapedBy);
		public Builder check(Check check);
		public PartitionRule_SingleLine build();
	}
}
