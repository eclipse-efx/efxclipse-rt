package org.eclipse.fx.code.editor.services;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.code.editor.StringInput;
import org.eclipse.fx.core.event.EventBus;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;

public class InputDocument extends Document {
	private StringInput input;
	private IDocumentListener listener = new IDocumentListener() {

		@Override
		public void documentChanged(DocumentEvent event) {
			input.updateData(event.getOffset(), event.getLength(), event.getText());
		}

		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {
			eventBus.publish(Constants.TOPIC_SOURCE_FILE_INPUT_TOBE_MODIFIED, new StringInputAboutToChange(input, event), true);
		}
	};

	private final EventBus eventBus;

	@Inject
	public InputDocument(@Named("org.eclipse.fx.code.editor.Input") StringInput input, EventBus eventBus) {
		this.input = input;
		this.eventBus = eventBus;
		set(input.getData());
		addDocumentListener(listener);
	}

	public void persist() {
		input.setData(get());
		input.persist();
	}

	@PreDestroy
	public void dispose() {
		removeDocumentListener(listener);
	}
}