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

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * A dialog with a reserved area at the top to display informations
 */
public class TitleAreaDialog extends Dialog {
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
		private final Label titleMessage;
		
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

			ImageView titleImage = new ImageView();
			titleImage.getStyleClass().add("efx-dialog-title-image"); //$NON-NLS-1$
			box.getChildren().addAll(messageArea, titleImage);

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
}
