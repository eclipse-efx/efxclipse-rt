/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.editor.e4.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.code.editor.Constants;

public class SaveFile {
	@CanExecute
	public boolean canSave(@Named(Constants.EDITOR_DIRTY_FLAG_KEY) @Optional Boolean dirtyFlag) {
		return Boolean.TRUE.equals(dirtyFlag);
	}

	@Execute
	public void save(MPart part, IEclipseContext context) {
		if( part.isDirty() ) {
			ContextInjectionFactory.invoke(part.getObject(), Persist.class,context);
		}
	}
}
