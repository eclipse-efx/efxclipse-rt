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
package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.di.ScopedObjectFactory;

@SuppressWarnings("restriction")
public class Handler1 {
	@Execute
	public void execute(MApplication application, IEventBroker broker, @Optional MPart part) {
		System.err.println("Executing H1 in context of " + part);
		Integer v = (Integer) application.getContext().get("test_2");
		if( v == null ) {
			v = Integer.valueOf(0);
		} else {
			v = Integer.valueOf((v.intValue()+1)%2);
		}
		application.getContext().set("test_2", v);
		broker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
	}

}
