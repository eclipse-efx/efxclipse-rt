package org.eclipse.fx.code.editor.ldef.langs.fx.php;

public class Php__php_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Php__php_string() {
		org.eclipse.jface.text.rules.Token php_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("php.php_string"));
		setDefaultReturnToken(php_stringToken);
		org.eclipse.jface.text.rules.Token php_string_interToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("php.php_string_inter"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "${"
			, "}"
			, php_string_interToken
			, (char)0
			, false);
		rules[1] = new org.eclipse.fx.text.rules.RegexRule(php_string_interToken, java.util.regex.Pattern.compile("\\$"),1,java.util.regex.Pattern.compile("\\w"));

		setRules(rules);
	}
}
