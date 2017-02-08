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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.text.MessageFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.text.StrLookup;
import org.apache.commons.lang.text.StrSubstitutor;
import org.eclipse.fx.core.IntTuple;
import org.eclipse.fx.core.Triple;
import org.eclipse.fx.core.function.BiIntPredicate;
import org.eclipse.fx.core.function.BiIntToIntFunction;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Utility methods to deal with texts
 *
 * @since 2.4.0
 */
public class TextUtil {
	// TODO This would work with ICU
	// private static final BreakIterator POSIX_ITERATOR =
	// BreakIterator.getWordInstance(new Locale("en", "US", "POSIX"));
	// //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

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
		if (rv != BreakIterator.DONE && pointAsBoundary) {
			String s = content.subSequence(offset, rv).toString();
			int idx = s.indexOf('.');
			if (idx >= 0) {
				rv = offset + idx;
			}

			if (rv == offset) {
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

		if (rv != BreakIterator.DONE && pointAsBoundary) {
			String s = content.subSequence(rv, offset).toString();
			int idx = s.lastIndexOf('.');
			if (idx > 0) {
				rv += idx + 1;
			}

			// move before the point
			if (rv == offset) {
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

		if (pointAsBoundary && previous != BreakIterator.DONE && next != BreakIterator.DONE) {
			String preMatch = content.subSequence(previous, offset).toString();
			String postMatch = content.subSequence(offset, next).toString();

			int idx = preMatch.lastIndexOf('.');
			if (idx > 0) {
				previous += idx + 1;
			}

			idx = postMatch.indexOf('.');
			if (idx > 0) {
				next = offset + idx;
			}
		}

		return new IntTuple(previous, next);
	}

	/**
	 * Substitute template values (including child-properties) and format them
	 *
	 * The following examples are possible:
	 * <p>
	 *
	 * <pre>
	 * The name is ${person.firstname}.
	 * The birthdate is ${person.birthdate,date,dd.MM.yyyy}.
	 * </pre>
	 * </p>
	 *
	 * @param template
	 *            the template
	 * @param data
	 *            the data
	 * @return the final string
	 * @since 2.4.0
	 */
	public static String templateValuSubstitutor(String template, Map<String, Object> data) {
		return new StrSubstitutor(new StrLookupImpl(data)).replace(template);
	}

	/**
	 * Make the first character in the string upper case
	 *
	 * @param value
	 *            the value
	 * @return the value with the first character as uppercase
	 * @since 2.4.0
	 */
	public static String toFirstUpper(String value) {
		char[] cs = value.toCharArray();
		cs[0] = Character.toUpperCase(cs[0]);
		return String.valueOf(cs);
	}

	/**
	 * Apply the consumer for each matched char
	 *
	 * @param content
	 *            the content
	 * @param c
	 *            the character to find
	 * @param consumer
	 *            the consumer who gets passed the position of the matched char
	 * @since 2.4.0
	 */
	public static void foreachCharPosition(String content, char c, IntConsumer consumer) {
		char[] cs = content.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == c) {
				consumer.accept(i);
			}
		}
	}

	/**
	 * Apply the consumer for each matched char
	 *
	 * @param content
	 *            the content
	 * @param c
	 *            the character to find
	 * @param consumer
	 *            the function who gets passed the position of the matched char
	 * @return stream with objects produced by the function
	 * @since 2.4.0
	 */
	public static <R> Stream<R> foreachCharPosition(String content, char c, IntFunction<R> consumer) {
		// TODO We should not precreate the list
		List<R> list = new ArrayList<>();
		char[] cs = content.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == c) {
				list.add(consumer.apply(i));
			}
		}
		return list.stream();
	}

	/**
	 * Strip characters matched by the filter
	 *
	 * @param content
	 *            the content
	 * @param filter
	 *            the filter
	 * @return string without the filtered characters
	 * @since 2.4.0
	 */
	public static String stripOff(String content, IntPredicate filter) {
		char[] cs = content.toCharArray();
		char[] target = new char[cs.length];
		int j = 0;
		for (int i = 0; i < cs.length; i++) {
			if (!filter.test(cs[i])) {
				target[j++] = cs[i];
			}
		}

		if (j < cs.length) {
			return new String(target, 0, j);
		}

		return content;
	}

	/**
	 * Make use the value is not null
	 *
	 * @param value
	 *            the nullable value
	 * @param defaultValue
	 *            the default if the value is null
	 * @return a nonnull string
	 * @since 2.0
	 */
	public static @NonNull String notNull(@Nullable String value, @NonNull String defaultValue) {
		return value == null ? defaultValue : value;
	}

	/**
	 * Create a string of the same char
	 *
	 * @param c
	 *            the character
	 * @param length
	 *            the length
	 * @return the created string
	 * @since 2.4.0
	 */
	public static String createRepeatedString(char c, int length) {
		char[] vals = new char[length];
		Arrays.fill(vals, c);
		return String.valueOf(vals);
	}

	static class StrLookupImpl extends StrLookup {
		private final Map<String, Object> data;

		public StrLookupImpl(Map<String, Object> data) {
			this.data = data;
		}

		@Override
		public String lookup(String key) {
			String[] pathAndFormat = key.split(","); //$NON-NLS-1$
			String[] path = pathAndFormat[0].split("\\."); //$NON-NLS-1$

			Object object = this.data.get(path[0]);
			if (object != null && path.length > 1) {
				int i = 1;
				while (object != null && i < path.length) {
					Method m = null;
					try {
						m = object.getClass().getDeclaredMethod("get" + toFirstUpper(path[i])); //$NON-NLS-1$
					} catch (NoSuchMethodException | SecurityException e) {
						try {
							m = object.getClass().getDeclaredMethod("is" + toFirstUpper(path[i])); //$NON-NLS-1$
						} catch (NoSuchMethodException | SecurityException e1) {
							// nothing todo
						}
					}
					if (m == null) {
						throw new IllegalStateException("Unable to locate accessor property for property '" + path[i] //$NON-NLS-1$
								+ "' on object " + object + "."); //$NON-NLS-1$//$NON-NLS-2$
					}

					m.setAccessible(true);
					try {
						object = m.invoke(object);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						throw new IllegalStateException(e);
					}
					i++;
				}
			}

			if (pathAndFormat.length > 1) {
				String msg = "{0," + Stream.of(pathAndFormat).skip(1).collect(Collectors.joining(",")) + "}"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				return MessageFormat.format(msg, object);
			}

			return object == null ? null : object.toString();
		}

	}

	/**
	 * Replace tabs through spaces return
	 * <ul>
	 * <li>{@link Triple#value1}: the new char array</li>
	 * <li>{@link Triple#value2}: the indices the tabs have been found</li>
	 * <li>{@link Triple#value3}: the new indices where a "tab" is starts
	 * now</li>
	 * </ul>
	 *
	 * @param source
	 *            the source array
	 * @param tabAdvance
	 * @return a triple with the values
	 */
	public static Triple<char[], int[], int[]> replaceTabBySpace(char[] source, int tabAdvance) {
		if (tabAdvance <= 0) {
			throw new IllegalArgumentException("tabAdvance must be greater 0"); //$NON-NLS-1$
		}
		int tabCount = 0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] == '\t') {
				tabCount++;
			}
		}

		if (tabCount == 0) {
			char[] rv = new char[source.length];
			System.arraycopy(source, 0, rv, 0, rv.length);
			return new Triple<>(rv, new int[0], new int[0]);
		}

		int[] tabPositions = new int[tabCount];
		int[] newTabPositions = new int[tabCount];
		char[] rv = new char[source.length + (tabCount * (tabAdvance - 1))];

		int count = 0;
		int tabIdx = 0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] == '\t') {
				tabPositions[tabIdx] = i;
				newTabPositions[tabIdx] = count;
				tabIdx++;
				for (int j = 0; j < tabAdvance; j++) {
					rv[count++] = ' ';
				}
			} else {
				rv[count++] = source[i];
			}
		}

		return new Triple<>(rv, tabPositions, newTabPositions);
	}

	/**
	 * Replaces all occurences of the provided character in the source
	 *
	 * @param source
	 *            the source
	 * @param c
	 *            the character to replace
	 * @param newChar
	 *            the replacement
	 * @return a new array with all character replaced
	 */
	public static char[] replaceAll(char[] source, char c, char[] newChar) {
		StringBuilder b = new StringBuilder(source.length);

		for (int i = 0; i < source.length; i++) {
			if (source[i] == c) {
				b.append(newChar);
			} else {
				b.append(source[i]);
			}
		}

		char[] rv = new char[b.length()];
		b.getChars(0, b.length(), rv, 0);
		return rv;
	}

	/**
	 * Transform the provided source array by applying the provided function
	 *
	 * @param source
	 *            the source
	 * @param transformer
	 *            the transformation function, first argument is the character
	 *            index, second argument is the character
	 * @return transformed character array
	 */
	public static char[] transform(char[] source, BiIntToIntFunction transformer) {
		char[] rv = new char[source.length];
		for (int i = 0; i < source.length; i++) {
			rv[i] = (char) transformer.apply(i, source[i]);
		}
		return rv;
	}

	/**
	 * Replace entries matching the provided predicate with the provided char
	 *
	 * @param source
	 *            the source array
	 * @param c
	 *            the replacement character
	 * @param predicate
	 *            the predicate to decided if a character is replaced, first
	 *            argument is the character index, second argument is the
	 *            character
	 * @return transformed character array
	 */
	public static char[] replace(char[] source, char c, BiIntPredicate predicate) {
		char[] rv = new char[source.length];
		for (int i = 0; i < source.length; i++) {
			rv[i] = predicate.test(i, source[i]) ? c : source[i];
		}
		return rv;
	}

	private static String[] BASIC_STRING_CACHE = new String[256];

	/**
	 * Get the matching string for the char. The string object returned might be
	 * the same instance.
	 *
	 * @param c
	 *            the character
	 * @return a (cached) string object
	 */
	public static String toString(char c) {
		String rv = null;
		if (c < BASIC_STRING_CACHE.length) {
			rv = BASIC_STRING_CACHE[c];
			if (rv == null) {
				BASIC_STRING_CACHE[c] = String.valueOf(c);
			}
		}
		if (rv == null) {
			rv = String.valueOf(c);
		}
		return rv;
	}
}
