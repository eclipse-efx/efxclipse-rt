/*******************************************************************************
 * Copyright (c) 2015 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/

package org.eclipse.fx.runtime.swt.e4.internal;

import javafx.stage.Stage;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTActiveShellFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		Object active = context.get(IServiceConstants.ACTIVE_SHELL);
		if (active != null && active instanceof Stage) {
			UISynchronize uiSynchronize = context.get(UISynchronize.class);
			Shell result = uiSynchronize.syncExec(() -> {
				return new Shell((Stage)active);
			}, null);
			return result;
		}
		return Display.getCurrent().getActiveShell();
	}
}
