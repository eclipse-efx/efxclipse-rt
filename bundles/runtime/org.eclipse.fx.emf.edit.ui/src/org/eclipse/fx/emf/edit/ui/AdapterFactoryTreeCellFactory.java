/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui;

import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * This {@link TreeCell} factory wraps an {@link AdapterFactory} and delegates
 * calls to its {@link TreeCell}s to the corresponding adapter-implemented item
 * provider interfaces.
 * 
 * <ul>
 * <li>{@link Cell#setText(String)} and {@link Cell#setGraphic(Node)} are
 * delegated to {@link IItemLabelProvider}</li>
 * <li>{@link Cell#setTextFill(javafx.scene.paint.Paint)} and the CSS property
 * <code>-fx-background-color</code> are delegated to {@link IItemColorProvider}
 * </li>
 * <li>{@link Cell#setFont(javafx.scene.text.Font)} is delegated to
 * {@link IItemFontProvider}</li>
 * </ul>
 */
public class AdapterFactoryTreeCellFactory extends AdapterFactoryCellFactory implements Callback<TreeView<Object>, TreeCell<Object>> {

	public AdapterFactoryTreeCellFactory(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public TreeCell<Object> call(TreeView<Object> param) {

		final TreeCell<Object> treeCell = new TreeCell<Object>() {

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
				cellEditHandler = getCellEditHandler(this);
				if(cellEditHandler != null)
					cellEditHandler.startEdit(this);
			}

			@Override
			public void commitEdit(Object newValue) {
				super.commitEdit(newValue);
				if(cellEditHandler != null)
					cellEditHandler.commitEdit(this, newValue);
			}

			@Override
			public void cancelEdit() {
				super.cancelEdit();
				if(cellEditHandler != null)
					cellEditHandler.cancelEdit(this);
				update(getItem());
			}

			@Override
			protected void updateItem(Object item, boolean empty) {
				super.updateItem(item, empty);

				// check if the item changed
				if (item != currentItem) {

					// remove the adapter if attached
					if (currentItem instanceof Notifier)
						((Notifier) currentItem).eAdapters().remove(adapter);

					// update the current item
					currentItem = item;

					// attach the adapter to the new item
					if (currentItem instanceof Notifier)
						((Notifier) currentItem).eAdapters().add(adapter);
				}

				// notify the listeners
				for (ICellUpdateListener cellUpdateListener : cellUpdateListeners)
					cellUpdateListener.updateItem(this, item, empty);

				update(item);
			}

			private void update(Object item) {
				// setText(item == null ? "null" : item.toString());
				applyItemProviderStyle(item, this, adapterFactory);
			}

		};

		for (ICellCreationListener cellCreationListener : cellCreationListeners)
			cellCreationListener.cellCreated(treeCell);

		return treeCell;
	}

}
