package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class GroovyPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public GroovyPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[4];
		pr[0] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/**"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__groovy_apidoc")
			, (char)0
			, false);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__groovy_multiline_comment")
			, (char)0
			, false);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__groovy_string")
			, (char)0
			, false);
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__groovy_character")
			, (char)0
			, false);
		setPredicateRules(pr);
	}
}
