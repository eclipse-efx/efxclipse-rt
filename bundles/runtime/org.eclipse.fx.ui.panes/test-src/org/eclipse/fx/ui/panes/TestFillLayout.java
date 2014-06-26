package org.eclipse.fx.ui.panes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TestFillLayout extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FillLayoutPane p = new FillLayoutPane();
		p.getStyleClass().add("test-css");
		
		{
			TableView<String> v = new TableView<>();
			TableColumn<String, String> c = new TableColumn<>();
			c.setPrefWidth(200);
			c.setText("Sample");
			p.getChildren().add(v);
		}
		
		{
			TableView<String> v = new TableView<>();
			TableColumn<String, String> c = new TableColumn<>();
			c.setPrefWidth(200);
			c.setText("Sample");
			p.getChildren().add(v);
		}
		
		Scene s = new Scene(p,500,500);
		s.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
