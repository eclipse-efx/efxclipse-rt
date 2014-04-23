/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.swt.e4;

import javafx.scene.layout.BorderPane;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.FX_SWT;

public class FXToSWTAdapterFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		BorderPane p = context.get(BorderPane.class);
		return FX_SWT.new_Composite(p);
	}
}
