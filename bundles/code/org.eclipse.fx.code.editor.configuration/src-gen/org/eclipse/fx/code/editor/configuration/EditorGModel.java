package org.eclipse.fx.code.editor.configuration;

public interface EditorGModel {
	public static EditorGModel create() {
		return new org.eclipse.fx.code.editor.configuration.gson.GsonElementFactory();
	}

	public <T extends EditorBase> T createObject(java.io.Reader json);
	public <T extends EditorBase> java.util.List<T> createList(java.io.Reader json);

	public String toString(EditorBase o);
	public String toString(java.util.List<EditorBase> o);

	public LanguageDef.Builder LanguageDefBuilder();
	public Partition.Builder PartitionBuilder();
	public PartitionRule.Builder PartitionRuleBuilder();
	public PartitionRule_MultiLine.Builder PartitionRule_MultiLineBuilder();
	public PartitionRule_SingleLine.Builder PartitionRule_SingleLineBuilder();
	public PartitionWhiteSpace.Builder PartitionWhiteSpaceBuilder();
	public Token.Builder TokenBuilder();
	public TokenScanner.Builder TokenScannerBuilder();
	public TokenScanner_CharacterRule.Builder TokenScanner_CharacterRuleBuilder();
	public TokenScanner_Keyword.Builder TokenScanner_KeywordBuilder();
	public TokenScanner_PatternRule.Builder TokenScanner_PatternRuleBuilder();
	public TokenScanner_SingleLineRule.Builder TokenScanner_SingleLineRuleBuilder();
	public TokenScanner_MultiLineRule.Builder TokenScanner_MultiLineRuleBuilder();
	public Check.Builder CheckBuilder();
	public Equals.Builder EqualsBuilder();
	public Range.Builder RangeBuilder();
}
