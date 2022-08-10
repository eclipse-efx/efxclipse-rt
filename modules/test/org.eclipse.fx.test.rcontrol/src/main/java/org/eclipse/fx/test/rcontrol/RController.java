/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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
package org.eclipse.fx.test.rcontrol;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javafx.scene.Node;

/**
 * Remote control a JavaFX UI
 */
public interface RController {
	public <T extends Node> Query<T,?> cssQuery(String selector);
	public <T extends Node> Query<T,?> labelQuery(String label);
	public <T extends Node> Query<T,?> predicateQuery(Class<T> type, Predicate<T> p);
//	public <T extends Node, I> Query<T,?> findByCustom(Class<Query<T, I>> type, I p);
	
	
	/**
	 * Query for the first {@link Node} using a CSS-Selector using
	 * {@link Node#lookupAll(String)}
	 * 
	 * @param selector
	 *            the selector
	 * @return query result
	 */
	public <T extends Node> Optional<RNode<T>> cssFirst(String selector);

	/**
	 * Query for the first {@link Node} using a CSS-Selector using
	 * {@link Node#lookupAll(String)}
	 * 
	 * @param timeout
	 *            the time out
	 * 
	 * @param selector
	 *            the selector
	 * @return query result
	 */
	public <T extends Node> Optional<RNode<T>> cssFirst(Duration timeout, String selector);

	/**
	 * Query for the first {@link Node} using a CSS-Selector using
	 * {@link Node#lookupAll(String)}
	 * 
	 * @param type
	 *            the {@link Node} type
	 * 
	 * @param selector
	 *            the selector
	 * @return query result
	 */
	public <T extends Node> Optional<RNode<T>> cssFirst(Class<T> type, String selector);

	/**
	 * Query for the first {@link Node} using a CSS-Selector using
	 * {@link Node#lookupAll(String)}
	 * 
	 * @param timeout
	 *            the time out
	 * 
	 * @param type
	 *            the {@link Node} type
	 * 
	 * @param selector
	 *            the selector
	 * @return query result
	 */
	public <T extends Node> Optional<RNode<T>> cssFirst(Duration timeout, Class<T> type, String selector);

	/**
	 * Query for all {@link Node} nodes using a CSS-Selector using
	 * {@link Node#lookupAll(String)}
	 * 
	 * @param selector
	 *            the selector
	 * @return stream with query result
	 */
	public <T extends Node> Stream<RNode<T>> css(String selector);

	/**
	 * Query for all {@link Node} nodes using a CSS-Selector using
	 * {@link Node#lookupAll(String)}
	 * 
	 * @param type
	 *            the {@link Node} type
	 * 
	 * @param selector
	 *            the selector
	 * @return stream with query result
	 */
	public <T extends Node> Stream<RNode<T>> css(Class<T> type, String selector);

	/**
	 * Wait for the UI to render
	 * 
	 * @return self
	 */
	public RController waitForRender();

	/**
	 * Run the provided code
	 * 
	 * @param r
	 *            the runnable
	 * @return self
	 */
	public RController run(Runnable r);

	/**
	 * Run the provided code
	 * 
	 * @param c
	 *            the consumer
	 * @return self
	 */
	public RController run(Consumer<RController> c);

	/**
	 * Run the provided code
	 * 
	 * @param f
	 *            the function
	 * @return the result of the function
	 */
	public <R> R run(Function<RController, R> f);

	/**
	 * Run the provided operations
	 * 
	 * @param r
	 *            operations to run
	 * @return self
	 */
	public RController run(Operation... r);

	/**
	 * @return instance to generate nativ events like mouse-events, key-events
	 */
	public RRobot eventGenerator();
}
