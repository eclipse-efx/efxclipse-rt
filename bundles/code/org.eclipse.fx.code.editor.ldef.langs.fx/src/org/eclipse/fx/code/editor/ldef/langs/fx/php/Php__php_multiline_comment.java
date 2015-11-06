package org.eclipse.fx.code.editor.ldef.langs.fx.php;

public class Php__php_multiline_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Php__php_multiline_comment() {
		org.eclipse.jface.text.rules.Token php_doc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_doc_default"));
		setDefaultReturnToken(php_doc_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
