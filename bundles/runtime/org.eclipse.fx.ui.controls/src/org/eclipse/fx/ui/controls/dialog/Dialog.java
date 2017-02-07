/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.dialog;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.eclipse.fx.ui.controls.stage.DefaultFramePane;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Base class for dialogs
 *
 * <p>
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 */
public class Dialog extends DefaultFramePane {
	private final DialogContentPane dialogPane;
	private final DialogMessagesProvider messagesProvider;

	/**
	 * Create a new dialog
	 *
	 * @param clientArea
	 *            the node displayed in the client area
	 * @param frameTitle
	 *            the title displayed on the frame
	 */
	public Dialog(Node clientArea, String frameTitle) {
		this(new DefaultDialogContentPane(), clientArea, frameTitle);
	}

	/**
	 * Create a new dialog
	 *
	 * @param pane
	 *            the pane wrapping the content displaying buttons
	 * @param clientArea
	 *            the client are who presents the business controls
	 * @param frameTitle
	 *            the title displayed on the frame
	 * @param <D>
	 *            the content pane type
	 */
	public <D extends Pane & DialogContentPane> Dialog(D pane, Node clientArea, String frameTitle) {
		this(pane, clientArea, DialogMessagesProvider.createDefaultRegistry(frameTitle));
	}

	/**
	 * Create a new dialog
	 *
	 * @param pane
	 *            the pane wrapping the content displaying buttons
	 * @param clientArea
	 *            the client are who presents the business controls
	 * @param messagesProvider
	 *            the provide for messages
	 * @param <D>
	 *            the content pane type
	 */
	public <D extends Pane & DialogContentPane> Dialog(D pane, Node clientArea, DialogMessagesProvider messagesProvider) {
		super(pane, true);
		this.dialogPane = pane;
		this.messagesProvider = messagesProvider;
		this.dialogPane.setActionConsumer(this::handleButtonPress);
		setClientArea(clientArea);
		messagesProvider.register(this.titleProperty()::set, messagesProvider::frameTitle);
		getStyleClass().add("efx-dialog"); //$NON-NLS-1$
		parentProperty().addListener((o, ol, ne) -> {
			opened();
		});
	}

	/**
	 * Called when the dialog is attached to scenegraph
	 */
	protected void opened() {
		if( ! getDialogPane().getButtonList().isEmpty() ) {
			getButtonNode(getDialogPane().getButtonList().get(0)).ifPresent( e -> {
				Platform.runLater( () -> e.requestFocus());
			} );
		}
		// Fix regression introduced in Java8u102
		Platform.runLater( () -> {
			JavaFXCompatUtil.reapplyCSS(this);
		});
	}

	@Override
	protected final void requestCancelClose() {
		handleCancel();
	}

	/**
	 * Handle the press of a button
	 *
	 * @param button
	 *            the button
	 */
	protected void handleButtonPress(DialogButton button) {
		if (button.type == ButtonType.OK) {
			handleOk();
		} else if (button.type == ButtonType.CANCEL) {
			handleCancel();
		}
	}

	/**
	 * Handle the pressing of the ok button
	 */
	protected void handleOk() {
		close();
	}

	/**
	 * Handle the canceling of the dialog by hitting the OK-Button or dismissing
	 * the dialog in other ways
	 */
	protected void handleCancel() {
		close();
	}

	/**
	 * @return the dialog pane
	 */
	protected DialogContentPane getDialogPane() {
		return this.dialogPane;
	}

	/**
	 * @return the list of buttons
	 */
	public ObservableList<DialogButton> getButtonList() {
		return this.dialogPane.getButtonList();
	}

	@Override
	protected void updateClientArea(ObservableValue<? extends Node> o, Node oldClientArea, Node newClientArea) {
		this.dialogPane.getDialogContentNodeProperty().set(newClientArea);
	}

	/**
	 * A dialog button
	 */
	public static class DialogButton {
		@NonNull
		private final StringProperty label;
		@NonNull
		final ButtonType type;

		DialogButton(@NonNull ButtonType type, @NonNull String label) {
			this.type = type;
			this.label = new SimpleStringProperty(this, "label", label); //$NON-NLS-1$
		}

		/**
		 * Create a dialog button
		 *
		 * @param label
		 *            the label
		 */
		public DialogButton(@NonNull String label) {
			this(ButtonType.CUSTOM, label);
		}

		/**
		 * @return the label property
		 */
		public @NonNull StringProperty labelProperty() {
			return this.label;
		}

		/**
		 * Set a new label
		 *
		 * @param label
		 *            the new label
		 */
		public void setLabel(@NonNull String label) {
			this.label.set(label);
		}

		/**
		 * @return the current label
		 */
		@SuppressWarnings("null")
		public @NonNull String getLabel() {
			return this.label.get();
		}

		/**
		 * @return the type
		 */
		public @NonNull ButtonType getType() {
			return this.type;
		}
	}

	/**
	 * @return create a new ok button
	 */
	@SuppressWarnings("null")
	public @NonNull DialogButton createOKButton() {
		DialogButton dialogButton = new DialogButton(ButtonType.OK, this.messagesProvider.ok());
		this.messagesProvider.register(dialogButton.labelProperty()::set, this.messagesProvider::ok);
		return dialogButton;
	}

	/**
	 * @return create a new cancel button
	 */
	@SuppressWarnings("null")
	public @NonNull DialogButton createCancelButton() {
		DialogButton dialogButton = new DialogButton(ButtonType.CANCEL, this.messagesProvider.cancel());
		this.messagesProvider.register(dialogButton.labelProperty()::set, this.messagesProvider::cancel);
		return dialogButton;
	}

	/**
	 * Enum representing standard button type
	 */
	public static enum ButtonType {
		/**
		 * An ok button
		 */
		OK,
		/**
		 * A cancel button
		 */
		CANCEL,
		/**
		 * A yes button
		 */
		YES,
		/**
		 * A no button
		 */
		NO,
		/**
		 * A custom button
		 */
		CUSTOM
	}

	/**
	 * Pane representing the dialog content
	 */
	public interface DialogContentPane {
		/**
		 * @return the property holding the content node
		 */
		@NonNull
		ObjectProperty<@Nullable Node> getDialogContentNodeProperty();

		/**
		 * @return a list of buttons
		 */
		@NonNull
		ObservableList<@NonNull DialogButton> getButtonList();

		/**
		 * Set an action consumer
		 *
		 * @param actionConsumer
		 *            the consumer of actions
		 */
		void setActionConsumer(Consumer<DialogButton> actionConsumer);

		/**
		 * Find the button node for the give button type
		 *
		 * @param button
		 *            the button
		 * @return the button node wrapped in an optional
		 */
		Optional<Button> getButtonNode(DialogButton button);
	}

	/**
	 * A default implementation for the dialog content
	 */
	public static class DefaultDialogContentPane extends BorderPane implements DialogContentPane {
		private final GridLayoutPane buttonArea = new GridLayoutPane();
		@SuppressWarnings("null")
		private final @NonNull ObservableList<@NonNull DialogButton> buttonList = FXCollections.observableArrayList();
		private Consumer<DialogButton> actionConsumer;
		private BorderPane clientAreaContainer = new BorderPane();

		/**
		 * Create a new dialog pane
		 */
		public DefaultDialogContentPane() {
			getStyleClass().add("efx-dialog-pane"); //$NON-NLS-1$
			this.buttonArea.setMakeColumnsEqualWidth(true);

			this.buttonList.addListener((javafx.collections.ListChangeListener.Change<? extends DialogButton> c) -> {
				this.buttonArea.setNumColumns(this.buttonList.size());
				while (c.next()) {
					if (c.wasAdded()) {
						this.buttonArea.getChildren().addAll(c.getFrom(), c.getAddedSubList().stream().map(b -> {
							Button bu = new Button();
							bu.setUserData(b);
							bu.textProperty().bind(b.labelProperty());
							bu.setOnAction(e -> this.actionConsumer.accept(b));
							GridLayoutPane.setConstraint(bu, new GridData(Alignment.FILL, Alignment.FILL, false, false));
							return bu;
						}).collect(Collectors.toList()));
					}
					if (c.wasRemoved()) {
						this.buttonArea.getChildren().removeIf(b -> c.getRemoved().contains(b.getUserData()));
					}
				}
			});
			BorderPane.setAlignment(this.buttonArea, Pos.BOTTOM_RIGHT);
			HBox box = new HBox(this.buttonArea);
			box.getStyleClass().add("efx-dialog-button-area"); //$NON-NLS-1$
			box.setAlignment(Pos.CENTER_RIGHT);
			setBottom(box);
			BorderPane.setAlignment(this.buttonArea, Pos.BOTTOM_RIGHT);

			this.clientAreaContainer = new BorderPane();
			this.clientAreaContainer.getStyleClass().add("efx-dialog-client-area"); //$NON-NLS-1$
			setCenter(this.clientAreaContainer);
		}

		@Override
		public Optional<Button> getButtonNode(DialogButton button) {
			return this.buttonArea.getChildren().stream().filter(b -> b.getUserData() == button).map(b -> (Button) b).findFirst();
		}

		@Override
		public void setActionConsumer(Consumer<DialogButton> actionConsumer) {
			this.actionConsumer = actionConsumer;
		}

		@Override
		public @NonNull ObservableList<@NonNull DialogButton> getButtonList() {
			return this.buttonList;
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull ObjectProperty<@Nullable Node> getDialogContentNodeProperty() {
			return this.clientAreaContainer.centerProperty();
		}

		@Override
		public String getUserAgentStylesheet() {
			return Dialog.class.getResource("dialog.css").toExternalForm(); //$NON-NLS-1$
		}
	}

	/**
	 * Find the button node for the give button type
	 *
	 * @param button
	 *            the button
	 * @return the button node wrapped in an optional
	 * @since 2.4.0
	 */
	public Optional<Button> getButtonNode(DialogButton button) {
		return getDialogPane().getButtonNode(button);
	}

	/**
	 * Add default buttons - the default implementation adds
	 * <ul>
	 * <li>OK</li>
	 * <li>Cancel</li>
	 * </ul>
	 */
	protected void addDefaultButtons() {
		getButtonList().addAll(createOKButton(), createCancelButton());
	}

	/**
	 * Create a simple dialog
	 *
	 * @param clientArea
	 *            the client area
	 * @param frameTitle
	 *            the title displayed in the frame
	 * @return the dialog instance
	 */
	public static Dialog createSimpleDialog(Node clientArea, String frameTitle) {
		Dialog d = new Dialog(clientArea, frameTitle);
		d.addDefaultButtons();
		return d;
	}
}