package org.eclipse.fx.code.editor.asciidoc.fx;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.SourceFileChange;
import org.eclipse.fx.code.editor.SourceFileInput;
import org.eclipse.fx.code.editor.asciidoc.HTMLConverter;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.event.Event;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.core.preferences.Preference;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

@SuppressWarnings("restriction")
public class AsciiDoctorPreviewer {
	private final Input<String> input;
	private final HTMLConverter converter;
	private final ThreadSynchronize threadSynchronize;
	private final SimpleStringProperty content;
	private WebView view;
	private Subscription updateSubscription;
	private Subscription fileChangeSubscription;
	private EventBus eventBus;

	@Inject
	public AsciiDoctorPreviewer(Input<String> input,
			@Optional HTMLConverter converter,
			ThreadSynchronize threadSynchronize,
			EventBus eventBus) {
		this.input = input;
		this.converter = converter;
		this.threadSynchronize = threadSynchronize;
		this.content = new SimpleStringProperty(this.input.getData());
		this.eventBus = eventBus;
		eventBus.subscribe(Constants.TOPIC_SOURCE_FILE_INPUT_SAVED, this::handleFileSaved);
		updateSubscription = threadSynchronize.delayedChangeExecution(400, content, this::refreshPreview);
	}

	@Inject
	public void setUpdateOnDelay(@Preference(key="refresh-onchange",defaultValue="true") boolean value) {
		System.err.println("VALUE: " + value);
		if( value ) {
			if( fileChangeSubscription == null ) {
				fileChangeSubscription = eventBus.subscribe(Constants.TOPIC_SOURCE_FILE_INPUT_MODIFIED, this::handleFileChange);
			}
		} else if( fileChangeSubscription != null ) {
			fileChangeSubscription.dispose();
			fileChangeSubscription = null;
		}
	}

	private void handleFileChange(Event<SourceFileChange> event) {
		if( event.getData().input == input ) {
			this.content.set(event.getData().input.getData());
		}
	}

	private void handleFileSaved(Event<SourceFileInput> event) {
		if( event.getData() == input ) {
			this.content.set(event.getData().getData());
		}
	}

	private void refreshPreview(String data) {
		if( converter != null ) {
			CompletableFuture<String> convert = converter.convert("",  data);
			Consumer<String> consumer = threadSynchronize.wrap(view.getEngine()::loadContent);
			convert.thenAccept(consumer);
		}
	}

	@PostConstruct
	void init(BorderPane parent) {
		view = new WebView();
		refreshPreview(input.getData());
		parent.setCenter(view);
	}

	@PreDestroy
	void dispose() {
		updateSubscription.dispose();
	}
}
