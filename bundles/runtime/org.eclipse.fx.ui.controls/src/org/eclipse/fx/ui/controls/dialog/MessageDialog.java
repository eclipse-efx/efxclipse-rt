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
package org.eclipse.fx.ui.controls.dialog;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.fx.ui.controls.stage.FrameEvent;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.jdt.annotation.NonNull;

import com.sun.javafx.tk.Toolkit;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Create a message dialog
 */
@SuppressWarnings("restriction")
public class MessageDialog extends Dialog {
	/**
	 * The message type
	 */
	public enum Type {
		/**
		 * A custom dialog
		 */
		CUSTOM, /**
				 * A question dialog
				 */
		QUESTION, /**
					 * An information dialog
					 */
		INFORMATION, /**
						 * A warning dialog
						 */
		WARNING, /**
					 * An error dialog
					 */
		ERROR, /**
				 * Confirmation dialog
				 */
		CONFIRM, /**
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
		YES(0), /**
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
		YES(0), /**
				 * No
				 */
		NO(1), /**
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
		OK(0), /**
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

	static class MessageDialogButton extends DialogButton {
		final int index;

		public MessageDialogButton(int index, @NonNull String label) {
			super(label);
			this.index = index;
		}

	}

	int index = 0;
	Function<MessageDialogButton, Boolean> buttonHandler;

	@SuppressWarnings("null")
	MessageDialog(@NonNull Function<@NonNull MessageDialogButton, @NonNull Boolean> buttonHandler, @NonNull String windowTitle, @NonNull String message, @NonNull Type type, String... dialogButtonLabels) {
		super(createDialogArea(type, message), windowTitle);
		this.buttonHandler = buttonHandler;

		getDialogPane().getButtonList().addAll(Stream.of(dialogButtonLabels).map(d -> new MessageDialogButton(this.index++, d)).collect(Collectors.toList()));
	}

	private static Node createDialogArea(@NonNull Type type, String message) {
		GridLayoutPane b = new GridLayoutPane();
		b.setHorizontalSpacing(20);
		b.setNumColumns(2);
		b.getStyleClass().add("efx-messagedialog-" + type.name().toLowerCase()); //$NON-NLS-1$

		ImageView view = new ImageView();
		view.getStyleClass().add("efx-messagedialog-icon"); //$NON-NLS-1$
		b.getChildren().add(view);

		Label l = new Label(message);
		l.getStyleClass().add("efx-messagedialog-message"); //$NON-NLS-1$

		b.getChildren().add(l);
		return b;
	}

	@Override
	protected void handleButtonPress(DialogButton button) {
		if (this.buttonHandler.apply((MessageDialogButton) button).booleanValue()) {
			close();
		}
	}

	static class OkDialog extends MessageDialog {
		@SuppressWarnings("null")
		public OkDialog(@NonNull String title, @NonNull String message, Type type) {
			super((b) -> Boolean.TRUE, title, message, Type.ERROR, DialogMessagesProvider.createDefaultRegistry(title).ok());
		}
	}

	/**
	 * An error dialog
	 */
	public static class ErrorDialog extends OkDialog {
		/**
		 * Create a new error dialog
		 * 
		 * @param title
		 *            the title
		 * @param message
		 *            the message
		 */
		public ErrorDialog(@NonNull String title, @NonNull String message) {
			super(title, message, Type.ERROR);
		}
	}

	/**
	 * Open an error dialog who blocks until closed
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param scenegraphAttacher
	 *            attaches the dialog in the scenegraph
	 */
	public static void openBlockingErrorDialog(@NonNull String title, @NonNull String message, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		ErrorDialog d = new ErrorDialog(title, message);
		scenegraphAttacher.accept(d);
		openBlocking(d);
	}

	private static void openBlocking(MessageDialog d) {
		String id = UUID.randomUUID().toString();
		d.addEventHandler(FrameEvent.CLOSED, (e) -> Toolkit.getToolkit().exitNestedEventLoop(id, null));
		Toolkit.getToolkit().enterNestedEventLoop(id);
	}

	/**
	 * An warning dialog
	 */
	public static class WarningDialog extends OkDialog {
		/**
		 * Create a new warning dialog
		 * 
		 * @param title
		 *            the title
		 * @param message
		 *            the message
		 */
		public WarningDialog(@NonNull String title, @NonNull String message) {
			super(title, message, Type.WARNING);
		}
	}

	/**
	 * Open a warning dialog who blocks until closed
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param scenegraphAttacher
	 *            attaches the dialog in the scenegraph
	 */
	public static void openWarningDialog(@NonNull String title, @NonNull String message, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		WarningDialog d = new WarningDialog(title, message);
		scenegraphAttacher.accept(d);
		openBlocking(d);
	}

	/**
	 * An information dialog
	 */
	public static class InformationDialog extends OkDialog {
		/**
		 * Create a new info dialog
		 * 
		 * @param title
		 *            the title
		 * @param message
		 *            the message
		 */
		public InformationDialog(@NonNull String title, @NonNull String message) {
			super(title, message, Type.WARNING);
		}
	}

	/**
	 * Open an information dialog who blocks until closed
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param scenegraphAttacher
	 *            attaches the dialog in the scenegraph
	 */
	public static void openInformationDialog(@NonNull String title, @NonNull String message, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		InformationDialog d = new InformationDialog(title, message);
		scenegraphAttacher.accept(d);
		openBlocking(d);
	}

	/**
	 * Open a question dialog who blocks until closed with default value
	 * {@link QuestionResult#YES}
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the mssage
	 * @param scenegraphAttacher
	 *            attaches the dialog in the scenegraph
	 * @return the result
	 */
	@NonNull
	public static QuestionResult openQuestionDialog(@NonNull String title, @NonNull String message, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		return openQuestionDialog(title, message, QuestionResult.YES, scenegraphAttacher);
	}

	/**
	 * Open a question dialog who blocks until closed
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @param scenegraphAttacher
	 *            attaches the dialog in the scenegraph
	 * @return the result
	 */
	@NonNull
	public static QuestionResult openQuestionDialog(@NonNull String title, @NonNull String message, @NonNull QuestionResult defaultValue, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		QuestionDialog d = new QuestionDialog(title, message);
		scenegraphAttacher.accept(d);
		openBlocking(d);
		return d.getResult();
	}

	/**
	 * A question dialog
	 */
	public static class QuestionDialog extends MessageDialog {
		@NonNull
		private QuestionResult result = QuestionResult.NO;

		/**
		 * Create a new question dialog
		 * 
		 * @param windowTitle
		 *            the window title
		 * @param message
		 *            the message
		 */
		@SuppressWarnings("null")
		public QuestionDialog(@NonNull String windowTitle, @NonNull String message) {
			super(b -> Boolean.FALSE, windowTitle, message, Type.QUESTION, DialogMessagesProvider.createDefaultRegistry(windowTitle).yes(), DialogMessagesProvider.createDefaultRegistry(windowTitle).no());
			this.buttonHandler = b -> {
				if (b.index == 0) {
					this.result = QuestionResult.YES;
				} else {
					this.result = QuestionResult.NO;
				}
				return Boolean.TRUE;
			};
		}

		/**
		 * @return the result
		 */
		public @NonNull QuestionResult getResult() {
			return this.result;
		}
	}

	/**
	 * Open an question cancel dialog who blocks until closed with default
	 * option {@link QuestionCancelResult#YES}
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param scenegraphAttacher
	 *            consumer responsible to attach the node to the scenegraph
	 * @return the result
	 */
	public static QuestionCancelResult openQuestionCancelDialog(@NonNull String title, @NonNull String message, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		return openQuestionCancelDialog(title, message, QuestionCancelResult.YES, scenegraphAttacher);
	}

	/**
	 * Open a question cancel dialog who blocks until closed
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @param scenegraphAttacher
	 *            consumer responsible to attach the node to the scenegraph
	 * @return the result
	 */
	public static QuestionCancelResult openQuestionCancelDialog(@NonNull String title, @NonNull String message, @NonNull QuestionCancelResult defaultValue, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		// int idx;
		//
		// switch (defaultValue) {
		// case CANCEL:
		// idx = 2;
		// break;
		// case NO:
		// idx = 1;
		// break;
		// default:
		// idx = 0;
		// break;
		// }
		QuestionCancelDialog d = new QuestionCancelDialog(title, message);
		scenegraphAttacher.accept(d);
		openBlocking(d);
		return d.getResult();
	}

	/**
	 * Dialog providing 3 options to the user:
	 * <ul>
	 * <li>Yes</li>
	 * <li>No</li>
	 * <li>Cancel</li>
	 * </ul>
	 */
	public static class QuestionCancelDialog extends MessageDialog {
		private QuestionCancelResult result = QuestionCancelResult.CANCEL;

		/**
		 * Create a new dialog
		 * 
		 * @param windowTitle
		 * @param message
		 */
		@SuppressWarnings("null")
		public QuestionCancelDialog(@NonNull String windowTitle, @NonNull String message) {
			super(e -> Boolean.FALSE, windowTitle, message, Type.QUESTION, DialogMessagesProvider.createDefaultRegistry(windowTitle).yes(), DialogMessagesProvider.createDefaultRegistry(windowTitle).no(), DialogMessagesProvider.createDefaultRegistry(windowTitle).cancel());
			this.buttonHandler = b -> {
				if (b.index == 0) {
					this.result = QuestionCancelResult.YES;
				} else if (b.index == 1) {
					this.result = QuestionCancelResult.NO;
				} else {
					this.result = QuestionCancelResult.CANCEL;
				}
				return Boolean.TRUE;
			};
		}

		/**
		 * @return the result of the dialog
		 */
		public QuestionCancelResult getResult() {
			return this.result;
		}
	}

	/**
	 * Open confirm dialog who blocks until closed with default
	 * {@link ConfirmResult#OK}
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param scenegraphAttacher
	 *            consumer responsible to attach the node to the scenegraph
	 * @return the result
	 */
	public static ConfirmResult openConfirmDialog(@NonNull String title, @NonNull String message, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		return openConfirmDialog(title, message, ConfirmResult.OK, scenegraphAttacher);
	}

	/**
	 * Open confirmation dialog who blocks until closed
	 *
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 * @param defaultValue
	 *            the default value
	 * @param scenegraphAttacher
	 *            consumer responsible to attach the node to the scenegraph
	 * @return the result
	 */
	public static ConfirmResult openConfirmDialog(@NonNull String title, @NonNull String message, @NonNull ConfirmResult defaultValue, @NonNull Consumer<@NonNull MessageDialog> scenegraphAttacher) {
		ConfirmDialog d = new ConfirmDialog(title, message);
		scenegraphAttacher.accept(d);
		openBlocking(d);
		return d.getResult();
	}

	/**
	 * A confirm dialog
	 */
	public static class ConfirmDialog extends MessageDialog {
		private ConfirmResult result = ConfirmResult.CANCEL;

		@SuppressWarnings("null")
		ConfirmDialog(@NonNull String windowTitle, @NonNull String message) {
			super(b -> Boolean.FALSE, windowTitle, message, Type.CONFIRM, DialogMessagesProvider.createDefaultRegistry(windowTitle).ok(), DialogMessagesProvider.createDefaultRegistry(windowTitle).cancel());
			this.buttonHandler = b -> {
				if (b.index == 0) {
					this.result = ConfirmResult.OK;
				} else {
					this.result = ConfirmResult.CANCEL;
				}
				return Boolean.TRUE;
			};
		}

		/**
		 * @return the result
		 */
		public ConfirmResult getResult() {
			return this.result;
		}
	}
}