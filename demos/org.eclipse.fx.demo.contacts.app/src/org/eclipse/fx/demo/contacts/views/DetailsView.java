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

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.model.ContactsManager;


@SuppressWarnings("restriction")
public class DetailsView {

	DetailsViewController controller;

	@Inject
	ContactsManager contactsManager;

	@Inject
	public DetailsView(BorderPane parent, final MApplication application) {

		URL location = getClass().getResource("details.fxml");

		FXMLLoader fxmlLoader = new FXMLLoader(location);
		controller = new DetailsViewController();
		fxmlLoader.setController(controller);

		Pane root = null;
		try {
			root = (Pane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		parent.setCenter(root);
	}

	@Inject
	public void setSelection(@Optional Object selectedItem) {
		Contact contact = selectedItem instanceof Contact ? (Contact) selectedItem : null;
		controller.updateBindings(contact, contactsManager.getEditingDomain());
	}

}
