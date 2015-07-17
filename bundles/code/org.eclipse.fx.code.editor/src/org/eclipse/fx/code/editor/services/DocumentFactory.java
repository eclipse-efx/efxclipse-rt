package org.eclipse.fx.code.editor.services;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.core.ObjectFactoryService;
import org.eclipse.jface.text.IDocument;

public interface DocumentFactory extends ObjectFactoryService<Input<?>, IDocument> {

	boolean persistDocument(IDocument document);

}
