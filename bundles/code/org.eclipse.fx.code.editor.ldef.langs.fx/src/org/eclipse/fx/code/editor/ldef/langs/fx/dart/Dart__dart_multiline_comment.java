package org.eclipse.fx.code.editor.ldef.langs.fx.dart;

public class Dart__dart_multiline_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Dart__dart_multiline_comment() {
		org.eclipse.jface.text.rules.Token dart_multi_line_commentToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("dart.dart_multi_line_comment"));
		setDefaultReturnToken(dart_multi_line_commentToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
