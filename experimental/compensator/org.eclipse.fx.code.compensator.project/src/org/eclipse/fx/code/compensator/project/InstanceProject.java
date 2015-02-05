	package org.eclipse.fx.code.compensator.project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;

public abstract class InstanceProject {
	private final Project project;
	private final List<VersionControlService> versionControlServiceList;
	private final IEventBroker eventBroker;
	
	public InstanceProject(
			IEventBroker eventBroker,
			Project project,
			List<VersionControlService> versionControlServiceList) {
		this.eventBroker = eventBroker;
		this.project = project;
		this.versionControlServiceList = versionControlServiceList;
		if( this.project instanceof LocalProject ) {
			((LocalProject)this.project).getVcsRepositoryList().forEach(this::handleRepository);
		}
	}
	
	private void handleRepository(VCSRepository repository) {
		Path path = Paths.get(java.net.URI.create(repository.getLocalURI()));
		if( ! Files.exists(path) ) {
			getVersionControlServiceList()
				.stream()
				.filter(v -> v.getId().equals(repository.getRepoType()))
				.findFirst().ifPresent(v -> v.cloneRepository(path, repository.getRepoURI(), repository.getRepoUsername(), repository.getRepoPassword(), null));
		}
	}

	public final Project getProject() {
		return project;
	}

	public final List<VersionControlService> getVersionControlServiceList() {
		return versionControlServiceList;
	}
	
	public IEventBroker getEventBroker() {
		return eventBroker;
	}

	public abstract boolean openItem(ProjectNavigatorItem item);
	public abstract ProjectNavigatorItem mapModule(ProjectNavigatorItem parent, Module module);
}
