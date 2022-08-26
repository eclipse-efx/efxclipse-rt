/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.dialog;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.image.FontIconView;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * A dialog with a reserved area at the top to display informations
 */
public class TitleAreaDialog extends Dialog {
	private Subscription currentTemporyMessage;

	/**
	 * Create a new dialog
	 *
	 * @param frameTitle
	 *            the title displayed in the frame
	 * @param title
	 *            the title displayed in the title area
	 * @param message
	 *            the message displayed in the title area
	 */
	public TitleAreaDialog(String frameTitle, String title, String message) {
		this(null, frameTitle, title, message);
	}

	/**
	 * Create a new dialog
	 *
	 * @param clientArea
	 *            the client area
	 * @param frameTitle
	 *            the title displayed in the frame
	 * @param title
	 *            the title displayed in the title area
	 * @param message
	 *            the message displayed in the title area
	 */
	public TitleAreaDialog(Node clientArea, String frameTitle, String title, String message) {
		super(new TitleAreaDialogPane(), clientArea, frameTitle);
		getDialogPane().titleProperty().set(title);
		getDialogPane().titleMessageProperty().set(message);
	}

	@Override
	protected TitleAreaDialogPane getDialogPane() {
		return (TitleAreaDialogPane) super.getDialogPane();
	}

	/**
	 * Pane with a title area next to the content area
	 */
	public static class TitleAreaDialogPane extends DefaultDialogContentPane {
		private final Label titleLabel;
		final Label titleMessage;

		/**
		 *
		 */
		public TitleAreaDialogPane() {
			HBox box = new HBox();
			box.getStyleClass().add("efx-dialog-title-area"); //$NON-NLS-1$

			VBox messageArea = new VBox();
			messageArea.getStyleClass().add("efx-dialog-messageArea-area"); //$NON-NLS-1$

			this.titleLabel = new Label();
			this.titleLabel.getStyleClass().add("efx-dialog-title"); //$NON-NLS-1$

			this.titleMessage = new Label();
			this.titleMessage.setWrapText(true);
			this.titleMessage.getStyleClass().add("efx-dialog-title-message"); //$NON-NLS-1$

			messageArea.getChildren().add(this.titleLabel);
			messageArea.getChildren().add(this.titleMessage);

			HBox.setHgrow(messageArea, Priority.ALWAYS);

			StackPane container = new StackPane();
			container.getStyleClass().add("efx-dialog-graphic-container"); //$NON-NLS-1$

			ImageView titleImage = new ImageView();
			titleImage.getStyleClass().add("efx-dialog-title-image"); //$NON-NLS-1$

			FontIconView v = new FontIconView();
			v.getStyleClass().add("efx-dialog-title-font-icon"); //$NON-NLS-1$
			container.getChildren().addAll(titleImage,v);

			box.getChildren().addAll(messageArea, container);

			setTop(box);
		}

		/**
		 * @return the title property
		 */
		public StringProperty titleProperty() {
			return this.titleLabel.textProperty();
		}

		/**
		 * @return the message property
		 */
		public StringProperty titleMessageProperty() {
			return this.titleMessage.textProperty();
		}
	}

	/**
	 * Show a temporary message if another temporary message is already showing
	 * then the original one will be removed before
	 *
	 * @param temporaryMessage
	 *            the message to display
	 * @param messageStyles
	 *            the message styles to apply
	 * @return the subscription to remove the temporary message
	 * @since 2.4.0
	 */
	public Subscription showTemporaryMessage(String temporaryMessage, String... messageStyles) {
		if (this.currentTemporyMessage != null) {
			this.currentTemporyMessage.dispose();
		}
		TitleAreaDialogPane dialogPane = getDialogPane();
		dialogPane.titleMessage.setText(temporaryMessage);
		dialogPane.titleMessage.getStyleClass().addAll(messageStyles);
		this.currentTemporyMessage = () -> {
			dialogPane.titleMessage.setText(titleProperty().get());
			dialogPane.titleMessage.getStyleClass().removeAll(messageStyles);
			this.currentTemporyMessage = null;
		};

		return this.currentTemporyMessage;
	}

	/**
	 * Show a temporary warning message if another temporary message is already
	 * showing then the original one will be removed before
	 *
	 * @param temporaryMessage
	 *            the temporary message
	 * @return the subscription to remove the temporary message
	 * @since 2.4.0
	 */
	public Subscription showTemporaryWarningMessage(String temporaryMessage) {
		return showTemporaryMessage(temporaryMessage, "warning-message"); //$NON-NLS-1$
	}

	/**
	 * Show a temporary error message if another temporary message is already
	 * showing then the original one will be removed before
	 *
	 * @param temporaryMessage
	 *            the temporary message
	 * @return the subscription to remove the temporary message
	 * @since 2.4.0
	 */
	public Subscription showTemporaryErrorMessage(String temporaryMessage) {
		return showTemporaryMessage(temporaryMessage, "error-message"); //$NON-NLS-1$
	}

	/**
	 * Show a temporary info message if another temporary message is already
	 * showing then the original one will be removed before
	 *
	 * @param temporaryMessage
	 *            the temporary message
	 * @return the subscription to remove the temporary message
	 * @since 2.4.0
	 */
	public Subscription showTemporaryInfoMessage(String temporaryMessage) {
		return showTemporaryMessage(temporaryMessage, "info-message"); //$NON-NLS-1$
	}
}
