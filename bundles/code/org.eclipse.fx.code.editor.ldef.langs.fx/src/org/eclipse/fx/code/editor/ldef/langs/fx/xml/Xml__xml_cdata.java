package org.eclipse.fx.code.editor.ldef.langs.fx.xml;

public class Xml__xml_cdata extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Xml__xml_cdata() {
		org.eclipse.jface.text.rules.Token xml_cdataToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("xml.xml_cdata"));
		setDefaultReturnToken(xml_cdataToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
