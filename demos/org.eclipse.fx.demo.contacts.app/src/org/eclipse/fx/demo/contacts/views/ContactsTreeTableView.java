/******************************************************************************* 
 * Copyright (c) 2013 TESIS DYNAware GmbH and others. 
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

import javafx.collections.ListChangeListener;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.demo.contacts.ContactsPackage;
import org.eclipse.fx.demo.contacts.model.ContactsManager;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeItem;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeTableCellFactory;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.TreeTableProxyCellValueFactory;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.fx.emf.edit.ui.dnd.EditingDomainCellDropAdapter;

@SuppressWarnings("restriction")
public class ContactsTreeTableView {

	@Inject
	@SuppressWarnings("unchecked")
	public ContactsTreeTableView(BorderPane parent, final MApplication application, final ContactsManager contactsManager) {
		EditingDomain editingDomain = contactsManager.getEditingDomain();
		AdapterFactory adapterFactory = contactsManager.getAdapterFactory();

		TreeTableView<Object> treeTableView = new TreeTableView<>();

		parent.setCenter(treeTableView);

		TreeTableColumn<Object, Object> nameColumn = new TreeTableColumn<>("Contact");
		TreeTableColumn<Object, Object> emailColumn = new TreeTableColumn<>("e-Mail");

		treeTableView.getColumns().addAll(nameColumn, emailColumn);

		CellDragAdapter dragAdapter = new CellDragAdapter();
		EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(editingDomain);
//		dropAdapter.setFeedbackHandler(new StyleClassFeedbackHandler());
		
		AdapterFactoryTreeTableCellFactory<Object, Object> firstNameCellFactory = new AdapterFactoryTreeTableCellFactory<>(adapterFactory, 0);
		firstNameCellFactory.addCellCreationListener(dragAdapter);
		firstNameCellFactory.addCellCreationListener(dropAdapter);
		nameColumn.setCellFactory(firstNameCellFactory);
		nameColumn.setSortable(false);
		nameColumn.setCellValueFactory(new TreeTableProxyCellValueFactory());

		AdapterFactoryTreeTableCellFactory<Object, Object> emailCellFactory = new AdapterFactoryTreeTableCellFactory<>(adapterFactory, 1);
		
		// add drag & drop support
		emailCellFactory.addCellCreationListener(dragAdapter);
		emailCellFactory.addCellCreationListener(dropAdapter);
		emailColumn.setCellFactory(emailCellFactory);
		
		emailColumn.setSortable(false);
		emailColumn.setCellValueFactory(new TreeTableProxyCellValueFactory());

		treeTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		treeTableView.setRoot(new AdapterFactoryTreeItem(contactsManager.getRootGroup(), adapterFactory));

		treeTableView.setShowRoot(false);
		
		// add edit support
		treeTableView.setEditable(true);
		emailCellFactory.addCellEditHandler(new EAttributeCellEditHandler(ContactsPackage.eINSTANCE.getContact_Email(), editingDomain));

		// add the context menu
		ContextMenuProvider contextMenuProvider = new ContextMenuProvider(contactsManager);
		firstNameCellFactory.addCellUpdateListener(contextMenuProvider);
		emailCellFactory.addCellUpdateListener(contextMenuProvider);

//		treeTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
//
//			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
//				if (newValue instanceof AdapterFactoryTreeItem) {
//					Object value = ((AdapterFactoryTreeItem) newValue).getValue();
//					if (value instanceof Contact)
//						application.getContext().set(Object.class, value);
//				}
//			}
//
//		});
		
		treeTableView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Object>() {

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

	}

}
