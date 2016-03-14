package org.eclipse.fx.code.editor.configuration;

public interface TokenScanner_SingleLineRule extends EditorBase, TokenScanner {
	public String getStartSeq();
	public String getEndSeq();
	public String getEscapedBy();
	public Check getCheck();
	public Condition getCondition();

	public interface Builder {
		public Builder startSeq(String startSeq);
		public Builder endSeq(String endSeq);
		public Builder escapedBy(String escapedBy);
		public Builder check(Check check);
		public Builder condition(Condition condition);
		public TokenScanner_SingleLineRule build();
	}
}
