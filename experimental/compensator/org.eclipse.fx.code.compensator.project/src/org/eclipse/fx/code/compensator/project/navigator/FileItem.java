package org.eclipse.fx.code.compensator.project.navigator;

import java.nio.file.Path;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public class FileItem extends PathItem {

	public FileItem(ProjectNavigatorItem parent, Path path) {
		super(parent, path);
	}

	@Override
	public CharSequence getLabel() {
		return path.getName(path.getNameCount()-1).toString();
	}

	@Override
	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/file_obj.png";
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
