package org.eclipse.fx.code.editor.langs.codegen.fx.asciidoc;

public class Adoc__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Adoc__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token adoc_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_default"));
		setDefaultReturnToken(adoc_defaultToken);
		org.eclipse.jface.text.rules.Token adoc_blockToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_block"));
		org.eclipse.jface.text.rules.Token adoc_headerToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_header"));
		org.eclipse.jface.text.rules.Token adoc_header_attributeToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_header_attribute"));
		org.eclipse.jface.text.rules.Token adoc_section_0Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_section_0"));
		org.eclipse.jface.text.rules.Token adoc_section_1Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_section_1"));
		org.eclipse.jface.text.rules.Token adoc_section_2Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_section_2"));
		org.eclipse.jface.text.rules.Token adoc_section_3Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_section_3"));
		org.eclipse.jface.text.rules.Token adoc_section_4Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_section_4"));
		org.eclipse.jface.text.rules.Token adoc_section_5Token = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_section_5"));
		org.eclipse.jface.text.rules.Token adoc_mono_bold_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_mono_bold_italic"));
		org.eclipse.jface.text.rules.Token adoc_bold_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_bold_italic"));
		org.eclipse.jface.text.rules.Token adoc_mono_boldToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_mono_bold"));
		org.eclipse.jface.text.rules.Token adoc_mono_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_mono_italic"));
		org.eclipse.jface.text.rules.Token adoc_italicToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_italic"));
		org.eclipse.jface.text.rules.Token adoc_boldToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_bold"));
		org.eclipse.jface.text.rules.Token adoc_literalToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_literal"));
		org.eclipse.jface.text.rules.Token adoc_superToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_super"));
		org.eclipse.jface.text.rules.Token adoc_subToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_sub"));
		org.eclipse.jface.text.rules.Token adoc_admonitionToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("adoc.adoc_admonition"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[34];
		rules[0] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "****"
			, null
			, adoc_blockToken
			, (char)0
			, true),v -> v == 0
			);
		rules[1] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "++++"
			, null
			, adoc_blockToken
			, (char)0
			, true),v -> v == 0
			);
		rules[2] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "____"
			, null
			, adoc_blockToken
			, (char)0
			, true),v -> v == 0
			);
		rules[3] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "----"
			, null
			, adoc_blockToken
			, (char)0
			, true),v -> v == 0
			);
		rules[4] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "."
			, null
			, adoc_headerToken
			, (char)0
			, true),v -> v == 0
			);
		rules[5] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  ":"
			, null
			, adoc_header_attributeToken
			, (char)0
			, true),v -> v == 0
			);
		rules[6] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "= "
			, null
			, adoc_section_0Token
			, (char)0
			, true),v -> v == 0
			);
		rules[7] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "== "
			, null
			, adoc_section_1Token
			, (char)0
			, true),v -> v == 0
			);
		rules[8] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "=== "
			, null
			, adoc_section_2Token
			, (char)0
			, true),v -> v == 0
			);
		rules[9] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "==== "
			, null
			, adoc_section_3Token
			, (char)0
			, true),v -> v == 0
			);
		rules[10] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "===== "
			, null
			, adoc_section_4Token
			, (char)0
			, true),v -> v == 0
			);
		rules[11] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "====== "
			, null
			, adoc_section_5Token
			, (char)0
			, true),v -> v == 0
			);
		rules[12] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "``**__"
			, "__**``"
			, adoc_mono_bold_italicToken
			, (char)0
			, false);
		rules[13] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "`*_"
			, "_*`"
			, adoc_mono_bold_italicToken
			, (char)0
			, false);
		rules[14] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "**_"
			, "_**"
			, adoc_bold_italicToken
			, (char)0
			, false);
		rules[15] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "*_"
			, "_*"
			, adoc_bold_italicToken
			, (char)0
			, false);
		rules[16] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "`*"
			, "*`"
			, adoc_mono_boldToken
			, (char)0
			, false);
		rules[17] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "``**"
			, "**``"
			, adoc_mono_boldToken
			, (char)0
			, false);
		rules[18] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "`_"
			, "_`"
			, adoc_mono_italicToken
			, (char)0
			, false);
		rules[19] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "``__"
			, "__``"
			, adoc_mono_italicToken
			, (char)0
			, false);
		rules[20] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "__"
			, "__"
			, adoc_italicToken
			, (char)0
			, false);
		rules[21] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "_"
			, "_"
			, adoc_italicToken
			, (char)0
			, false);
		rules[22] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "**"
			, "**"
			, adoc_boldToken
			, (char)0
			, false);
		rules[23] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "*"
			, "*"
			, adoc_boldToken
			, (char)0
			, false);
		rules[24] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "``"
			, "``"
			, adoc_literalToken
			, (char)0
			, false);
		rules[25] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "`"
			, "`"
			, adoc_literalToken
			, (char)0
			, false);
		rules[26] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "^"
			, "^"
			, adoc_superToken
			, (char)0
			, false);
		rules[27] = new org.eclipse.jface.text.rules.SingleLineRule(
			  "~"
			, "~"
			, adoc_subToken
			, (char)0
			, false);
		rules[28] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "NOTE:"
			, null
			, adoc_admonitionToken
			, (char)0
			, true),v -> v == 0
			);
		rules[29] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "TIP:"
			, null
			, adoc_admonitionToken
			, (char)0
			, true),v -> v == 0
			);
		rules[30] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "IMPORTANT:"
			, null
			, adoc_admonitionToken
			, (char)0
			, true),v -> v == 0
			);
		rules[31] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "WARNING:"
			, null
			, adoc_admonitionToken
			, (char)0
			, true),v -> v == 0
			);
		rules[32] = new org.eclipse.fx.text.rules.ColumnStartRule(new org.eclipse.jface.text.rules.SingleLineRule(
			  "CAUTION:"
			, null
			, adoc_admonitionToken
			, (char)0
			, true),v -> v == 0
			);
		rules[33] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		setRules(rules);
	}
}
