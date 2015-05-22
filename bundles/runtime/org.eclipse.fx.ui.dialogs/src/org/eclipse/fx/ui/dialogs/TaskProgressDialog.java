/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.dialogs;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @param <R>
 */
public class TaskProgressDialog<R> extends Dialog<R> {
	
	/**
	 * @param <T>
	 */
	@FunctionalInterface
	public interface CancelledHandler<T> {
		/**
		 * Will be called when the task is cancelled
		 * @return The result to be passed on to the dialog
		 */
		T cancelled();
	}
	
	/**
	 * @param <T>
	 */
	@FunctionalInterface
	public interface FailedHandler<T> {
		/**
		 * Will be called when the task fails,
		 * @param exception The exception the task failed with
		 * @return The result to be passed on to the dialog
		 */
		T failedWithException(Throwable exception);
	}
	
	private ObjectProperty<CancelledHandler<R>> cancelledHandler = new SimpleObjectProperty<>();
	private ObjectProperty<FailedHandler<R>> failedHandler = new SimpleObjectProperty<>();
	private BooleanProperty cancelable = new SimpleBooleanProperty();
	
	/**
	 * @param owner the owner stage of this dialog
	 * @param task the task to perform when the dialog opens
	 */
	public TaskProgressDialog(Stage owner, Task<R> task) {
		initOwner(owner);
		titleProperty().bind(task.titleProperty());
		initTaskHandlers(task);
		getDialogPane().setContent(createContent(task));
		setOnShown(event -> startTask(task));
	}
	
	/**
	 * @return The owner stage of the dialog
	 */
	public Stage getStage() {
		return (Stage)getDialogPane().getScene().getWindow();
	}

	@SuppressWarnings("null")
	private void initTaskHandlers(Task<R> task) {
		task.setOnSucceeded(event -> {
			R value = task.getValue();
			setResult(value);
			// If the result is NULL the dialog will not close automatically, otherwise it will
			if (value == null) 
				getStage().close();
		});
		task.setOnCancelled(event -> {
			if (this.cancelledHandler.get() == null) {
				setResult((R)null);
			} else {
				setResult(this.cancelledHandler.get().cancelled());
			}
			getStage().close();
		});
		task.setOnFailed(event -> {
			if (this.failedHandler.get() == null) {
				setResult((R)null);
			} else {
				setResult(this.failedHandler.get().failedWithException(task.getException()));
			}
			getStage().close();
		});
	}
	
	private Node createContent(Task<R> task) {
		VBox progressPane = new VBox(6);
		progressPane.setMaxWidth(Double.MAX_VALUE);
		progressPane.setAlignment(Pos.CENTER_LEFT);

		Label messageLabel = new Label(task.getMessage());
		messageLabel.setPadding(new Insets(14, 0, 0, 0));
		messageLabel.setMaxWidth(Double.MAX_VALUE);
		messageLabel.setPrefSize(420, 56);
		messageLabel.setWrapText(true);
		messageLabel.setAlignment(Pos.TOP_LEFT);
		progressPane.getChildren().add(messageLabel);
		
		HBox hbox = new HBox(3);
		hbox.setAlignment(Pos.CENTER_LEFT);
		progressPane.getChildren().add(hbox);
		
		ProgressBar progressBar = new ProgressBar();
		progressBar.setMaxWidth(Double.MAX_VALUE);
		progressBar.setMaxHeight(Double.MAX_VALUE);
		hbox.getChildren().add(progressBar);
		HBox.setHgrow(progressBar, Priority.ALWAYS);
		
		Button cancelButton = new Button();
		cancelButton.setGraphic(new ImageView(new Image(TaskProgressDialog.class.getResourceAsStream("cancel.png")))); //$NON-NLS-1$
		cancelButton.setCancelButton(true);
		cancelButton.setOnAction((event) -> {
			task.cancel();
		});
		if (this.cancelable.get()) {
			hbox.getChildren().add(cancelButton);
		}
		this.cancelable.addListener((o, oV, nV) -> {
			if (nV.booleanValue()) {
				hbox.getChildren().add(cancelButton);
			} else if (hbox.getChildren().contains(cancelButton)) {
				hbox.getChildren().remove(cancelButton);
			}
		});
		
		messageLabel.textProperty().bind(task.messageProperty());
		progressBar.progressProperty().bind(task.progressProperty());
		
		return progressPane;
	}
	
	private void startTask(Task<R> task) {
		Thread th = new Thread(task);
		th.setName(task.getTitle());
		th.setDaemon(true);
		th.start();
	}
	
	public final BooleanProperty cancelableProperty() {
		return this.cancelable;
	}

	public final boolean isCancelable() {
		return this.cancelableProperty().get();
	}

	public final void setCancelable(final boolean cancelable) {
		this.cancelableProperty().set(cancelable);
	}
	
	public final ObjectProperty<CancelledHandler<R>> cancelledHandlerProperty() {
		return this.cancelledHandler;
	}

	public final CancelledHandler<R> getCancelledHandler() {
		return this.cancelledHandlerProperty().get();
	}

	public final void setCancelledHandler(final CancelledHandler<R> cancelledHandler) {
		this.cancelledHandlerProperty().set(cancelledHandler);
	}

	public final ObjectProperty<FailedHandler<R>> failedHandlerProperty() {
		return this.failedHandler;
	}

	public final FailedHandler<R> getFailedHandler() {
		return this.failedHandlerProperty().get();
	}

	public final void setFailedHandler(final FailedHandler<R> failedHandler) {
		this.failedHandlerProperty().set(failedHandler);
	}

}
