/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.text;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

import javafx.scene.layout.BorderPane;
import javafx.stage.PopupWindow;

public class TextViewerHoverManager {
	private final TextViewer textViewer;
	private final PopupWindow popup;
	private final BorderPane root;

	public TextViewerHoverManager(TextViewer textViewer) {
		this.textViewer = textViewer;
		this.popup = new PopupWindow() {
		};
		this.popup.setAutoFix(false);
		this.popup.setAutoHide(false);
		this.textViewer.getTextWidget().sceneProperty().addListener( e -> {
			if( textViewer.getTextWidget().getScene() != null ) {
				popup.getScene().getStylesheets().setAll(textViewer.getTextWidget().getScene().getStylesheets());
			}

		});
		root = new BorderPane();
		root.getStyleClass().add("styled-text-hover");
		popup.getScene().setRoot(root);
	}

	public TextViewer getTextViewer() {
		return textViewer;
	}

	public PopupWindow getPopup() {
		return popup;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void install(StyledTextArea styledTextArea) {
		// No hook yet in styled text
	}
}
