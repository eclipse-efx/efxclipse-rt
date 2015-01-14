package org.eclipse.fx.code.compensator.project.internal.adapter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FileItem;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.navigator.PathItem;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;
import org.eclipse.fx.core.FilesystemService;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

public class VCSContainerItem implements ProjectNavigatorItem {
	private final LocalProject project;
	private final VersionControlService service;
	private final FilesystemService filesystemService;
	private final ObservableList<ProjectNavigatorItem> items = FXCollections.observableArrayList();

	public VCSContainerItem(LocalProject project, VersionControlService service, FilesystemService filesystemService) {
		this.project = project;
		this.service = service;
		this.filesystemService = filesystemService;
		this.items.add(new VCSRootDirectory(project, filesystemService));
	}

	@Override
	public CharSequence getLabel() {
		return service.getLabel();
	}

	@Override
	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/vcs.png";
	}

	@Override
	public Object getDomainObject() {
		return project;
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDeletable() {
		return false;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return items;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	static class VCSRootDirectory implements ProjectNavigatorItem {

		private final LocalProject project;
		private ObservableList<ProjectNavigatorItem> items;
		private FilesystemService filesystemService;
		private final Path path;
		private static Logger LOGGER;

		public VCSRootDirectory(LocalProject project, FilesystemService filesystemService) {
			this.project = project;
			this.filesystemService = filesystemService;
			Path path = null;
			try {
				path = Paths.get(new URI(project.getLocalURI()));
			} catch (URISyntaxException e) {
				getLogger().errorf("Unable to retrieve root path for '%0'",e,project.getLocalURI());
			}
			this.path = path;
		}

		private static Logger getLogger() {
			if( LOGGER == null ) {
				LOGGER = LoggerCreator.createLogger(VCSRootDirectory.class);
			}
			return LOGGER;
		}

		@Override
		public CharSequence getLabel() {
			return "Working Directory";
		}

		@Override
		public String getIcon() {
			return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/fldr_obj.png";
		}

		@Override
		public Object getDomainObject() {
			return null;
		}

		@Override
		public String getOpenCommandId() {
			return null;
		}

		@Override
		public boolean isDeletable() {
			return false;
		}

		@Override
		public ObservableList<ProjectNavigatorItem> getChildren() {
			if( items == null ) {
				items = FXCollections.observableArrayList();
				try {
					items.addAll(Files.walk(path, 1).filter(p -> ! p.equals(path)).map(p -> {
						if( Files.isDirectory(p) ) {
							return new VCSDirectory(this,p);
						} else {
							return new FileItem(this,p);
						}
					}).collect(Collectors.toList()));
				} catch (IOException e) {
					getLogger().errorf("Unable calculate children of '%0'",e,path.toString());
				}
			}
			return items;
		}

		@Override
		public boolean isLeaf() {
			return false;
		}
	}

	public static class VCSDirectory extends FolderItem {
		private static final BiFunction<Path, FolderItem, PathItem> DEFAULT = (p,i) -> {
			if( Files.isDirectory(p) ) {
				return new VCSDirectory(i,p);
			} else {
				return new FileItem(i,p);
			}
		};

		public VCSDirectory(ProjectNavigatorItem parent,Path path) {
			super(parent,path,DEFAULT);
		}

	}

//	public static class VCSDirectory implements ProjectNavigatorItem {
//		private final Path path;
//		private ObservableList<ProjectNavigatorItem> items;
//
//		public VCSDirectory(Path path) {
//			this.path = path;
//		}
//
//		@Override
//		public CharSequence getLabel() {
//			return path.getFileName().toString();
//		}
//
//		@Override
//		public String getIcon() {
//			return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/fldr_obj.png";
//		}
//
//		@Override
//		public Object getDomainObject() {
//			return path;
//		}
//
//		@Override
//		public String getOpenCommandId() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public boolean isDeletable() {
//			return Files.isWritable(path.getParent());
//		}
//
//		@Override
//		public ObservableList<ProjectNavigatorItem> getChildren() {
//			if( items == null ) {
//				items = FXCollections.observableArrayList();
//				try {
//					items.addAll(Files.walk(path, 1).filter(p -> ! p.equals(path)).map(p -> {
//						if( Files.isDirectory(p) ) {
//							return new VCSDirectory(p);
//						} else {
//							return new VCSFile(p);
//						}
//					}).collect(Collectors.toList()));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return items;
//		}
//
//		@Override
//		public boolean isLeaf() {
//			return false;
//		}
//	}
//
//	public static class VCSFile implements ProjectNavigatorItem {
//
//		private final Path path;
//
//		public VCSFile(Path path) {
//			this.path = path;
//		}
//
//		@Override
//		public CharSequence getLabel() {
//			return path.getFileName().toString();
//		}
//
//		@Override
//		public String getIcon() {
//			return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/file_obj.png";
//		}
//
//		@Override
//		public Object getDomainObject() {
//			return path;
//		}
//
//		@Override
//		public String getOpenCommandId() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public boolean isDeletable() {
//			return Files.isWritable(path.getParent());
//		}
//
//		@Override
//		public ObservableList<ProjectNavigatorItem> getChildren() {
//			return FXCollections.emptyObservableList();
//		}
//
//		@Override
//		public boolean isLeaf() {
//			return true;
//		}
//	}
}
