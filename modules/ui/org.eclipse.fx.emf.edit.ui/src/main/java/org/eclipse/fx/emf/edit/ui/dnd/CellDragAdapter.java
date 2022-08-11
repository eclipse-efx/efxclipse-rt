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
import java.util.List;

import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory;
import org.eclipse.fx.emf.edit.ui.CellUtil;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellCreationListener;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * Allows to drag items from viewers backed by an {@link AdapterFactoryCellFactory} using a
 * {@link LocalTransfer}.
 */
public class CellDragAdapter implements ICellCreationListener {

	@Override
	public void cellCreated(final Cell<?> cell) {

		cell.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				/* allow any transfer mode */
				Dragboard db = cell.startDragAndDrop(TransferMode.ANY);

				/* put a string on dummy content dragboard */
				ClipboardContent content = new ClipboardContent();
				content.putString("dummy content"); //$NON-NLS-1$
				db.setContent(content);

				MultipleSelectionModel<?> selectionModel = CellUtil.getSelectionModel(cell);
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

}
