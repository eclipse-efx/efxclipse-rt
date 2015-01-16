package org.eclipse.fx.code.compensator.project.vcs.git;

import java.nio.file.Path;

import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;

public class GitRepositoryItem extends FolderItem {
	private VCSRepository repository;

	public GitRepositoryItem(VCSRepository repository, Path path) {
		super(null, path);
		this.repository = repository;
	}

	public String getLabel() {
		return "Working Directory";
	}
}
