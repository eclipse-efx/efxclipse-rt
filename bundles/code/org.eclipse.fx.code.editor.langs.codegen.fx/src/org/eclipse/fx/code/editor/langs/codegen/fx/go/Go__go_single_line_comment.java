package org.eclipse.fx.code.editor.langs.codegen.fx.go;

public class Go__go_single_line_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Go__go_single_line_comment() {
		org.eclipse.jface.text.rules.Token go_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("go.go_doc_default"));
		setDefaultReturnToken(go_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
