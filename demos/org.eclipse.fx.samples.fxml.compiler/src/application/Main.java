package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.eclipse.fx.core.fxml.ExtendedFXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			BorderPane root = ExtendedFXMLLoader.load(getClass().getClassLoader(), "application/Sample.fxml");
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
