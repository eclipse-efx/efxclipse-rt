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

import org.eclipse.fx.core.KeyValueStore;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Event published on the event system.
 *
 * <p>
 * This is a value-based class; use of identity-sensitive operations (including
 * reference equality (==), identity hash code, or synchronization) on instances
 * of Event may have unpredictable results and should be avoided.
 * </p>
 *
 * @param <T>
 *            the type
 *
 * @since 2.1.0
 */
public final class Event<@Nullable T> {
	private final String topic;
	private final T data;
	private final KeyValueStore<String, Object> properties;

	/**
	 * Create an event
	 *
	 * @param topic
	 *            the topic as which the event is published
	 * @param data
	 *            the main data
	 */
	@Deprecated
	public Event(String topic, T data) {
		this(topic, data, null);
	}

	/**
	 * Create an event
	 *
	 * @param topic
	 *            the topic as which the event is published
	 * @param data
	 *            the main data
	 * @since 2.2.0
	 */
	public Event(Topic<T> topic, T data) {
		this(topic.topic, data, null);
	}

	/**
	 * Create an event
	 *
	 * @param topic
	 *            the topic as which the event is published
	 * @param data
	 *            the main data
	 * @param properties
	 *            properties
	 * @since 2.2.0
	 */
	public Event(Topic<T> topic, T data, KeyValueStore<String, Object> properties) {
		this(topic.topic,data,properties);
	}

	/**
	 * Create an event
	 *
	 * @param topic
	 *            the topic as which the event is published
	 * @param data
	 *            the main data
	 * @param properties
	 *            properties
	 */
	@Deprecated
	public Event(String topic, T data, KeyValueStore<String, Object> properties) {
		this.topic = topic;
		this.data = data;
		this.properties = properties;

	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return this.topic;
	}

	/**
	 * @return the main data published
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * @return additional properties published
	 */
	public KeyValueStore<String, Object> getProperties() {
		return this.properties;
	}
}
