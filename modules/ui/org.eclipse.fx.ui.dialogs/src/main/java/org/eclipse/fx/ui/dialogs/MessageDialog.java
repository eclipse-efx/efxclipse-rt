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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

/**
 * Create a message dialog
 */
public class MessageDialog extends Dialog {
	/**
	 * The message type
	 */
	public enum Type {
		/**
		 * A custom dialog
		 */
		CUSTOM,
		/**
		 * A question dialog
		 */
		QUESTION,
		/**
		 * An information dialog
		 */
		INFORMATION,
		/**
		 * A warning dialog
		 */
		WARNING,
		/**
		 * An error dialog
		 */
		ERROR,
		/**
		 * Confirmation dialog
		 */
		CONFIRM,
		/**
		 * Question and cancel dialog which has result of
		 * {@link QuestionCancelResult}
		 */
		QUESTION_CANCEL
	}

	/**
	 * Result of a dialog of type {@link QuestionResult}
	 */
	public enum QuestionResult {
		/**
		 * Yes
		 */
		YES(0),
		/**
		 * No
		 */
		NO(1);

		private final int index;

		private QuestionResult(int index) {
			this.index = index;
		}

		@NonNull
		static QuestionResult fromIndex(int index) {
			if (index == YES.index) {
				return YES;
			} else {
				return NO;
			}
		}
	}

	/**
	 * Result of a dialog of type {@link QuestionCancelResult}
	 */
	public enum QuestionCancelResult {
		/**
		 * Yes
		 */
		YES(0),
		/**
		 * No
		 */
		NO(1),
		/**
		 * Cancel
		 */
		CANCEL(2);

		private final int index;

		private QuestionCancelResult(int index) {
			this.index = index;
		}

		static QuestionCancelResult fromIndex(int index) {
			if (index == YES.index) {
				return YES;
			} else if (index == NO.index) {
				return NO;
			} else {
				return CANCEL;
			}
		}
	}

	/**
	 * Confirmation result
	 */
	public enum ConfirmResult {
		/**
		 * Ok
		 */
		OK(0),
		/**
		 * Cancel
		 */
		CANCEL(1);

		private final int index;

		private ConfirmResult(int index) {
			this.index = index;
		}

		static ConfirmResult fromIndex(int index) {
			if (index == OK.index) {
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

	public MessageDialog(@Nullable Window parent, @NonNull String windowTitle,
			@NonNull String message, @NonNull Type type, int okButton,
			int cancelButton, String... dialogButtonLabels) {
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
		b.getStyleClass()
				.add("messagedialog-" + this.type.name().toLowerCase()); //$NON-NLS-1$

		ImageView view = new ImageView();
		view.getStyleClass().add("messagedialog-icon"); //$NON-NLS-1$
		b.getChildren().add(view);

		Label l = new Label(this.message);
		l.getStyleClass().add("messagedialog-message"); //$NON-NLS-1$

		b.getChildren().add(l);
		return b;
	}

	@Override
	protected List<String> getStylesheets() {
		List<String> list = new ArrayList<>(super.getStylesheets());
		list.add(0, MessageDialog.class.getResource("message_dialog.css") //$NON-NLS-1$
				.toExternalForm());
		return list;
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
	protected void buttonPressed(int type) {
		setReturnCode(type);
		close();
	}

	/**
	 * Open an error dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public static void openErrorDialog(@Nullable Window parent,
			@NonNull String title, @NonNull String message) {
		new MessageDialog(parent, title, message, Type.ERROR, 0, 0, Messages.getString("MessageDialog.Ok")) //$NON-NLS-1$
				.open();
	}

	/**
	 * Open a warning dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public static void openWarningDialog(@Nullable Window parent,
			@NonNull String title, @NonNull String message) {
		new MessageDialog(parent, title, message, Type.WARNING, 0, 0, Messages.getString("MessageDialog.Ok")) //$NON-NLS-1$
				.open();
	}

	/**
	 * Open an information dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public static void openInformationDialog(@Nullable Window parent,
			@NonNull String title, @NonNull String message) {
		new MessageDialog(parent, title, message, Type.INFORMATION, 0, 0, Messages.getString("MessageDialog.Ok")) //$NON-NLS-1$
				.open();
	}

	/**
	 * Open a question dialog who blocks until closed with default value {@link QuestionResult#YES}
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the mssage
	 * @return the result
	 */
	@NonNull
	public static QuestionResult openQuestionDialog(@Nullable Window parent,
			@NonNull String title, @NonNull String message) {
		return openQuestionDialog(parent, title, message, QuestionResult.YES);
	}

	/**
	 * Open a question dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @return the result
	 */
	@NonNull
	public static QuestionResult openQuestionDialog(@Nullable Window parent,
			@NonNull String title, @NonNull String message,
			@NonNull QuestionResult defaultValue) {
		return QuestionResult.fromIndex(new MessageDialog(parent, title,
				message, Type.QUESTION, defaultValue == QuestionResult.YES ? 0
						: 1, defaultValue == QuestionResult.YES ? 1 : 0, Messages.getString("MessageDialog.Yes"), //$NON-NLS-1$
				Messages.getString("MessageDialog.No")).open()); //$NON-NLS-1$
	}

	/**
	 * Open an question cancel dialog who blocks until closed with default option
	 * {@link QuestionCancelResult#YES}
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @return the result
	 */
	public static QuestionCancelResult openQuestionCancelDialog(
			@Nullable Window parent, @NonNull String title,
			@NonNull String message) {
		return openQuestionCancelDialog(parent, title, message,
				QuestionCancelResult.YES);
	}

	/**
	 * Open a question cancel dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @return the result
	 */
	public static QuestionCancelResult openQuestionCancelDialog(
			@Nullable Window parent, @NonNull String title,
			@NonNull String message, @NonNull QuestionCancelResult defaultValue) {
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

		return QuestionCancelResult.fromIndex(new MessageDialog(parent, title,
				message, Type.QUESTION, idx, 2, Messages.getString("MessageDialog.Yes"), Messages.getString("MessageDialog.No"), Messages.getString("MessageDialog.Cancel")).open()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Open confirm dialog who blocks until closed with default {@link ConfirmResult#OK}
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @return the result
	 */
	public static ConfirmResult openConfirmDialog(@Nullable Window parent, @NonNull String title,
			@NonNull String message) {
		return openConfirmDialog(parent, title, message, ConfirmResult.OK);
	}

	/**
	 * Open confirmation dialog who blocks until closed
	 * 
	 * @param parent
	 *            the parent
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @return the result
	 */
	public static ConfirmResult openConfirmDialog(@Nullable Window parent, @NonNull String title,
			@NonNull String message, @NonNull ConfirmResult defaultValue) {
		return ConfirmResult.fromIndex(new MessageDialog(parent, title,
				message, Type.CONFIRM,
				defaultValue == ConfirmResult.OK ? 0 : 1, 1, Messages.getString("MessageDialog.Ok"), Messages.getString("MessageDialog.Cancel")) //$NON-NLS-1$ //$NON-NLS-2$
				.open());
	}
}
