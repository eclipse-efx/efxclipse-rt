package org.eclipse.fx.code.editor.langs.codegen.fx.ts;

public class Ts__ts_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Ts__ts_string() {
		org.eclipse.jface.text.rules.Token ts_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ts.ts_string"));
		setDefaultReturnToken(ts_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
