/*******************************************************************************
 * Copyright (c) 2015 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.emf.edit.ui;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jdt.annotation.NonNull;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;

/**
 * This list cell factory wraps an {@link AdapterFactory} and delegates calls to its {@link CheckBoxListCell}s to the
 * corresponding adapter-implemented item provider interfaces.
 * 
 * <ul>
 * <li>{@link Cell#setText(String)} and {@link Cell#setGraphic(Node)} are delegated to
 * {@link IItemLabelProvider}</li>
 * <li>{@link Cell#setTextFill(javafx.scene.paint.Paint)} and the CSS property
 * <code>-fx-background-color</code> are delegated to {@link IItemColorProvider}</li>
 * <li>
 * {@link Cell#setFont(javafx.scene.text.Font)} is delegated to {@link IItemFontProvider}</li>
 * </ul>
 * 
 * @param <T> The type of the item contained within the {@link ListView} value
 */
public class AdapterFactoryCheckBoxListCellFactory<T> extends AdapterFactoryCellFactory implements Callback<@NonNull ListView<T>, @NonNull ListCell<T>> {

	private Callback<T, ObservableValue<Boolean>> getSelectedProperty;

	/**
	 * Create a new adapter factory for list cells
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 * @param getSelectedProperty
	 *            A {@link Callback} that will return an
	 *            {@code ObservableValue<Boolean>} given an item from the
	 *            ListView
	 * 
	 */
	public AdapterFactoryCheckBoxListCellFactory(@NonNull AdapterFactory adapterFactory, Callback<T, ObservableValue<Boolean>> getSelectedProperty) {
		super(adapterFactory);
		this.getSelectedProperty = getSelectedProperty;
	}

	@Override
	public ListCell<T> call(@NonNull ListView<T> param) {

		final CheckBoxListCell<T> listCell = new CheckBoxListCell<T>(this.getSelectedProperty) {

			Object currentItem = null;
			ICellEditHandler cellEditHandler;

			AdapterImpl adapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					update(msg.getNotifier());
				}
			};

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
				for (ICellUpdateListener cellUpdateListener : AdapterFactoryCheckBoxListCellFactory.this.cellUpdateListeners)
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

			void update(Object item) {
				if (Platform.isFxApplicationThread()) {
					updateOnFxThread(item);
				} else {
					Platform.runLater(() -> updateOnFxThread(item));
				}
			}

			private void updateOnFxThread(Object item) {
				applyItemProviderStyle(item, this, AdapterFactoryCheckBoxListCellFactory.this.adapterFactory);
			}

		};

		for (ICellCreationListener cellCreationListener : this.cellCreationListeners)
			cellCreationListener.cellCreated(listCell);

		return listCell;
	}

}
