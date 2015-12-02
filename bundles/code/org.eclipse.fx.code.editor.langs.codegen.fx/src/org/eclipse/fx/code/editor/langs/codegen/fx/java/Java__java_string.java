package org.eclipse.fx.code.editor.langs.codegen.fx.java;

public class Java__java_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Java__java_string() {
		org.eclipse.jface.text.rules.Token java_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("java.java_string"));
		setDefaultReturnToken(java_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
