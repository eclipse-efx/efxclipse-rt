package org.eclipse.fx.runtime.examples.swt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class SimpleApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TabPane tb = new TabPane();
		
		{
			Tab ti = new Tab();
			ti.setText("B1");
			ti.setClosable(false);
			tb.getTabs().add(ti);

			HBox hb = new HBox();
			{
				TitledPane tp = new TitledPane();
				tp.setText("T1");
				HBox.setHgrow(tp, Priority.ALWAYS);
				hb.getChildren().add(tp);
				
				HBox internal = new HBox();
				TextField tf = new TextField("Bla Bla");
				HBox.setHgrow(tf, Priority.ALWAYS);
				internal.getChildren().add(tf);
				tp.setContent(internal);
			}
			
			TitledPane tp2 = new TitledPane();
			tp2.setText("T2");
			hb.getChildren().add(tp2);
			
			ti.setContent(hb);
		}
		
		{
			Tab ti = new Tab();
			ti.setText("B2");
			ti.setClosable(false);
			tb.getTabs().add(ti);

			HBox hb = new HBox();
			{
				TitledPane tp = new TitledPane();
				tp.setText("T1");
				HBox.setHgrow(tp, Priority.ALWAYS);
				hb.getChildren().add(tp);
				
				HBox internal = new HBox();
				TextField tf = new TextField("Bla Bla");
				HBox.setHgrow(tf, Priority.ALWAYS);
				internal.getChildren().add(tf);
				tp.setContent(internal);
			}
			
			TitledPane tp2 = new TitledPane();
			tp2.setText("T2");
			hb.getChildren().add(tp2);
			
			ti.setContent(hb);
		}
		
		Scene s = new Scene(tb, 400, 400);
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
