package org.eclipse.fx.code.editor.ldef.langs.fx.js;

public class Js__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Js__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token js_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("js.js_default"));
		setDefaultReturnToken(js_defaultToken);
		org.eclipse.jface.text.rules.Token js_operatorToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("js.js_operator"));
		org.eclipse.jface.text.rules.Token js_bracketToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("js.js_bracket"));
		org.eclipse.jface.text.rules.Token js_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("js.js_keyword"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[4];
		rules[0] = new org.eclipse.jface.text.source.CharacterRule(js_operatorToken, new char[] {';','.','=','/','\\','+','-','*','<','>',':','?','!',',','|','&','^','%','~'});
		rules[1] = new org.eclipse.jface.text.source.CharacterRule(js_bracketToken, new char[] {'(',')','{','}','[',']'});
		rules[2] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.jface.text.source.JavaLikeWordDetector wordDetector= new org.eclipse.jface.text.source.JavaLikeWordDetector();
		org.eclipse.jface.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.jface.text.rules.CombinedWordRule(wordDetector, js_defaultToken);
		{
			org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher js_keywordWordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
			js_keywordWordRule.addWord("break", js_keywordToken);
			js_keywordWordRule.addWord("case", js_keywordToken);
			js_keywordWordRule.addWord("catch", js_keywordToken);
			js_keywordWordRule.addWord("continue", js_keywordToken);
			js_keywordWordRule.addWord("debugger", js_keywordToken);
			js_keywordWordRule.addWord("default", js_keywordToken);
			js_keywordWordRule.addWord("delete", js_keywordToken);
			js_keywordWordRule.addWord("do", js_keywordToken);
			js_keywordWordRule.addWord("else", js_keywordToken);
			js_keywordWordRule.addWord("finally", js_keywordToken);
			js_keywordWordRule.addWord("for", js_keywordToken);
			js_keywordWordRule.addWord("function", js_keywordToken);
			js_keywordWordRule.addWord("if", js_keywordToken);
			js_keywordWordRule.addWord("in", js_keywordToken);
			js_keywordWordRule.addWord("instanceof", js_keywordToken);
			js_keywordWordRule.addWord("new", js_keywordToken);
			js_keywordWordRule.addWord("return", js_keywordToken);
			js_keywordWordRule.addWord("switch", js_keywordToken);
			js_keywordWordRule.addWord("this", js_keywordToken);
			js_keywordWordRule.addWord("throw", js_keywordToken);
			js_keywordWordRule.addWord("try", js_keywordToken);
			js_keywordWordRule.addWord("typeof", js_keywordToken);
			js_keywordWordRule.addWord("var", js_keywordToken);
			js_keywordWordRule.addWord("void", js_keywordToken);
			js_keywordWordRule.addWord("while", js_keywordToken);
			js_keywordWordRule.addWord("with", js_keywordToken);
			combinedWordRule.addWordMatcher(js_keywordWordRule);
		}
		rules[3] = combinedWordRule;
		setRules(rules);
	}
}
