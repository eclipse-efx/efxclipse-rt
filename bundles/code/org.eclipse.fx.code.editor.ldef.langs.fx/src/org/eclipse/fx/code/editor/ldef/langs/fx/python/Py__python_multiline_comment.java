package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class Py__python_multiline_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Py__python_multiline_comment() {
		org.eclipse.jface.text.rules.Token python_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("py.python_doc_default"));
		setDefaultReturnToken(python_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
