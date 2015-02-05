package org.eclipse.fx.code.compensator.project.navigator;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public abstract class PathItem implements ProjectNavigatorItem {
	protected final Path path;
	protected final ProjectNavigatorItem parent;

	public PathItem(ProjectNavigatorItem parent, Path path) {
		this.path = path;
		this.parent = parent;
	}
	
	public ProjectNavigatorItem getParent() {
		return parent;
	}

	@Override
	public CharSequence getLabel() {
		return path.getName(path.getNameCount()-1).toString();
	}

	@Override
	public final Path getDomainObject() {
		return path;
	}

	@Override
	public boolean isDeletable() {
		return Files.isWritable(path.getParent());
	}
}
