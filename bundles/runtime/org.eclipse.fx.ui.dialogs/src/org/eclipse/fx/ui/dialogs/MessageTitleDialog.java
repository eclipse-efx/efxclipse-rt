/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

import org.eclipse.fx.ui.dialogs.MessageDialog.ConfirmResult;
import org.eclipse.fx.ui.dialogs.MessageDialog.QuestionCancelResult;
import org.eclipse.fx.ui.dialogs.MessageDialog.QuestionResult;
import org.eclipse.fx.ui.dialogs.MessageDialog.Type;

public final class MessageTitleDialog extends TitleAreaDialog {
	private String message;
	private String[] dialogButtonLabels;
	private int okButton;
	private int cancelButton;
	
	MessageTitleDialog(Window parent, String windowTitle, String title, String message, Type type, int okButton, int cancelButton, String... dialogButtonLabels) {
		super(parent, windowTitle, title, null, type.name().toLowerCase());
		this.message = message;
		this.dialogButtonLabels = dialogButtonLabels;
		this.okButton = okButton;
		this.cancelButton = cancelButton;
	}
	
	@Override
	protected boolean isOkDefault(int buttonId) {
		return okButton == buttonId;
	}
	
	protected boolean isCancelDefault(int buttonId) {
		return cancelButton == buttonId;
	}
	
	@Override
	protected List<Button> createButtonsForBar() {
		List<Button> rv = new ArrayList<Button>();
		for( int i = 0; i < dialogButtonLabels.length; i++ ) {
			rv.add(createButtonForBar(i,dialogButtonLabels[i], isOkDefault(i), isCancelDefault(i)));
		}
		return rv;
	}
	
	@Override
	protected Node createDialogContent() {
		BorderPane p = new BorderPane();
		p.setLeft(new Label(message));
		return p;
	}
	
	public static void openErrorDialog(Window parent, String windowTitle, String title, String message) {
		new MessageTitleDialog(parent, windowTitle, title, message, Type.ERROR, 0, 0, "Ok").open();
	}
	
	public static void openWarningDialog(Window parent, String windowTitle, String title, String message) {
		new MessageTitleDialog(parent, windowTitle, title, message, Type.WARNING, 0, 0, "Ok").open();
	}
	
	public static void openInformationDialog(Window parent, String windowTitle, String title, String message) {
		new MessageTitleDialog(parent, windowTitle, title, message, Type.INFORMATION, 0, 0, "Ok").open();
	}
	
	public static QuestionResult openQuestionDialog(Window parent, String windowTitle, String title, String message) {
		return openQuestionDialog(parent, windowTitle, title, message, QuestionResult.YES);
	}
	
	public static QuestionResult openQuestionDialog(Window parent, String windowTitle, String title, String message, QuestionResult defaultValue) {
		return QuestionResult.fromIndex(new MessageTitleDialog(parent, windowTitle, title, message, Type.QUESTION, defaultValue == QuestionResult.YES ? 0 : 1, defaultValue == QuestionResult.YES ? 1 : 0, "Yes", "No").open());
	}
	
	public static QuestionCancelResult openQuestionCancelDialog(Window parent, String windowTitle, String title, String message) {
		return openQuestionCancelDialog(parent, windowTitle, title, message, QuestionCancelResult.YES);
	}
	
	public static QuestionCancelResult openQuestionCancelDialog(Window parent, String windowTitle, String title, String message, QuestionCancelResult defaultValue) {
		int idx;
		
		switch (defaultValue) {
		case CANCEL:
			idx = 2;
			break;
		case NO:
			idx = 1;
			break;
		default:
			idx = 0;
			break;
		}
		
		return QuestionCancelResult.fromIndex(new MessageTitleDialog(parent, windowTitle, title, message, Type.QUESTION, idx, 2, "Yes", "No", "Cancel").open());
	}
	
	public static ConfirmResult openConfirmDialog(Window parent, String windowTitle, String title, String message) {
		return openConfirmDialog(parent, windowTitle, title, message, ConfirmResult.OK);
	}
	
	public static ConfirmResult openConfirmDialog(Window parent, String windowTitle, String title, String message, ConfirmResult defaultValue) {
		return ConfirmResult.fromIndex(new MessageTitleDialog(parent, windowTitle, title, message, Type.CONFIRM, defaultValue == ConfirmResult.OK ? 0 : 1, 1, "Ok", "Cancel").open());
	}
}
