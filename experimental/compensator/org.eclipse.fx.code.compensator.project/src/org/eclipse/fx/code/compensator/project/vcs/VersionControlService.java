package org.eclipse.fx.code.compensator.project.vcs;

import java.net.URI;
import java.nio.file.Path;

import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.ProgressReporter;

public interface VersionControlService {
	public String getId();
	public String getLabel();
	public String getIconURI();
	public URI cloneRepository(Path localDirectory, String url, String username, String password, ProgressReporter reporter);

	public VCSRootNavigatorItem mapRepository(ProjectNavigatorItem parent, VCSRepositoryInstance instance);
	public VCSRepositoryInstance createRepository(InstanceProject project, VCSRepository repository, String uri);
}
