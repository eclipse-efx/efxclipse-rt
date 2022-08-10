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

import java.util.List;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

@SuppressWarnings("restriction")
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