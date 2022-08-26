/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.rules;

import java.util.regex.Pattern;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

@SuppressWarnings("restriction")
public class RegexRule implements IRule {
	private final IToken token;
	private final int startLength;
	private final Pattern startPattern;
	private final Pattern containmentPattern;
	private final Pattern leadCharPattern;

	public RegexRule(IToken token, Pattern startPattern, int startLength, Pattern containmentPattern) {
		this(token, null, startPattern, startLength, containmentPattern);
	}

	public RegexRule(IToken token, Pattern leadCharPattern, Pattern startPattern, int startLength, Pattern containmentPattern) {
		this.token = token;
		this.leadCharPattern = leadCharPattern;
		this.startLength = startLength;
		this.startPattern = startPattern;
		this.containmentPattern = containmentPattern;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		if( leadCharPattern != null && scanner.getColumn() > 0 ) {
			scanner.unread();
			int c = scanner.read();
			if( ! leadCharPattern.matcher(String.valueOf((char)c)).matches() ) {
				return Token.UNDEFINED;
			}
		}

		StringBuilder b = new StringBuilder();
		int readCount = 0;
		for( int i = 0; i < startLength; i++ ) {
			readCount++;
			int c = scanner.read();
			if( c == ICharacterScanner.EOF ) {
				break;
			}
			b.append((char)c);
		}

		if( startPattern.matcher(b.toString()).matches() ) {
			String input;
			do {
				readCount++;
				int c = scanner.read();
				if( c == ICharacterScanner.EOF ||
						c == '\n' || c == '\r') {
					return token;
				}
				input = String.valueOf((char)c);
			} while( containmentPattern.matcher(input).matches() );

			scanner.unread();
			return token;
		} else {
			for( int i = 0; i < readCount; i++ ) {
				scanner.unread();
			}
		}

		return Token.UNDEFINED;
	}

}
