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
package org.eclipse.fx.code.compensator.project.internal;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.code.compensator.project.ProjectSetupService;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;

public class ProjectSetupServiceImpl implements ProjectSetupService {

	@Inject
	@Service
	List<ProjectService> services;

	@Inject
	@Log
	private Logger logger;

	private final MApplication application;

	private final MWindow window;

	private final EModelService modelService;

	private final EPartService partService;

	@Inject
	public ProjectSetupServiceImpl(MApplication application, MWindow window, EModelService modelService, EPartService partService) {
		this.application = application;
		this.window = window;
		this.modelService = modelService;
		this.partService = partService;
	}

	@Override
	public void setupProject(Project p) {
		Optional<ProjectService> os = services.stream().filter(s -> s.applies(p)).findFirst();
		if( os.isPresent() ) {
			setupProject(p, os.get());
		} else {
			logger.error("Unable to find service to setup project '"+p+"'");
		}
	}

	private void setupProject(Project p, ProjectService s) {
		String id = s.getProjectPerspectiveTemplate(p);
		Optional<MUIElement> perspective = application.getSnippets().stream().filter(e -> e instanceof MPerspective && id.equals(e.getElementId())).findFirst();

		if( perspective.isPresent() ) {
			MPerspective clone = (MPerspective) modelService.cloneSnippet(application, id, window);
			clone.setElementId("compensator.project.perspective."+p.getProjectId());
			MPerspectiveStack ps = (MPerspectiveStack) window.getChildren().get(0);
			ps.getChildren().add(clone);
			partService.switchPerspective(clone);
		} else {
			logger.error("Unable to locate perspective template with ID '"+id+"'");
		}
	}

}