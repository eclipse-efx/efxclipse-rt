/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.ui.dialogs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

/**
 * A dialog with a title are to display text and an image. You can use the
 * following css-class selectors:
 * <ul>
 * <li>titleDialog_TitleArea</li>
 * <li>titleDialog_MessageArea</li>
 * <li>titleDialog_Title</li>
 * <li>titleDialog_Message</li>
 * <li>titleDialog_Icon-$iconClass (if you pass a icon-css-class in the
 * constructor)</li>
 * <li>titleDialog_ContentArea</li>
 * </ul>
 */
public abstract class TitleAreaDialog extends Dialog {
	@NonNull
	private String title;
	@Nullable
	private String message;
	@Nullable
	private URL imageURI;
	@Nullable
	private String iconClass;
	private Label messageLabel;
	private Subscription currentTemporyMessage;

	/**
	 * Create a new dialog
	 *
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the header title text
	 * @param message
	 *            the header message
	 * @param imageURI
	 *            the uri of the image to display
	 */
	public TitleAreaDialog(@Nullable Window parent, @NonNull String windowTitle, @NonNull String title, @NonNull String message, @Nullable URL imageURI) {
		super(parent, windowTitle);
		this.title = title;
		this.message = message;
		this.imageURI = imageURI;
	}

	/**
	 * Create a new dialog
	 *
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the header title text
	 * @param message
	 *            the header message
	 * @param iconClass
	 *            the css class to use for the icon
	 */
	public TitleAreaDialog(@Nullable Window parent, @NonNull String windowTitle, @NonNull String title, @Nullable String message, @Nullable String iconClass) {
		super(parent, windowTitle);
		this.title = title;
		this.message = message;
		this.iconClass = iconClass;
	}

	@Override
	protected List<String> getStylesheets() {
		List<String> list = new ArrayList<String>(super.getStylesheets());
		list.add(0, MessageDialog.class.getResource("titlearea_dialog.css") //$NON-NLS-1$
				.toExternalForm());
		return list;
	}

	@Override
	protected final Node createDialogArea() {
		VBox pane = new VBox();
		BorderPane titleArea = new BorderPane();
		titleArea.getStyleClass().add("titleDialog_TitleArea"); //$NON-NLS-1$
		// titleArea.setPadding(new Insets(0, 0, 0, 10));

		VBox messageArea = new VBox();
		// messageArea.setPadding(new Insets(10, 0, 0, 0));
		messageArea.getStyleClass().add("titleDialog_MessageArea"); //$NON-NLS-1$

		{
			Label l = new Label(this.title);
			l.getStyleClass().add("titleDialog_Title"); //$NON-NLS-1$
			messageArea.getChildren().add(l);
		}

		{
			this.messageLabel = new Label(this.message);
			this.messageLabel.getStyleClass().add("titleDialog_Message"); //$NON-NLS-1$
			messageArea.getChildren().add(this.messageLabel);
		}

		titleArea.setCenter(messageArea);

		if (this.imageURI != null) {
			try (InputStream in = this.imageURI.openStream()) {
				titleArea.setRight(new ImageView(new Image(in)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (this.iconClass != null) {
			ImageView image = new ImageView();
			image.getStyleClass().addAll("titleDialog_Icon-" + this.iconClass); //$NON-NLS-1$
			titleArea.setRight(image);
		}

		pane.getChildren().add(titleArea);
		BorderPane dialogContent = new BorderPane();
		dialogContent.getStyleClass().add("titleDialog_ContentArea"); //$NON-NLS-1$
		dialogContent.setCenter(createDialogContent());
		dialogContent.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().add(dialogContent);

		return pane;
	}

	@Override
	protected Insets getContentInset() {
		return new Insets(0, 0, 0, 0);
	}

	/**
	 * @return create the content node
	 */
	protected abstract Node createDialogContent();

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
		this.messageLabel.setText(temporaryMessage);
		this.messageLabel.getStyleClass().addAll(messageStyles);
		this.currentTemporyMessage = () -> {
			this.messageLabel.setText(this.message);
			this.messageLabel.getStyleClass().removeAll(messageStyles);
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
