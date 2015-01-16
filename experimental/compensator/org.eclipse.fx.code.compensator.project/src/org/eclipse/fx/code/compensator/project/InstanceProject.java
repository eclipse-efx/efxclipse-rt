package org.eclipse.fx.code.compensator.project;

import java.util.List;

import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;

public abstract class InstanceProject {
	private final Project project;
	private final List<VersionControlService> versionControlServiceList;

	public InstanceProject(
			Project project,
			List<VersionControlService> versionControlServiceList) {
		this.project = project;
		this.versionControlServiceList = versionControlServiceList;
	}

	public final Project getProject() {
		return project;
	}

	public final List<VersionControlService> getVersionControlServiceList() {
		return versionControlServiceList;
	}

	public abstract boolean openItem(ProjectNavigatorItem item);
	public abstract ProjectNavigatorItem mapModule(Module module);
}
