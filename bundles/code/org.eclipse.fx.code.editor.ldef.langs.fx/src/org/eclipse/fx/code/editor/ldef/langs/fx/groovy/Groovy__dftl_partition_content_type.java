package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class Groovy__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Groovy__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token groovy_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("groovy.groovy_default"));
		setDefaultReturnToken(groovy_defaultToken);
		org.eclipse.jface.text.rules.Token groovy_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("groovy.groovy_keyword"));
		org.eclipse.jface.text.rules.Token groovy_builtin_typeToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("groovy.groovy_builtin_type"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, groovy_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher groovy_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			groovy_keywordWordRule.addWord("abstract", groovy_keywordToken);
			groovy_keywordWordRule.addWord("as", groovy_keywordToken);
			groovy_keywordWordRule.addWord("assert", groovy_keywordToken);
			groovy_keywordWordRule.addWord("break", groovy_keywordToken);
			groovy_keywordWordRule.addWord("case", groovy_keywordToken);
			groovy_keywordWordRule.addWord("catch", groovy_keywordToken);
			groovy_keywordWordRule.addWord("class", groovy_keywordToken);
			groovy_keywordWordRule.addWord("const", groovy_keywordToken);
			groovy_keywordWordRule.addWord("continue", groovy_keywordToken);
			groovy_keywordWordRule.addWord("def", groovy_keywordToken);
			groovy_keywordWordRule.addWord("default", groovy_keywordToken);
			groovy_keywordWordRule.addWord("do", groovy_keywordToken);
			groovy_keywordWordRule.addWord("else", groovy_keywordToken);
			groovy_keywordWordRule.addWord("enum", groovy_keywordToken);
			groovy_keywordWordRule.addWord("extends", groovy_keywordToken);
			groovy_keywordWordRule.addWord("false", groovy_keywordToken);
			groovy_keywordWordRule.addWord("final", groovy_keywordToken);
			groovy_keywordWordRule.addWord("finally", groovy_keywordToken);
			groovy_keywordWordRule.addWord("for", groovy_keywordToken);
			groovy_keywordWordRule.addWord("goto", groovy_keywordToken);
			groovy_keywordWordRule.addWord("if", groovy_keywordToken);
			groovy_keywordWordRule.addWord("implements", groovy_keywordToken);
			groovy_keywordWordRule.addWord("import", groovy_keywordToken);
			groovy_keywordWordRule.addWord("in", groovy_keywordToken);
			groovy_keywordWordRule.addWord("instanceof", groovy_keywordToken);
			groovy_keywordWordRule.addWord("interface", groovy_keywordToken);
			groovy_keywordWordRule.addWord("native", groovy_keywordToken);
			groovy_keywordWordRule.addWord("new", groovy_keywordToken);
			groovy_keywordWordRule.addWord("null", groovy_keywordToken);
			groovy_keywordWordRule.addWord("package", groovy_keywordToken);
			groovy_keywordWordRule.addWord("private", groovy_keywordToken);
			groovy_keywordWordRule.addWord("protected", groovy_keywordToken);
			groovy_keywordWordRule.addWord("public", groovy_keywordToken);
			groovy_keywordWordRule.addWord("static", groovy_keywordToken);
			groovy_keywordWordRule.addWord("strictfp", groovy_keywordToken);
			groovy_keywordWordRule.addWord("super", groovy_keywordToken);
			groovy_keywordWordRule.addWord("switch", groovy_keywordToken);
			groovy_keywordWordRule.addWord("synchronized", groovy_keywordToken);
			groovy_keywordWordRule.addWord("this", groovy_keywordToken);
			groovy_keywordWordRule.addWord("threadsafe", groovy_keywordToken);
			groovy_keywordWordRule.addWord("throw", groovy_keywordToken);
			groovy_keywordWordRule.addWord("throws", groovy_keywordToken);
			groovy_keywordWordRule.addWord("transient", groovy_keywordToken);
			groovy_keywordWordRule.addWord("true", groovy_keywordToken);
			groovy_keywordWordRule.addWord("try", groovy_keywordToken);
			groovy_keywordWordRule.addWord("void", groovy_keywordToken);
			groovy_keywordWordRule.addWord("volatile", groovy_keywordToken);
			groovy_keywordWordRule.addWord("while", groovy_keywordToken);
			groovy_keywordWordRule.addWord("return", groovy_keywordToken);
			combinedWordRule.addWordMatcher(groovy_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher groovy_builtin_typeWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			groovy_builtin_typeWordRule.addWord("boolean", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("byte", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("char", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("short", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("int", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("long", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("double", groovy_builtin_typeToken);
			groovy_builtin_typeWordRule.addWord("float", groovy_builtin_typeToken);
			combinedWordRule.addWordMatcher(groovy_builtin_typeWordRule);
		}
		rules[1] = combinedWordRule;
		setRules(rules);
	}
}
