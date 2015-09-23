package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class PyPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public PyPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__python_string")
			, '\\'
			, false);
		pr[1] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "#"
			, ""
			, new org.eclipse.jface.text.rules.Token("__python_singleline_comment")
			, (char)0
			, true);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "'''"
			, "'''"
			, new org.eclipse.jface.text.rules.Token("__python_multiline_comment")
			, (char)0
			, false);
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__python_string")
			, '\\'
			, false);
		setPredicateRules(pr);
	}
}
