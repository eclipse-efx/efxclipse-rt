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
