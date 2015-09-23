package org.eclipse.fx.code.editor.ldef.langs.fx.xml;

public class Xml__xml_tag extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Xml__xml_tag() {
		org.eclipse.jface.text.rules.Token xml_tagToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("xml.xml_tag"));
		setDefaultReturnToken(xml_tagToken);
		org.eclipse.jface.text.rules.Token xml_property_valueToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("xml.xml_property_value"));
		org.eclipse.jface.text.rules.Token xml_equalsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("xml.xml_equals"));
		org.eclipse.jface.text.rules.Token xml_property_nameToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("xml.xml_property_name"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[6];
		rules[0] = new org.eclipse.fx.text.RegexRule(xml_tagToken, java.util.regex.Pattern.compile("</"),2,java.util.regex.Pattern.compile("[\\w|-]"));
		rules[1] = new org.eclipse.fx.text.RegexRule(xml_tagToken, java.util.regex.Pattern.compile("<"),1,java.util.regex.Pattern.compile("[\\w|-]"));
		rules[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "\""
			, "\""
			, xml_property_valueToken
			, (char)0
			, false);
		rules[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "'"
			, "'"
			, xml_property_valueToken
			, (char)0
			, false);
		rules[4] = new org.eclipse.jface.text.source.CharacterRule(xml_equalsToken, new char[] {'='});
		rules[5] = new org.eclipse.fx.text.RegexRule(xml_property_nameToken, java.util.regex.Pattern.compile("\\w"),1,java.util.regex.Pattern.compile("\\w"));

		setRules(rules);
	}
}
