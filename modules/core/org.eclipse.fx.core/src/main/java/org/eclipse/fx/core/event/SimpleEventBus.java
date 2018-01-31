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
import org.eclipse.fx.core.event.Event;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.eventbus.Subscribe;

/**
 * A simple event bus implementation
 *
 * @since 2.1.0
 */
public class SimpleEventBus implements EventBus {
	private com.google.common.eventbus.EventBus bus;

	/**
	 * A simple event bus
	 */
	public SimpleEventBus() {
		this.bus = new com.google.common.eventbus.EventBus();
	}

	@Override
	public <@Nullable T> void publish(Event<T> event, boolean synchronous) {
		this.bus.post(event);
	}

	@Override
	public void publish(String topic, Object data, boolean synchronous) {
		this.bus.post(new Event<>(topic, data));
	}

	@Override
	public <@Nullable T> Subscription subscribe(String topic, Consumer<Event<T>> consumer) {
		SubscribeWrapper<T> wrapper = new SubscribeWrapper<>(topic, consumer);
		this.bus.register(wrapper);
		return () -> this.bus.unregister(wrapper);
	}

	static class SubscribeWrapper<@Nullable T> {
		private final String topic;
		private final boolean allSubTopics;
		private Consumer<Event<T>> consumer;

		public SubscribeWrapper(String topic, Consumer<Event<T>> consumer) {
			String t = topic;
			if (t.endsWith("*")) { //$NON-NLS-1$
				t = t.substring(0, topic.length() - 1);
				this.allSubTopics = true;
			} else {
				this.allSubTopics = false;
			}
			this.topic = t;
			this.consumer = consumer;
		}

		@Subscribe
		public void record(Event<T> event) {
			if (event.getTopic().equals(this.topic) || (this.allSubTopics && event.getTopic().startsWith(this.topic))) {
				this.consumer.accept(event);
			}
		}
	}
}
