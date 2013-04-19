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
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicFactoryImpl;

@SuppressWarnings("restriction")
public class PinToBottom {
	public void pin(MPart part) {
		MElementContainer<MUIElement> parent = part.getParent();
		MPartSashContainer sashContainer = (MPartSashContainer) ((MUIElement)parent.getParent());
		parent.getChildren().remove(part);
		
		MPartStack stack = BasicFactoryImpl.eINSTANCE.createPartStack();
		stack.getChildren().add(part);
		stack.setContainerData("0.3");
		stack.setSelectedElement(part);
		sashContainer.getChildren().add(stack);
	}
}
