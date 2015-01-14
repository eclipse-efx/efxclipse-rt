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
