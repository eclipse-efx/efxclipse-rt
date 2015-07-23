package org.eclipse.fx.code.editor.services;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.jface.text.Document;

public class InputDocument extends Document {
	private Input<?> input;

	@Inject
	public InputDocument(Input<?> input) {
		this.input = input;
		set(input.getText());
	}

	public void persist() {
		input.setText(get());
		input.persist();
	}


}
