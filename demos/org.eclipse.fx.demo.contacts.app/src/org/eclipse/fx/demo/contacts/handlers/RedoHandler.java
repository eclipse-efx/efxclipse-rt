/*******************************************************************************
 * Copyright (c) 2009 Siemens AG and others.
 * 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
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
public class RedoHandler {
	
	@Inject
	ContactsManager contactsManager;

	@CanExecute
	public boolean canUndo() {
		CommandStack commandStack = contactsManager.getEditingDomain().getCommandStack();
		return commandStack.canRedo();
	}

	@Execute
	public void undo() {
		CommandStack commandStack = contactsManager.getEditingDomain().getCommandStack();
		if (commandStack.canRedo())
			commandStack.redo();
	}
}
