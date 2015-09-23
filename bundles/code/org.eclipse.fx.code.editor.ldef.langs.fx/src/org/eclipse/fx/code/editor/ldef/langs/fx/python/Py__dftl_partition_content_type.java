package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class Py__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Py__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token python_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("py.python_default"));
		setDefaultReturnToken(python_defaultToken);
		org.eclipse.jface.text.rules.Token python_operatorToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("py.python_operator"));
		org.eclipse.jface.text.rules.Token python_bracketToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("py.python_bracket"));
		org.eclipse.jface.text.rules.Token python_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("py.python_keyword"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[4];
		rules[0] = new org.eclipse.jface.text.source.CharacterRule(python_operatorToken, new char[] {';','.','=','/','\\','+','-','*','<','>',':','?','!',',','|','&','^','%','~'});
		rules[1] = new org.eclipse.jface.text.source.CharacterRule(python_bracketToken, new char[] {'(',')','{','}','[',']'});
		rules[2] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.jface.text.source.JavaLikeWordDetector wordDetector= new org.eclipse.jface.text.source.JavaLikeWordDetector();
		org.eclipse.jface.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.jface.text.rules.CombinedWordRule(wordDetector, python_defaultToken);
		{
			org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher python_keywordWordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
			python_keywordWordRule.addWord("and", python_keywordToken);
			python_keywordWordRule.addWord("as", python_keywordToken);
			python_keywordWordRule.addWord("assert", python_keywordToken);
			python_keywordWordRule.addWord("break", python_keywordToken);
			python_keywordWordRule.addWord("class", python_keywordToken);
			python_keywordWordRule.addWord("continue", python_keywordToken);
			python_keywordWordRule.addWord("def", python_keywordToken);
			python_keywordWordRule.addWord("del", python_keywordToken);
			python_keywordWordRule.addWord("elif", python_keywordToken);
			python_keywordWordRule.addWord("else", python_keywordToken);
			python_keywordWordRule.addWord("except", python_keywordToken);
			python_keywordWordRule.addWord("exec", python_keywordToken);
			python_keywordWordRule.addWord("finally", python_keywordToken);
			python_keywordWordRule.addWord("for", python_keywordToken);
			python_keywordWordRule.addWord("from", python_keywordToken);
			python_keywordWordRule.addWord("global", python_keywordToken);
			python_keywordWordRule.addWord("if", python_keywordToken);
			python_keywordWordRule.addWord("import", python_keywordToken);
			python_keywordWordRule.addWord("in", python_keywordToken);
			python_keywordWordRule.addWord("is", python_keywordToken);
			python_keywordWordRule.addWord("lambda", python_keywordToken);
			python_keywordWordRule.addWord("not", python_keywordToken);
			python_keywordWordRule.addWord("or", python_keywordToken);
			python_keywordWordRule.addWord("pass", python_keywordToken);
			python_keywordWordRule.addWord("print", python_keywordToken);
			python_keywordWordRule.addWord("raise", python_keywordToken);
			python_keywordWordRule.addWord("return", python_keywordToken);
			python_keywordWordRule.addWord("try", python_keywordToken);
			python_keywordWordRule.addWord("while", python_keywordToken);
			python_keywordWordRule.addWord("with", python_keywordToken);
			python_keywordWordRule.addWord("yield", python_keywordToken);
			python_keywordWordRule.addWord("return", python_keywordToken);
			combinedWordRule.addWordMatcher(python_keywordWordRule);
		}
		rules[3] = combinedWordRule;
		setRules(rules);
	}
}
