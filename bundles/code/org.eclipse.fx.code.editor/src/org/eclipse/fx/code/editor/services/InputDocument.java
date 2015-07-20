package org.eclipse.fx.code.editor.services;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.StringInput;
import org.eclipse.jface.text.Document;

public class InputDocument extends Document {
	private StringInput input;

	@Inject
	public InputDocument(StringInput input) {
		this.input = input;
		set(input.getData());
	}

	public void persist() {
		input.setData(get());
		input.persist();
	}


}
