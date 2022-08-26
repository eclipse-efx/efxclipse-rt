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
package org.eclipse.fx.emf.edit.ui;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.jdt.annotation.NonNull;

/**
 * This list cell factory wraps an {@link AdapterFactory} and delegates calls to its {@link TableCell}s to the
 * corresponding adapter-implemented item provider interfaces.
 * 
 * <ul>
 * <li>{@link Cell#setText(String)} and {@link Cell#setGraphic(Node)} are delegated to
 * {@link ITableItemLabelProvider}</li>
 * <li>{@link Cell#setTextFill(javafx.scene.paint.Paint)} and the CSS property
 * <code>-fx-background-color</code> are delegated to {@link ITableItemColorProvider}</li>
 * <li>{@link Cell#setFont(javafx.scene.text.Font)} is delegated to {@link ITableItemFontProvider}</li>
 * </ul>
 * 
 * @param <S>
 *            the row type
 * @param <T>
 *            the cell type
 */
public class AdapterFactoryTableCellFactory<S, T> extends AdapterFactoryCellFactory implements Callback<TableColumn<S, T>, TableCell<S, T>> {

	/**
	 * The cells column index
	 */
	protected int columnIndex;

	/**
	 * Create an instance of a column
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 * @param columnIndex
	 *            the column index
	 */
	public AdapterFactoryTableCellFactory(@NonNull AdapterFactory adapterFactory, int columnIndex) {
		super(adapterFactory);
		this.columnIndex = columnIndex;
	}

	@Override
	@SuppressWarnings("unchecked")
	public TableCell<S, T> call(TableColumn<S, T> arg0) {

		final TableCell<Object, Object> tableCell = new TableCell<Object, Object>() {

			Object currentItem = null;
			ICellEditHandler cellEditHandler;

			AdapterImpl adapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					update(msg.getNotifier());
				}
			};

			@Override
			protected void updateItem(Object item, boolean empty) {
				super.updateItem(item, empty);

				// check if the item changed
				if (item != this.currentItem) {

					// remove the adapter if attached
					if (this.currentItem instanceof Notifier)
						((Notifier) this.currentItem).eAdapters().remove(this.adapter);

					// update the current item
					this.currentItem = item;

					// attach the adapter to the new item
					if (this.currentItem instanceof Notifier)
						((Notifier) this.currentItem).eAdapters().add(this.adapter);
				}

				// notify the listeners
				for (ICellUpdateListener cellUpdateListener : AdapterFactoryTableCellFactory.this.cellUpdateListeners)
					cellUpdateListener.updateItem(this, item, empty);

				update(item);
			}

			@Override
			public void startEdit() {
				super.startEdit();
				this.cellEditHandler = getCellEditHandler(this);
				if (this.cellEditHandler != null)
					this.cellEditHandler.startEdit(this);
			}

			@Override
			public void commitEdit(Object newValue) {
				super.commitEdit(newValue);
				if (this.cellEditHandler != null)
					this.cellEditHandler.commitEdit(this, newValue);
			}

			@Override
			public void cancelEdit() {
				super.cancelEdit();
				if (this.cellEditHandler != null)
					this.cellEditHandler.cancelEdit(this);
				update(getItem());
			}

			void update(Object item) {
				if (Platform.isFxApplicationThread()) {
					updateOnFxThread(item);
				} else {
					Platform.runLater(() -> updateOnFxThread(item));
				}
			}

			private void updateOnFxThread(Object item) {
				applyTableItemProviderStyle(item, AdapterFactoryTableCellFactory.this.columnIndex, this, AdapterFactoryTableCellFactory.this.adapterFactory);
			}

		};

		for (ICellCreationListener cellCreationListener : this.cellCreationListeners)
			cellCreationListener.cellCreated(tableCell);

		return (TableCell<S, T>) tableCell;
	}

}
