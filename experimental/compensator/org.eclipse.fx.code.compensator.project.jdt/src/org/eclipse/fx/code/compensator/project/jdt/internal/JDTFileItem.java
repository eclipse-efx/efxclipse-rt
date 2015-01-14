package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.nio.file.Path;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.PathItem;

public class JDTFileItem extends PathItem implements JDTPathItem {

	public JDTFileItem(ProjectNavigatorItem parent, Path p) {
		super(parent,p);
	}

	@Override
	public JDTModuleItem getModuleItem() {
		return ((JDTPathItem)parent).getModuleItem();
	}

	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return FXCollections.emptyObservableList();
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

}
