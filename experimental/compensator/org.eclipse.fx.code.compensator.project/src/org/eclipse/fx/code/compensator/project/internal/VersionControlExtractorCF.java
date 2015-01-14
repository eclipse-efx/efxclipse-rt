package org.eclipse.fx.code.compensator.project.internal;

import java.util.List;
import java.util.Optional;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;
import org.eclipse.fx.core.di.Service;

public class VersionControlExtractorCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		MPerspective p = context.get(MPerspective.class);
		VersionControlService rv = (VersionControlService) p.getContext().get("_cached_perspective_vcs");
		if( rv == null ) {
			rv = (VersionControlService) ContextInjectionFactory.invoke(new VersionControlHelper(), Execute.class, p.getContext());
			p.getContext().set("_cached_perspective_vcs", rv);
		}

		return rv;
	}

	static class VersionControlHelper {
		@Execute
		public VersionControlService getVersionControl(@Service List<VersionControlService> service, Project p) {
			if(p instanceof LocalProject) {
				LocalProject lp = (LocalProject) p;
				Optional<VersionControlService> first = service.stream().filter((vcs) -> vcs.getId().equals(lp.getRepoType())).findFirst();
				if( first.isPresent() ) {
					return first.get();
				}
			}

			return null;
		}
	}
}
