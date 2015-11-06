package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class AdocPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public AdocPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[5];
		pr[0] = new org.eclipse.fx.text.rules.PredicateColumnStartRule(new org.eclipse.jface.text.rules.MultiLineRule(
			  "////"
			, "////"
			, new org.eclipse.jface.text.rules.Token("__adoc_multiline_comment")
			, (char)0
			, false),v -> v == 0
			);
		pr[1] = new org.eclipse.fx.text.rules.PredicateColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, null
			, new org.eclipse.jface.text.rules.Token("__adoc_singleline_comment")
			, (char)0
			, true),v -> v == 0
			);
		pr[2] = new org.eclipse.fx.text.rules.PredicateColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "* "
			, null
			, new org.eclipse.jface.text.rules.Token("__adoc_list_entry")
			, (char)0
			, true),v -> v == 0
			);
		pr[3] = new org.eclipse.fx.text.rules.PredicateColumnStartRule(new org.eclipse.jface.text.rules.MultiLineRule(
			  "----"
			, "----"
			, new org.eclipse.jface.text.rules.Token("__adoc_multiline_code")
			, (char)0
			, false),v -> v == 0
			);
		pr[4] = new org.eclipse.fx.text.rules.PredicateColumnStartRule(new org.eclipse.jface.text.rules.MultiLineRule(
			  "...."
			, "...."
			, new org.eclipse.jface.text.rules.Token("__adoc_literal_block")
			, (char)0
			, false),v -> v == 0
			);
		setPredicateRules(pr);
	}
}
