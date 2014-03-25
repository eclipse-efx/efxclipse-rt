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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Window;

/**
 * Dialog to prompt the user for a value
 */
public class PromptInputDialog extends Dialog {
	private String text;
	private TextField f;
	private String input;

	/**
	 * Create a prompt dialog
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the window title
	 * @param text
	 *            the prompt text
	 */
	public PromptInputDialog(@Nullable Window parent, @NonNull String title, @NonNull String text) {
		super(parent, title);
		this.text = text;
	}

	@Override
	protected Node createDialogArea() {
		HBox box = new HBox(5);
		box.getChildren().add(new Label(this.text));

		this.f = new TextField();
		box.getChildren().add(this.f);

		return box;
	}

	@Override
	protected void okPressed() {
		this.input = this.f.getText();
		super.okPressed();
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return this.input;
	}
}