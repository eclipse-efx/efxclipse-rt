package org.eclipse.fx.code.editor.e4.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.editor.Constants;
import org.osgi.service.event.Event;

public class DirtyStateTrackingAddon {
	private EModelService modelService;

	private MApplication application;

	private final IEventBroker broker;

	@Inject
	public DirtyStateTrackingAddon(IEventBroker broker, EModelService modelService, MApplication application) {
		this.broker = broker;
		this.modelService = modelService;
		this.application = application;
	}

	@PostConstruct
	void init() {
		broker.subscribe(Constants.EDITOR_DOCUMENT_MODIFIED, this::handleDocumentModified);
		broker.subscribe(Constants.EDITOR_DOCUMENT_SAVED, this::handleDocumentSaved);
		broker.subscribe(UIEvents.Dirtyable.TOPIC_DIRTY, this::handlePartDirty);
	}

	void handlePartDirty(Event event) {
		Object element = event.getProperty(EventTags.ELEMENT);
		if( element instanceof MContext ) {
			((MContext) element).getContext().set(Constants.EDITOR_DIRTY_FLAG_KEY, event.getProperty(EventTags.NEW_VALUE));
			broker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
		}
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
