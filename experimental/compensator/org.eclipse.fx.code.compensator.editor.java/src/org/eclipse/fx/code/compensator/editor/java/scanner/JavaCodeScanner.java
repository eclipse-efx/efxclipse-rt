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
package org.eclipse.fx.code.compensator.editor.java.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.rules.CombinedWordRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class JavaCodeScanner extends AbstractJavaScanner {
	private static final String INTERFACE= "interface";  //$NON-NLS-1$
	private static final String RETURN= "return"; //$NON-NLS-1$
	
	private static String[] fgJava14Keywords= { "assert" }; //$NON-NLS-1$
	private static String[] fgJava15Keywords= { "enum" }; //$NON-NLS-1$
	
	static String[] fgKeywords= {
		"abstract", //$NON-NLS-1$
		"break", //$NON-NLS-1$
		"case", "catch", "class", "const", "continue", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
		"default", "do", //$NON-NLS-2$ //$NON-NLS-1$
		"else", "extends", //$NON-NLS-2$ //$NON-NLS-1$
		"final", "finally", "for", //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
		"goto", //$NON-NLS-1$
		"if", "implements", "import", "instanceof", "interface", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
		"native", "new", //$NON-NLS-2$ //$NON-NLS-1$
		"package", "private", "protected", "public", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
		"static", "super", "switch", "synchronized", //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
		"this", "throw", "throws", "transient", "try", //$NON-NLS-5$ //$NON-NLS-4$ //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
		"volatile", //$NON-NLS-1$
		"while" //$NON-NLS-1$
	};

	private static String[] fgTypes= { "void", "boolean", "char", "byte", "short", "strictfp", "int", "long", "float", "double" }; //$NON-NLS-1$ //$NON-NLS-5$ //$NON-NLS-7$ //$NON-NLS-6$ //$NON-NLS-8$ //$NON-NLS-9$  //$NON-NLS-10$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-2$
	private static String[] fgConstants= { "false", "null", "true" }; //$NON-NLS-3$ //$NON-NLS-2$ //$NON-NLS-1$
	
	public JavaCodeScanner() {
		initialize();
	}
	
//	@Override
//	public IToken nextToken() {
//		IToken nextToken = super.nextToken();
//		System.err.println("FIND TOKEN: " + nextToken.getData());
//		return nextToken;
//	}
	
	@Override
	protected List<IRule> createRules() {
		List<IRule> rules= new ArrayList<IRule>();
	
		Token token= getToken(IJavaColorConstants.JAVA_STRING);
		rules.add(new SingleLineRule("'", "'", token, '\\')); //$NON-NLS-2$ //$NON-NLS-1$
		
		Token defaultToken= getToken(IJavaColorConstants.JAVA_DEFAULT);
		
		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new JavaWhitespaceDetector(), defaultToken));

		token= getToken(IJavaColorConstants.ANNOTATION);
		AnnotationRule atInterfaceRule= new AnnotationRule(getToken(IJavaColorConstants.JAVA_KEYWORD), token);
		rules.add(atInterfaceRule);

		// Add word rule for new keywords, see bug 4077
		JavaWordDetector wordDetector= new JavaWordDetector();
		CombinedWordRule combinedWordRule= new CombinedWordRule(wordDetector, defaultToken);

		// Add rule for operators
		token= getToken(IJavaColorConstants.JAVA_OPERATOR);
		rules.add(new OperatorRule(token));

		// Add rule for brackets
		token= getToken(IJavaColorConstants.JAVA_BRACKET);
		rules.add(new BracketRule(token));

		// Add word rule for keyword 'return'.
		CombinedWordRule.WordMatcher returnWordRule= new CombinedWordRule.WordMatcher();
		token= getToken(IJavaColorConstants.JAVA_KEYWORD_RETURN);
		returnWordRule.addWord(RETURN, token);
		combinedWordRule.addWordMatcher(returnWordRule);

		// Add word rule for keywords, types, and constants.
		CombinedWordRule.WordMatcher wordRule= new CombinedWordRule.WordMatcher();
		token= getToken(IJavaColorConstants.JAVA_KEYWORD);
		
		for (int i=0; i<fgJava14Keywords.length; i++)
			wordRule.addWord(fgJava14Keywords[i], token);
		for (int i=0; i<fgJava15Keywords.length; i++)
			wordRule.addWord(fgJava15Keywords[i], token);
		for (int i=0; i<fgKeywords.length; i++)
			wordRule.addWord(fgKeywords[i], token);
		for (int i=0; i<fgTypes.length; i++)
			wordRule.addWord(fgTypes[i], token);
		for (int i=0; i<fgConstants.length; i++)
			wordRule.addWord(fgConstants[i], token);

		combinedWordRule.addWordMatcher(wordRule);

		rules.add(combinedWordRule);
		
		token = getToken(IJavaColorConstants.JAVA_NUMBER);
		rules.add(new NumberRule(token));

		setDefaultReturnToken(defaultToken);
		return rules;
	}
	
	/**
	 * An annotation rule matches the '@' symbol, any following whitespace and
	 * optionally a following <code>interface</code> keyword.
	 *
	 * It does not match if there is a comment between the '@' symbol and
	 * the identifier. See https://bugs.eclipse.org/bugs/show_bug.cgi?id=82452
	 *
	 * @since 3.1
	 */
	private static class AnnotationRule implements IRule {
		/**
		 * A resettable scanner supports marking a position in a scanner and
		 * unreading back to the marked position.
		 */
		private static final class ResettableScanner implements ICharacterScanner {
			private final ICharacterScanner fDelegate;
			private int fReadCount;

			/**
			 * Creates a new resettable scanner that will forward calls
			 * to <code>scanner</code>, but store a marked position.
			 *
			 * @param scanner the delegate scanner
			 */
			public ResettableScanner(final ICharacterScanner scanner) {
				Assert.isNotNull(scanner);
				fDelegate= scanner;
				mark();
			}

			/*
			 * @see org.eclipse.jface.text.rules.ICharacterScanner#getColumn()
			 */
			public int getColumn() {
				return fDelegate.getColumn();
			}

			/*
			 * @see org.eclipse.jface.text.rules.ICharacterScanner#getLegalLineDelimiters()
			 */
			public char[][] getLegalLineDelimiters() {
				return fDelegate.getLegalLineDelimiters();
			}

			/*
			 * @see org.eclipse.jface.text.rules.ICharacterScanner#read()
			 */
			public int read() {
				int ch= fDelegate.read();
				if (ch != ICharacterScanner.EOF)
					fReadCount++;
				return ch;
			}

			/*
			 * @see org.eclipse.jface.text.rules.ICharacterScanner#unread()
			 */
			public void unread() {
				if (fReadCount > 0)
					fReadCount--;
				fDelegate.unread();
			}

			/**
			 * Marks an offset in the scanned content.
			 */
			public void mark() {
				fReadCount= 0;
			}

			/**
			 * Resets the scanner to the marked position.
			 */
			public void reset() {
				while (fReadCount > 0)
					unread();

				while (fReadCount < 0)
					read();
			}
		}
		
		private final IWhitespaceDetector fWhitespaceDetector= new JavaWhitespaceDetector();
		private final IWordDetector fWordDetector= new JavaWordDetector();
		private final IToken fInterfaceToken;
		private final IToken fAtToken;

		/**
		 * Creates a new rule.
		 *
		 * @param interfaceToken the token to return if
		 *        <code>'@\s*interface'</code> is matched
		 * @param atToken the token to return if <code>'@'</code>
		 *        is matched, but not <code>'@\s*interface'</code>
		 * @param version the lowest <code>JavaCore.COMPILER_SOURCE</code>
		 *        version that this rule is enabled
		 * @param currentVersion the current
		 *        <code>JavaCore.COMPILER_SOURCE</code> version
		 */
		public AnnotationRule(IToken interfaceToken, Token atToken) {
			fInterfaceToken= interfaceToken;
			fAtToken= atToken;
		}

		/*
		 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public IToken evaluate(ICharacterScanner scanner) {
			ResettableScanner resettable= new ResettableScanner(scanner);
			if (resettable.read() == '@')
				return readAnnotation(resettable);

			resettable.reset();
			return Token.UNDEFINED;
		}

		private IToken readAnnotation(ResettableScanner scanner) {
			scanner.mark();
			skipWhitespace(scanner);
			if (readInterface(scanner)) {
				return fInterfaceToken;
			} else {
				while( Character.isJavaIdentifierPart(scanner.read()) ) {
				}
				scanner.unread();
//				scanner.reset();
				return fAtToken;
			}
		}
		
		private boolean readInterface(ICharacterScanner scanner) {
			int ch= scanner.read();
			int i= 0;
			while (i < INTERFACE.length() && INTERFACE.charAt(i) == ch) {
				i++;
				ch= scanner.read();
			}
			if (i < INTERFACE.length())
				return false;

			if (fWordDetector.isWordPart((char) ch))
				return false;

			if (ch != ICharacterScanner.EOF)
				scanner.unread();

			return true;
		}

		private boolean skipWhitespace(ICharacterScanner scanner) {
			while (fWhitespaceDetector.isWhitespace((char) scanner.read())) {
				// do nothing
			}

			scanner.unread();
			return true;
		}

	}
	
	private static final class NumberRule implements IRule {
		private final IToken fToken;
		
		public NumberRule(IToken fToken) {
			this.fToken = fToken;
		}

		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			int v = scanner.read();
			
			if( Character.isDigit(v) ) {
				while( (v = scanner.read()) != ICharacterScanner.EOF ) {
					if( ! Character.isDigit(v) & v != '.' && v != '_' ) {
						scanner.unread();
						break;
					}
				}
				return fToken;
			} else {
				return Token.UNDEFINED;
			}
		}
		
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
