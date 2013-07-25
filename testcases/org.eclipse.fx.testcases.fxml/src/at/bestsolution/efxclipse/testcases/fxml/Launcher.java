package at.bestsolution.efxclipse.testcases.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launcher extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent p = FXMLLoader.load(Launcher.class.getResource("Controller.fxml"));
		Scene s = new Scene(p);
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
