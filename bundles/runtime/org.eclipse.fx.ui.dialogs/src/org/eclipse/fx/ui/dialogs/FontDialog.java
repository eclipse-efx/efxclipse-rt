/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.dialogs;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FontDialog extends Dialog {
	private ObjectProperty<Font> font = new SimpleObjectProperty<>(this,"font",Font.getDefault());
	
	public FontDialog(Window parent, String title) {
		super(parent, title);
	}
	
	public ObjectProperty<Font> font() {
		return font;
	}

	public void setFont(Font f) {
		font.set(f);
	}
	
	public Font getFont() {
		return font.get();
	}
	
	@Override
	protected Node createDialogArea() {
		VBox p = new VBox(10);
		
		{
			HBox top = new HBox(10);
			
			{
				VBox container = new VBox();
				container.getChildren().add(new Label("Family:"));
				
				TextField f = new TextField();
				f.setText(font.get().getFamily());
				f.setOnKeyReleased(new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {
						// TODO Auto-generated method stub
						
					}
				});
				container.getChildren().add(f);
				
				final ListView<String> v = new ListView<String>();
				v.setItems(FXCollections.observableArrayList(Font.getFamilies()));
				v.getSelectionModel().select(font.get().getFamily());
				v.scrollTo(font.get().getFamily());
				v.setPrefHeight(250);
				
				container.getChildren().add(v);
				
				top.getChildren().add(container);
			}
			
			{
				VBox container = new VBox();
				container.getChildren().add(new Label("Posture:"));
				
				FontPosture posture = font.get().getStyle().toLowerCase().contains("italic") ? FontPosture.ITALIC : FontPosture.REGULAR;
				TextField f = new TextField();
				f.setText(posture.name());
				container.getChildren().add(f);
				
				ListView<FontPosture> v = new ListView<>();
				v.setItems(FXCollections.observableArrayList(FontPosture.values()));
				
				v.getSelectionModel().select(posture);
				v.scrollTo(posture);
				v.setPrefWidth(120);
				v.setPrefHeight(250);
				
				container.getChildren().add(v);
				
				top.getChildren().add(container);
			}
			
			{
				VBox container = new VBox();
				container.getChildren().add(new Label("Weight:"));
				
				TextField f = new TextField();
				container.getChildren().add(f);
								
				ListView<FontWeight> v = new ListView<>();
				v.setItems(FXCollections.observableArrayList(FontWeight.values()));
				container.getChildren().add(v);
				v.setPrefHeight(250);
				v.setPrefWidth(120);
				
				top.getChildren().add(container);
			}
			
			{
				VBox container = new VBox();
				container.getChildren().add(new Label("Size:"));
				
				TextField f = new TextField();
				f.setText(font.get().getSize()+"");
				container.getChildren().add(f);
				
				ListView<Double> v = new ListView<Double>();
				ObservableList<Double> sizes = FXCollections.observableArrayList(8d,9d,10d,11d,12d,14d,16d,18d,20d,22d,24d,26d,28d,36d,48d,72d);
				if( !sizes.contains(font.get().getSize()) ) {
					for( int i = 0; i < sizes.size(); i++ ) {
						if( font.get().getSize() > sizes.get(i) ) {
							sizes.add(i, font.get().getSize());
							break;
						}
					}
				}
				v.setItems(sizes);
				v.getSelectionModel().select(font.get().getSize());
				v.setPrefWidth(80);
				v.setPrefHeight(250);
				container.getChildren().add(v);
				
				top.getChildren().add(container);
			}
			
			p.getChildren().add(top);
		}
		
		{
			TitledPane tb = new TitledPane();
			tb.setCollapsible(false);
			tb.setText("Preview");
			
			TextField f = new TextField("AaBbYyZz");
			f.fontProperty().bind(font);
			f.setPrefHeight(80);
			tb.setContent(f);
			
			p.getChildren().add(tb);
		}
		
		
		return p;
	}
	
	public static void main(String[] args) {
		Application.launch(TempApp.class, args);
	}
	
	public static class TempApp extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			FontDialog fd = new FontDialog(null, "Fonts");
			fd.open();
		}
	}
}