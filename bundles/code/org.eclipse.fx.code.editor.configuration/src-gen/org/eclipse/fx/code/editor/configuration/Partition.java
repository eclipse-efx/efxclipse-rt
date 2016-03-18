package org.eclipse.fx.code.editor.configuration;

public interface Partition extends EditorBase {
	public String getName();
	public java.util.List<PartitionRule> getRuleList();
	public java.util.List<Token> getTokenList();
	public PartitionWhiteSpace getWhitespace();

	public interface Builder {
		public Builder name(String name);
		public Builder ruleList(java.util.List<PartitionRule> ruleList);
		public Builder appendRuleList(PartitionRule ruleList);
		public Builder ruleList(java.util.function.Function<EditorGModel,java.util.List<PartitionRule>> provider);
		public Builder appendRuleList(java.util.function.Function<PartitionRule.Builder,PartitionRule> provider);
		public Builder tokenList(java.util.List<Token> tokenList);
		public Builder appendTokenList(Token tokenList);
		public Builder tokenList(java.util.function.Function<EditorGModel,java.util.List<Token>> provider);
		public Builder appendTokenList(java.util.function.Function<Token.Builder,Token> provider);
		public Builder whitespace(PartitionWhiteSpace whitespace);
		public Partition build();
	}
}
