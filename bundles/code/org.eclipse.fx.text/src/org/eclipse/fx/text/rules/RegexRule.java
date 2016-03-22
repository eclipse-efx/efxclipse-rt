/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	public RegexRule(IToken token, Pattern startPattern, int startLength, Pattern containmentPattern) {
		this.token = token;
		this.startLength = startLength;
		this.startPattern = startPattern;
		this.containmentPattern = containmentPattern;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
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
