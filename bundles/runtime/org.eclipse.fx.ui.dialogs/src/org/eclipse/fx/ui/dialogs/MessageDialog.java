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
import java.util.List;

import org.eclipse.fx.ui.panes.GridLayoutPane;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

public class MessageDialog extends Dialog {
	public enum Type {
		CUSTOM,
		QUESTION,
		INFORMATION,
		WARNING,
		ERROR,
		CONFIRM,
		QUESTION_CANCEL
	}
	
	public enum QuestionResult {
		YES(0),
		NO(1);
		
		private final int index;
		
		private QuestionResult(int index) {
			this.index = index;
		}
		
		static QuestionResult fromIndex(int index) {
			if( index == YES.index ) {
				return YES;
			} else {
				return NO;
			}
		}
	}
	
	public enum QuestionCancelResult {
		YES(0),
		NO(1),
		CANCEL(2);
		
		private final int index;
		
		private QuestionCancelResult(int index) {
			this.index = index;
		}
		
		static QuestionCancelResult fromIndex(int index) {
			if( index == YES.index ) {
				return YES;
			} else if( index == NO.index ) {
				return NO;
			} else {
				return CANCEL;
			}
		}
	}
	
	public enum ConfirmResult {
		OK(0),
		CANCEL(1);
		
		private final int index;
		
		private ConfirmResult(int index) {
			this.index = index;
		}
		
		static ConfirmResult fromIndex(int index) {
			if( index == OK.index ) {
				return OK;
			} else {
				return CANCEL;
			}
		}
	}
	
	private final Type type;
	private final String message;
	private final String[] dialogButtonLabels;
	private final int okButton;
	private final int cancelButton;
	
	MessageDialog(Window parent, String windowTitle, String message, Type type, int okButton, int cancelButton, String... dialogButtonLabels) {
		super(parent, windowTitle);
		this.type = type;
		this.message = message;
		this.dialogButtonLabels = dialogButtonLabels;
		this.okButton = okButton;
		this.cancelButton = cancelButton;
	}

	@Override
	protected Node createDialogArea() {
		GridLayoutPane b = new GridLayoutPane();
		b.setHorizontalSpacing(20);
		b.setNumColumns(2);
		b.getStyleClass().add("messagedialog-" + type.name().toLowerCase());
		
		ImageView view = new ImageView();
		view.getStyleClass().add("messagedialog-icon");
		b.getChildren().add(view);
		
		Label l = new Label(message);
		l.getStyleClass().add("messagedialog-message");
		
		b.getChildren().add(l);
		return b;
	}
	
	@Override
	protected List<String> getStylesheets() {
		List<String> list = new ArrayList<>(super.getStylesheets());
		list.add(0, MessageDialog.class.getResource("message_dialog.css").toExternalForm());
		return list;
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
	protected void buttonPressed(int type) {
		setReturnCode(type);
		close();
	}

	public static void openErrorDialog(Window parent, String title, String message) {
		new MessageDialog(parent, title, message, Type.ERROR, 0, 0, "Ok").open();
	}
	
	public static void openWarningDialog(Window parent, String title, String message) {
		new MessageDialog(parent, title, message, Type.WARNING, 0, 0, "Ok").open();
	}
	
	public static void openInformationDialog(Window parent, String title, String message) {
		new MessageDialog(parent, title, message, Type.INFORMATION, 0, 0, "Ok").open();
	}
	
	public static QuestionResult openQuestionDialog(Window parent, String title, String message) {
		return openQuestionDialog(parent, title, message, QuestionResult.YES);
	}
	
	public static QuestionResult openQuestionDialog(Window parent, String title, String message, QuestionResult defaultValue) {
		return QuestionResult.fromIndex(new MessageDialog(parent, title, message, Type.QUESTION, defaultValue == QuestionResult.YES ? 0 : 1, defaultValue == QuestionResult.YES ? 1 : 0, "Yes", "No").open());
	}
	
	public static QuestionCancelResult openQuestionCancelDialog(Window parent, String title, String message) {
		return openQuestionCancelDialog(parent, title, message, QuestionCancelResult.YES);
	}
	
	public static QuestionCancelResult openQuestionCancelDialog(Window parent, String title, String message, QuestionCancelResult defaultValue) {
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
		
		return QuestionCancelResult.fromIndex(new MessageDialog(parent, title, message, Type.QUESTION, idx, 2, "Yes", "No", "Cancel").open());
	}
	
	public static ConfirmResult openConfirmDialog(Window parent, String title, String message) {
		return openConfirmDialog(parent, title, message, ConfirmResult.OK);
	}
	
	public static ConfirmResult openConfirmDialog(Window parent, String title, String message, ConfirmResult defaultValue) {
		return ConfirmResult.fromIndex(new MessageDialog(parent, title, message, Type.CONFIRM, defaultValue == ConfirmResult.OK ? 0 : 1, 1, "Ok", "Cancel").open());
	}
}
