package org.eclipse.fx.code.editor.ldef.langs.fx.dart;

public class DartPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public DartPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[6];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, new org.eclipse.jface.text.rules.Token("__dart_string")
			);
		pr[1] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, new org.eclipse.jface.text.rules.Token("__dart_string")
			);
		pr[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "///"
			, ""
			, new org.eclipse.jface.text.rules.Token("__dart_singlelinedoc_comment")
			);
		pr[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "//"
			, ""
			, new org.eclipse.jface.text.rules.Token("__dart_singleline_comment")
			);
		pr[4] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/**"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__dart_multilinedoc_comment")
			);
		pr[5] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "/*"
			, "*/"
			, new org.eclipse.jface.text.rules.Token("__dart_multiline_comment")
			);
		setPredicateRules(pr);
	}
}
