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
package org.eclipse.fx.ui.workbench.fx.internal;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.fx.ui.services.menu.MenuService;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

/**
 * {@link ContextFunction} to create an instance of {@link MenuService}
 */
@Component(service = IContextFunction.class, property = "service.context.key=org.eclipse.fx.ui.services.menu.MenuService")
public class MenuServiceCF extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		return ContextInjectionFactory.make(MenuServiceImpl.class, context);
	}

	static class MenuServiceImpl implements MenuService {
		@Inject
		private EMenuService eMenuService;

		@Override
		public boolean registerContextMenu(@NonNull Object parent, @NonNull String menuId) {
			return this.eMenuService.registerContextMenu(parent, menuId);
		}
	}
}

