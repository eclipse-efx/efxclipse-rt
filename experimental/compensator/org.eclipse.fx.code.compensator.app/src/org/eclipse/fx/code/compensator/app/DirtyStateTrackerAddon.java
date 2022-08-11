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
package org.eclipse.fx.code.compensator.app;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.compensator.editor.Constants;
import org.osgi.service.event.Event;

public class DirtyStateTrackerAddon {
	@Inject
	EModelService modelService;

	@Inject
	MApplication application;

	@PostConstruct
	void init(IEventBroker broker) {
		broker.subscribe(Constants.EDITOR_DOCUMENT_MODIFIED, this::handleDocumentModified);
		broker.subscribe(Constants.EDITOR_DOCUMENT_SAVED, this::handleDocumentSaved);

//		application.getCommands().forEach(System.err::println);
//		application.getHandlers().forEach(h -> System.err.println(h.getContributionURI() + " => " + h.getCommand()));

	}

	void handleDocumentSaved(Event event) {
		Object theEditor = event.getProperty(IEventBroker.DATA);
		modelService.findElements(application, MPart.class, EModelService.ANYWHERE, (e) -> {
			if( e instanceof MPart) {
				return ((MPart) e).getObject() == theEditor;
			}
			return false;
		}).forEach((e) -> {
			((MPart)e).setDirty(false);
		});
	}

	void handleDocumentModified(Event event) {
		Object theEditor = event.getProperty(IEventBroker.DATA);
		modelService.findElements(application, MPart.class, EModelService.ANYWHERE, (e) -> {
			if( e instanceof MPart) {
				return ((MPart) e).getObject() == theEditor;
			}
			return false;
		}).forEach((e) -> {
			((MPart)e).setDirty(true);
		});
	}
}
