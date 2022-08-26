/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;

public class EventSender {
	public static final String SYNC_EVENT = "e4fx/SYNC";
	public static final String ASYNC_EVENT = "e4fx/ASYNC";
	
	@Execute
	void send(IEventBroker broker) {
		broker.send(SYNC_EVENT, "This is a sync");
		broker.post(ASYNC_EVENT, "This is an async");
	}
}
