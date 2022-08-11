/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui.dnd;

import java.util.ArrayList;
import java.util.Collection;

import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellCreationListener;
import org.eclipse.fx.emf.edit.ui.CellUtil;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Allows to drop items into viewers backed by an {@link AdapterFactoryCellFactory} using a
 * {@link LocalTransfer}.
 */
public class EditingDomainCellDropAdapter implements ICellCreationListener {

	/**
	 * Handles the feedback to Drag &amp; Drop events by styling or otherwise modifying the affected {@link Cell}
	 */
	public interface IDnDFeedbackHandler {

		/**
		 * insert before feedback
		 * 
		 * @param cell
		 *            the cell
		 */
		void onFeedbackInsertBefore(Cell<?> cell);

		/**
		 * insert after feedback
		 * 
		 * @param cell
		 *            the cell
		 */
		void onFeedbackInsertAfter(Cell<?> cell);

		/**
		 * select feedback
		 * 
		 * @param cell
		 *            the cell
		 */
		void onFeedbackSelect(Cell<?> cell);

		/**
		 * no feedback
		 * 
		 * @param cell
		 *            the cell
		 */
		void onFeedbackNone(Cell<?> cell);

	}

	final EditingDomain editingDomain;
	Command dndCommand;
	@NonNull
	IDnDFeedbackHandler feedbackHandler = new DefaultFeedbackHandler();

	/**
	 * Create a new drop adapter
	 * 
	 * @param editingDomain
	 *            the editing domain
	 */
	public EditingDomainCellDropAdapter(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * @return the feedback
	 */
	@NonNull
	public IDnDFeedbackHandler getFeedbackHandler() {
		return this.feedbackHandler;
	}

	/**
	 * Setting a new feedback handler
	 * 
	 * @param feedbackHandler
	 *            the handler
	 */
	public void setFeedbackHandler(IDnDFeedbackHandler feedbackHandler) {
		if (feedbackHandler == null)
			throw new IllegalArgumentException("The feeback handler cannot be null"); //$NON-NLS-1$

		this.feedbackHandler = feedbackHandler;
	}

	@Override
	public void cellCreated(final Cell<?> cell) {

		cell.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				Object item = cell.getItem();

				Cell<?> node = CellUtil.getRowNode(cell);

				double y = event.getY();
				double height = cell.getLayoutBounds().getHeight();

				float position = (float) (y / height);

				Object object = LocalTransfer.INSTANCE.getObject();

				Command command = DragAndDropCommand.create(EditingDomainCellDropAdapter.this.editingDomain, item, position, DragAndDropFeedback.DROP_MOVE | DragAndDropFeedback.DROP_LINK, DragAndDropFeedback.DROP_MOVE,
						(Collection<?>) object);

				if (command.canExecute()) {
					EditingDomainCellDropAdapter.this.dndCommand = command;

					if (command instanceof DragAndDropFeedback) {
						DragAndDropFeedback dndFeedback = (DragAndDropFeedback) command;
						int feedback = dndFeedback.getFeedback();

						if ((feedback & DragAndDropFeedback.FEEDBACK_INSERT_BEFORE) != 0)
							EditingDomainCellDropAdapter.this.feedbackHandler.onFeedbackInsertBefore(node);
						else if ((feedback & DragAndDropFeedback.FEEDBACK_INSERT_AFTER) != 0)
							EditingDomainCellDropAdapter.this.feedbackHandler.onFeedbackInsertAfter(node);
						else if ((feedback & DragAndDropFeedback.FEEDBACK_SELECT) != 0)
							EditingDomainCellDropAdapter.this.feedbackHandler.onFeedbackSelect(node);
						else
							EditingDomainCellDropAdapter.this.feedbackHandler.onFeedbackNone(node);

						if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) { //$NON-NLS-1$ //$NON-NLS-2$
							event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
						} else {
							ArrayList<TransferMode> modes = new ArrayList<>();

							if ((feedback & DragAndDropFeedback.DROP_COPY) != 0)
								modes.add(TransferMode.COPY);
							if ((feedback & DragAndDropFeedback.DROP_LINK) != 0)
								modes.add(TransferMode.LINK);
							if ((feedback & DragAndDropFeedback.DROP_MOVE) != 0)
								modes.add(TransferMode.MOVE);

							event.acceptTransferModes(modes.toArray(new TransferMode[modes.size()]));
						}
					}

				} else {
					EditingDomainCellDropAdapter.this.dndCommand = null;
					EditingDomainCellDropAdapter.this.feedbackHandler.onFeedbackNone(node);
				}

			}

		});

		cell.setOnDragExited(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				EditingDomainCellDropAdapter.this.feedbackHandler.onFeedbackNone(CellUtil.getRowNode(cell));
			}

		});

		cell.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				if (EditingDomainCellDropAdapter.this.dndCommand != null)
					EditingDomainCellDropAdapter.this.editingDomain.getCommandStack().execute(EditingDomainCellDropAdapter.this.dndCommand);

				event.setDropCompleted(true);
				event.consume();
			}
		});
	}

	/**
	 * This default implementation of {@link IDnDFeedbackHandler} adds a red line where the dragged
	 * {@link Cell} can be dropped.
	 */
	public static class DefaultFeedbackHandler implements IDnDFeedbackHandler {

		@Override
		public void onFeedbackInsertBefore(Cell<?> cell) {
			cell.setStyle("-fx-border-color: red transparent transparent transparent;"); //$NON-NLS-1$
		}

		@Override
		public void onFeedbackInsertAfter(Cell<?> cell) {
			cell.setStyle("-fx-border-color: transparent transparent red transparent;"); //$NON-NLS-1$
		}

		@Override
		public void onFeedbackSelect(Cell<?> cell) {
			cell.setStyle("-fx-border-color: transparent;"); //$NON-NLS-1$
		}

		@Override
		public void onFeedbackNone(Cell<?> cell) {
			cell.setStyle("-fx-border-color: transparent;"); //$NON-NLS-1$
		}

	}

}
