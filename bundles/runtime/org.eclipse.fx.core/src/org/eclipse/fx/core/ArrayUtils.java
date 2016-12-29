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
package org.eclipse.fx.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * Utility methods to deal with arrays
 *
 * @since 3.0
 */
public class ArrayUtils {
	/**
	 * The target array to be filled
	 *
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
	 * Show an ASCII art with the informations in the array ( - if cell is null,
	 * x if cell is filled)
	 *
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
	 * <li>keys start with a dash (-) e.g. <code>-path /tmp</code> transforms
	 * into <code>{ path => /tmp }</code></li>
	 * <li>a key without a value associates {@link Boolean#TRUE} with the key
	 * e.g. <code>-console -consoleLog</code> transforms into
	 * <code>{ console => true, consoleLog => true }</code></li>
	 * <li>a key followed by multiple values associates an {@link List} with the
	 * key e.g. <code>-path /tmp /private/tmp</code> transforms into
	 * <code>{ path => [ /tmp, /private/tmp ] }</code></li>
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
}
