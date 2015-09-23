package org.eclipse.fx.code.editor.ldef.langs.fx.php;

public class PhpPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public PhpPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[3];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__php_string")
			, '\\'
			, false);
		pr[1] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__php_string")
			, '\\'
			, false);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__php_multiline_comment")
			, (char)0
			, false);
		setPredicateRules(pr);
	}
}
