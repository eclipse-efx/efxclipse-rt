package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class Groovy__groovy_character extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Groovy__groovy_character() {
		org.eclipse.jface.text.rules.Token groovy_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("groovy.groovy_string"));
		setDefaultReturnToken(groovy_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
