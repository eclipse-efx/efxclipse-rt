package org.eclipse.fx.code.editor.ldef.langs.fx.java;

public class Java__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Java__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token java_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_default"));
		setDefaultReturnToken(java_defaultToken);
		org.eclipse.jface.text.rules.Token java_operatorToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_operator"));
		org.eclipse.jface.text.rules.Token java_bracketToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_bracket"));
		org.eclipse.jface.text.rules.Token java_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_keyword"));
		org.eclipse.jface.text.rules.Token java_buitin_typeToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_buitin_type"));
		org.eclipse.jface.text.rules.Token java_constantToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_constant"));
		org.eclipse.jface.text.rules.Token java_annotationToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_annotation"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[4];
		rules[0] = new org.eclipse.fx.text.rules.CharacterRule(java_operatorToken, new char[] {';','.','=','/','\\','+','-','*','<','>',':','?','!',',','|','&','^','%','~'});
		rules[1] = new org.eclipse.fx.text.rules.CharacterRule(java_bracketToken, new char[] {'(',')','{','}','[',']'});
		rules[2] = new org.eclipse.fx.text.rules.RegexRule(java_annotationToken, java.util.regex.Pattern.compile("@"),1,java.util.regex.Pattern.compile("\\w"));

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, java_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher java_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			java_keywordWordRule.addWord("abstract", java_keywordToken);
			java_keywordWordRule.addWord("break", java_keywordToken);
			java_keywordWordRule.addWord("case", java_keywordToken);
			java_keywordWordRule.addWord("catch", java_keywordToken);
			java_keywordWordRule.addWord("class", java_keywordToken);
			java_keywordWordRule.addWord("const", java_keywordToken);
			java_keywordWordRule.addWord("continue", java_keywordToken);
			java_keywordWordRule.addWord("default", java_keywordToken);
			java_keywordWordRule.addWord("do", java_keywordToken);
			java_keywordWordRule.addWord("else", java_keywordToken);
			java_keywordWordRule.addWord("extends", java_keywordToken);
			java_keywordWordRule.addWord("final", java_keywordToken);
			java_keywordWordRule.addWord("finally", java_keywordToken);
			java_keywordWordRule.addWord("for", java_keywordToken);
			java_keywordWordRule.addWord("goto", java_keywordToken);
			java_keywordWordRule.addWord("if", java_keywordToken);
			java_keywordWordRule.addWord("implements", java_keywordToken);
			java_keywordWordRule.addWord("import", java_keywordToken);
			java_keywordWordRule.addWord("instanceof", java_keywordToken);
			java_keywordWordRule.addWord("interface", java_keywordToken);
			java_keywordWordRule.addWord("native", java_keywordToken);
			java_keywordWordRule.addWord("new", java_keywordToken);
			java_keywordWordRule.addWord("package", java_keywordToken);
			java_keywordWordRule.addWord("private", java_keywordToken);
			java_keywordWordRule.addWord("protected", java_keywordToken);
			java_keywordWordRule.addWord("public", java_keywordToken);
			java_keywordWordRule.addWord("static", java_keywordToken);
			java_keywordWordRule.addWord("super", java_keywordToken);
			java_keywordWordRule.addWord("switch", java_keywordToken);
			java_keywordWordRule.addWord("synchronized", java_keywordToken);
			java_keywordWordRule.addWord("this", java_keywordToken);
			java_keywordWordRule.addWord("throw", java_keywordToken);
			java_keywordWordRule.addWord("throws", java_keywordToken);
			java_keywordWordRule.addWord("transient", java_keywordToken);
			java_keywordWordRule.addWord("try", java_keywordToken);
			java_keywordWordRule.addWord("volatile", java_keywordToken);
			java_keywordWordRule.addWord("while", java_keywordToken);
			java_keywordWordRule.addWord("interface", java_keywordToken);
			java_keywordWordRule.addWord("enum", java_keywordToken);
			java_keywordWordRule.addWord("return", java_keywordToken);
			combinedWordRule.addWordMatcher(java_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher java_buitin_typeWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			java_buitin_typeWordRule.addWord("void", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("boolean", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("char", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("byte", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("short", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("strictfp", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("int", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("long", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("float", java_buitin_typeToken);
			java_buitin_typeWordRule.addWord("double", java_buitin_typeToken);
			combinedWordRule.addWordMatcher(java_buitin_typeWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher java_constantWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			java_constantWordRule.addWord("true", java_constantToken);
			java_constantWordRule.addWord("false", java_constantToken);
			java_constantWordRule.addWord("null", java_constantToken);
			combinedWordRule.addWordMatcher(java_constantWordRule);
		}
		rules[3] = combinedWordRule;
		setRules(rules);
	}
}
