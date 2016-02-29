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
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarSeparator;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBarSeparator;

/**
 * Base renderer for {@link MToolBarSeparator}
 *
 * @param <N>
 *            the native widget type
 */
public abstract class BaseToolBarSeparatorRenderer<N> extends BaseRenderer<MToolBarSeparator, WToolBarSeparator<N>> {

	@Override
	protected void doProcessContent(MToolBarSeparator element) {
		// there is no content
	}

	@Override
	public void childRendered(MToolBarSeparator parentElement, MUIElement element) {
		// there is no content
	}

	@Override
	public void hideChild(MToolBarSeparator container, MUIElement changedObj) {
		// there is no content
	}

}
