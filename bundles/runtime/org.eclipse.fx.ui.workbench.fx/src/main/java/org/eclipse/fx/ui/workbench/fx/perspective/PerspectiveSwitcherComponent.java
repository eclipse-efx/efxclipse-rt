/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
