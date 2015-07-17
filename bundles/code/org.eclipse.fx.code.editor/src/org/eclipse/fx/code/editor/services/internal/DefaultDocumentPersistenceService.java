package org.eclipse.fx.code.editor.services.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DocumentFactory;
import org.eclipse.fx.code.editor.services.DocumentPersitenceService;
import org.eclipse.jface.text.IDocument;
import org.osgi.service.component.annotations.Component;

@Component
public class DefaultDocumentPersistenceService implements DocumentPersitenceService {
	private List<DocumentFactory> documentFactoryList = new ArrayList<DocumentFactory>();

	public void registerDocumentFactory(DocumentFactory documentFactory) {
		synchronized (documentFactoryList) {
			documentFactoryList.add(documentFactory);
		}
	}

	public void unregisterDocumentFactory(DocumentFactory documentFactory) {
		synchronized (documentFactoryList) {
			documentFactoryList.remove(documentFactory);
		}
	}

	@Override
	public boolean persist(Input<?> input, IDocument d) {
		synchronized (documentFactoryList) {
			return documentFactoryList.stream()
				.filter( df -> df.test(input))
				.findFirst()
				.map( df -> df.persistDocument(d))
				.orElse(Boolean.FALSE);
		}
	}

}
