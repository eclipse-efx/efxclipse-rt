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

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Utilities when working with {@link Stream}
 */
public class StreamUtils {
	/**
	 * Helper method allowing to insert temporary debug information in an
	 * {@link Stream} mapping
	 *
	 * @param data
	 *            the data
	 * @return the data
	 * @since 2.2.0
	 */
	public static <T> T debugStderr(T data) {
		System.err.println(data);
		return data;
	}
	
	/**
	 * Creates a {@link Stream} that iterates over the given list in reverse
	 * order
	 * 
	 * @param list
	 *            list
	 * @return reverse list stream
	 */
	public static <T> Stream<T> reverse(List<T> list) {
		int size = list.size();
		return IntStream.range(0, size).mapToObj(i -> list.get(size - 1- i));
	}
}
