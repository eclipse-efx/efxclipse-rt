package org.eclipse.fx.code.editor.ldef.langs.fx.dart;

public class Dart__dart_singlelinedoc_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Dart__dart_singlelinedoc_comment() {
		org.eclipse.jface.text.rules.Token dart_docToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("dart.dart_doc"));
		setDefaultReturnToken(dart_docToken);
		org.eclipse.jface.text.rules.Token dart_doc_referenceToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("dart.dart_doc_reference"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[1];
		rules[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "["
			, "]"
			, dart_doc_referenceToken
			, (char)0
			, false);

		setRules(rules);
	}
}
