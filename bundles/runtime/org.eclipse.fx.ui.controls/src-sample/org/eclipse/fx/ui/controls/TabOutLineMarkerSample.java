package org.eclipse.fx.ui.controls;

import org.eclipse.fx.ui.controls.markers.TabOutlineMarker;

import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TabOutLineMarkerSample extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane p = new AnchorPane();
		
		TabPane t = new TabPane();
		t.getTabs().addAll(new Tab("Tab 1"),new Tab("Tab 2"));
		p.getChildren().add(t);
		t.getSelectionModel().select(1);
		AnchorPane.setLeftAnchor(t, 0.0);
		AnchorPane.setTopAnchor(t, 0.0);
		AnchorPane.setRightAnchor(t, 0.0);
		AnchorPane.setBottomAnchor(t, 0.0);
				
		primaryStage.setScene(new Scene(p, 400, 400));
		primaryStage.show();
		
		TabOutlineMarker marker = new TabOutlineMarker(t.getBoundsInLocal(), new BoundingBox(54, 5, 68, 28), true);
		marker.setManaged(false);
		p.getChildren().add(marker);

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
