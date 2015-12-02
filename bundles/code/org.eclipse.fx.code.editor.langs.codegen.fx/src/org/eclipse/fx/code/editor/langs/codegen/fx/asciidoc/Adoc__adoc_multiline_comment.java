package org.eclipse.fx.code.editor.langs.codegen.fx.asciidoc;

public class Adoc__adoc_multiline_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Adoc__adoc_multiline_comment() {
		org.eclipse.jface.text.rules.Token adoc_commentToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_comment"));
		setDefaultReturnToken(adoc_commentToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
