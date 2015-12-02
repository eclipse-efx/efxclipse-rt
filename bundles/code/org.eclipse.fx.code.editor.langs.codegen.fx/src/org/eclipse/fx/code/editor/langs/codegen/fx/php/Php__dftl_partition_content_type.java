package org.eclipse.fx.code.editor.langs.codegen.fx.php;

public class Php__dftl_partition_content_type extends org.eclipse.jface.text.rules.RuleBasedScanner {
	public Php__dftl_partition_content_type() {
		org.eclipse.jface.text.rules.Token php_defaultToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_default"));
		setDefaultReturnToken(php_defaultToken);
		org.eclipse.jface.text.rules.Token php_keywordToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_keyword"));
		org.eclipse.jface.text.rules.Token php_operatorToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_operator"));
		org.eclipse.jface.text.rules.Token php_bracketToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_bracket"));
		org.eclipse.jface.text.rules.Token php_builtin_functionsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_builtin_functions"));
		org.eclipse.jface.text.rules.Token php_builtin_classesToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_builtin_classes"));
		org.eclipse.jface.text.rules.Token php_compile_constantsToken = new org.eclipse.jface.text.rules.Token(new org.eclipse.fx.text.ui.TextAttribute("php.php_compile_constants"));
		org.eclipse.jface.text.rules.IRule[] rules = new org.eclipse.jface.text.rules.IRule[4];
		rules[0] = new org.eclipse.fx.text.rules.CharacterRule(php_operatorToken, new char[] {';','.','=','/','\\','+','-','*','<','>',':','?','!',',','|','&','^','%','~'});
		rules[1] = new org.eclipse.fx.text.rules.CharacterRule(php_bracketToken, new char[] {'(',')','{','}','[',']'});
		rules[2] = new org.eclipse.jface.text.rules.WhitespaceRule(Character::isWhitespace);

		org.eclipse.fx.text.rules.JavaLikeWordDetector wordDetector= new org.eclipse.fx.text.rules.JavaLikeWordDetector();
		org.eclipse.fx.text.rules.CombinedWordRule combinedWordRule= new org.eclipse.fx.text.rules.CombinedWordRule(wordDetector, php_defaultToken);
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher php_keywordWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			php_keywordWordRule.addWord("abstract", php_keywordToken);
			php_keywordWordRule.addWord("and", php_keywordToken);
			php_keywordWordRule.addWord("as", php_keywordToken);
			php_keywordWordRule.addWord("break", php_keywordToken);
			php_keywordWordRule.addWord("callable", php_keywordToken);
			php_keywordWordRule.addWord("case", php_keywordToken);
			php_keywordWordRule.addWord("catch", php_keywordToken);
			php_keywordWordRule.addWord("class", php_keywordToken);
			php_keywordWordRule.addWord("clone", php_keywordToken);
			php_keywordWordRule.addWord("const", php_keywordToken);
			php_keywordWordRule.addWord("continue", php_keywordToken);
			php_keywordWordRule.addWord("declare", php_keywordToken);
			php_keywordWordRule.addWord("default", php_keywordToken);
			php_keywordWordRule.addWord("do", php_keywordToken);
			php_keywordWordRule.addWord("else", php_keywordToken);
			php_keywordWordRule.addWord("elseif", php_keywordToken);
			php_keywordWordRule.addWord("enddeclare", php_keywordToken);
			php_keywordWordRule.addWord("endfor", php_keywordToken);
			php_keywordWordRule.addWord("endforeach", php_keywordToken);
			php_keywordWordRule.addWord("endif", php_keywordToken);
			php_keywordWordRule.addWord("endswitch", php_keywordToken);
			php_keywordWordRule.addWord("endwhile", php_keywordToken);
			php_keywordWordRule.addWord("extends", php_keywordToken);
			php_keywordWordRule.addWord("final", php_keywordToken);
			php_keywordWordRule.addWord("finally", php_keywordToken);
			php_keywordWordRule.addWord("for", php_keywordToken);
			php_keywordWordRule.addWord("foreach", php_keywordToken);
			php_keywordWordRule.addWord("function", php_keywordToken);
			php_keywordWordRule.addWord("global", php_keywordToken);
			php_keywordWordRule.addWord("goto", php_keywordToken);
			php_keywordWordRule.addWord("if", php_keywordToken);
			php_keywordWordRule.addWord("implements", php_keywordToken);
			php_keywordWordRule.addWord("instanceof", php_keywordToken);
			php_keywordWordRule.addWord("insteadof", php_keywordToken);
			php_keywordWordRule.addWord("interface", php_keywordToken);
			php_keywordWordRule.addWord("namespace", php_keywordToken);
			php_keywordWordRule.addWord("new", php_keywordToken);
			php_keywordWordRule.addWord("or", php_keywordToken);
			php_keywordWordRule.addWord("private", php_keywordToken);
			php_keywordWordRule.addWord("protected", php_keywordToken);
			php_keywordWordRule.addWord("public", php_keywordToken);
			php_keywordWordRule.addWord("return", php_keywordToken);
			php_keywordWordRule.addWord("static", php_keywordToken);
			php_keywordWordRule.addWord("switch", php_keywordToken);
			php_keywordWordRule.addWord("throw", php_keywordToken);
			php_keywordWordRule.addWord("trait", php_keywordToken);
			php_keywordWordRule.addWord("try", php_keywordToken);
			combinedWordRule.addWordMatcher(php_keywordWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher php_builtin_functionsWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			php_builtin_functionsWordRule.addWord("__halt_compiler", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("array", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("die", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("echo", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("empty", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("eval", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("exit", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("include", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("include_once", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("isset", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("list", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("print", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("unset", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("use", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("var", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("while", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("xor", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("require", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("require_once", php_builtin_functionsToken);
			php_builtin_functionsWordRule.addWord("yield", php_builtin_functionsToken);
			combinedWordRule.addWordMatcher(php_builtin_functionsWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher php_builtin_classesWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			php_builtin_classesWordRule.addWord("ArrayAccess", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("Closure", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("ErrorException", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("Exception", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("Generator", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("Iterator", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("IteratorAggregate", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("Serializable", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("Traversable", php_builtin_classesToken);
			php_builtin_classesWordRule.addWord("stdClass", php_builtin_classesToken);
			combinedWordRule.addWordMatcher(php_builtin_classesWordRule);
		}
		{
			org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher php_compile_constantsWordRule = new org.eclipse.fx.text.rules.CombinedWordRule.WordMatcher();
			php_compile_constantsWordRule.addWord("__CLASS__", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__DIR__", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__FILE__", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__FUNCTION__", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__LINE__", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__METHOD__", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__NAMESPACE__ ", php_compile_constantsToken);
			php_compile_constantsWordRule.addWord("__TRAIT__", php_compile_constantsToken);
			combinedWordRule.addWordMatcher(php_compile_constantsWordRule);
		}
		rules[3] = combinedWordRule;
		setRules(rules);
	}
}
