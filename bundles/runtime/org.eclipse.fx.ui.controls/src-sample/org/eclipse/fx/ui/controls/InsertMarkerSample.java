package org.eclipse.fx.ui.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.eclipse.fx.ui.controls.markers.PositionMarker;

public class InsertMarkerSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane(new PositionMarker());
		primaryStage.setScene(new Scene(p,300,300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
