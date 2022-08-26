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
package org.eclipse.fx.code.compensator.project.internal.commands;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.code.compensator.editor.TextEditor;
import org.eclipse.fx.code.compensator.editor.services.FileIconLookup;

public class OpenResource {
	@Execute
	public void open(MPerspective perspective, EModelService service, @Named("resourceURI") String uri, EPartService partService, FileIconLookup lookup) {
		MPartStack element = (MPartStack) service.find("org.eclipse.fx.code.compensator.project.partstack.1", perspective);

		for( MStackElement p : element.getChildren() ) {
			if( uri.equals(p.getPersistedState().get(TextEditor.DOCUMENT_URL)) ) {
				partService.showPart((MPart)p, PartState.ACTIVATE);
				return;
			}
		}

		MPart p = service.createModelElement(MPart.class);
		p.setContributionURI("bundleclass://org.eclipse.fx.code.compensator.editor/org.eclipse.fx.code.compensator.editor.TextEditor");
		p.getPersistedState().put(TextEditor.DOCUMENT_URL, uri);
		p.setLabel(URI.createURI(uri).lastSegment());
		p.setIconURI(lookup.getFileIcon(uri) != null ? lookup.getFileIcon(uri).toString() : null);
		p.setCloseable(true);
		p.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		element.getChildren().add(p);
		partService.showPart(p, PartState.ACTIVATE);
	}
}
