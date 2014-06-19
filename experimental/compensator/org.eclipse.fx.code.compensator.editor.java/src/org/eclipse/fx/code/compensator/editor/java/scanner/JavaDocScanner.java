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

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class JavaDocScanner extends JavaCommentScanner {
	private static String[] fgTokenProperties= {
		IJavaColorConstants.JAVADOC_KEYWORD,
		IJavaColorConstants.JAVADOC_TAG,
		IJavaColorConstants.JAVADOC_LINK,
		IJavaColorConstants.JAVADOC_DEFAULT,
		TASK_TAG
	};


	public JavaDocScanner() {
		super(IJavaColorConstants.JAVADOC_DEFAULT, fgTokenProperties);
	}
	
	public IDocument getDocument() {
		return fDocument;
	}

	@Override
	protected List<IRule> createRules() {

		List<IRule> list= new ArrayList<IRule>();

		// Add rule for tags
		Token token= getToken(IJavaColorConstants.JAVADOC_TAG);
		list.add(new TagRule(token));


		// Add rule for HTML comments
		WordRule wordRule= new WordRule(new HTMLCommentDetector(), token);
		wordRule.addWord("<!--", token); //$NON-NLS-1$
		wordRule.addWord("--!>", token); //$NON-NLS-1$
		list.add(wordRule);


		// Add rules for links
		token= getToken(IJavaColorConstants.JAVADOC_LINK);
		list.add(new MultiLineRule("{@link", "}", token)); //$NON-NLS-2$ //$NON-NLS-1$
		list.add(new MultiLineRule("{@value", "}", token)); //$NON-NLS-2$ //$NON-NLS-1$
		list.add(new MultiLineRule("{@inheritDoc", "}", token)); //$NON-NLS-2$ //$NON-NLS-1$

		// Add rules for @code and @literals
		token= getToken(IJavaColorConstants.JAVADOC_DEFAULT);
		list.add(new MultiLineRule("{@code", "}", token)); //$NON-NLS-2$ //$NON-NLS-1$
		list.add(new MultiLineRule("{@literal", "}", token)); //$NON-NLS-2$ //$NON-NLS-1$

		// Add generic whitespace rule
		token= getToken(IJavaColorConstants.JAVADOC_DEFAULT);
		list.add(new WhitespaceRule(new JavaWhitespaceDetector(), token));


		list.addAll(super.createRules());
		return list;
	}
	
	class TagRule extends SingleLineRule {

		/*
		 * @see SingleLineRule
		 */
		public TagRule(IToken token) {
			super("<", ">", token, (char) 0); //$NON-NLS-2$ //$NON-NLS-1$
		}

		/*
		 * @see SingleLineRule
		 */
		public TagRule(IToken token, char escapeCharacter) {
			super("<", ">", token, escapeCharacter); //$NON-NLS-2$ //$NON-NLS-1$
		}

		private IToken evaluateToken() {
			try {
				final String token= getDocument().get(getTokenOffset(), getTokenLength()) + "."; //$NON-NLS-1$

				int offset= 0;
				char character= token.charAt(++offset);

				if (character == '/')
					character= token.charAt(++offset);

				while (Character.isWhitespace(character))
					character= token.charAt(++offset);

				while (Character.isLetterOrDigit(character))
					character= token.charAt(++offset);

				while (Character.isWhitespace(character))
					character= token.charAt(++offset);

				if (offset >= 2 && token.charAt(offset) == fEndSequence[0])
					return fToken;

			} catch (BadLocationException exception) {
				// Do nothing
			}
			return getToken(IJavaColorConstants.JAVADOC_DEFAULT);
		}

		/*
		 * @see PatternRule#evaluate(ICharacterScanner)
		 */
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			IToken result= super.evaluate(scanner);
			if (result == fToken)
				return evaluateToken();
			return result;
		}
	}
	
	static class HTMLCommentDetector implements IWordDetector {

		/**
		 * @see IWordDetector#isWordStart(char)
		 */
		public boolean isWordStart(char c) {
			return (c == '<' || c == '-');
		}

		/**
		 * @see IWordDetector#isWordPart(char)
		 */
		public boolean isWordPart(char c) {
			return (c == '-' || c == '!' || c == '>');
		}
	}
}
