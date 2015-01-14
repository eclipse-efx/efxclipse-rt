package org.eclipse.fx.code.compensator.project;

import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;

public interface InstanceProject {
	public ProjectNavigatorItem mapModule(Module module);
	public Project getProject();
	public boolean openItem(ProjectNavigatorItem item);
}
