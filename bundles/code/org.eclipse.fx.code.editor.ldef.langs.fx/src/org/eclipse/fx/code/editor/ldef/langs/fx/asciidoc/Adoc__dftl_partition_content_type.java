package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class Adoc__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Adoc__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token adoc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_default"));
		setDefaultReturnToken(adoc_defaultToken);
		org.eclipse.jface.text.rules.Token adoc_section_0Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_section_0"));
		org.eclipse.jface.text.rules.Token adoc_section_1Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_section_1"));
		org.eclipse.jface.text.rules.Token adoc_section_2Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_section_2"));
		org.eclipse.jface.text.rules.Token adoc_section_3Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_section_3"));
		org.eclipse.jface.text.rules.Token adoc_section_4Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_section_4"));
		org.eclipse.jface.text.rules.Token adoc_section_5Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_section_5"));
		org.eclipse.jface.text.rules.Token adoc_mono_bold_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_mono_bold_italic"));
		org.eclipse.jface.text.rules.Token adoc_bold_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_bold_italic"));
		org.eclipse.jface.text.rules.Token adoc_mono_boldToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_mono_bold"));
		org.eclipse.jface.text.rules.Token adoc_mono_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_mono_italic"));
		org.eclipse.jface.text.rules.Token adoc_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_italic"));
		org.eclipse.jface.text.rules.Token adoc_boldToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_bold"));
		org.eclipse.jface.text.rules.Token adoc_literalToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_literal"));
		org.eclipse.jface.text.rules.Token adoc_superToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_super"));
		org.eclipse.jface.text.rules.Token adoc_subToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.jface.text.TextAttribute("adoc.adoc_sub"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[22];
		rules[0] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "= "
			, ""
			, adoc_section_0Token
			);
		rules[1] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "== "
			, ""
			, adoc_section_1Token
			);
		rules[2] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "=== "
			, ""
			, adoc_section_2Token
			);
		rules[3] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "==== "
			, ""
			, adoc_section_3Token
			);
		rules[4] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "===== "
			, ""
			, adoc_section_4Token
			);
		rules[5] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "====== "
			, ""
			, adoc_section_5Token
			);
		rules[6] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "``**__"
			, "__**``"
			, adoc_mono_bold_italicToken
			);
		rules[7] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "`*_"
			, "_*`"
			, adoc_mono_bold_italicToken
			);
		rules[8] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "**_"
			, "_**"
			, adoc_bold_italicToken
			);
		rules[9] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "*_"
			, "_*"
			, adoc_bold_italicToken
			);
		rules[10] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "`*"
			, "*`"
			, adoc_mono_boldToken
			);
		rules[11] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "``**"
			, "**``"
			, adoc_mono_boldToken
			);
		rules[12] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "`_"
			, "_`"
			, adoc_mono_italicToken
			);
		rules[13] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "``__"
			, "__``"
			, adoc_mono_italicToken
			);
		rules[14] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "__"
			, "__"
			, adoc_italicToken
			);
		rules[15] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "_"
			, "_"
			, adoc_italicToken
			);
		rules[16] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "**"
			, "**"
			, adoc_boldToken
			);
		rules[17] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "``"
			, "``"
			, adoc_literalToken
			);
		rules[18] = new org.eclipse.jface.text.rules.MultiLineRule(
			  "`"
			, "`"
			, adoc_literalToken
			);
		rules[19] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "^"
			, "^"
			, adoc_superToken
			);
		rules[20] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "~"
			, "~"
			, adoc_subToken
			);
		rules[21] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		setRules(rules);
	}
}
