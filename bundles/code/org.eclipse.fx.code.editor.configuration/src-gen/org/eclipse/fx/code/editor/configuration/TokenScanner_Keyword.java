package org.eclipse.fx.code.editor.configuration;

public interface TokenScanner_Keyword extends EditorBase, TokenScanner {
	public java.util.List<String> getKeywordList();
	public Check getCheck();

	public interface Builder {
		public Builder keywordList(java.util.List<String> keywordList);
		public Builder appendKeywordList(String keywordList);
		public Builder check(Check check);
		public TokenScanner_Keyword build();
	}
}
