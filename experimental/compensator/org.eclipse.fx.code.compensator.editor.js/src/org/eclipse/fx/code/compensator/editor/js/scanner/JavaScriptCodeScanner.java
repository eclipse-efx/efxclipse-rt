/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.editor.js.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.CombinedWordRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class JavaScriptCodeScanner extends AbstractJavaScriptScanner {
	private static final String RETURN= "return"; //$NON-NLS-1$
	
	static String[] fgKeywords= {
	    "break",
	    "case",
	    "catch",
	    "continue",
	    "debugger",
	    "default",
	    "delete",
	    "do",
	    "else",
	    "finally",
	    "for",
	    "function",
	    "if",
	    "in",
	    "instanceof",
	    "new",
	    "return",
	    "switch",
	    "this",
	    "throw",
	    "try",
	    "typeof",
	    "var",
	    "void",
	    "while",
	    "with"


		
	};

	public JavaScriptCodeScanner() {
		initialize();
	}
	
	@Override
	protected List<IRule> createRules() {
		List<IRule> rules= new ArrayList<IRule>();
	
		Token token= getToken(IJavaScriptColorConstants.JAVA_STRING);
		rules.add(new SingleLineRule("'", "'", token, '\\')); //$NON-NLS-2$ //$NON-NLS-1$
		
		Token defaultToken= getToken(IJavaScriptColorConstants.JAVA_DEFAULT);
		
		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new JavaScriptWhitespaceDetector(), defaultToken));

		// Add word rule for new keywords, see bug 4077
		JavaScriptWordDetector wordDetector= new JavaScriptWordDetector();
		CombinedWordRule combinedWordRule= new CombinedWordRule(wordDetector, defaultToken);

		// Add rule for operators
		token= getToken(IJavaScriptColorConstants.JAVA_OPERATOR);
		rules.add(new OperatorRule(token));

		// Add rule for brackets
		token= getToken(IJavaScriptColorConstants.JAVA_BRACKET);
		rules.add(new BracketRule(token));

		// Add word rule for keyword 'return'.
		CombinedWordRule.WordMatcher returnWordRule= new CombinedWordRule.WordMatcher();
		token= getToken(IJavaScriptColorConstants.JAVA_KEYWORD_RETURN);
		returnWordRule.addWord(RETURN, token);
		combinedWordRule.addWordMatcher(returnWordRule);

		// Add word rule for keywords, types, and constants.
		CombinedWordRule.WordMatcher wordRule= new CombinedWordRule.WordMatcher();
		token= getToken(IJavaScriptColorConstants.JAVA_KEYWORD);
		
		for (int i=0; i<fgKeywords.length; i++)
			wordRule.addWord(fgKeywords[i], token);

		combinedWordRule.addWordMatcher(wordRule);

		rules.add(combinedWordRule);

		setDefaultReturnToken(defaultToken);
		return rules;
	}
	
	private static final class OperatorRule implements IRule {

		/** Java operators */
		private final char[] JAVA_OPERATORS= { ';', '.', '=', '/', '\\', '+', '-', '*', '<', '>', ':', '?', '!', ',', '|', '&', '^', '%', '~'};
		/** Token to return for this rule */
		private final IToken fToken;

		/**
		 * Creates a new operator rule.
		 *
		 * @param token Token to use for this rule
		 */
		public OperatorRule(IToken token) {
			fToken= token;
		}

		/**
		 * Is this character an operator character?
		 *
		 * @param character Character to determine whether it is an operator character
		 * @return <code>true</code> iff the character is an operator, <code>false</code> otherwise.
		 */
		public boolean isOperator(char character) {
			for (int index= 0; index < JAVA_OPERATORS.length; index++) {
				if (JAVA_OPERATORS[index] == character)
					return true;
			}
			return false;
		}

		/*
		 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public IToken evaluate(ICharacterScanner scanner) {

			int character= scanner.read();
			if (isOperator((char) character)) {
				do {
					character= scanner.read();
				} while (isOperator((char) character));
				scanner.unread();
				return fToken;
			} else {
				scanner.unread();
				return Token.UNDEFINED;
			}
		}
	}
	
	private static final class BracketRule implements IRule {

		/** Java brackets */
		private final char[] JAVA_BRACKETS= { '(', ')', '{', '}', '[', ']' };
		/** Token to return for this rule */
		private final IToken fToken;

		/**
		 * Creates a new bracket rule.
		 *
		 * @param token Token to use for this rule
		 */
		public BracketRule(IToken token) {
			fToken= token;
		}

		/**
		 * Is this character a bracket character?
		 *
		 * @param character Character to determine whether it is a bracket character
		 * @return <code>true</code> iff the character is a bracket, <code>false</code> otherwise.
		 */
		public boolean isBracket(char character) {
			for (int index= 0; index < JAVA_BRACKETS.length; index++) {
				if (JAVA_BRACKETS[index] == character)
					return true;
			}
			return false;
		}

		/*
		 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public IToken evaluate(ICharacterScanner scanner) {

			int character= scanner.read();
			if (isBracket((char) character)) {
				do {
					character= scanner.read();
				} while (isBracket((char) character));
				scanner.unread();
				return fToken;
			} else {
				scanner.unread();
				return Token.UNDEFINED;
			}
		}
	}
}
