/*******************************************************************************
 * Copyright (c) 2015 EM-SOFTWARE and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/

package org.eclipse.fx.runtime.swt.e4.internal;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Display;

public class FXToSWTDisplayFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return Display.getCurrent();
	}
}
