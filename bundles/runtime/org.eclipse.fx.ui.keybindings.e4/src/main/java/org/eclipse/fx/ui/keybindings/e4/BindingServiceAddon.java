/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.eclipse.fx.ui.keybindings.e4;

import javax.annotation.PostConstruct;

import org.eclipse.core.commands.contexts.ContextManager;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.keybindings.e4.internal.BindingServiceCreationFunction;
import org.eclipse.fx.ui.keybindings.e4.internal.BindingTableManager;
import org.eclipse.fx.ui.keybindings.e4.internal.ContextSet;

/**
 * Provide the binding and context id services as an add-on. Must be
 * instantiated against the application level context.
 */
public class BindingServiceAddon {
	@SuppressWarnings("static-method")
	@PostConstruct
	void init(IEclipseContext context) {
		ContextManager contextManager = context.get(ContextManager.class);
		ContextSet.setComparator(new ContextSet.CComp(contextManager));

		context.set(BindingTableManager.class, ContextInjectionFactory.make(BindingTableManager.class, context));

		context.set(EBindingService.class.getName(), new BindingServiceCreationFunction());
	}
}
