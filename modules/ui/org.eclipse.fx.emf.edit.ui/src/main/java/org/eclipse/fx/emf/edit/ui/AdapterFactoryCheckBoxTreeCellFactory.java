/*******************************************************************************
 * Copyright (c) 2015 EM-SOFTWARE and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jdt.annotation.NonNull;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.util.Callback;

/**
 * This {@link CheckBoxTreeCell} factory wraps an {@link AdapterFactory} and delegates calls to its {@link TreeCell}s
 * to the corresponding adapter-implemented item provider interfaces.
 * 
 * <ul>
 * <li>{@link Cell#setText(String)} and {@link Cell#setGraphic(Node)} are delegated to
 * {@link IItemLabelProvider}</li>
 * <li>{@link Cell#setTextFill(javafx.scene.paint.Paint)} and the CSS property
 * <code>-fx-background-color</code> are delegated to {@link IItemColorProvider}</li>
 * <li>{@link Cell#setFont(javafx.scene.text.Font)} is delegated to {@link IItemFontProvider}</li>
 * </ul>
 * 
 * @param <T> The type of the item contained within the {@link TreeItem} value
 */
public class AdapterFactoryCheckBoxTreeCellFactory<T> extends AdapterFactoryCellFactory implements Callback<TreeView<T>, TreeCell<T>> {

	/**
	 * Create a new tree factory
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public AdapterFactoryCheckBoxTreeCellFactory(@NonNull AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public TreeCell<T> call(TreeView<T> param) {

		final CheckBoxTreeCell<T> treeCell = new CheckBoxTreeCell<T>() {

			Object currentItem = null;
			ICellEditHandler cellEditHandler;

			AdapterImpl adapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					update(msg.getNotifier());
				}
			};

			@Override
			public void startEdit() {
				super.startEdit();
				this.cellEditHandler = getCellEditHandler(this);
				if (this.cellEditHandler != null)
					this.cellEditHandler.startEdit(this);
			}

			@Override
			public void commitEdit(T newValue) {
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

			@Override
			public void updateItem(T item, boolean empty) {
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
				for (ICellUpdateListener cellUpdateListener : AdapterFactoryCheckBoxTreeCellFactory.this.cellUpdateListeners)
					cellUpdateListener.updateItem(this, item, empty);

				update(item);
			}

			void update(Object item) {
				if (Platform.isFxApplicationThread()) {
					updateOnFxThread(item);
				} else {
					Platform.runLater(() -> updateOnFxThread(item));
				}
			}

			private void updateOnFxThread(Object item) {
				if (item != null)
					applyItemProviderStyle(item, this, AdapterFactoryCheckBoxTreeCellFactory.this.adapterFactory);
				else {
					setText(null);
					setGraphic(null);
				}
			}

		};

		for (ICellCreationListener cellCreationListener : this.cellCreationListeners)
			cellCreationListener.cellCreated(treeCell);

		return treeCell;
	}

}
