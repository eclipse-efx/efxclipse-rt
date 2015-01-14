package org.eclipse.fx.code.compensator.project.internal.adapter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public class BuildServerItem implements ProjectNavigatorItem {

	@Override
	public CharSequence getLabel() {
		return "Build-Server";
	}

	@Override
	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/update.png";
	}

	@Override
	public Object getDomainObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDeletable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return FXCollections.emptyObservableList();
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
