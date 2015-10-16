package org.eclipse.fx.code.editor.fx;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.fx.code.editor.services.EditorOpener;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.preferences.Value;
import org.eclipse.fx.ui.controls.filesystem.DirItem;
import org.eclipse.fx.ui.controls.filesystem.FileItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceEvent;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceTreeView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;

@SuppressWarnings("restriction")
public class FilesystemViewer {

	@Inject
	EditorOpener textEditorOpener;

	private final ObservableList<DirItem> rootDirectories = FXCollections.observableArrayList();

	private final RootResourceList resourceList;

	@XmlRootElement
	public static class RootResourceList {
		private List<String> resourceList = new ArrayList<String>();

		public RootResourceList() {

		}

		public RootResourceList(List<DirItem> pathList) {
			resourceList.addAll(pathList.stream().map( p -> p.getUri()).collect(Collectors.toList()));
		}

		@XmlElement(name="resourceList")
		public List<String> getResourceList() {
			return resourceList;
		}
	}

	private Value<RootResourceList> value;

	@Inject
	public FilesystemViewer(@Preference(key="rootPaths") Value<RootResourceList> value) {
		this.value = value;
		RootResourceList resourceList = value.getValue();
		if( resourceList == null ) {
			resourceList = new RootResourceList();
		}
		this.resourceList = resourceList;
	}

	@Inject
	public void initUI(BorderPane pane) {
		rootDirectories.addAll(resourceList.resourceList
				.stream()
				.map( p -> Paths.get(java.net.URI.create(p)))
				.filter(p -> Files.exists(p))
				.map( p -> ResourceItem.createObservedPath(p))
				.collect(Collectors.toList()));

		ResourceTreeView viewer = new ResourceTreeView();
		viewer.setRootDirectories(rootDirectories);
		viewer.addEventHandler(ResourceEvent.openResourceEvent(), this::handleEvent);
		viewer.setOnDragDropped(this::handleDrop);
		viewer.setOnDragOver(this::handleDragOver);
		pane.setCenter(viewer);
	}

	private void handleDragOver(DragEvent e) {
		if( e.getDragboard().hasFiles() ) {
			e.acceptTransferModes(TransferMode.ANY);
		}
	}

	private void handleDrop(DragEvent e) {
		if( e.getDragboard().hasFiles() ) {
			addDirectories(e.getDragboard().getFiles()
				.stream()
				.filter( f -> f.isDirectory())
				.map( f -> f.toPath())
				.collect(Collectors.toList()));
		}
	}

	private void addDirectories(List<Path> pathList) {
		rootDirectories.addAll(pathList
				.stream()
				.filter(p -> Files.isDirectory(p))
				.map( p -> ResourceItem.createObservedPath(p))
				.collect(Collectors.toList()));
		value.publish(new RootResourceList(rootDirectories));
	}

	private void handleEvent(ResourceEvent<ResourceItem> e) {
		e.getResourceItems().stream().filter(r -> r instanceof FileItem).map(r -> (FileItem) r).forEach(this::handle);
	}

	private void handle(FileItem item) {
		textEditorOpener.openEditor(item.getUri());
	}
}