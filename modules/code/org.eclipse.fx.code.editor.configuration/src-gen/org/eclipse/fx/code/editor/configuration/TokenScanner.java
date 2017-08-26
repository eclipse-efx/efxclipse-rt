package org.eclipse.fx.code.editor.configuration;

public interface TokenScanner extends EditorBase {
	public Check getCheck();
	public Condition getCondition();

	public interface Builder {
		public Builder check(Check check);
		public Builder condition(Condition condition);
		public TokenScanner build();
	}
}
