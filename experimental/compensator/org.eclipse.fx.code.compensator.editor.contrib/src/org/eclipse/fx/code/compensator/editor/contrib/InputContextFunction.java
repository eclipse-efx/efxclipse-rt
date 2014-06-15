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
package org.eclipse.fx.code.compensator.editor.contrib;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.TextEditor;

public class InputContextFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		Input<?> input = (Input<?>) context.get("localInput");
		if( input == null ) {
			MPart part = context.get(MPart.class);
			String url = part.getPersistedState().get(TextEditor.DOCUMENT_URL);
			
			ServiceCollector collector = context.get(ServiceCollector.class);
			input = collector.createInput(url);
			context.set("localInput", input);
		}
		return input;
	}
}
