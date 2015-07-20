package org.eclipse.fx.code.editor.services.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DocumentTypeProvider;
import org.eclipse.fx.code.editor.services.DocumentPersitenceService;
import org.eclipse.jface.text.IDocument;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component
public class DefaultDocumentPersistenceService implements DocumentPersitenceService {
	private List<DocumentTypeProvider> documentFactoryList = new ArrayList<DocumentTypeProvider>();

	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC,policyOption=ReferencePolicyOption.GREEDY)
	public void registerDocumentFactory(DocumentTypeProvider documentFactory) {
		synchronized (documentFactoryList) {
			documentFactoryList.add(documentFactory);
		}
	}

	public void unregisterDocumentFactory(DocumentTypeProvider documentFactory) {
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
