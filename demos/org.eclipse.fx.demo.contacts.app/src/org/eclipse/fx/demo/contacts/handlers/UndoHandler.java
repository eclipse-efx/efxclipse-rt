/*******************************************************************************
 * Copyright (c) 2009 Siemens AG and others.
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


import javax.inject.Inject;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.fx.demo.contacts.model.ContactsManager;

@SuppressWarnings("restriction")
public class UndoHandler {
	
	@Inject
	ContactsManager contactsManager;
	
	@CanExecute
	public boolean canUndo() {
		CommandStack commandStack = contactsManager.getEditingDomain().getCommandStack();
		return commandStack.canUndo();
	}

	@Execute
	public void undo() {
		CommandStack commandStack = contactsManager.getEditingDomain().getCommandStack();
		if (commandStack.canUndo())
			commandStack.undo();
	}
	
}
