package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class Groovy__groovy_apidoc extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Groovy__groovy_apidoc() {
		org.eclipse.jface.text.rules.Token groovy_api_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("groovy.groovy_api_doc_default"));
		setDefaultReturnToken(groovy_api_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
