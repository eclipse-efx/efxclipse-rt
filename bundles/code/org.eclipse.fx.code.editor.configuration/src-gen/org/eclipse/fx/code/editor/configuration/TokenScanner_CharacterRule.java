package org.eclipse.fx.code.editor.configuration;

public interface TokenScanner_CharacterRule extends EditorBase, TokenScanner {
	public java.util.List<String> getCharacterList();
	public Check getCheck();

	public interface Builder {
		public Builder characterList(java.util.List<String> characterList);
		public Builder appendCharacterList(String characterList);
		public Builder check(Check check);
		public TokenScanner_CharacterRule build();
	}
}
