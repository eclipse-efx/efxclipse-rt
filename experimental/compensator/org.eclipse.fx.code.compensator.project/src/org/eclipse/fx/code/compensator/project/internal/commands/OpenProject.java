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
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.code.compensator.model.workbench.Workbench;
import org.eclipse.fx.code.compensator.project.ProjectSetupService;

public class OpenProject {
	@Execute
	public void openProject(
			@Named("projectId") String projectId,
			ProjectSetupService projectSetup, MApplication application, Workbench workbench,
			EModelService modelService,
			EPartService partService) {
		MPerspective p = (MPerspective) modelService.find("compensator.project.perspective."+projectId, application);
		if( p == null ) {
			workbench.getProjectList().stream()
				.filter(e -> projectId.equals(e.getProjectId()))
				.findFirst().ifPresent( e -> projectSetup.setupProject(e));
		} else {
			partService.switchPerspective(p);
		}
	}
}
