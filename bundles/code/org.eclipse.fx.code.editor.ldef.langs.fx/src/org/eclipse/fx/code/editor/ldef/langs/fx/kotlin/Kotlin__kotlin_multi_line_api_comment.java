package org.eclipse.fx.code.editor.ldef.langs.fx.kotlin;

public class Kotlin__kotlin_multi_line_api_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Kotlin__kotlin_multi_line_api_comment() {
		org.eclipse.jface.text.rules.Token kotlin_api_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("kotlin.kotlin_api_doc_default"));
		setDefaultReturnToken(kotlin_api_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
