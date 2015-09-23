package org.eclipse.fx.code.editor.ldef.langs.fx.kotlin;

public class Kotlin__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Kotlin__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token kotlin_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("kotlin.kotlin_default"));
		setDefaultReturnToken(kotlin_defaultToken);
		org.eclipse.jface.text.rules.Token kotlin_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("kotlin.kotlin_keyword"));
		org.eclipse.jface.text.rules.Token kotlin_literalsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("kotlin.kotlin_literals"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[1];

		org.eclipse.jface.text.source.JavaLikeWordDetector wordDetector= new org.eclipse.jface.text.source.JavaLikeWordDetector();
		org.eclipse.jface.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.jface.text.rules.CombinedWordRule(wordDetector, kotlin_defaultToken);
		{
			org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher kotlin_keywordWordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
			kotlin_keywordWordRule.addWord("break", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("continue", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("return", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("if", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("else", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("when", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("do", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("for", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("while", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("as", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("in", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("is", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("by", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("get", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("set", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("out", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("super", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("this", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("This", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("where", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("try", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("catch", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("finally", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("throw", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("import", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("package", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("annotation", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("companion", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("enum", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("inner", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("internal", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("private", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("protected", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("public", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("abstract", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("final", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("open", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("override", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("sealed", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("vararg", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("dynamic", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("class", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("object", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("interface", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("trait", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("fun", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("val", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("var", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("constructor", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("init", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("typealias", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("data", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("inline", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("reified", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("native", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("synchronized", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("transient", kotlin_keywordToken);
			kotlin_keywordWordRule.addWord("volatile", kotlin_keywordToken);
			combinedWordRule.addWordMatcher(kotlin_keywordWordRule);
		}
		{
			org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher kotlin_literalsWordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
			kotlin_literalsWordRule.addWord("true", kotlin_literalsToken);
			kotlin_literalsWordRule.addWord("false", kotlin_literalsToken);
			kotlin_literalsWordRule.addWord("null", kotlin_literalsToken);
			combinedWordRule.addWordMatcher(kotlin_literalsWordRule);
		}
		rules[0] = combinedWordRule;
		setRules(rules);
	}
}
