package org.eclipse.fx.code.editor.ldef.langs.fx.java;

public class Java__java_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Java__java_string() {
		org.eclipse.jface.text.rules.Token java_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("java.java_string"));
		setDefaultReturnToken(java_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
