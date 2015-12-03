package org.eclipse.fx.code.editor.langs.codegen.fx.ts;

public class Ts__ts_single_line_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Ts__ts_single_line_comment() {
		org.eclipse.jface.text.rules.Token ts_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_doc_default"));
		setDefaultReturnToken(ts_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
