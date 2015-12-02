package org.eclipse.fx.code.editor.langs.codegen.fx.ceylon;

public class Ceylon__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Ceylon__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token ceylon_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ceylon.ceylon_default"));
		setDefaultReturnToken(ceylon_defaultToken);
		org.eclipse.jface.text.rules.Token ceylon_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ceylon.ceylon_keyword"));
		org.eclipse.jface.text.rules.Token ceylon_annotationToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ceylon.ceylon_annotation"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, ceylon_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher ceylon_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			ceylon_keywordWordRule.addWord("abstracts", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("alias", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("assembly", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("assert", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("assign", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("break", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("case", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("catch", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("class", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("continue", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("dynamic", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("else", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("exists", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("extends", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("finally", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("for", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("function", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("given", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("if", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("import", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("in", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("interface", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("is", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("let", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("module", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("new", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("nonempty", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("object", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("of", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("out", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("outer", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("package", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("return", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("satisfies", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("super", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("switch", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("then", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("this", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("throw", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("try", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("value", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("void", ceylon_keywordToken);
			ceylon_keywordWordRule.addWord("while", ceylon_keywordToken);
			combinedWordRule.addWordMatcher(ceylon_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher ceylon_annotationWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			ceylon_annotationWordRule.addWord("abstract", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("actual", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("annotation", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("default", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("deprecated", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("doc", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("by", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("formal", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("final", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("late", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("license", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("native", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("optional", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("sealed", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("see", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("shared", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("throws", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("tagged", ceylon_annotationToken);
			ceylon_annotationWordRule.addWord("variable", ceylon_annotationToken);
			combinedWordRule.addWordMatcher(ceylon_annotationWordRule);
		}
		rules[1] = combinedWordRule;
		setRules(rules);
	}
}
