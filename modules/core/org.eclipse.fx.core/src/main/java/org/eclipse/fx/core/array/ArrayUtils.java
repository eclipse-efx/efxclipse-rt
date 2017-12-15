/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.PrimitiveIterator.OfInt;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Utility methods to deal with arrays
 *
 * @since 3.0
 */
public class ArrayUtils {
	/**
	 * The target array to be filled
	 * 
	 * @param <T>
	 *            the array element type
	 * @param array
	 *            the array
	 * @param s
	 *            the supplier to fetch a value from
	 */
	public static <T> void fill(T[] array, Supplier<T> s) {
		for (int i = 0; i < array.length; i++) {
			array[i] = s.get();
		}
	}

	/**
	 * The target array to be filled
	 * 
	 * @param <T>
	 *            the array element type
	 * @param array
	 *            the array
	 * @param f
	 *            the function to apply for each index
	 */
	public static <T> void fill(T[] array, IntFunction<T> f) {
		for (int i = 0; i < array.length; i++) {
			array[i] = f.apply(i);
		}
	}

	/**
	 * Show an ASCII art with the informations in the array ( - if cell is null, x
	 * if cell is filled)
	 * 
	 * @param <T>
	 *            the array element type
	 * @param array
	 *            the array
	 */
	public static <T> void toString(T[][] array) {
		System.err.println("---------------"); //$NON-NLS-1$
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.err.print(array[i][j] == null ? " - " : " x "); //$NON-NLS-1$//$NON-NLS-2$
			}
			System.err.println();
		}
		System.err.println("---------------"); //$NON-NLS-1$
	}

	/**
	 * Transforms the given array into a key-value map using the following rules
	 * <ul>
	 * <li>keys start with a dash (-) e.g. <code>-path /tmp</code> transforms into
	 * <code>{ path =&gt; /tmp }</code></li>
	 * <li>a key without a value associates {@link Boolean#TRUE} with the key e.g.
	 * <code>-console -consoleLog</code> transforms into
	 * <code>{ console =&gt; true, consoleLog =&gt; true }</code></li>
	 * <li>a key followed by multiple values associates an {@link List} with the key
	 * e.g. <code>-path /tmp /private/tmp</code> transforms into
	 * <code>{ path =&gt; [ /tmp, /private/tmp ] }</code></li>
	 * </ul>
	 *
	 * @param args
	 *            array of arguments
	 * @return map with the transformed array values
	 */
	public static Map<String, Object> toMap(String... args) {
		Map<String, Object> rv = new HashMap<>();
		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) { //$NON-NLS-1$
				List<String> l = new ArrayList<>();
				String key = args[i].substring(1);
				if (i + 1 < args.length && !args[i + 1].startsWith("-")) { //$NON-NLS-1$
					do {
						l.add(args[++i]);
					} while (i + 1 < args.length && !args[i + 1].startsWith("-")); //$NON-NLS-1$
					if (l.size() == 1) {
						rv.put(key, l.get(0));
					} else {
						rv.put(key, l);
					}
				} else {
					rv.put(args[i].substring(1), Boolean.TRUE);
				}
			}
		}
		return rv;
	}

	/**
	 * Create a character stream similar to {@link Arrays#stream(int[], int, int)}
	 *
	 * @param content
	 *            the content
	 * @param startInclusive
	 *            the first index to cover, inclusive
	 * @param endExclusive
	 *            index immediately past the last index to cover
	 * @return stream of characters
	 */
	public static IntStream stream(char[] content, int startInclusive, int endExclusive) {
		OfInt ofInt = new PrimitiveIterator.OfInt() {
			int cur = startInclusive;

			@Override
			public boolean hasNext() {
				return this.cur < endExclusive;
			}

			@Override
			public int nextInt() {
				if (hasNext()) {
					return content[this.cur];
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void forEachRemaining(IntConsumer action) {
				while (this.cur < endExclusive) {
					action.accept(content[this.cur]);
					this.cur++;
				}
			}

		};
		return StreamSupport.intStream(
				() -> Spliterators.spliterator(ofInt, endExclusive - startInclusive, Spliterator.ORDERED),
				Spliterator.SUBSIZED | Spliterator.SIZED | Spliterator.ORDERED, false);
	}

	/**
	 * Convenience method to create a new array with the specified type
	 * 
	 * @param <T>
	 *            array element type
	 * @param elementType
	 *            the element type
	 * @param length
	 *            the length
	 * @return an array of this type
	 * @see Array#newInstance(Class, int)
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] createArray1Dim(Class<T> elementType, int length) {
		return (T[]) Array.newInstance(elementType, length);
	}

	/**
	 * Convenience method to create a new 2 dimensional array with the specified
	 * type
	 * 
	 * @param <T>
	 *            array element type
	 * @param elementType
	 *            the element type
	 * @param lengthLevel1
	 *            the array length at the 1st level
	 * @param lengthLevel2
	 *            the array length at the 2nd level
	 * @return a new 2 dimensional array
	 * @see Array#newInstance(Class, int...)
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[][] createArray2Dim(Class<T> elementType, int lengthLevel1, int lengthLevel2) {
		return (T[][]) Array.newInstance(elementType, lengthLevel1, lengthLevel2);
	}

	/**
	 * Shorthand method for {@link #createArray2Dim(Class, int, int)} with length at
	 * level 2 equal to 0
	 * 
	 * @param <T>
	 *            array element type
	 * @param elementType
	 *            the element type
	 * @param lengthLevel1
	 *            the array length at the 1st level
	 * @return a new 2 dimensional array
	 * @see Array#newInstance(Class, int...)
	 */
	public static <T> T[][] createArray2Dim(Class<T> elementType, int lengthLevel1) {
		return createArray2Dim(elementType, lengthLevel1, 0);
	}
}
