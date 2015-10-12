/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.event;

import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jdt.annotation.Nullable;

/**
 * System to publish events and subscribe to topics
 *
 * @since 2.1.0
 */
public interface EventBus {
	/**
	 * Publish the event
	 *
	 * @param event
	 *            the event to publish
	 * @param synchronous
	 *            <code>true</code> returns after the event has been processed
	 *            by all subscribers
	 */
	public <@Nullable T> void publish(Event<T> event, boolean synchronous);

	/**
	 * Publish the event
	 *
	 * @param topic
	 *            the topic on which you want to publish the event
	 * @param data
	 *            the data to publish
	 * @param synchronous
	 *            <code>true</code> returns after the event has been processed
	 *            by all subscribers
	 */
	@Deprecated
	public void publish(String topic, Object data, boolean synchronous);

	/**
	 * Publish the event
	 *
	 * @param topic
	 *            the topic on which you want to publish the event
	 * @param data
	 *            the data to publish
	 * @param synchronous
	 *            <code>true</code> returns after the event has been processed
	 *            by all subscribers
	 * @since 2.2.0
	 */
	public default <T> void publish(Topic<T> topic, T data, boolean synchronous) {
		publish(topic.topic, data, synchronous);
	}

	/**
	 * Subscribe to an event topic
	 *
	 * @param topic
	 *            the topic
	 * @param consumer
	 *            the consumer
	 * @return subscription to cancel the subscribtion
	 */
	@Deprecated
	public <@Nullable T> Subscription subscribe(String topic, Consumer<Event<T>> consumer);

	/**
	 * Subscribe to an event topic
	 *
	 * @param topic
	 *            the topic
	 * @param consumer
	 *            the consumer
	 * @return subscription to cancel the subscribtion
	 * @since 2.2.0
	 */
	public default <@Nullable T> Subscription subscribe(Topic<T> topic, Consumer<Event<T>> consumer) {
		return subscribe(topic.topic, consumer);
	}

	/**
	 * Wrap a main data consumer as an event consumer
	 *
	 * @param consumer
	 *            the consumer
	 * @return the event consumer
	 */
	public static <@Nullable T> Consumer<Event<T>> data(Consumer<T> consumer) {
		return e -> consumer.accept(e.getData());
	}
}
