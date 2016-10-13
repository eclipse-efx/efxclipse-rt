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

import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * Utility methods to deal with arrays
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
				System.err.print(array[i][j] == null ? " - " : " x ");  //$NON-NLS-1$//$NON-NLS-2$
			}
			System.err.println();
		}
		System.err.println("---------------"); //$NON-NLS-1$
	}
}
