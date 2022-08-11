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
package org.eclipse.fx.testcases.e4.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

@SuppressWarnings("restriction")
public class SwitchPerspectiveHandler {
	@CanExecute
	boolean canExecute(MPerspective perspective, @Named("org.eclipse.fx.testcases.e4.command.2.perspective") String perspectiveId) {
		return ! perspective.getElementId().equals(perspectiveId);
	}
	
	@Execute
	void execute(EPartService partService, MPerspective current, MWindow window, @Named("org.eclipse.fx.testcases.e4.command.2.perspective") String perspectiveId) {
		MPerspectiveStack stack = (MPerspectiveStack) window.getChildren().get(0);
		for( MPerspective p : stack.getChildren() ) {
			if( perspectiveId.equals(p.getElementId()) ) {
				partService.switchPerspective(p);
				break;
			}
		}
	}
}