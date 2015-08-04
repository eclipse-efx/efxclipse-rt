package org.eclipse.fx.text;

import java.util.regex.Pattern;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

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
			System.err.println("MATCHED =======> " + b);
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
