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

import java.util.Optional;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.code.editor.fx.e4.EditorPartTabContextMenuService;
import org.osgi.service.component.annotations.Component;

@Component(property="service.ranking:Integer=-1")
public class SnippetEditorPartTabContextMenuService implements EditorPartTabContextMenuService {
	@Override
	public MPopupMenu getContextMenu(EModelService modelService, MApplication application, MPart part) {
		Optional<MUIElement> menu = application.getSnippets().stream().filter(
				e -> e instanceof MPopupMenu && ("editor.part.contextmenu").equals(e.getElementId()) ).findFirst();
		return (MPopupMenu) menu.map( e -> modelService.cloneElement(e, null)).orElse(null);
	}

}