package org.eclipse.fx.code.editor.ldef.langs.fx.js;

public class JsPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public JsPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__js_single_line_comment")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__js_multi_line_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__js_string")
			, '\\');
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__js_string")
			, '\\');
		setPredicateRules(pr);
	}
}
