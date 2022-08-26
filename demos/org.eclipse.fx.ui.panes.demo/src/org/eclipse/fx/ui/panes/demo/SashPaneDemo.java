/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.panes.demo;

import org.eclipse.fx.ui.panes.SashPane;
import org.eclipse.fx.ui.panes.SashPane.FixedSashItem;

import javafx.application.Application;
import javafx.beans.value.ObservableBooleanValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
		root.getTabs().add(createComplex3());
		root.getTabs().add(createComplex4());

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
		pane.getItems().add(new StackPane(new Label("Top 1")));
		pane.getItems().add(new StackPane(new Label("Top 2")));
		pane.getItems().add(createGroupNode());
		pane.getItems().add(createGroupNode());
		pane.getItems().add(new StackPane(new Label("Bottom 1")));
		pane.getItems().add(new StackPane(new Label("Bottom 2")));

		StackPane root = new StackPane(pane);
		
		return new Tab("Complex - Center - Vertical", root);
	}

	private Tab createComplex4() {
		SashPane pane = new SashPane();
		VBox.setVgrow(pane, Priority.ALWAYS);
		pane.setHorizontal(false);
		pane.getItems().add(createGroupNode());
		pane.getItems().add(createGroupNode());
		pane.getItems().add(new StackPane(new Label("Top 1")));
		pane.getItems().add(new StackPane(new Label("Top 2")));
		pane.getItems().add(new StackPane(new Label("Bottom 1")));
		pane.getItems().add(new StackPane(new Label("Bottom 2")));

		StackPane root = new StackPane(pane);
		
		return new Tab("Complex - Start - Vertical", root);
	}

	
	private TitledPane createGroupNode() {
		VBox content = new VBox(new Label("Content"));
		content.setPadding(new Insets(30));
//		content.setPrefHeight(1000);
//		content.setMaxHeight(1000);
		ScrollPane scrollPane = new ScrollPane(content);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true); 
		TitledPane pane = new SashTitledPane("Sample", scrollPane);
		pane.setAnimated(false);
		return pane;
	}
	
	class SashTitledPane extends TitledPane implements FixedSashItem {
		public SashTitledPane(String title, Node content) {
			super(title, content);
		}
		
		@Override
		public ObservableBooleanValue fixed() {
			return expandedProperty().not();
		}
		
	}
}
