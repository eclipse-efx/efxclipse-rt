/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.WeakHashMap;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.DocumentFactory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;


public class JDTDocumentFactory implements DocumentFactory {
	private WeakHashMap<IDocument, JDTServerInput> documents = new WeakHashMap<IDocument, JDTServerInput>();

	@Override
	public boolean applies(Input<?> input) {
		return input instanceof JDTServerInput;
	}

	@Override
	public IDocument createDocument(Input<?> input) {
		IDocument document;

		Optional<Entry<IDocument, JDTServerInput>> first = documents.entrySet().stream().filter((e) -> e.getValue() == input).findFirst();
		if( first.isPresent() ) {
			document = first.get().getKey();
		} else {
			document = new Document(((JDTServerInput)input).getData());
			document.addDocumentListener(new IDocumentListener() {

				@Override
				public void documentChanged(DocumentEvent event) {
					if( event.fLength == 0 ) {
						JDTServerInput input = documents.get(document);
						if( input != null ) {
							input.insertData(event.fOffset, event.fText);
						}
					} else {
						JDTServerInput input = documents.get(document);
						if( input != null ) {
							input.replaceData(event.fOffset, event.fLength, event.fText);
						}
					}
				}

				@Override
				public void documentAboutToBeChanged(DocumentEvent event) {

				}
			});
		}

		documents.put(document, (JDTServerInput) input);
		return document;
	}

	@Override
	public boolean persistDocument(IDocument document) {
		Input<?> input = documents.get(document);
		if( input != null ) {
			JDTServerInput serverInput = (JDTServerInput)input;
			serverInput.setData(document.get());
			serverInput.persist();
			return true;
		}
		return false;
	}

}
