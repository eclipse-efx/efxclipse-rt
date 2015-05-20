package org.eclipse.fx.xtext.sample.editor.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class SampleTextFlow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		
		TextFlow f = new TextFlow();
		
		Text t1 = new Text("I'm black 12pt");
		t1.setFont(Font.font(12));
		f.getChildren().add(t1);
		
		Text t2 = new Text("I'm red 20pt");
		t2.setFont(Font.font(20));
		t2.setFill(Color.RED);
		f.getChildren().add(t2);
		
		p.setCenter(f);
		primaryStage.setScene(new Scene(p));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
