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
package org.eclipse.fx.code.editor.asciidoc.fx.e4;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.editor.Input;

@SuppressWarnings("restriction")
public class EditorDelegate {
	private final MCompositePart part;
	private final EModelService modelService;

	@Inject
	public EditorDelegate(Input<String> input, MCompositePart part, EModelService modelService) {
		this.part = part;
		this.modelService = modelService;
	}

	@Persist
	public void save() {
		modelService
			.findElements(part, null, MPart.class, null)
			.stream()
			.filter(m -> m != part && m.getObject() != null)
			.forEach( m -> ContextInjectionFactory.invoke(m.getObject(), Persist.class, m.getContext(), null));

	}
}
