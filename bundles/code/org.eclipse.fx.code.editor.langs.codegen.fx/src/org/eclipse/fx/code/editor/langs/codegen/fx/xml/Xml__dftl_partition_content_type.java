package org.eclipse.fx.code.editor.langs.codegen.fx.xml;

public class Xml__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Xml__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token xml_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("xml.xml_default"));
		setDefaultReturnToken(xml_defaultToken);
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[0];

		setRules(rules);
	}
}
