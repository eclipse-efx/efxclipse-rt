/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.contrib;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.jface.text.IDocument;

public class DocumentContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		IDocument document = (IDocument) context.get("localDoc");
		if( document == null ) {
			Input<?> input = context.get(Input.class); 
			ServiceCollector collector = context.get(ServiceCollector.class);
			document = collector.createDocument(input);
			context.set("localDoc", document);
		}
		return document;
	}
}
