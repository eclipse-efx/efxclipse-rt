package org.eclipse.fx.code.editor.langs.codegen.fx.ts;

public class Ts__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Ts__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token ts_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_default"));
		setDefaultReturnToken(ts_defaultToken);
		org.eclipse.jface.text.rules.Token ts_operatorToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_operator"));
		org.eclipse.jface.text.rules.Token ts_bracketToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_bracket"));
		org.eclipse.jface.text.rules.Token ts_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_keyword"));
		org.eclipse.jface.text.rules.Token ts_builtin_typesToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_builtin_types"));
		org.eclipse.jface.text.rules.Token ts_constantToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_constant"));
		org.eclipse.jface.text.rules.Token ts_numberToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_number"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[5];
		rules[0] = new org.eclipse.fx.text.rules.CharacterRule(ts_operatorToken, new char[] {';','.','=','/','\\','+','-','*','<','>',':','?','!',',','|','&','^','%','~'});
		rules[1] = new org.eclipse.fx.text.rules.CharacterRule(ts_bracketToken, new char[] {'(',')','{','}','[',']'});
		rules[2] = new org.eclipse.fx.text.rules.RegexRule(ts_numberToken, java.util.regex.Pattern.compile("\\d"),1,java.util.regex.Pattern.compile("[\\d|\\.]"));
		rules[3] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, ts_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher ts_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			ts_keywordWordRule.addWord("break", ts_keywordToken);
			ts_keywordWordRule.addWord("case", ts_keywordToken);
			ts_keywordWordRule.addWord("catch", ts_keywordToken);
			ts_keywordWordRule.addWord("continue", ts_keywordToken);
			ts_keywordWordRule.addWord("debugger", ts_keywordToken);
			ts_keywordWordRule.addWord("default", ts_keywordToken);
			ts_keywordWordRule.addWord("delete", ts_keywordToken);
			ts_keywordWordRule.addWord("do", ts_keywordToken);
			ts_keywordWordRule.addWord("else", ts_keywordToken);
			ts_keywordWordRule.addWord("finally", ts_keywordToken);
			ts_keywordWordRule.addWord("for", ts_keywordToken);
			ts_keywordWordRule.addWord("function", ts_keywordToken);
			ts_keywordWordRule.addWord("if", ts_keywordToken);
			ts_keywordWordRule.addWord("in", ts_keywordToken);
			ts_keywordWordRule.addWord("instanceof", ts_keywordToken);
			ts_keywordWordRule.addWord("new", ts_keywordToken);
			ts_keywordWordRule.addWord("return", ts_keywordToken);
			ts_keywordWordRule.addWord("switch", ts_keywordToken);
			ts_keywordWordRule.addWord("this", ts_keywordToken);
			ts_keywordWordRule.addWord("throw", ts_keywordToken);
			ts_keywordWordRule.addWord("try", ts_keywordToken);
			ts_keywordWordRule.addWord("typeof", ts_keywordToken);
			ts_keywordWordRule.addWord("var", ts_keywordToken);
			ts_keywordWordRule.addWord("while", ts_keywordToken);
			ts_keywordWordRule.addWord("with", ts_keywordToken);
			ts_keywordWordRule.addWord("interface", ts_keywordToken);
			ts_keywordWordRule.addWord("class", ts_keywordToken);
			ts_keywordWordRule.addWord("constructor", ts_keywordToken);
			ts_keywordWordRule.addWord("declare", ts_keywordToken);
			ts_keywordWordRule.addWord("module", ts_keywordToken);
			ts_keywordWordRule.addWord("export", ts_keywordToken);
			ts_keywordWordRule.addWord("extends", ts_keywordToken);
			ts_keywordWordRule.addWord("super", ts_keywordToken);
			ts_keywordWordRule.addWord("public", ts_keywordToken);
			combinedWordRule.addWordMatcher(ts_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher ts_builtin_typesWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			ts_builtin_typesWordRule.addWord("any", ts_builtin_typesToken);
			ts_builtin_typesWordRule.addWord("void", ts_builtin_typesToken);
			ts_builtin_typesWordRule.addWord("string", ts_builtin_typesToken);
			ts_builtin_typesWordRule.addWord("number", ts_builtin_typesToken);
			ts_builtin_typesWordRule.addWord("boolean", ts_builtin_typesToken);
			combinedWordRule.addWordMatcher(ts_builtin_typesWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher ts_constantWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			ts_constantWordRule.addWord("true", ts_constantToken);
			ts_constantWordRule.addWord("false", ts_constantToken);
			ts_constantWordRule.addWord("undefined", ts_constantToken);
			combinedWordRule.addWordMatcher(ts_constantWordRule);
		}
		rules[4] = combinedWordRule;
		setRules(rules);
	}
}
