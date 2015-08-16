package org.eclipse.fx.code.editor.ldef.langs.fx.dart;

public class Dart__dart_singleline_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Dart__dart_singleline_comment() {
		org.eclipse.jface.text.rules.Token dart_single_line_commentToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("dart.dart_single_line_comment"));
		setDefaultReturnToken(dart_single_line_commentToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
