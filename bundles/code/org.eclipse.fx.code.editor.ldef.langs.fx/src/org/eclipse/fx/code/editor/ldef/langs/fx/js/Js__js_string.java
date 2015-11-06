package org.eclipse.fx.code.editor.ldef.langs.fx.js;

public class Js__js_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Js__js_string() {
		org.eclipse.jface.text.rules.Token js_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("js.js_string"));
		setDefaultReturnToken(js_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
