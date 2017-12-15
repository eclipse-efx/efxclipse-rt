package org.eclipse.fx.code.editor.configuration;

public interface Token extends EditorBase {
	public boolean isDefaultToken();
	public String getName();
	public java.util.List<TokenScanner> getTokenScannerList();

	public interface Builder {
		public Builder defaultToken(boolean defaultToken);
		public Builder name(String name);
		public Builder tokenScannerList(java.util.List<TokenScanner> tokenScannerList);
		public Builder appendTokenScannerList(TokenScanner tokenScannerList);
		public Builder tokenScannerList(java.util.function.Function<EditorGModel,java.util.List<TokenScanner>> provider);
		public Builder appendTokenScannerList(java.util.function.Function<TokenScanner.Builder,TokenScanner> provider);
		public Token build();
	}
}
