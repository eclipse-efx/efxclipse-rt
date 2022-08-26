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
package org.eclipse.fx.code.compensator.project.jdt.menu;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ProjectService.MenuElement;
import org.eclipse.fx.core.di.Invoke;

public class NewModuleElement extends MenuElement {

	public NewModuleElement() {
		super("new-java-module", "New Module");
	}

	@Override
	public boolean applies(ProjectNavigatorItem item) {
		return true;
	}

	@Invoke
	public void run() {
		System.err.println("NEW MODULE");
	}
}
