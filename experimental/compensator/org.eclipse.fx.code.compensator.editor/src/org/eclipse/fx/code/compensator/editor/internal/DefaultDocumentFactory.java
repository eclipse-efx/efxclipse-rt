/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.internal;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.WeakHashMap;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.DocumentFactory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;

public class DefaultDocumentFactory implements DocumentFactory {
	private WeakHashMap<IDocument, Input<?>> documents = new WeakHashMap<IDocument, Input<?>>();

	@Override
	public boolean applies(Input<?> input) {
		return input instanceof FileInput;
	}

	@Override
	public IDocument createDocument(Input<?> input) {
		IDocument document;

		Optional<Entry<IDocument, Input<?>>> first = documents.entrySet().stream().filter((e) -> e.getValue() == input).findFirst();
		if( first.isPresent() ) {
			document = first.get().getKey();
		} else {
			document = new Document(((FileInput)input).getData());
		}

		documents.put(document, input);
		return document;
	}

	@Override
	public boolean persistDocument(IDocument document) {
		Input<?> input = documents.get(document);
		if( input != null ) {
			FileInput fileInput = (FileInput)input;
			fileInput.setData(document.get());
			fileInput.persist();
			return true;
		}
		return false;
	}

}
