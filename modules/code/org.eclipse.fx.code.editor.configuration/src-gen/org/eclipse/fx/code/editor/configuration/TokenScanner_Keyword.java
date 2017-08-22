package org.eclipse.fx.code.editor.configuration;

public interface TokenScanner_Keyword extends EditorBase, TokenScanner {
	public java.util.List<String> getKeywordList();
	public Check getCheck();
	public Condition getCondition();

	public interface Builder {
		public Builder keywordList(java.util.List<String> keywordList);
		public Builder appendKeywordList(String keywordList);
		public Builder check(Check check);
		public Builder condition(Condition condition);
		public TokenScanner_Keyword build();
	}
}
