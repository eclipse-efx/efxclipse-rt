package org.eclipse.fx.code.editor.ldef.langs.fx.ceylon;

public class CeylonPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public CeylonPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__ceylon_single_line_comment")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/**"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__ceylon_multi_line_api_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__ceylon_multi_line_comment")
			);
		pr[3] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__ceylon_string")
			, '\\');
		setPredicateRules(pr);
	}
}
