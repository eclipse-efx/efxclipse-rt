package org.eclipse.fx.code.compensator.project.vcs;

import java.io.File;
import java.net.URI;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.ProgressReporter;
import org.eclipse.fx.core.ReturnValue;

public interface VersionControlService {
	public String getId();
	public String getLabel();
	public String getIconURI();
	public ProjectNavigatorItem mapVCS();
	public ReturnValue<URI> cloneRepository(File localDirectory, String url, String username, String password, ProgressReporter reporter);
}
