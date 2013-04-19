/*******************************************************************************
 * Copyright (c) 2009, 2010 Siemens AG and others.
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Kai T��dter - initial implementation
 ******************************************************************************/

package org.eclipse.fx.demo.contacts.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsFactory;
import org.eclipse.fx.demo.contacts.ContactsPackage;
import org.eclipse.fx.demo.contacts.model.ContactsManager;


@SuppressWarnings("restriction")
public class AddContactHandler {

	@Inject
	ContactsManager contactsManager;

	@Execute
	void execute() {
		Contact contact = ContactsFactory.eINSTANCE.createContact();
		Command command = AddCommand.create(contactsManager.getEditingDomain(), contactsManager.getRootGroup(), ContactsPackage.Literals.GROUP__CONTACTS, contact); 
		if (command != null && command.canExecute())
			contactsManager.getEditingDomain().getCommandStack().execute(command);
	}

}
