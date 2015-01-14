package org.eclipse.fx.code.compensator.project;

import java.util.List;

import org.eclipse.fx.code.compensator.project.ProjectService.ContextMenuGroup;

public interface ProjectNavigatorContribution {
	public boolean applies(ProjectService service);
	public List<ContextMenuGroup> getContextGroups();
}
