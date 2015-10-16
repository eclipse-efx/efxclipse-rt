package org.eclipse.fx.code.editor.ldef.langs.fx.lua;

public class Lua__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Lua__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token lua_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("lua.lua_default"));
		setDefaultReturnToken(lua_defaultToken);
		org.eclipse.jface.text.rules.Token lua_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("lua.lua_keyword"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.jface.text.source.JavaLikeWordDetector wordDetector= new org.eclipse.jface.text.source.JavaLikeWordDetector();
		org.eclipse.jface.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.jface.text.rules.CombinedWordRule(wordDetector, lua_defaultToken);
		{
			org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher lua_keywordWordRule = new org.eclipse.jface.text.rules.CombinedWordRule.WordMatcher();
			lua_keywordWordRule.addWord("function", lua_keywordToken);
			lua_keywordWordRule.addWord("end", lua_keywordToken);
			lua_keywordWordRule.addWord("for", lua_keywordToken);
			lua_keywordWordRule.addWord("if", lua_keywordToken);
			combinedWordRule.addWordMatcher(lua_keywordWordRule);
		}
		rules[1] = combinedWordRule;
		setRules(rules);
	}
}
