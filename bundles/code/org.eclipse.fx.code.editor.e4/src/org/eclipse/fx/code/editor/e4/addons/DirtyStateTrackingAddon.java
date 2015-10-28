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
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.SourceFileChange;
import org.eclipse.fx.code.editor.services.URIProvider;
import org.osgi.service.event.Event;

@SuppressWarnings("restriction")
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
		broker.subscribe(Constants.TOPIC_SOURCE_FILE_INPUT_MODIFIED, this::handleDocumentModified);
		broker.subscribe(Constants.TOPIC_SOURCE_FILE_INPUT_SAVED, this::handleDocumentSaved);
		broker.subscribe(UIEvents.Dirtyable.TOPIC_DIRTY, this::handlePartDirty);
	}

	void handlePartDirty(Event event) {
		Object element = event.getProperty(EventTags.ELEMENT);
		if( element instanceof MContext ) {
			((MContext) element).getContext().set(Constants.EDITOR_DIRTY_FLAG_KEY, event.getProperty(EventTags.NEW_VALUE));
			broker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
		}
	}

//	private static String toURI(String uri) throws MalformedURLException {
//		if( uri.startsWith("module-file") ) {
//			return uri;
//		} else {
//			return java.net.URI.create(uri.toString()).toURL().toExternalForm();
//		}
//	}

	void handleDocumentSaved(Event event) {
		Input<?> input = (Input<?>) event.getProperty(IEventBroker.DATA);
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

	void handleDocumentModified(Event event) {
		SourceFileChange change = (SourceFileChange) event.getProperty(IEventBroker.DATA);
		String tmpUri = ((URIProvider)change.input).getURI();
		String uri = tmpUri;
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
