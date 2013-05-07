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

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsPackage;
import org.eclipse.fx.demo.contacts.model.ContactsManager;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeItem;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.fx.emf.edit.ui.dnd.EditingDomainCellDropAdapter;


@SuppressWarnings("restriction")
public class ContactsTreeView {

	@Inject
	public ContactsTreeView(BorderPane parent, final MApplication application, final ContactsManager contactsManager) {
		EditingDomain editingDomain = contactsManager.getEditingDomain();

		// TreeView
		TreeView<Object> treeView = new TreeView<>();
		treeView.setRoot(new AdapterFactoryTreeItem(contactsManager.getRootGroup(), treeView, contactsManager.getAdapterFactory()));
		AdapterFactoryTreeCellFactory treeCellFactory = new AdapterFactoryTreeCellFactory(contactsManager.getAdapterFactory());

		// add edit support
		treeCellFactory.addCellEditHandler(new EAttributeCellEditHandler(ContactsPackage.eINSTANCE.getGroup_Name(), editingDomain));

		// adds drag support
		treeCellFactory.addCellCreationListener(new CellDragAdapter());

		// adds drop support
		EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(editingDomain);
		dropAdapter.setFeedbackHandler(new CustomFeedbackHandler());
		treeCellFactory.addCellCreationListener(dropAdapter);

		treeView.setCellFactory(treeCellFactory);

		parent.setCenter(treeView);

		treeView.setShowRoot(false);
		
		treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				if (arg2 instanceof AdapterFactoryTreeItem) {
					Object value = ((AdapterFactoryTreeItem) arg2).getValue();
					if (value instanceof Contact)
						application.getContext().set(Object.class, value);
				}
			}

		});
		
		treeView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Object>() {

			@Override
			public void onChanged(Change<?> change) {
				ArrayList<Object> selection = new ArrayList<Object>();
				for (Object item : change.getList()) {
					if (item instanceof AdapterFactoryTreeItem) {
						Object value = ((AdapterFactoryTreeItem) item).getValue();
						selection.add(value);
					}
				}
				application.getContext().set(List.class, selection);
			}
			
		});
		
		// add the context menu
		ContextMenuProvider contextMenuProvider = new ContextMenuProvider(contactsManager);
		treeCellFactory.addCellUpdateListener(contextMenuProvider);

		treeView.setEditable(true);
	}
}
