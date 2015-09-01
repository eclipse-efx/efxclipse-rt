package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class AdocPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public AdocPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[3];
		pr[0] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "----"
			, "----"
			, new org.eclipse.jface.text.rules.Token("__adoc_multiline_code")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "////"
			, "////"
			, new org.eclipse.jface.text.rules.Token("__adoc_multiline_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__adoc_singleline_comment")
			);
		setPredicateRules(pr);
	}
}
