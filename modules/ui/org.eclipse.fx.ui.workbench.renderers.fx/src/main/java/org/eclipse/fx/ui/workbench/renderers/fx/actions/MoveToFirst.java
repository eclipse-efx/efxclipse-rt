/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.renderers.fx.actions;

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

/**
 * Move part on the first position in the stack
 */
public class MoveToFirst {
	/**
	 * Move to the first position
	 * 
	 * @param part
	 *            the part
	 */
	@SuppressWarnings("static-method")
	public void move(final MPart part) {
		final MElementContainer<MUIElement> parent = part.getParent();
		parent.getChildren().remove(part);
		parent.getChildren().add(0, part);
	}
}
