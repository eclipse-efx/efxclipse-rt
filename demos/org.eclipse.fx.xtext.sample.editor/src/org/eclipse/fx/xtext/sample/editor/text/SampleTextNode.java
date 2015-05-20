package org.eclipse.fx.xtext.sample.editor.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleTextNode extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		Text t = new Text("I'm a text with font-size 20");
		t.setFont(Font.font(20));
		p.setCenter(t);
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
