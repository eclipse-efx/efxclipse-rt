package org.eclipse.fx.code.editor.services;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.jface.text.IDocument;

public interface DocumentPersitenceService {
	public boolean persist(Input<?> input, IDocument d);
}
