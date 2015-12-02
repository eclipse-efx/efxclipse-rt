package org.eclipse.fx.code.editor.langs.codegen.fx.go;

public class Go__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Go__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token go_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("go.go_default"));
		setDefaultReturnToken(go_defaultToken);
		org.eclipse.jface.text.rules.Token go_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("go.go_keyword"));
		org.eclipse.jface.text.rules.Token go_typesToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("go.go_types"));
		org.eclipse.jface.text.rules.Token go_builtin_constantsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("go.go_builtin_constants"));
		org.eclipse.jface.text.rules.Token go_builtin_functionsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("go.go_builtin_functions"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[2];
		rules[0] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, go_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher go_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			go_keywordWordRule.addWord("break", go_keywordToken);
			go_keywordWordRule.addWord("case", go_keywordToken);
			go_keywordWordRule.addWord("const", go_keywordToken);
			go_keywordWordRule.addWord("continue", go_keywordToken);
			go_keywordWordRule.addWord("default", go_keywordToken);
			go_keywordWordRule.addWord("defer", go_keywordToken);
			go_keywordWordRule.addWord("else", go_keywordToken);
			go_keywordWordRule.addWord("fallthrough", go_keywordToken);
			go_keywordWordRule.addWord("for", go_keywordToken);
			go_keywordWordRule.addWord("func", go_keywordToken);
			go_keywordWordRule.addWord("go", go_keywordToken);
			go_keywordWordRule.addWord("goto", go_keywordToken);
			go_keywordWordRule.addWord("if", go_keywordToken);
			go_keywordWordRule.addWord("import", go_keywordToken);
			go_keywordWordRule.addWord("interface", go_keywordToken);
			go_keywordWordRule.addWord("package", go_keywordToken);
			go_keywordWordRule.addWord("range", go_keywordToken);
			go_keywordWordRule.addWord("return", go_keywordToken);
			go_keywordWordRule.addWord("select", go_keywordToken);
			go_keywordWordRule.addWord("struct", go_keywordToken);
			go_keywordWordRule.addWord("switch", go_keywordToken);
			go_keywordWordRule.addWord("type", go_keywordToken);
			go_keywordWordRule.addWord("var", go_keywordToken);
			combinedWordRule.addWordMatcher(go_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher go_typesWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			go_typesWordRule.addWord("bool", go_typesToken);
			go_typesWordRule.addWord("byte", go_typesToken);
			go_typesWordRule.addWord("chan", go_typesToken);
			go_typesWordRule.addWord("complex64", go_typesToken);
			go_typesWordRule.addWord("complex128", go_typesToken);
			go_typesWordRule.addWord("error", go_typesToken);
			go_typesWordRule.addWord("float32", go_typesToken);
			go_typesWordRule.addWord("float64", go_typesToken);
			go_typesWordRule.addWord("func", go_typesToken);
			go_typesWordRule.addWord("int", go_typesToken);
			go_typesWordRule.addWord("int8", go_typesToken);
			go_typesWordRule.addWord("int16", go_typesToken);
			go_typesWordRule.addWord("int32", go_typesToken);
			go_typesWordRule.addWord("int64", go_typesToken);
			go_typesWordRule.addWord("map", go_typesToken);
			go_typesWordRule.addWord("rune", go_typesToken);
			go_typesWordRule.addWord("string", go_typesToken);
			go_typesWordRule.addWord("uint", go_typesToken);
			go_typesWordRule.addWord("uint8", go_typesToken);
			go_typesWordRule.addWord("uint16", go_typesToken);
			go_typesWordRule.addWord("uint32", go_typesToken);
			go_typesWordRule.addWord("uint64", go_typesToken);
			go_typesWordRule.addWord("uintptr", go_typesToken);
			combinedWordRule.addWordMatcher(go_typesWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher go_builtin_constantsWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			go_builtin_constantsWordRule.addWord("iota", go_builtin_constantsToken);
			go_builtin_constantsWordRule.addWord("nil", go_builtin_constantsToken);
			go_builtin_constantsWordRule.addWord("true", go_builtin_constantsToken);
			go_builtin_constantsWordRule.addWord("false", go_builtin_constantsToken);
			combinedWordRule.addWordMatcher(go_builtin_constantsWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher go_builtin_functionsWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			go_builtin_functionsWordRule.addWord("append", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("cap", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("close", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("complex", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("copy", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("delete", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("imag", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("len", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("make", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("new", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("panic", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("real", go_builtin_functionsToken);
			go_builtin_functionsWordRule.addWord("recover", go_builtin_functionsToken);
			combinedWordRule.addWordMatcher(go_builtin_functionsWordRule);
		}
		rules[1] = combinedWordRule;
		setRules(rules);
	}
}
