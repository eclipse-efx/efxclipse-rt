package org.eclipse.fx.code.compensator.project.jdt.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.code.server.jdt.JDTServerFactory;

public class ProjectServerCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		IEclipseContext pContext = context.get(MPerspective.class).getContext();
		JDTServer s = (JDTServer) pContext.get("_cached_project_server");
		if( s == null ) {
			Project p = context.get(Project.class);
			s = context.get(JDTServerFactory.class).getOrCreateServer(p.getName());
			pContext.set("_cached_project_server",s);
		}

		return s;
	}
}
