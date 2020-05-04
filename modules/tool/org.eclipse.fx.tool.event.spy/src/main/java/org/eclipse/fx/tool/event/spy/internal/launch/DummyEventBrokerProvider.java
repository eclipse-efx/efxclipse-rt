/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.event.spy.internal.launch;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.service.event.EventHandler;

/**
 * Provide a dummy broker for starting without an osgi application.
 */
public class DummyEventBrokerProvider {

    private final IEventBroker eventBroker;

    public DummyEventBrokerProvider() {
        eventBroker = new DummyEventBroker();
    }

    public IEventBroker getIEventBroker() {
        return eventBroker;
    }

    private static class DummyEventBroker implements IEventBroker {

        @Override
        public boolean send(String s, Object o) {
            return false;
        }

        @Override
        public boolean post(String s, Object o) {
            return false;
        }

        @Override
        public boolean subscribe(String s, EventHandler eventHandler) {
            return false;
        }

        @Override
        public boolean subscribe(String s, String s1, EventHandler eventHandler, boolean b) {
            return false;
        }

        @Override
        public boolean unsubscribe(EventHandler eventHandler) {
            return false;
        }
    }
}
