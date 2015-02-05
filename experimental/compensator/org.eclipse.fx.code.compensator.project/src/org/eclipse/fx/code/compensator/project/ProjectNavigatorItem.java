package org.eclipse.fx.code.compensator.project;

import org.eclipse.fx.core.URI;

import javafx.collections.ObservableList;

public interface ProjectNavigatorItem {
	public CharSequence getLabel();
	public URI getIcon();
	public Object getDomainObject();
	public String getOpenCommandId();
	public boolean isDeletable();
	public ObservableList<ProjectNavigatorItem> getChildren();
	public boolean isLeaf();
	public ProjectNavigatorItem getParent();
}
