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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A message title dialog is a more complex message dialog than
 * {@link MessageDialog}
 */
public final class MessageTitleDialog extends TitleAreaDialog {
	private String message;
	private String[] dialogButtonLabels;
	private int okButton;
	private int cancelButton;

	MessageTitleDialog(@Nullable Window parent, @NonNull String windowTitle,
			@NonNull String title, @NonNull String message, @NonNull Type type,
			int okButton, int cancelButton, String... dialogButtonLabels) {
		super(parent, windowTitle, title, null, type.name().toLowerCase());
		this.message = message;
		this.dialogButtonLabels = dialogButtonLabels;
		this.okButton = okButton;
		this.cancelButton = cancelButton;
	}

	@Override
	protected boolean isOkDefault(int buttonId) {
		return this.okButton == buttonId;
	}

	@Override
	protected boolean isCancelDefault(int buttonId) {
		return this.cancelButton == buttonId;
	}

	@Override
	protected List<Button> createButtonsForBar() {
		List<Button> rv = new ArrayList<Button>();
		for (int i = 0; i < this.dialogButtonLabels.length; i++) {
			rv.add(createButtonForBar(i, this.dialogButtonLabels[i],
					isOkDefault(i), isCancelDefault(i)));
		}
		return rv;
	}

	@Override
	protected Node createDialogContent() {
		BorderPane p = new BorderPane();
		p.setLeft(new Label(this.message));
		return p;
	}

	/**
	 * Open an error dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 */
	public static void openErrorDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title,
			@NonNull String message) {
		new MessageTitleDialog(parent, windowTitle, title, message, Type.ERROR,
				0, 0, Messages.getString("MessageTitleDialog.Ok")).open(); //$NON-NLS-1$
	}

	/**
	 * Open a warning dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 */
	public static void openWarningDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title,
			@NonNull String message) {
		new MessageTitleDialog(parent, windowTitle, title, message,
				Type.WARNING, 0, 0, Messages.getString("MessageTitleDialog.Ok")).open(); //$NON-NLS-1$
	}

	/**
	 * Open an information dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 */
	public static void openInformationDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title,
			@NonNull String message) {
		new MessageTitleDialog(parent, windowTitle, title, message,
				Type.INFORMATION, 0, 0, Messages.getString("MessageTitleDialog.Ok")).open(); //$NON-NLS-1$
	}

	/**
	 * Open a question dialog  who blocks until closed with {@link QuestionResult#YES} as default
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @return the result
	 */
	public static QuestionResult openQuestionDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title,
			@NonNull String message) {
		return openQuestionDialog(parent, windowTitle, title, message,
				QuestionResult.YES);
	}

	/**
	 * Open a question dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @return the result
	 */
	public static QuestionResult openQuestionDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title,
			@NonNull String message, @NonNull QuestionResult defaultValue) {
		return QuestionResult
				.fromIndex(new MessageTitleDialog(parent, windowTitle, title,
						message, Type.QUESTION,
						defaultValue == QuestionResult.YES ? 0 : 1,
						defaultValue == QuestionResult.YES ? 1 : 0, Messages.getString("MessageTitleDialog.Yes"), Messages.getString("MessageTitleDialog.No")) //$NON-NLS-1$ //$NON-NLS-2$
						.open());
	}

	/**
	 * Open a question-cancel dialog who blocks until closed with {@link QuestionCancelResult#YES} as
	 * default
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 * @return the result
	 */
	public static QuestionCancelResult openQuestionCancelDialog(
			@Nullable Window parent, @NonNull String windowTitle,
			@NonNull String title, @NonNull String message) {
		return openQuestionCancelDialog(parent, windowTitle, title, message,
				QuestionCancelResult.YES);
	}

	/**
	 * Open a question-cancel dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @return the result
	 */
	public static QuestionCancelResult openQuestionCancelDialog(
			@Nullable Window parent, @NonNull String windowTitle,
			@NonNull String title, @NonNull String message,
			@NonNull QuestionCancelResult defaultValue) {
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

		return QuestionCancelResult.fromIndex(new MessageTitleDialog(parent,
				windowTitle, title, message, Type.QUESTION, idx, 2, Messages.getString("MessageTitleDialog.Yes"), //$NON-NLS-1$
				Messages.getString("MessageTitleDialog.No"), Messages.getString("MessageTitleDialog.Cancel")).open()); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Open a confirmation dialog who blocks until closed with {@link ConfirmResult#OK} as default
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 * @return the result
	 */
	public static ConfirmResult openConfirmDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title,
			@NonNull String message) {
		return openConfirmDialog(parent, windowTitle, title, message,
				ConfirmResult.OK);
	}

	/**
	 * Open a confirmation dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param windowTitle
	 *            the window title
	 * @param title
	 *            the title text
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @return the result
	 */
	public static ConfirmResult openConfirmDialog(@Nullable Window parent,
			@NonNull String windowTitle, @NonNull String title, @NonNull String message,
			@NonNull ConfirmResult defaultValue) {
		return ConfirmResult.fromIndex(new MessageTitleDialog(parent,
				windowTitle, title, message, Type.CONFIRM,
				defaultValue == ConfirmResult.OK ? 0 : 1, 1, Messages.getString("MessageTitleDialog.Ok"), Messages.getString("MessageTitleDialog.Cancel")) //$NON-NLS-1$ //$NON-NLS-2$
				.open());
	}
}
