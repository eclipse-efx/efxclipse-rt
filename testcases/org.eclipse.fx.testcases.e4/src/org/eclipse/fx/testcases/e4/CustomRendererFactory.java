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
package org.eclipse.fx.testcases.e4;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.workbench.renderers.fx.DefWorkbenchRendererFactory;
import org.eclipse.jdt.annotation.NonNull;

public class CustomRendererFactory extends DefWorkbenchRendererFactory {
	@Inject
	public CustomRendererFactory(@NonNull IEclipseContext context) {
		super(context);
	}

//	@Override
//	protected Class<? extends BaseMenuRenderer<?>> getMenuRendererClass() {
//		return MyDefMenuRenderer.class;
//	}
}
