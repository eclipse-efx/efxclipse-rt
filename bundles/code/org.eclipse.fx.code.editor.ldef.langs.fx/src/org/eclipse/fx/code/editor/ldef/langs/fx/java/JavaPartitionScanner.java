package org.eclipse.fx.code.editor.ldef.langs.fx.java;

public class JavaPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public JavaPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[5];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__java_single_line_comment")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/**"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__java_multi_line_api_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__java_multi_line_comment")
			);
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__java_string")
			, '\\');
		pr[4] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__java_string")
			, '\\');
		setPredicateRules(pr);
	}
}
