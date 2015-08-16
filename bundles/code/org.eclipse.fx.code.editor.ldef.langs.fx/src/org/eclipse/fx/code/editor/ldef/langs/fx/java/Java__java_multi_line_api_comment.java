package org.eclipse.fx.code.editor.ldef.langs.fx.java;

public class Java__java_multi_line_api_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Java__java_multi_line_api_comment() {
		org.eclipse.jface.text.rules.Token java_apidocToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("java.java_apidoc"));
		setDefaultReturnToken(java_apidocToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
