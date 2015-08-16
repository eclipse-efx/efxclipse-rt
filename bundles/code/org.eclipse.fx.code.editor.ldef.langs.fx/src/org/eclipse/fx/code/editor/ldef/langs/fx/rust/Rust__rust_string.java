package org.eclipse.fx.code.editor.ldef.langs.fx.rust;

public class Rust__rust_string extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Rust__rust_string() {
		org.eclipse.jface.text.rules.Token rust_stringToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("rust.rust_string"));
		setDefaultReturnToken(rust_stringToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
