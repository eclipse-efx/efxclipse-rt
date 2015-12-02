package org.eclipse.fx.code.editor.langs.codegen.fx.groovy;

public class Groovy__groovy_multiline_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Groovy__groovy_multiline_comment() {
		org.eclipse.jface.text.rules.Token groovy_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("groovy.groovy_doc_default"));
		setDefaultReturnToken(groovy_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
