package org.eclipse.fx.code.editor.langs.codegen.fx.rust;

public class Rust__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Rust__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token rust_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_default"));
		setDefaultReturnToken(rust_defaultToken);
		org.eclipse.jface.text.rules.Token rust_functionToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_function"));
		org.eclipse.jface.text.rules.Token rust_typeToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_type"));
		org.eclipse.jface.text.rules.Token rust_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_keyword"));
		org.eclipse.jface.text.rules.Token rust_typesToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_types"));
		org.eclipse.jface.text.rules.Token rust_selfToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_self"));
		org.eclipse.jface.text.rules.Token rust_constantsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("rust.rust_constants"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, rust_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher rust_functionWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			rust_functionWordRule.addWord("fn", rust_functionToken);
			combinedWordRule.addWordMatcher(rust_functionWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher rust_typeWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			rust_typeWordRule.addWord("type", rust_typeToken);
			combinedWordRule.addWordMatcher(rust_typeWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher rust_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			rust_keywordWordRule.addWord("abstract", rust_keywordToken);
			rust_keywordWordRule.addWord("alignof", rust_keywordToken);
			rust_keywordWordRule.addWord("as", rust_keywordToken);
			rust_keywordWordRule.addWord("become", rust_keywordToken);
			rust_keywordWordRule.addWord("box", rust_keywordToken);
			rust_keywordWordRule.addWord("break", rust_keywordToken);
			rust_keywordWordRule.addWord("const", rust_keywordToken);
			rust_keywordWordRule.addWord("continue", rust_keywordToken);
			rust_keywordWordRule.addWord("crate", rust_keywordToken);
			rust_keywordWordRule.addWord("do", rust_keywordToken);
			rust_keywordWordRule.addWord("else", rust_keywordToken);
			rust_keywordWordRule.addWord("enum", rust_keywordToken);
			rust_keywordWordRule.addWord("extern", rust_keywordToken);
			rust_keywordWordRule.addWord("final", rust_keywordToken);
			rust_keywordWordRule.addWord("for", rust_keywordToken);
			rust_keywordWordRule.addWord("if", rust_keywordToken);
			rust_keywordWordRule.addWord("impl", rust_keywordToken);
			rust_keywordWordRule.addWord("in", rust_keywordToken);
			rust_keywordWordRule.addWord("let", rust_keywordToken);
			rust_keywordWordRule.addWord("loop", rust_keywordToken);
			rust_keywordWordRule.addWord("macro", rust_keywordToken);
			rust_keywordWordRule.addWord("match", rust_keywordToken);
			rust_keywordWordRule.addWord("mod", rust_keywordToken);
			rust_keywordWordRule.addWord("move", rust_keywordToken);
			rust_keywordWordRule.addWord("mut", rust_keywordToken);
			rust_keywordWordRule.addWord("offsetof", rust_keywordToken);
			rust_keywordWordRule.addWord("override", rust_keywordToken);
			rust_keywordWordRule.addWord("priv", rust_keywordToken);
			rust_keywordWordRule.addWord("proc", rust_keywordToken);
			rust_keywordWordRule.addWord("pub", rust_keywordToken);
			rust_keywordWordRule.addWord("pure", rust_keywordToken);
			rust_keywordWordRule.addWord("ref", rust_keywordToken);
			rust_keywordWordRule.addWord("return", rust_keywordToken);
			rust_keywordWordRule.addWord("sizeof", rust_keywordToken);
			rust_keywordWordRule.addWord("static", rust_keywordToken);
			rust_keywordWordRule.addWord("struct", rust_keywordToken);
			rust_keywordWordRule.addWord("super", rust_keywordToken);
			rust_keywordWordRule.addWord("trait", rust_keywordToken);
			rust_keywordWordRule.addWord("typeof", rust_keywordToken);
			rust_keywordWordRule.addWord("unsafe", rust_keywordToken);
			rust_keywordWordRule.addWord("unsized", rust_keywordToken);
			rust_keywordWordRule.addWord("use", rust_keywordToken);
			rust_keywordWordRule.addWord("virtual", rust_keywordToken);
			rust_keywordWordRule.addWord("where", rust_keywordToken);
			rust_keywordWordRule.addWord("while", rust_keywordToken);
			rust_keywordWordRule.addWord("yield", rust_keywordToken);
			combinedWordRule.addWordMatcher(rust_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher rust_typesWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			rust_typesWordRule.addWord("bool", rust_typesToken);
			rust_typesWordRule.addWord("isize", rust_typesToken);
			rust_typesWordRule.addWord("usize", rust_typesToken);
			rust_typesWordRule.addWord("i8", rust_typesToken);
			rust_typesWordRule.addWord("i16", rust_typesToken);
			rust_typesWordRule.addWord("i32", rust_typesToken);
			rust_typesWordRule.addWord("i64", rust_typesToken);
			rust_typesWordRule.addWord("u8", rust_typesToken);
			rust_typesWordRule.addWord("u16", rust_typesToken);
			rust_typesWordRule.addWord("u32", rust_typesToken);
			rust_typesWordRule.addWord("u64", rust_typesToken);
			rust_typesWordRule.addWord("f32", rust_typesToken);
			rust_typesWordRule.addWord("f64", rust_typesToken);
			rust_typesWordRule.addWord("char", rust_typesToken);
			rust_typesWordRule.addWord("str", rust_typesToken);
			combinedWordRule.addWordMatcher(rust_typesWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher rust_selfWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			rust_selfWordRule.addWord("self", rust_selfToken);
			rust_selfWordRule.addWord("Self", rust_selfToken);
			combinedWordRule.addWordMatcher(rust_selfWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher rust_constantsWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			rust_constantsWordRule.addWord("true", rust_constantsToken);
			rust_constantsWordRule.addWord("false", rust_constantsToken);
			combinedWordRule.addWordMatcher(rust_constantsWordRule);
		}
		rules[1] = combinedWordRule;
		setRules(rules);
	}
}
