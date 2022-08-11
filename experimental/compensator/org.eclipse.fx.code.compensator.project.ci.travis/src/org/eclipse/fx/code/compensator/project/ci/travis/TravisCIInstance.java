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

import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ci.CIService;
import org.eclipse.fx.code.compensator.project.ci.CIServiceInstance;

public class TravisCIInstance implements CIServiceInstance {

	private final CIService service;
	private final InstanceProject project;
	
	public TravisCIInstance(CIService service, InstanceProject project) {
		this.service = service;
		this.project = project;
	}
	
	@Override
	public CIService getService() {
		return service;
	}

	public InstanceProject getProject() {
		return project;
	}
}
