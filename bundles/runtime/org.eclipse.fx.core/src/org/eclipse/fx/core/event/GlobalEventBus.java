/*******************************************************************************
 * Copyright (c) 2016 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.event;

import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jdt.annotation.Nullable;

/**
 * EventBus as OSGi Service to send and receive events
 * that are compatible with the e4 client EventBus
 */
public interface GlobalEventBus extends EventBus {
	
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
	 * @since 2.4.0
	 */
	@Override
	<T> void publish(Topic<T> topic, T data, boolean synchronous);

	/**
	 * Subscribe to an event topic
	 *
	 * @param topic
	 *            the topic
	 * @param consumer
	 *            the consumer
	 * @return subscription to cancel the subscribtion
	 * @since 2.4.0
	 */
	@Override
	<@Nullable T> Subscription subscribe(Topic<@Nullable T> topic, Consumer<Event<@Nullable T>> consumer);

}
