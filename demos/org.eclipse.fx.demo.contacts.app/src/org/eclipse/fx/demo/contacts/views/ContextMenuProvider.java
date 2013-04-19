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
package org.eclipse.fx.demo.contacts.views;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.demo.contacts.handlers.CopyHandler;
import org.eclipse.fx.demo.contacts.handlers.CutHandler;
import org.eclipse.fx.demo.contacts.handlers.DeleteContactHandler;
import org.eclipse.fx.demo.contacts.handlers.PasteHandler;
import org.eclipse.fx.demo.contacts.model.ContactsManager;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellUpdateListener;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Cell;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;

public class ContextMenuProvider implements ICellUpdateListener {

	ContactsManager contactsManager;
	private DeleteContactHandler deleteHandler;
	private MenuItem deleteMenuItem;
	CutHandler cutHandler;
	private MenuItem cutMenuItem;
	private CopyHandler copyHandler;
	private MenuItem copyMenuItem;
	private PasteHandler pasteHandler;
	private MenuItem pasteMenuItem;

	public ContextMenuProvider(ContactsManager contactsManager) {
		this.contactsManager = contactsManager;
	}

	static List<?> getSelectionModel(Cell<?> cell) {
		if (cell instanceof ListCell<?>) {
			return ((ListCell<?>) cell).getListView().getSelectionModel().getSelectedItems();
		} else if (cell instanceof TreeCell<?>) {
			MultipleSelectionModel<?> selectionModel = ((TreeCell<?>) cell).getTreeView().getSelectionModel();
			ObservableList<?> selectedItems = selectionModel.getSelectedItems();
			ArrayList<Object> unwrappedItems = new ArrayList<>(selectedItems.size());
			for (Object object : selectedItems) {
				TreeItem<?> treeItem = (TreeItem<?>) object;
				unwrappedItems.add(treeItem.getValue());
			}
			return unwrappedItems;
		} else if (cell instanceof TableCell<?, ?>) {
			return ((TableCell<?, ?>) cell).getTableView().getSelectionModel().getSelectedItems();
		} else if (cell instanceof TableRow<?>) {
			return ((TableRow<?>) cell).getTableView().getSelectionModel().getSelectedItems();
		}
		return null;
	}

	@Override
	public void updateItem(final Cell<?> cell, final Object item, boolean empty) {

		final ContextMenu contextMenu = new ContextMenu();
		cell.setContextMenu(contextMenu);
		contextMenu.getItems().add(new MenuItem());
		contextMenu.setOnShowing(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				List<?> selectedItems = getSelectionModel(cell);
				deleteMenuItem.setDisable(!deleteHandler.canExecute(selectedItems));
				cutMenuItem.setDisable(!cutHandler.canExecute(selectedItems));
				copyMenuItem.setDisable(!copyHandler.canExecute(selectedItems));
				
				Object item2 = cell.getItem();
				
				pasteMenuItem.setDisable(!pasteHandler.canExecute(item2));
				contextMenu.getItems().clear();
				contextMenu.getItems().add(deleteMenuItem);
				contextMenu.getItems().add(cutMenuItem);
				contextMenu.getItems().add(copyMenuItem);
				contextMenu.getItems().add(pasteMenuItem);
			}

		});

		deleteMenuItem = new MenuItem("Delete", getImage("icons/silk/cross.png"));
		deleteHandler = new DeleteContactHandler(contactsManager);
		deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteHandler.execute();
			}
		});

		cutMenuItem = new MenuItem("Cut", getImage("icons/silk/cut.png"));
		cutHandler = new CutHandler(contactsManager);
		cutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cutHandler.execute();
			}
		});

		copyMenuItem = new MenuItem("Copy", getImage("icons/silk/page_copy.png"));
		copyHandler = new CopyHandler(contactsManager);
		copyMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				copyHandler.execute();
			}
			
		});

		pasteMenuItem = new MenuItem("Paste", getImage("icons/silk/page_paste.png"));
		pasteHandler = new PasteHandler(contactsManager);
		pasteMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				pasteHandler.execute();
			}
			
		});
		
	}

	private ImageView getImage(String path) {
		try {
			URL url = new URL("platform:/plugin/org.eclipse.fx.demo.contacts.app/" + path);
			Image image = new Image(url.toExternalForm());
			return new ImageView(image);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
