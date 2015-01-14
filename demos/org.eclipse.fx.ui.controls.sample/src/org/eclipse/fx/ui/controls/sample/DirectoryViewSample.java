package org.eclipse.fx.ui.controls.sample;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

import org.eclipse.fx.ui.controls.filesystem.DirectoryTreeView;
import org.eclipse.fx.ui.controls.filesystem.DirectoryView;
import org.eclipse.fx.ui.controls.filesystem.IconSize;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.filesystem.ResourcePreview;
import org.eclipse.fx.ui.controls.filesystem.RootDirItem;

public class DirectoryViewSample extends Application {

	private static RootDirItem rootDirItem;

	@Override
	public void start(Stage primaryStage) throws Exception {
		rootDirItem = ResourceItem.createObservedPath(Paths.get("/Users/tomschindl/Desktop"));

		DirectoryTreeView tv = new DirectoryTreeView();
		tv.setIconSize(IconSize.MEDIUM);
		tv.setRootDirectories(FXCollections.observableArrayList(rootDirItem));


		DirectoryView v = new DirectoryView();
		v.setIconSize(IconSize.MEDIUM);
		v.setOnOpenResource(e -> System.err.println(e.getResourceItems()));

		tv.getSelectedItems().addListener( (Observable o) -> {
			if( ! tv.getSelectedItems().isEmpty() ) {
				v.setDir(tv.getSelectedItems().get(0));
			} else {
				v.setDir(null);
			}
		});

		ResourcePreview prev = new ResourcePreview();
		v.getSelectedItems().addListener((Observable o) -> {
			if( v.getSelectedItems().size() == 1 ) {
				prev.setItem(v.getSelectedItems().get(0));
			} else {
				prev.setItem(null);
			}
		});

		SplitPane p = new SplitPane(tv,v, prev);
		p.setDividerPositions(0.3,0.8);
		Scene s = new Scene(p,500,500);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
		rootDirItem.dispose();
	}
}