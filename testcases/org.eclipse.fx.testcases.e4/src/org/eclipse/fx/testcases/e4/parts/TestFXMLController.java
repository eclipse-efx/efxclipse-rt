/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.osgi.service.event.Event;

public class TestFXMLController {
	
	@PostConstruct
	public void init() {
		System.err.println("Created");
	}
	
	@PreDestroy
	public void cleanup() {
		System.err.println("Destroyed");
	}
	
	@Inject
	@Optional
	public void receiveEvent(@EventTopic("MyTopic") Event event) {
		System.err.println("CONTROLLER Receiving Topic: " + event);
	}
	
	@Inject
	public void setContext(IEclipseContext context) {
		System.err.println("CONTROLLER CONTEXT: " + context);
	}
}
