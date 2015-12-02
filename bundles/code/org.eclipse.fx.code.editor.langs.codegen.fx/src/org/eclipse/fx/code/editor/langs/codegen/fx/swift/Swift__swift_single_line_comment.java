package org.eclipse.fx.code.editor.langs.codegen.fx.swift;

public class Swift__swift_single_line_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Swift__swift_single_line_comment() {
		org.eclipse.jface.text.rules.Token swift_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("swift.swift_doc_default"));
		setDefaultReturnToken(swift_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
