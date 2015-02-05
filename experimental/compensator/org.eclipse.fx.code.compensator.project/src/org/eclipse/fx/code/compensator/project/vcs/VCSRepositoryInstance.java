package org.eclipse.fx.code.compensator.project.vcs;

import java.nio.file.Path;
import java.util.Collection;

public interface VCSRepositoryInstance {
	public Path getRootPath();
	public void fetch();
	public void push();
	public void merge();
	public void commit();
	public void commit(Collection<Path> pathList);
}
