package org.eclipse.fx.code.editor.ldef.langs.fx.lua;

public class Lua__lua_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Lua__lua_string() {
		org.eclipse.jface.text.rules.Token lua_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("lua.lua_string"));
		setDefaultReturnToken(lua_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
