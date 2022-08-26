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
package org.eclipse.fx.code.editor.e4.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.SourceFileChange;
import org.eclipse.fx.code.editor.SourceFileInput;
import org.eclipse.fx.code.editor.services.URIProvider;
import org.eclipse.fx.core.event.Event;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.core.event.Topic;

@SuppressWarnings("restriction")
public class DirtyStateTrackingAddon {
	private EModelService modelService;

	private MApplication application;

	private final EventBus broker;

	private final Topic<MApplicationElement> TOPIC_DIRTY = new Topic<>(UIEvents.Dirtyable.TOPIC_DIRTY);
	private final Topic<String> TOPIC_REQUEST_ENABLEMENT_UPDATE_STRING = new Topic<>(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC);

	@Inject
	public DirtyStateTrackingAddon(EventBus broker, EModelService modelService, MApplication application) {
		this.broker = broker;
		this.modelService = modelService;
		this.application = application;
	}

	@PostConstruct
	void init() {
		broker.subscribe(Constants.TOPIC_SOURCE_FILE_INPUT_MODIFIED, this::handleDocumentModified);
		broker.subscribe(Constants.TOPIC_SOURCE_FILE_INPUT_SAVED, this::handleDocumentSaved);
		broker.subscribe(TOPIC_DIRTY, this::handlePartDirty);
	}

	void handlePartDirty(Event<MApplicationElement> event) {
		Object element = event.getData();

		// TODO remove once we run on Neon See https://bugs.eclipse.org/bugs/show_bug.cgi?id=480934
		if( element == null ) {
			element = event.getProperties().get(EventTags.ELEMENT);
		}

		if( element instanceof MContext ) {
			((MContext) element).getContext().set(Constants.EDITOR_DIRTY_FLAG_KEY, event.getProperties().get(EventTags.NEW_VALUE));
			broker.publish(TOPIC_REQUEST_ENABLEMENT_UPDATE_STRING, UIEvents.ALL_ELEMENT_ID,true);
		}
	}

	void handleDocumentSaved(Event<SourceFileInput> event) {
		Input<?> input = event.getData();
		String tmpUri = ((URIProvider)input).getURI();

		String uri = tmpUri;
		modelService.findElements(application, MPart.class, EModelService.ANYWHERE, (e) -> {
			if( e instanceof MPart) {
				return ((MPart) e).getContext() != null && uri.equals(((MPart) e).getContext().getLocal(Constants.DOCUMENT_URL));
			}
			return false;
		}).forEach((e) -> {
			((MPart)e).setDirty(false);
		});
	}

	void handleDocumentModified(Event<SourceFileChange> event) {
		String uri = event.getData().input.getURI();
		modelService.findElements(application, MPart.class, EModelService.ANYWHERE, (e) -> {
			if( e instanceof MPart) {
				return ((MPart) e).getContext() != null && uri.equals(((MPart) e).getContext().getLocal(Constants.DOCUMENT_URL));
			}
			return false;
		}).forEach((e) -> {
			((MPart)e).setDirty(true);
		});
	}

}
