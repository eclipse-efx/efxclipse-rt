package org.eclipse.fx.code.compensator.project.vcs.git;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitVCSRepositoryInstance implements VCSRepositoryInstance {
	private Path path;
	private Repository repo;
	
	public GitVCSRepositoryInstance(Path path) {
		this.path = path;
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			repo = builder.setGitDir(path.toFile()).readEnvironment().findGitDir().build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Path getRootPath() {
		return path;
	}

	@Override
	public void fetch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit(Collection<Path> pathList) {
		// TODO Auto-generated method stub
		
	}

}
