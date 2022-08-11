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
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

/**
 * Pin the part to the bottom
 */
public class PinToBottom {

	/**
	 * Pin it
	 * 
	 * @param part
	 *            the part
	 * @param modelService
	 *            the model service
	 */
	@SuppressWarnings("static-method")
	public void pin(MPart part, EModelService modelService) {
		MElementContainer<MUIElement> parent = part.getParent();
		MPartSashContainer sashContainer = (MPartSashContainer) ((MUIElement) parent.getParent());
		parent.getChildren().remove(part);

		MPartStack stack = modelService.createModelElement(MPartStack.class);
		stack.getChildren().add(part);
		stack.setContainerData("0.3"); //$NON-NLS-1$
		stack.setSelectedElement(part);
		sashContainer.getChildren().add(stack);
	}
}
