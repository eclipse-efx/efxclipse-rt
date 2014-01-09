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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class Dialog {
	public static final int OK_BUTTON = 1;
	public static final int CANCEL_BUTTON = 2;
	
	private Stage stage;
	private boolean blockOnOpen = true;
	private int returnCode;
	private List<Button> buttons;
	private String title;
	private Window parent;
	
	public Dialog(Window parent, String title) {
		this.parent = parent;
		this.title = title;
	}
	
	protected Parent createContents() {
		BorderPane p = new BorderPane();
		p.getStyleClass().add(getClass().getSimpleName());
		HBox box = new HBox();
		box.setPadding(getContentInset());
		
		Node content = createDialogArea();
		HBox.setHgrow(content, Priority.ALWAYS);
		box.getChildren().add(content);
		
		p.setCenter(box);
		p.setBottom(createButtonBar());
		return p;
	}
	
	protected Insets getContentInset() {
		return new Insets(10,10,0,10);
	}
	
	protected abstract Node createDialogArea();

	protected Node createButtonBar() {
		HBox b = new HBox(10);
		b.setPadding(new Insets(10));
		Region spacer = new Region();
		
		b.getChildren().add(spacer);
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		buttons = createButtonsForBar();
		b.getChildren().addAll(buttons);
		
		return b;
	}
	
	protected List<Button> createButtonsForBar() {
		List<Button> rv = new ArrayList<Button>();
		rv.add(createButtonForBar(CANCEL_BUTTON, "Cancel",isOkDefault(CANCEL_BUTTON),isCancelDefault(CANCEL_BUTTON)));
		rv.add(createButtonForBar(OK_BUTTON, "Ok", isOkDefault(OK_BUTTON), isCancelDefault(OK_BUTTON)));
		return rv;
	}
	
	protected boolean isOkDefault(int buttonId) {
		return buttonId == OK_BUTTON;
	}
	
	protected boolean isCancelDefault(int buttonId) {
		return buttonId == CANCEL_BUTTON;
	}
	
	protected Button createButtonForBar(final int type, String label, boolean defaultOkButton, boolean defaultCancel) {
		Button b = new Button(label);
		b.setDefaultButton(defaultOkButton);
		b.setCancelButton(defaultCancel);
		b.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				buttonPressed(type);
			}
		});
		return b;
	}
	
	protected void buttonPressed(int type) {
		if( type == CANCEL_BUTTON ) {
			cancelPressed();
		} else if( type == OK_BUTTON ) {
			okPressed();
		}
	}
	
	protected void okPressed() {
		returnCode = OK_BUTTON;
		close();
	}
	
	protected void cancelPressed() {
		returnCode = CANCEL_BUTTON;
		close();
	}
	
	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	
	protected void close() {
		stage.close();
	}
	
	protected List<String> getStylesheets() {
		if( parent != null ) {
			return Collections.unmodifiableList(parent.getScene().getStylesheets());
		}
		return Collections.emptyList();
	}
	
	protected Stage create() {
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.initOwner(parent);
		Parent content = createContents();
		Scene s = new Scene(content);
		s.getStylesheets().addAll(getStylesheets());
		stage.setScene(s);
		Point2D size = getInitialSize(content);
		if( size != null ) {
			stage.setWidth(size.getX());
			stage.setHeight(size.getY());
		}
		Point2D location = getInitialLocation(content);
		if( location != null ) {
			stage.setX(location.getX());
			stage.setY(location.getY());
		}
		return stage;
	}
	
	protected Point2D getInitialSize(Parent rootContainer) {
		return null;
	}
	
	protected Point2D getInitialLocation(Parent rootContainer) {
		return null;
	}
	
	void layout() {
		double maxWidth = 0;
		for( Button b : buttons ) {
			maxWidth = Math.max(maxWidth, b.prefWidth(-1));
		}
		
		for( Button b : buttons ) {
			b.setPrefWidth(maxWidth);
		}
		
//		Point2D size = getInitialSize();
//		stage.setWidth(size.getX());
//		stage.setHeight(size.getY());
//		stage.sizeToScene();
	}
	
	protected Modality getModality() {
		return Modality.WINDOW_MODAL;
	}
	
	public int open() {
		if( stage == null ) {
			stage = create();
			stage.showingProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(
						ObservableValue<? extends Boolean> observable,
						Boolean oldValue, Boolean newValue) {
					if( newValue ) {
						layout();
					}
				}
			});
		}
		
		stage.initModality(getModality());
		if( blockOnOpen ) {
			stage.showAndWait();			
		} else {
			stage.show();
		}
		
		return returnCode;
	}
}
