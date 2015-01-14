package org.eclipse.fx.code.compensator.project;

import javafx.collections.ObservableList;

public interface ProjectNavigatorItem {
	public CharSequence getLabel();
	public String getIcon();
	public Object getDomainObject();
	public String getOpenCommandId();
	public boolean isDeletable();
	public ObservableList<ProjectNavigatorItem> getChildren();
	public boolean isLeaf();
}
