package org.eclipse.fx.code.editor.configuration;

public interface TokenScanner_JavaScript extends EditorBase, TokenScanner {
	public String getScript();
	public Check getCheck();
	public Condition getCondition();

	public interface Builder {
		public Builder script(String script);
		public Builder check(Check check);
		public Builder condition(Condition condition);
		public TokenScanner_JavaScript build();
	}
}
