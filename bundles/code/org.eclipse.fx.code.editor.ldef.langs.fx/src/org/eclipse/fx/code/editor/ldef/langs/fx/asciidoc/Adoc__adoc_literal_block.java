package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class Adoc__adoc_literal_block extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Adoc__adoc_literal_block() {
		org.eclipse.jface.text.rules.Token adoc_literalToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_literal"));
		setDefaultReturnToken(adoc_literalToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
