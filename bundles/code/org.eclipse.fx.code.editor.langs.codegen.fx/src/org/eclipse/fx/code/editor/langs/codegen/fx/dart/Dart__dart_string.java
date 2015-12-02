package org.eclipse.fx.code.editor.langs.codegen.fx.dart;

public class Dart__dart_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Dart__dart_string() {
		org.eclipse.jface.text.rules.Token dart_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("dart.dart_string"));
		setDefaultReturnToken(dart_stringToken);
		org.eclipse.jface.text.rules.Token dart_string_interToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("dart.dart_string_inter"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "${"
			, "}"
			, dart_string_interToken
			, (char)0
			, false);
		rules[1] = new org.eclipse.fx.text.rules.RegexRule(dart_string_interToken, java.util.regex.Pattern.compile("\\$"),1,java.util.regex.Pattern.compile("\\w"));

		setRules(rules);
	}
}
