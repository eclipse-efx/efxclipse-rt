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

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.DocumentFactory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;

public class DefaultDocumentFactory implements DocumentFactory {

	@Override
	public boolean applies(Input<?> input) {
		return input instanceof FileInput;
	}

	@Override
	public IDocument createDocument(Input<?> input) {
		return new Document(((FileInput)input).getData());
	}

}
