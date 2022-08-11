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
package org.eclipse.fx.demo.contacts.views;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.demo.contacts.ContactsPackage;
import org.eclipse.fx.demo.contacts.model.ContactsManager;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryObservableList;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTableCellFactory;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.ProxyCellValueFactory;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.fx.emf.edit.ui.dnd.EditingDomainCellDropAdapter;


@SuppressWarnings("restriction")
public class ContactsTableView {

	@Inject
	public ContactsTableView(BorderPane parent, final MApplication application, final ContactsManager contactsManager) {
		EditingDomain editingDomain = contactsManager.getEditingDomain();
		AdapterFactory adapterFactory = contactsManager.getAdapterFactory();

		TableView<Object> tableView = new TableView<>();

		parent.setCenter(tableView);

		TableColumn<Object, Object> firstNameColumn = new TableColumn<>("First Name");
		TableColumn<Object, Object> lastNameColumn = new TableColumn<>("Last Name");

		tableView.getColumns().addAll(firstNameColumn, lastNameColumn);

		firstNameColumn.setCellValueFactory(new ProxyCellValueFactory<Object, Object>());
		AdapterFactoryTableCellFactory<Object, Object> firstNameCellFactory = new AdapterFactoryTableCellFactory<>(adapterFactory, 0);
		firstNameCellFactory.addCellCreationListener(new CellDragAdapter());
		firstNameCellFactory.addCellCreationListener(new EditingDomainCellDropAdapter(editingDomain));
		firstNameColumn.setCellFactory(firstNameCellFactory);
		firstNameColumn.setSortable(false);

		lastNameColumn.setCellValueFactory(new ProxyCellValueFactory<Object, Object>());
		AdapterFactoryTableCellFactory<Object, Object> lastNameCellFactory = new AdapterFactoryTableCellFactory<Object, Object>(
				adapterFactory, 1);
		lastNameCellFactory.addCellCreationListener(new CellDragAdapter());
		lastNameCellFactory.addCellCreationListener(new EditingDomainCellDropAdapter(editingDomain));
		lastNameColumn.setCellFactory(lastNameCellFactory);
		lastNameColumn.setSortable(false);

		tableView.setItems(new AdapterFactoryObservableList<Object>(adapterFactory, contactsManager.getRootGroup()));
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// add edit support
		tableView.setEditable(true);
		firstNameCellFactory.addCellEditHandler(new EAttributeCellEditHandler(ContactsPackage.eINSTANCE.getContact_FirstName(),
				editingDomain));
		lastNameCellFactory
				.addCellEditHandler(new EAttributeCellEditHandler(ContactsPackage.eINSTANCE.getContact_LastName(), editingDomain));

		// add the context menu
		ContextMenuProvider contextMenuProvider = new ContextMenuProvider(contactsManager);
		firstNameCellFactory.addCellUpdateListener(contextMenuProvider);
		lastNameCellFactory.addCellUpdateListener(contextMenuProvider);

		tableView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Object>() {

			@Override
			public void onChanged(Change<?> change) {
				application.getContext().set(List.class, change.getList());
			}

		});

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				application.getContext().set(Object.class, arg2);
			}

		});

	}

}
