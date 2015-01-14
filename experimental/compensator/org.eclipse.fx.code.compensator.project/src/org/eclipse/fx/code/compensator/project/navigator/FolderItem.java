package org.eclipse.fx.code.compensator.project.navigator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public class FolderItem extends PathItem {
	private ObservableList<ProjectNavigatorItem> items;

	public final BiFunction<Path, FolderItem, PathItem> pathItemFactory;

	public static final BiFunction<Path, FolderItem, PathItem> DEFAULTFACTORY = (p,i) -> {
		if( Files.isDirectory(p) ) {
			return new FolderItem(i,p, i.pathItemFactory);
		} else {
			return new FileItem(i,p);
		}
	};

	public FolderItem(ProjectNavigatorItem parent, Path path, BiFunction<Path, FolderItem, PathItem> pathItemFactory) {
		super(parent,path);
		this.pathItemFactory = pathItemFactory;
	}

	public FolderItem(ProjectNavigatorItem parent, Path path) {
		this(parent, path, DEFAULTFACTORY);
	}

	@Override
	public CharSequence getLabel() {
		return path.getName(path.getNameCount()-1).toString();
	}

	@Override
	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/fldr_obj.png";
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		if( items == null ) {
			items = FXCollections.observableArrayList();
			try {
				items.addAll(Files.walk(path, 1).filter(p -> ! p.equals(path)).map((p) -> pathItemFactory.apply(p.toAbsolutePath(), this)).collect(Collectors.toList()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
