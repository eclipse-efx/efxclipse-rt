/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public abstract class TitleAreaDialog extends Dialog {
	private String title;
	private String message;
	private URL imageURI;
	private String iconClass;
	
	public TitleAreaDialog(Window parent, String windowTitle, String title, String message, URL imageURI) {
		super(parent, windowTitle);
		this.title = title;
		this.message = message;
		this.imageURI = imageURI;
	}
	
	public TitleAreaDialog(Window parent, String windowTitle, String title, String message, String iconClass) {
		super(parent, windowTitle);
		this.title = title;
		this.message = message;
		this.iconClass = iconClass;
	}
	
	@Override
	protected List<String> getStylesheets() {
		List<String> list = new ArrayList<String>(super.getStylesheets());
		list.add(0, MessageDialog.class.getResource("titlearea_dialog.css").toExternalForm());
		return list;
	}
	
	@Override
	protected final Node createDialogArea() {
		VBox pane = new VBox();
		BorderPane titleArea = new BorderPane();
		titleArea.getStyleClass().add("titleDialog_TitleArea");
		titleArea.setPadding(new Insets(0,0,0,10));
		
		VBox messageArea = new VBox();
		messageArea.setPadding(new Insets(10, 0, 0, 0));
		messageArea.getStyleClass().add("titleDialog_MessageArea");
		
		{
			Label l = new Label(title);
			l.getStyleClass().add("titleDialog_Title");
			messageArea.getChildren().add(l);
		}
		
		{
			Label l = new Label(message);
			l.getStyleClass().add("titleDialog_Message");
			messageArea.getChildren().add(l);
		}
		
		titleArea.setCenter(messageArea);
		
		if( imageURI != null ) {
			try {
				InputStream in = imageURI.openStream();
				titleArea.setRight(new ImageView(new Image(in)));
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if( iconClass != null ) {
			System.err.println(iconClass); 
			ImageView image = new ImageView();
			image.getStyleClass().addAll("titleDialog_Icon-"+iconClass);
			titleArea.setRight(image);
		}
		
		pane.getChildren().add(titleArea);
		BorderPane dialogContent = new BorderPane();
		dialogContent.getStyleClass().add("titleDialog_ContentArea");
		dialogContent.setLeft(createDialogContent());
		dialogContent.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().add(dialogContent);
		
		return pane;
	}
	
	@Override
	protected Insets getContentInset() {
		return new Insets(0,0,0,0);
	}

	protected abstract Node createDialogContent();
}
