package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class Adoc__adoc_multiline_code extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Adoc__adoc_multiline_code() {
		org.eclipse.jface.text.rules.Token adoc_codeToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_code"));
		setDefaultReturnToken(adoc_codeToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
