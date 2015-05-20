package org.eclipse.fx.xtext.statemachine.fx.text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.CombinedWordRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.JavaLikeWordDetector;

public class StatemachineCodeScanner extends RuleBasedScanner {
	public StatemachineCodeScanner() {
		Token keywordToken = new Token(new TextAttribute("state_keyword"));
		Token defaultToken = new Token(new TextAttribute("state_default"));
		
		setDefaultReturnToken(defaultToken);
		
		IRule[] rules = new IRule[1];
		
		// Keyword rules
		JavaLikeWordDetector wordDetector= new JavaLikeWordDetector();
		CombinedWordRule combinedWordRule= new CombinedWordRule(wordDetector, defaultToken) {
			@Override
			public IToken evaluate(ICharacterScanner scanner) {
				IToken evaluate = super.evaluate(scanner);
				return evaluate;
			}
		};
		
		CombinedWordRule.WordMatcher wordRule= new CombinedWordRule.WordMatcher();
		wordRule.addWord("signal", keywordToken);
		wordRule.addWord("input", keywordToken);
		wordRule.addWord("output", keywordToken);
		wordRule.addWord("state", keywordToken);
		wordRule.addWord("end", keywordToken);
		wordRule.addWord("if", keywordToken);
		wordRule.addWord("goto", keywordToken);
		wordRule.addWord("and", keywordToken);
		wordRule.addWord("set", keywordToken);
		wordRule.addWord("true", keywordToken);
		wordRule.addWord("false", keywordToken);
		
		combinedWordRule.addWordMatcher(wordRule);
		rules[0] = combinedWordRule;
		setRules(rules);
	}

}
