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
package org.eclipse.fx.core.osgi;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.event.Event;
import org.eclipse.fx.core.event.GlobalEventBus;
import org.eclipse.fx.core.event.Topic;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

/**
 * Implementation of OSGiEventBus using OSGi EventAdmin Service
 */
@Component
public class OSGiEventBusImpl implements GlobalEventBus {

	/**
	 * Copy of IEventBroker.DATA as not to pull in the dependency on e4
	 */
	private static final String DATA = "org.eclipse.e4.data"; //$NON-NLS-1$

	private EventAdmin eventAdmin;

	@Reference
	synchronized void registerMessageService(EventAdmin eventAdmin) {
		this.eventAdmin = eventAdmin;
	}
	synchronized void unregisterMessageService(EventAdmin eventAdmin) {
		if (this.eventAdmin != null && this.eventAdmin.equals(eventAdmin)) {
			this.eventAdmin = null;
		}
	}

	@Override
	public <@Nullable T> void publish(Event<T> event, boolean synchronous) {
		Dictionary<String, Object> d = new Hashtable<String, Object>(2);
		d.put(EventConstants.EVENT_TOPIC, event.getTopic());
		d.put(DATA, event.getData());
		org.osgi.service.event.Event osgiEvent = new org.osgi.service.event.Event(event.getTopic(), d);

		if (synchronous) {
			this.eventAdmin.sendEvent(osgiEvent);
		} else {
			this.eventAdmin.postEvent(osgiEvent);
		}
	}

	@Override
	public <T> void publish(Topic<T> topic, T data, boolean synchronous) {
		Dictionary<String, Object> d = new Hashtable<String, Object>(2);
		d.put(EventConstants.EVENT_TOPIC, topic.topic);
		d.put(DATA, data);
		org.osgi.service.event.Event event = new org.osgi.service.event.Event(topic.topic, d);

		if (synchronous) {
			this.eventAdmin.sendEvent(event);
		} else {
			this.eventAdmin.postEvent(event);
		}
	}

	@Override
	public void publish(String topic, Object data, boolean synchronous) {
		publish(new Topic<Object>(topic), data, synchronous);
	}

	@Override
	public <@Nullable T> Subscription subscribe(Topic<T> topic, Consumer<Event<T>> consumer) {
		@SuppressWarnings("unchecked")
		EventHandler handler = event -> {
			Object data = event.getProperty(DATA);
			consumer.accept(new Event<T>(topic, (T)data));
		};
		Dictionary<String, Object> properties = new Hashtable<String, Object>(1);
		properties.put(EventConstants.EVENT_TOPIC, topic.topic);
		BundleContext bundleContext = FrameworkUtil.getBundle(OSGiEventBusImpl.class).getBundleContext();
		ServiceRegistration<EventHandler> serviceRegistration = bundleContext.registerService(EventHandler.class, handler, properties);
		return () -> serviceRegistration.unregister();
	}

	@Override
	public <@Nullable T> Subscription subscribe(String topic, Consumer<Event<T>> consumer) {
		return subscribe(new Topic<T>(topic), consumer);
	}

}
