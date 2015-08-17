package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class Py__python_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Py__python_string() {
		org.eclipse.jface.text.rules.Token phyton_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("py.phyton_string"));
		setDefaultReturnToken(phyton_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
