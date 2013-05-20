/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
