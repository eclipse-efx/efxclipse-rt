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
import org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuSeparator;

/**
 * Base renderer for {@link MMenuSeparator}
 *
 * @param <N>
 *            the node type
 */
public abstract class BaseMenuSeparatorRenderer<N> extends BaseRenderer<MMenuSeparator, WMenuSeparator<N>> {

	@Override
	public void doProcessContent(MMenuSeparator element) {
		// nothing todo
	}

	@Override
	public void childRendered(MMenuSeparator parentElement, MUIElement element) {
		// nothing todo
	}

	@Override
	public void hideChild(MMenuSeparator container, MUIElement changedObj) {
		// nothing todo
	}
}
