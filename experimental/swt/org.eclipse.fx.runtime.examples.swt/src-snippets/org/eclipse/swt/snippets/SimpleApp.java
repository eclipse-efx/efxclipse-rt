package org.eclipse.swt.snippets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class SimpleApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TabPane tb = new TabPane();
		
		{
			Tab t = new Tab("T1");
			t.setContent(new TitledPane("Bla",null));
			tb.getTabs().add(t);
		}
		
		{
			Tab t = new Tab("T2");
			t.setContent(new TitledPane("Bla",null));
			tb.getTabs().add(t);
		}
		
		primaryStage.setScene(new Scene(tb,400,400));
		primaryStage.show();
	}

}