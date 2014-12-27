package org.eclipse.fx.ui.controls.sample;

import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StyledTextSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		StyledTextArea t = new StyledTextArea();
		t.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
		t.getContent().setText("This is a styled text!\nThis is the 2nd line with data\nBlaBla");
		t.setStyleRanges(
				new StyleRange[] {
						new StyleRange("text-highlight",0,30,null,null)
						,
						new StyleRange("text-highlight",34,5,null,null)
//						,
//						new StyleRange("text-highlight",10,12,null,null)
				});
		p.setCenter(t);

		Scene scene = new Scene(p,800,600);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
