package org.eclipse.fx.xtext.sample.editor.text;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledString;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleStyledString extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();
		
		StyledString ss = new StyledString();
		ss.appendSegment("Styled", "h1");
		ss.appendSegment("String", "h1","colorful");
		
		p.setCenter(Util.toNode(ss));
		
		Scene s = new Scene(p);
		s.getStylesheets().add(getClass().getResource("styled-string.css").toExternalForm());
		
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
