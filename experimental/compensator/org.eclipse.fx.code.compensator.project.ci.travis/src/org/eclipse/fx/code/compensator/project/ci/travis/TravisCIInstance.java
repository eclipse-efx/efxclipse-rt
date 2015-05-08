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
