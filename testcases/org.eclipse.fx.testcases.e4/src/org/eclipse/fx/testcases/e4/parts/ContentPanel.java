package org.eclipse.fx.testcases.e4.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.testcases.e4.handlers.EventSender;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

@SuppressWarnings("restriction")
public class ContentPanel {
	
	private TextField f;
	
	@Inject
	protected UISynchronize uiSync;

	private MPart part;
	
	@Inject
	public ContentPanel(BorderPane p, final MPart part) {
		this.part = part;
		System.err.println("CREATED PANEL INSTANCE: " + part);
		f = new TextField(part.getLocalizedLabel());
		f.setOnKeyPressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				part.setDirty(true);
			}
		});
		p.setTop(f);
	}
	
	@PostConstruct
	void sync() {
		System.err.println("The sync: " + uiSync);
	}
	
	@Focus
	void focus() {
		f.requestFocus();
	}
	
	@PreDestroy
	void tearDown() {
		System.err.println("Teardown " + part);
	}
	
//	@Inject
//	@Optional
//	void eventSync(@EventTopic(EventSender.SYNC_EVENT) String event) {
//		System.err.println("SYNC: Received event: " + event + " on thread " + Thread.currentThread());
//	}
//	
//	@Inject
//	@Optional
//	void eventASync(@EventTopic(EventSender.ASYNC_EVENT) String event) {
//		System.err.println("ASYNC: Received event: " + event + " on thread " + Thread.currentThread());
//	}
	
	@Inject
	@Optional
	void eventSyncUI(@UIEventTopic(EventSender.SYNC_EVENT) String event) {
		System.err.println("UI-SYNC: Received event: " + event + " on thread " + Thread.currentThread());
	}
	
	@Inject
	@Optional
	void eventASyncUI(@UIEventTopic(EventSender.ASYNC_EVENT) String event) {
		System.err.println("UI-ASYNC: Received event: " + event + " on thread " + Thread.currentThread());
	}
}
