package org.eclipse.fx.code.editor.langs.codegen.fx.xml;

public class Xml__xml_comment extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Xml__xml_comment() {
		org.eclipse.jface.text.rules.Token xml_commentToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("xml.xml_comment"));
		setDefaultReturnToken(xml_commentToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
