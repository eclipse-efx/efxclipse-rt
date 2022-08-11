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
package org.eclipse.fx.code.editor.fx.e4.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.fx.code.editor.Constants;
import org.eclipse.fx.text.ui.source.SourceViewerConfiguration;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("restriction")
@Component(service=IContextFunction.class,property="service.context.key=org.eclipse.fx.text.ui.IUndoManager")
public class UndoManagerCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		MUIElement owner = context.get(MUIElement.class);
		if( owner != null && owner.getPersistedState().get(Constants.DOCUMENT_URL) != null ) {
			SourceViewerConfiguration configuration = context.get(SourceViewerConfiguration.class);
			if( configuration != null ) {
				return configuration.getUndoManager(null);
			}
		}

		return IInjector.NOT_A_VALUE;
	}
}
