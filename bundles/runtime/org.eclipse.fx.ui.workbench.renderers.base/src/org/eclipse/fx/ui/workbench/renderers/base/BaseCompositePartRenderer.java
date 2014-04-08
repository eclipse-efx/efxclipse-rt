/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCompositePart;

/**
 * Base renderer for {@link MCompositePart}
 * 
 * @param <N>
 *            the native widget
 */
public abstract class BaseCompositePartRenderer<N> extends BaseRenderer<MCompositePart, WCompositePart<N>> {

	@Override
	protected void doProcessContent(MCompositePart element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void childRendered(MCompositePart parentElement, MUIElement element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideChild(MCompositePart container, MUIElement changedObj) {
		// TODO Auto-generated method stub

	}

}
