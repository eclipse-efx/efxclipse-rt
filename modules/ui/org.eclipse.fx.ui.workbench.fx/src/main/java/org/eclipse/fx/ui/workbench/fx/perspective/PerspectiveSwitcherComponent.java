/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.fx.perspective;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;

import javafx.scene.Group;

/**
 * Component who can be embedded as a {@link MToolControl}
 */
public class PerspectiveSwitcherComponent {
	@SuppressWarnings("static-method")
	@PostConstruct
	void init(Group group, IEclipseContext context) {
		group.getChildren().add(ContextInjectionFactory.make(PerspectiveSwitcherNode.class, context));
	}


}
