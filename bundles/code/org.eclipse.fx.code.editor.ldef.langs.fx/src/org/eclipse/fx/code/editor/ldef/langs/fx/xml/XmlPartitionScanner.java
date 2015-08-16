package org.eclipse.fx.code.editor.ldef.langs.fx.xml;

public class XmlPartitionScanner extends org.eclipse.jface.text.rules.RuleBasedPartitionScanner {
	public XmlPartitionScanner() {
		org.eclipse.jface.text.rules.IPredicateRule[] pr = new org.eclipse.jface.text.rules.IPredicateRule[5];
		pr[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "<?xml"
			, "?>"
			, new org.eclipse.jface.text.rules.Token("__xml_decl")
			);
		pr[1] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "<![CDATA["
			, "]]>"
			, new org.eclipse.jface.text.rules.Token("__xml_cdata")
			);
		pr[2] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "<?"
			, "?>"
			, new org.eclipse.jface.text.rules.Token("__xml_pi")
			);
		pr[3] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "<!--"
			, "-->"
			, new org.eclipse.jface.text.rules.Token("__xml_comment")
			);
		pr[4] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "<"
			, ">"
			, new org.eclipse.jface.text.rules.Token("__xml_tag")
			);
		setPredicateRules(pr);
	}
}
