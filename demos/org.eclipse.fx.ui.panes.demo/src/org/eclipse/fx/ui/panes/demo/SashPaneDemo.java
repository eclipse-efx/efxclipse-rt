package org.eclipse.fx.ui.panes.demo;

import org.eclipse.fx.ui.panes.SashPane;
import org.eclipse.fx.ui.panes.SashPane.FixedSashItem;

import javafx.application.Application;
import javafx.beans.value.ObservableBooleanValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SashPaneDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TabPane root = new TabPane();
		root.getTabs().add(createSimpleStartVertical());
		root.getTabs().add(createSimpleEndVertical());

		Scene s = new Scene(root, 800, 600);
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	private Tab createSimpleStartVertical() {
		SashPane pane = new SashPane();
		VBox.setVgrow(pane, Priority.ALWAYS);
		pane.setHorizontal(false);
		
		pane.getItems().add(new StackPane(new Label("Content")));
		pane.getItems().add(createGroupNode());
		
		StackPane root = new StackPane(pane);
		
		return new Tab("Simple - Start - Vertical", root);
	}
	
	private Tab createSimpleEndVertical() {
		SashPane pane = new SashPane();
		VBox.setVgrow(pane, Priority.ALWAYS);
		pane.setHorizontal(false);
		
		pane.getItems().add(createGroupNode());
		pane.getItems().add(new StackPane(new Label("Content")));
		
		StackPane root = new StackPane(pane);
		
		return new Tab("Simple - End - Vertical", root);
	}
	
	private Tab createComplex3() {
		SashPane pane = new SashPane();
		VBox.setVgrow(pane, Priority.ALWAYS);
		pane.setHorizontal(false);
		pane.getItems().add(new StackPane(new Label("Top")));
		TitledPane titlePane = createGroupNode();
		pane.getItems().add(titlePane);
		pane.getItems().add(new StackPane(new Label("Bottom")));

		StackPane root = new StackPane(pane);
		
		return new Tab("Simple - Start - Vertical", root);
	}

	private TitledPane createGroupNode() {
		VBox content = new VBox(new Label("Content"));
		content.setPadding(new Insets(30));
//		content.setPrefHeight(1000);
//		content.setMaxHeight(1000);
		TitledPane pane = new SashTitlePane("Sample", content);
		return pane;
	}
	
	class SashTitlePane extends TitledPane implements FixedSashItem {
		public SashTitlePane(String title, Node content) {
			super(title, content);
		}
		
		@Override
		public ObservableBooleanValue fixed() {
			return expandedProperty().not();
		}
		
	}
}
