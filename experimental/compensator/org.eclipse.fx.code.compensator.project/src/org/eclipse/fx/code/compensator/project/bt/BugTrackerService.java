package org.eclipse.fx.code.compensator.project.bt;

import org.eclipse.fx.code.compensator.model.workbench.BugTracker;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public interface BugTrackerService {
	public String getLabel();
	public String getId();
	
	public BugTrackerInstance createInstance(BugTracker bugtracker);
	public BugTrackerRootNavigatorItem mapRepository(ProjectNavigatorItem parent, BugTrackerInstance instance);
}
