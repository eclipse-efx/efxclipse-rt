package org.eclipse.fx.code.editor.ldef.langs.fx.js;

public class Js__js_multi_line_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Js__js_multi_line_comment() {
		org.eclipse.jface.text.rules.Token js_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("js.js_doc_default"));
		setDefaultReturnToken(js_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
