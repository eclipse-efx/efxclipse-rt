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
package org.eclipse.fx.code.compensator.project.ci.travis;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;

public class OpenProjectViewerHandler {
	@Execute
	public void open(EModelService modelService, EPartService partService, MPerspective perspective) {
		MPartStack element = (MPartStack) modelService.find("org.eclipse.fx.code.compensator.project.partstack.1", perspective);

		MPart p = modelService.createModelElement(MPart.class);
		p.setContributionURI("bundleclass://org.eclipse.fx.code.compensator.project.ci.travis/org.eclipse.fx.code.compensator.project.ci.travis.TravisProjectViewer");
		p.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		element.getChildren().add(p);
		partService.showPart(p, PartState.ACTIVATE);
	}
}
