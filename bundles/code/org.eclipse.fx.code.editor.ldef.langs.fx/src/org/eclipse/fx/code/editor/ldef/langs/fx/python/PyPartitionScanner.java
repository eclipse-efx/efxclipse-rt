package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class PyPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public PyPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__python_string")
			);
		pr[1] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "#"
			, ""
			, new org.eclipse.jface.text.rules.Token("__python_singleline_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "'''"
			, "'''"
			, new org.eclipse.jface.text.rules.Token("__python_multiline_comment")
			);
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__python_string")
			);
		setPredicateRules(pr);
	}
}
