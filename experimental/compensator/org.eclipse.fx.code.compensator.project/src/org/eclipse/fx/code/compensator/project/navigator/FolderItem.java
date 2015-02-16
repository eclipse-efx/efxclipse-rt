package org.eclipse.fx.code.compensator.project.navigator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.FilesystemService;
import org.eclipse.fx.core.FilesystemService.Kind;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.Util;

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
		Util.lookupService(FilesystemService.class).observePath(path, this::handleFilesystemMod);
	}
	
	private void handleFilesystemMod(Kind kind, Path path) {
		Platform.runLater(() -> _handleFilesystemMod(kind,path));
	}
	
	public void _handleFilesystemMod(Kind kind, Path path) {
		if( items != null ) {
			if( path.startsWith(getDomainObject()) ) {
				PathItem item = null;
				for( ProjectNavigatorItem i : items ) {
					PathItem pi = (PathItem) i;
					if( path.startsWith(pi.getDomainObject()) ) {
						item = pi;
					}
				}
				
				if( item == null ) {
					refresh();
				}
			}
		}
	}

	public FolderItem(ProjectNavigatorItem parent, Path path) {
		this(parent, path, DEFAULTFACTORY);
	}

	@Override
	public CharSequence getLabel() {
		return path.getName(path.getNameCount()-1).toString();
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project","css/icons/16/fldr_obj.png");
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void refresh() {
		AtomicInteger idx = new AtomicInteger();
		
		//TODO Need to fix that we remove items currently shown if not yet found anymore
		try {
			Files.newDirectoryStream(path).forEach((p) -> {
				if( ! items.stream().filter( i -> ((Path)i.getDomainObject()).equals(p) ).findFirst().isPresent() ) {
					items.add(idx.get(), pathItemFactory.apply(p.toAbsolutePath(), this));
				}
				idx.incrementAndGet();
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
