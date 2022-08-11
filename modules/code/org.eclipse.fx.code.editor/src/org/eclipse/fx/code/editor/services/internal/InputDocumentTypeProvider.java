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
package org.eclipse.fx.code.editor.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.StringInput;
import org.eclipse.fx.code.editor.services.DocumentTypeProvider;
import org.eclipse.fx.code.editor.services.InputDocument;
import org.eclipse.jface.text.IDocument;
import org.osgi.service.component.annotations.Component;

@Component
public class InputDocumentTypeProvider implements DocumentTypeProvider {

	@Override
	public Class<? extends IDocument> getType(Input<?> s) {
		return InputDocument.class;
	}

	@Override
	public boolean test(Input<?> t) {
		return t instanceof StringInput;
	}

}