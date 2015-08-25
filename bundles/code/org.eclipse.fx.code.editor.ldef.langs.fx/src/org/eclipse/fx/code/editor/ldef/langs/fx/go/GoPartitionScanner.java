package org.eclipse.fx.code.editor.ldef.langs.fx.go;

public class GoPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public GoPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[5];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__go_single_line_comment")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__go_multi_line_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__go_string")
			, '\\');
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__go_string")
			, '\\');
		pr[4] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "`"
			, "`"
			, new org.eclipse.jface.text.rules.Token("__go_string")
			);
		setPredicateRules(pr);
	}
}
