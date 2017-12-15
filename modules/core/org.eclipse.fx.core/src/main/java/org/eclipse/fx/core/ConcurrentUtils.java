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
package org.eclipse.fx.core;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utilities to deal with concurrencies
 */
public class ConcurrentUtils {
	/**
	 * Collect the return values of all the futures provided
	 * 
	 * @param <T>
	 *            the value type
	 * @param futures
	 *            the futures the result is collected from
	 * @return a future with the collected results
	 */
	@SafeVarargs
	public static <T> CompletableFuture<List<T>> collect(CompletableFuture<T>... futures) {
		return CompletableFuture.allOf(futures)
				.thenApply(v -> Stream.of(futures).map(f -> f.join()).collect(Collectors.toList()));
	}

	/**
	 * Collect the return value of all the futures and apply the transformation
	 * method on it
	 * 
	 * @param <O>
	 *            the input value type
	 * @param <T>
	 *            the value type
	 * @param transformer
	 *            the transformation to apply
	 * @param futures
	 *            the future
	 * @return a future with the collected results
	 */
	@SafeVarargs
	public static <T, O> CompletableFuture<List<T>> collect(Function<O, T> transformer,
			CompletableFuture<O>... futures) {
		return CompletableFuture.allOf(futures).thenApply(
				v -> Stream.of(futures).map(f -> f.join()).map(transformer::apply).collect(Collectors.toList()));
	}

	/**
	 * Collect the returned lists of the the futures and combine them into a flat
	 * list
	 * 
	 * @param <T>
	 *            the value type
	 * @param futures
	 *            the futures
	 * @return a future holding the combined list of all future results
	 */
	@SafeVarargs
	public static <T> CompletableFuture<List<T>> collectLists(CompletableFuture<List<T>>... futures) {
		return CompletableFuture.allOf(futures)
				.thenApply(v -> Stream.of(futures).flatMap(f -> f.join().stream()).collect(Collectors.toList()));
	}

	/**
	 * Collect the returned lists of the the futures and combine them into a flat
	 * list and transform the entries
	 * 
	 * @param <O>
	 *            the input value type
	 * @param <T>
	 *            the value type
	 * @param transformer
	 *            the transformer
	 * @param futures
	 *            the futures
	 * @return a future holding the combined and transformed list
	 */
	@SafeVarargs
	public static <T, O> CompletableFuture<List<T>> collectLists(Function<O, T> transformer,
			CompletableFuture<List<O>>... futures) {
		return CompletableFuture.allOf(futures).thenApply(v -> Stream.of(futures).flatMap(f -> f.join().stream())
				.map(transformer::apply).collect(Collectors.toList()));
	}

	/**
	 * Collect the result by transforming the stream of feature results into a final
	 * result of all futures
	 *
	 * @param <O>
	 *            the input value type
	 * @param <T>
	 *            the value type
	 * @param streamTransformer
	 *            the transformer
	 * @param futures
	 *            the futures
	 * @return a future hold the collection of all futures
	 */
	@SafeVarargs
	public static <T, O> CompletableFuture<List<T>> collectWithStream(Function<Stream<O>, Stream<T>> streamTransformer,
			CompletableFuture<O>... futures) {
		return CompletableFuture.allOf(futures).thenApply(
				v -> streamTransformer.apply(Stream.of(futures).map(f -> f.join())).collect(Collectors.toList()));
	}
}
