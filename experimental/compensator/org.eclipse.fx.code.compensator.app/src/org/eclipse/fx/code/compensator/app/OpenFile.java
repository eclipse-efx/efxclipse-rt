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
package org.eclipse.fx.code.compensator.app;

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
import org.eclipse.fx.code.compensator.model.workbench.File;

public class OpenFile {
	@Execute
	public void openFile(MPerspective perspective, EModelService service, File file, EPartService partService, FileIconLookup lookup) {
		MPartStack element = (MPartStack) service.find("org.eclipse.fx.code.compensator.freeedit.partstack.1", perspective);

		for( MStackElement p : element.getChildren() ) {
			if( file.getUrl().equals(p.getPersistedState().get(TextEditor.DOCUMENT_URL)) ) {
				partService.showPart((MPart)p, PartState.ACTIVATE);
				return;
			}
		}

		MPart p = service.createModelElement(MPart.class);
		p.setContributionURI("bundleclass://org.eclipse.fx.code.compensator.editor/org.eclipse.fx.code.compensator.editor.TextEditor");
		p.getPersistedState().put(TextEditor.DOCUMENT_URL, file.getUrl());
		p.setLabel(URI.createURI(file.getUrl()).lastSegment());
		org.eclipse.fx.core.URI fileIcon = lookup.getFileIcon(file.getUrl());
		p.setIconURI(fileIcon == null ? null : fileIcon.toString());
		p.setCloseable(true);
		p.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		element.getChildren().add(p);
		partService.showPart(p, PartState.ACTIVATE);
	}
}
