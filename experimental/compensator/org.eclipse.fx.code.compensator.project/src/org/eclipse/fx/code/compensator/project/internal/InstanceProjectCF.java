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

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectService;

public class InstanceProjectCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		IEclipseContext mContext = context.get(MPerspective.class).getContext();
		InstanceProject ip = (InstanceProject) mContext.get("_cached_instance_project");
		if( ip == null ) {
			ProjectService s = context.get(ProjectService.class);
			ip = s.createProjectInstance(mContext);
			mContext.set("_cached_instance_project", ip);
		}

		return ip;
	}
}
