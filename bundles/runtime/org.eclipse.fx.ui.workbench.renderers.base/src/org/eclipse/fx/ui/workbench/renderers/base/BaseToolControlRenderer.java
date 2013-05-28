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
package org.eclipse.fx.ui.workbench.renderers.base;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolControl;


public abstract class BaseToolControlRenderer<N> extends BaseRenderer<MToolControl, WToolControl<N>> {
	@Override
	protected void doProcessContent(MToolControl element) {
		// no child
	}

	@Override
	public void childRendered(MToolControl parentElement, MUIElement element) {
		// no child		
	}

	@Override
	public void hideChild(MToolControl container, MUIElement changedObj) {
		// no child		
	}
}