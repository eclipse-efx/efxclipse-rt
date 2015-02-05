package org.eclipse.fx.code.compensator.project.vcs.git;

import java.nio.file.Path;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.fx.code.compensator.project.vcs.VCSRootNavigatorItem;
import org.eclipse.jgit.lib.Repository;

public class GitRepositoryItem extends FolderItem implements VCSRootNavigatorItem {
	private VCSRepositoryInstance repository;
	private Repository repo;

	public GitRepositoryItem(ProjectNavigatorItem parent, VCSRepositoryInstance repository, Path path) {
		super(parent, path);
		this.repository = repository;
	}

	public String getLabel() {
		return "Working Directory";
	}

//	@Override
//	public void fetch() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void push() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void merge() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void commit() {
//		
//	}
//	
//	@Override
//	public void commit(Collection<Path> pathList) {
//		Git git = new Git(repo);
//		for( Path p : pathList ) {
//			System.err.println(p.relativize(path));
//		}
//		
//	}
}