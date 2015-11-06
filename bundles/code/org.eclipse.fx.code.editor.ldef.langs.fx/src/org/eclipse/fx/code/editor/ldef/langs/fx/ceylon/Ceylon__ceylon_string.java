package org.eclipse.fx.code.editor.ldef.langs.fx.ceylon;

public class Ceylon__ceylon_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Ceylon__ceylon_string() {
		org.eclipse.jface.text.rules.Token ceylon_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("ceylon.ceylon_string"));
		setDefaultReturnToken(ceylon_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
