package org.eclipse.jface.text.rules;

import java.util.List;

public class FixedCharacterWSDetector implements IWhitespaceDetector {
	private final char[] chars;

	public FixedCharacterWSDetector(List<String> list) {
		chars = new char[list.size()];
		int i = 0;
		for( String s : list ) {
			chars[i++] = s.charAt(0);
		}
	}

	@Override
	public boolean isWhitespace(char c) {
		for( char ch : chars ) {
			if( ch == c ) {
				return true;
			}
		}
		return false;
	}
}