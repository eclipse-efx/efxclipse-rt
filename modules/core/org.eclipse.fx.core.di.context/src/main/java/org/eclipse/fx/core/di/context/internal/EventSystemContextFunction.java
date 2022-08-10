/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.core.KeyValueStore;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.event.Event;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.EventHandler;

/**
 * Context function creating an event system
 */
@Component(service=IContextFunction.class,property={"service.context.key=org.eclipse.fx.core.event.EventBus"})
public class EventSystemContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return new EventSytemImpl(context.get(IEventBroker.class));
	}

	static class EventSytemImpl implements EventBus {
		private final IEventBroker eventBroker;

		public EventSytemImpl(IEventBroker eventBroker) {
			this.eventBroker = eventBroker;
		}

		@Override
		public <@Nullable T> void publish(Event<T> event, boolean synchronous) {
			Map<String, Object> properties = new HashMap<>(event.getProperties().toMap());
			properties.put(IEventBroker.DATA, event.getData());
			if( synchronous ) {
				this.eventBroker.send(event.getTopic(), properties);
			} else {
				this.eventBroker.post(event.getTopic(), properties);
			}

		}

		@Override
		public void publish(String topic, Object data, boolean synchronous) {
			Object d = data;
			if( data instanceof Map<?, ?> || data instanceof Dictionary<?, ?> ) {
				d = Collections.singletonMap(IEventBroker.DATA, data);
			}

			if( synchronous ) {
				this.eventBroker.send(topic, d);
			} else {
				this.eventBroker.post(topic, d);
			}
		}

		@Override
		public <@Nullable T> Subscription subscribe(String topic, Consumer<Event<T>> consumer) {
			@SuppressWarnings("unchecked")
			EventHandler eventHandler = event -> {
				if( event.containsProperty(IEventBroker.DATA) ) {
					Object object = event.getProperty(IEventBroker.DATA);
					if( object instanceof Event ) {
						consumer.accept((Event<T>) object);
					} else {
						consumer.accept(new Event<T>(topic, (T)object, new KeyValueStore<String, Object>() {

							@Override
							public Object get(String key) throws IllegalArgumentException {
								Object property = event.getProperty(key);
								if( property == null ) {
									if( contains(key) ) {
										throw new IllegalArgumentException("The key '"+key+"' is not known.");  //$NON-NLS-1$//$NON-NLS-2$
									}
								}
								return property;
							}

							@Override
							public boolean contains(String key) {
								return event.containsProperty(key);
							}

							@Override
							public Set<String> getKeys() {
								return new HashSet<>(Arrays.asList(event.getPropertyNames()));
							}

							@Override
							public Collection<Object> getValues() {
								List<Object> data = new ArrayList<>(event.getPropertyNames().length);
								for( String d : event.getPropertyNames() ) {
									data.add(d);
								}
								return data;
							}
						}));
					}
				} else {
					consumer.accept(new Event<T>(topic, null, new KeyValueStore<String, Object>() {

						@Override
						public Object get(String key) throws IllegalArgumentException {
							Object property = event.getProperty(key);
							if( property == null ) {
								if( contains(key) ) {
									throw new IllegalArgumentException("The key '"+key+"' is not known.");  //$NON-NLS-1$//$NON-NLS-2$
								}
							}
							return property;
						}

						@Override
						public boolean contains(String key) {
							return event.containsProperty(key);
						}

						@Override
						public Set<String> getKeys() {
							return new HashSet<>(Arrays.asList(event.getPropertyNames()));
						}

						@Override
						public Collection<Object> getValues() {
							List<Object> data = new ArrayList<>(event.getPropertyNames().length);
							for( String d : event.getPropertyNames() ) {
								data.add(d);
							}
							return data;
						}
					}));
				}
			};
			this.eventBroker.subscribe(topic, eventHandler);
			return () -> this.eventBroker.unsubscribe(eventHandler);
		}

	}
}
