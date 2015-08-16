package org.eclipse.fx.code.editor.ldef.langs.fx.xml;

public class Xml__xml_pi extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Xml__xml_pi() {
		org.eclipse.jface.text.rules.Token xml_piToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("xml.xml_pi"));
		setDefaultReturnToken(xml_piToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
