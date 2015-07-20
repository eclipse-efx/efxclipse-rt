package org.eclipse.fx.code.editor.services;

import org.eclipse.jface.text.IDocument;

public interface DocumentTypeProvider extends InputDependentTypeProviderService<IDocument> {
	boolean persistDocument(IDocument document);
}
