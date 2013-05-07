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

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.demo.contacts.ContactsPackage;
import org.eclipse.fx.demo.contacts.model.ContactsManager;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryListCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryObservableList;
import org.eclipse.fx.emf.edit.ui.EAttributeCellEditHandler;
import org.eclipse.fx.emf.edit.ui.dnd.CellDragAdapter;
import org.eclipse.fx.emf.edit.ui.dnd.EditingDomainCellDropAdapter;


@SuppressWarnings("restriction")
public class ContactsListView {

	@Inject
	public ContactsListView(BorderPane parent, final MApplication application, final ContactsManager contactsManager) {
		EditingDomain editingDomain = contactsManager.getEditingDomain();
		AdapterFactory adapterFactory = contactsManager.getAdapterFactory();
		
		ListView<Object> listView = new ListView<>();

		parent.setCenter(listView);

		listView.setItems(new AdapterFactoryObservableList<Object>(adapterFactory, contactsManager.getRootGroup()));
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		AdapterFactoryListCellFactory listCellFactory = new AdapterFactoryListCellFactory(adapterFactory);
		listCellFactory.addCellCreationListener(new CellDragAdapter());
		EditingDomainCellDropAdapter dropAdapter = new EditingDomainCellDropAdapter(editingDomain);
		dropAdapter.setFeedbackHandler(new CustomFeedbackHandler());
		listCellFactory.addCellCreationListener(dropAdapter);
		listView.setCellFactory(listCellFactory);
		
		// add edit support
		listView.setEditable(true);
		listCellFactory.addCellEditHandler(new EAttributeCellEditHandler(ContactsPackage.eINSTANCE.getGroup_Name(), editingDomain));

		// add the context menu
		ContextMenuProvider contextMenuProvider = new ContextMenuProvider(contactsManager);
		listCellFactory.addCellUpdateListener(contextMenuProvider);
		
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		listView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Object>() {

			@Override
			public void onChanged(Change<?> change) {
				application.getContext().set(List.class, change.getList());
			}

		});

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				application.getContext().set(Object.class, arg2);
			}

		});
	}

}
