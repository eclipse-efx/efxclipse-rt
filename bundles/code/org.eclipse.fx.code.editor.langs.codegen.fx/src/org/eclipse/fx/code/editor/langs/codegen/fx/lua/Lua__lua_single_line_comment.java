package org.eclipse.fx.code.editor.langs.codegen.fx.lua;

public class Lua__lua_single_line_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Lua__lua_single_line_comment() {
		org.eclipse.jface.text.rules.Token lua_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("lua.lua_doc_default"));
		setDefaultReturnToken(lua_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
