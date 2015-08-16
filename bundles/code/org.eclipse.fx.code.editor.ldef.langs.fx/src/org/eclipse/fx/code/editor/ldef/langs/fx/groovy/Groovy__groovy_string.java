package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class Groovy__groovy_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Groovy__groovy_string() {
		org.eclipse.jface.text.rules.Token groovy_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("groovy.groovy_string"));
		setDefaultReturnToken(groovy_stringToken);
		org.eclipse.jface.text.rules.Token groovy_string_interToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("groovy.groovy_string_inter"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "${"
			, "}"
			, groovy_string_interToken
			);
		rules[1] = new org.eclipse.fx.text.RegexRule(groovy_string_interToken, java.util.regex.Pattern.compile("\\$"),1,java.util.regex.Pattern.compile("\\w"));

		setRules(rules);
	}
}
