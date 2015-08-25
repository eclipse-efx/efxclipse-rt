package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class GroovyPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public GroovyPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/**"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__groovy_apidoc")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__groovy_multiline_comment")
			);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__groovy_string")
			, '\\');
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__groovy_character")
			, '\\');
		setPredicateRules(pr);
	}
}
