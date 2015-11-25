package org.eclipse.fx.code.editor.ldef.langs.fx.js;

public class JsPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public JsPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__js_single_line_comment")
			, (char)0
			, true);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__js_multi_line_comment")
			, (char)0
			, false);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__js_string")
			, (char)0
			, false);
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__js_string")
			, (char)0
			, false);
		setPredicateRules(pr);
	}
}
