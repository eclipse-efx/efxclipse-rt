/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import org.eclipse.fx.core.IntTuple;

/**
 * Utility methods to deal with texts
 *
 * @since 2.4.0
 */
public class TextUtil {
//TODO This would work with ICU
//	private static final BreakIterator POSIX_ITERATOR = BreakIterator.getWordInstance(new Locale("en", "US", "POSIX"));   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

	/**
	 * A {@link CharSequence} who can provide an {@link CharacterIterator}
	 */
	public interface IterableCharSequence extends CharSequence {
		/**
		 * @return the iterator to use
		 */
		public default CharacterIterator getIterator() {
			return new StringCharacterIterator(subSequence(0, length()).toString());
		}
	}

	/**
	 * Find the end offset of the word
	 *
	 * @param content
	 *            the content
	 * @param offset
	 *            the offset to start the search from
	 * @param pointAsBoundary
	 *            should the '.' treated as word boundary
	 * @return the end offset or {@link BreakIterator#DONE}
	 */
	public static int findWordEndOffset(IterableCharSequence content, int offset, boolean pointAsBoundary) {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(content.getIterator());
		int rv = wordInstance.following(offset);
		if( rv != BreakIterator.DONE && pointAsBoundary ) {
			String s = content.subSequence(offset, rv).toString();
			int idx = s.indexOf('.');
			if( idx >= 0 ) {
				rv = offset + idx;
			}

			if( rv == offset ) {
				rv = offset + 1;
			}
		}
		return rv;
	}

	/**
	 * Find the start offset of the word
	 *
	 * @param content
	 *            the content
	 * @param offset
	 *            the offset to start the search from
	 * @param pointAsBoundary
	 *            should the '.' treated as word boundary
	 * @return the start offset or or {@link BreakIterator#DONE}
	 */
	public static int findWordStartOffset(IterableCharSequence content, int offset, boolean pointAsBoundary) {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(content.getIterator());
		int rv = wordInstance.preceding(offset);

		if( rv != BreakIterator.DONE && pointAsBoundary ) {
			String s = content.subSequence(rv, offset).toString();
			int idx = s.lastIndexOf('.');
			if( idx > 0 ) {
				rv += idx + 1;
			}

			// move before the point
			if( rv == offset ) {
				rv -= 1;
			}
		}

		return rv;
	}

	/**
	 * Find the bounds of the word
	 *
	 * @param content
	 *            the content
	 * @param offset
	 *            the offset
	 * @param pointAsBoundary
	 *            should the '.' treated as word boundary
	 * @return a tuple of value representing start and end
	 */
	public static IntTuple findWordBounds(IterableCharSequence content, int offset, boolean pointAsBoundary) {
		BreakIterator wordInstance = BreakIterator.getWordInstance();
		wordInstance.setText(content.getIterator());
		int previous = wordInstance.preceding(offset);
		int next = wordInstance.following(offset);

		if( pointAsBoundary && previous != BreakIterator.DONE && next != BreakIterator.DONE ) {
			String preMatch = content.subSequence(previous, offset).toString();
			String postMatch = content.subSequence(offset, next).toString();

			int idx = preMatch.lastIndexOf('.');
			if( idx > 0 ) {
				previous += idx + 1;
			}

			idx = postMatch.indexOf('.');
			if( idx > 0 ) {
				next = offset + idx;
			}
		}

		return new IntTuple(previous, next);
	}
}
