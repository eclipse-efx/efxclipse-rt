/*******************************************************************************
 * Copyright (c) 2009, 2010 Siemens AG and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Kai T??dter - initial implementation
 ******************************************************************************/

package org.eclipse.fx.demo.contacts.handlers;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.fx.demo.contacts.model.ContactsManager;

@SuppressWarnings("restriction")
public class CutHandler {

	ContactsManager contactsManager;
	Command command;

	@Inject
	public CutHandler(ContactsManager contactsManager) {
		this.contactsManager = contactsManager;
	}

	@CanExecute
	public boolean canExecute(@Optional List<?> selection) {
		if (selection != null) {
			command = CutToClipboardCommand.create(contactsManager.getEditingDomain(), selection);
			return command.canExecute();
		}
		return false;
	}

	@Execute
	public void execute() {
		if (command != null && command.canExecute())
			contactsManager.getEditingDomain().getCommandStack().execute(command);
	}

}
