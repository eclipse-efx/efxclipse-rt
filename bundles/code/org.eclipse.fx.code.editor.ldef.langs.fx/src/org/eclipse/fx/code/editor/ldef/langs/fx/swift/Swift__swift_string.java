package org.eclipse.fx.code.editor.ldef.langs.fx.swift;

public class Swift__swift_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Swift__swift_string() {
		org.eclipse.jface.text.rules.Token swift_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("swift.swift_string"));
		setDefaultReturnToken(swift_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
