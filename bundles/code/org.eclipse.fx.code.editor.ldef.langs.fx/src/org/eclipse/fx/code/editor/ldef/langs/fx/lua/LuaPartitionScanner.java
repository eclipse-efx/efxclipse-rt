package org.eclipse.fx.code.editor.ldef.langs.fx.lua;

public class LuaPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public LuaPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[3];
		pr[0] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "--[["
			, "]]--"
			, new org.eclipse.jface.text.rules.Token("__lua_multi_line_comment")
			, (char)0
			, false);
		pr[1] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "--"
			, ""
			, new org.eclipse.jface.text.rules.Token("__lua_single_line_comment")
			, (char)0
			, true);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__lua_string")
			, (char)0
			, false);
		setPredicateRules(pr);
	}
}
