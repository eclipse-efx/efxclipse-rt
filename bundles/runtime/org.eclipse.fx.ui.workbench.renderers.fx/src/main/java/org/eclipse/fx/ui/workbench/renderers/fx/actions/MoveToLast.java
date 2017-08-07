/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.actions;

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

/**
 * Move part to last position
 */
public class MoveToLast {
	/**
	 * @param part
	 *            the part to move
	 */
	@SuppressWarnings("static-method")
	public void move(MPart part) {
		MElementContainer<MUIElement> parent = part.getParent();
		parent.getChildren().remove(part);
		parent.getChildren().add(part);
		parent.setSelectedElement(part);
	}
}
