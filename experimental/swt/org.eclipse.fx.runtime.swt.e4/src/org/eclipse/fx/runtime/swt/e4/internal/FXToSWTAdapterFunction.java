/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.swt.e4.internal;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.FX_SWT;

public class FXToSWTAdapterFunction extends ContextFunction {
	
	@Override
	public Object compute(IEclipseContext context) {
		BorderPane borderPane = context.get(BorderPane.class);
		if (borderPane != null)
			return FX_SWT.new_Composite(borderPane);
		AnchorPane anchorPane = context.get(AnchorPane.class);
		if (anchorPane != null)
			return FX_SWT.new_Composite(anchorPane);
		Group group = context.get(Group.class);
		if (group != null)
			return FX_SWT.new_Composite(group);
		HBox hbox = context.get(HBox.class);
		if (hbox != null)
			return FX_SWT.new_Composite(hbox);
		throw new NullPointerException("Could not create SWT Composite wrapper");
	}
	
}
