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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Base class for dialogs
 */
public abstract class Dialog {
	/**
	 * Ok button ID
	 */
	public static final int OK_BUTTON = 1;
	/**
	 * Cancel button ID
	 */
	public static final int CANCEL_BUTTON = 2;

	private Stage stage;
	private boolean blockOnOpen = true;
	private int returnCode;
	private List<Button> buttons;
	private String title;
	private Window parent;

	/**
	 * Create a new dialog instance
	 * 
	 * @param parent
	 *            the owner, might be <code>null</code>
	 * @param title
	 *            the title shown in the window trim
	 */
	public Dialog(@Nullable Window parent, @NonNull String title) {
		this.parent = parent;
		this.title = title;
	}

	/**
	 * Create the dialog content
	 * <p>
	 * Subclasses should normally override {@link #createDialogArea()}
	 * </p>
	 * 
	 * @return the content
	 */
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

	/**
	 * @return insets of the content
	 */
	@SuppressWarnings("static-method")
	protected Insets getContentInset() {
		return new Insets(10, 10, 0, 10);
	}

	/**
	 * @return the dialog area
	 */
	protected abstract Node createDialogArea();

	/**
	 * @return the button bar
	 */
	protected Node createButtonBar() {
		HBox b = new HBox(10);
		b.setPadding(new Insets(10));
		Region spacer = new Region();

		b.getChildren().add(spacer);
		HBox.setHgrow(spacer, Priority.ALWAYS);

		this.buttons = createButtonsForBar();
		b.getChildren().addAll(this.buttons);

		return b;
	}

	/**
	 * Create the buttons for the bar
	 * 
	 * @return list of buttons to create
	 */
	protected List<Button> createButtonsForBar() {
		// TODO Do we need to reorder?
		List<Button> rv = new ArrayList<Button>();
		rv.add(createButtonForBar(CANCEL_BUTTON, "Cancel", isOkDefault(CANCEL_BUTTON), isCancelDefault(CANCEL_BUTTON)));
		rv.add(createButtonForBar(OK_BUTTON, "Ok", isOkDefault(OK_BUTTON), isCancelDefault(OK_BUTTON)));
		return rv;
	}

	/**
	 * Check if the button ID is the default ok button
	 * 
	 * @param buttonId
	 *            the button id
	 * @return <code>true</code> if the button is the default ok button
	 * @see Button#defaultButtonProperty()
	 */
	@SuppressWarnings("static-method")
	protected boolean isOkDefault(int buttonId) {
		return buttonId == OK_BUTTON;
	}

	/**
	 * Check if the button ID is the default cancle button
	 * 
	 * @param buttonId
	 *            the button id
	 * @return <code>true</code> if the button is the default cancel button
	 */
	@SuppressWarnings("static-method")
	protected boolean isCancelDefault(int buttonId) {
		return buttonId == CANCEL_BUTTON;
	}

	/**
	 * Create a button for the button bar
	 * 
	 * @param type
	 *            the button id
	 * @param label
	 *            the label
	 * @param defaultOkButton
	 *            <code>true</code> if it is the default button {@link Button#defaultButtonProperty()}
	 * @param defaultCancel
	 *            <code>true</code> if it is the cancel button {@link Button#cancelButtonProperty()}
	 * @return the button
	 */
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

	/**
	 * Method called when button is pressed
	 * 
	 * @param type
	 *            the button id
	 */
	protected void buttonPressed(int type) {
		if (type == CANCEL_BUTTON) {
			cancelPressed();
		} else if (type == OK_BUTTON) {
			okPressed();
		}
	}

	/**
	 * Method called when the ok button is invoked
	 */
	protected void okPressed() {
		this.returnCode = OK_BUTTON;
		close();
	}

	/**
	 * Method called when the cancle button is invoked
	 */
	protected void cancelPressed() {
		this.returnCode = CANCEL_BUTTON;
		close();
	}

	/**
	 * Setting the return code
	 * 
	 * @param returnCode
	 *            the new return code
	 */
	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Close the dialog
	 */
	protected void close() {
		this.stage.close();
	}

	/**
	 * @return the stylesheets to use
	 */
	protected List<String> getStylesheets() {
		if (this.parent != null) {
			return Collections.unmodifiableList(this.parent.getScene().getStylesheets());
		}
		return Collections.emptyList();
	}

	/**
	 * Create the dialogs stage
	 * 
	 * @return the stage
	 */
	@SuppressWarnings("deprecation")
	protected Stage create() {
		Stage stage = new Stage();
		stage.setTitle(this.title);
		stage.initOwner(this.parent);
		Parent content = createContents();
		BorderPane rootContainer = new BorderPane();
		rootContainer.setCenter(content);

		Scene s = new Scene(rootContainer);
		s.getStylesheets().addAll(getStylesheets());
		stage.setScene(s);

		Point2D size = getInitialSize(rootContainer);
		if (size != null) {
			stage.setWidth(size.getX());
			stage.setHeight(size.getY());
		} else {
			rootContainer.impl_processCSS(true);
			size = getInitialContentSize(rootContainer);
			if (size != null) {
				rootContainer.setPrefSize(size.getX(), size.getY());
			}
		}
		Point2D location = getInitialLocation(content);
		if (location != null) {
			stage.setX(location.getX());
			stage.setY(location.getY());
		}
		return stage;
	}

	/**
	 * Get the initial size of the content
	 * 
	 * @param rootContainer
	 *            the root container
	 * @return <code>null</code> if default is used
	 */
	@SuppressWarnings("static-method")
	protected Point2D getInitialContentSize(Parent rootContainer) {
		return null;
	}

	/**
	 * Get the initial size of the dialog
	 * 
	 * @param rootContainer
	 *            the root container
	 * @return <code>null</code> if the default is used
	 */
	@SuppressWarnings("static-method")
	protected Point2D getInitialSize(Parent rootContainer) {
		return null;
	}

	/**
	 * Get initial location of the dialog
	 * 
	 * @param rootContainer
	 *            the root container
	 * @return <code>null</code> if the default is used
	 */
	@SuppressWarnings("static-method")
	protected Point2D getInitialLocation(Parent rootContainer) {
		return null;
	}

	/**
	 * Set the bounds of the dialog
	 * <p>
	 * <b>Has to be called after {@link #open()}.</b> For initial size and location use
	 * {@link #getInitialSize(Parent)} {@link #getInitialLocation(Parent)}
	 * </p>
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            thy y position
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.stage.setX(x);
		this.stage.setY(y);
		this.stage.setWidth(width);
		this.stage.setHeight(height);
	}

	/**
	 * The bounds of the dialog
	 * <p>
	 * <b>Has to be called after {@link #open()}.</b>
	 * </p>
	 * 
	 * @return the current bounds of the dialog window
	 */
	public @NonNull
	Rectangle getBounds() {
		return new Rectangle(this.stage.getX(), this.stage.getY(), this.stage.getWidth(), this.stage.getHeight());
	}

	/**
	 * Pack the dialog to the content size
	 */
	public void pack() {
		this.stage.sizeToScene();
	}

	void layout() {
		double maxWidth = 0;
		for (Button b : this.buttons) {
			maxWidth = Math.max(maxWidth, b.prefWidth(-1));
		}

		for (Button b : this.buttons) {
			b.setPrefWidth(maxWidth);
		}

		// Point2D size = getInitialSize();
		// stage.setWidth(size.getX());
		// stage.setHeight(size.getY());
		// stage.sizeToScene();
	}

	/**
	 * @return the modality (default {@link Modality#WINDOW_MODAL})
	 */
	@SuppressWarnings("static-method")
	protected Modality getModality() {
		return Modality.WINDOW_MODAL;
	}

	/**
	 * Open the dialog
	 * 
	 * @return the return value
	 */
	public int open() {
		if (this.stage == null) {
			this.stage = create();
			this.stage.showingProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (newValue.booleanValue()) {
						layout();
					}
				}
			});
		}

		this.stage.initModality(getModality());
		preopen(this.stage);
		if (this.blockOnOpen) {
			this.stage.showAndWait();
		} else {
			this.stage.show();
		}

		return this.returnCode;
	}

	/**
	 * Called before dialog is opened
	 * 
	 * @param s
	 *            the stage
	 */
	protected void preopen(Stage s) {
		// Nothing by default
	}
}
