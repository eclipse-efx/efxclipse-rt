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
package org.eclipse.fx.emf.edit.ui.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellCreationListener;


import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * Allows to drag items from viewers backed by an {@link AdapterFactoryCellFactory} using a {@link LocalTransfer}.
 */
public class CellDragAdapter implements ICellCreationListener {

	@Override
	public void cellCreated(final Cell<?> treeCell) {

		treeCell.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				/* allow any transfer mode */
				Dragboard db = treeCell.startDragAndDrop(TransferMode.ANY);

				/* put a string on dummy content dragboard */
				ClipboardContent content = new ClipboardContent();
				content.putString("dummy content");
				db.setContent(content);

				MultipleSelectionModel<?> selectionModel = getSelectionModel(treeCell);
				ObservableList<?> selectedItems = selectionModel.getSelectedItems();

				List<Object> items = new ArrayList<>(selectedItems.size());

				for (Object item : selectedItems) {
					if (item instanceof TreeItem)
						items.add(((TreeItem<?>) item).getValue());
					else
						items.add(item);
				}

				LocalTransfer.INSTANCE.setObject(items);

				event.consume();
			}
		});

	}

	private MultipleSelectionModel<?> getSelectionModel(Cell<?> cell) {
		if (cell instanceof TreeCell)
			return ((TreeCell<?>) cell).getTreeView().getSelectionModel();
		else if (cell instanceof ListCell)
			return ((ListCell<?>) cell).getListView().getSelectionModel();
		else if (cell instanceof TableCell)
			return ((TableCell<?, ?>) cell).getTableView().getSelectionModel();

		throw new IllegalArgumentException("Unsupported Cell type");
	}

}
