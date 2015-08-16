package org.eclipse.fx.code.editor.ldef.langs.fx.kotlin;

public class Kotlin__kotlin_single_line_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Kotlin__kotlin_single_line_comment() {
		org.eclipse.jface.text.rules.Token kotlin_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("kotlin.kotlin_doc_default"));
		setDefaultReturnToken(kotlin_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
