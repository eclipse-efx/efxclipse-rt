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

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

/**
 * Action to detach a view
 */
public class DetachView {
	/**
	 * Detach the view
	 * 
	 * @param part
	 *            the part to detach
	 * @param modelService
	 *            the model service
	 */
	@SuppressWarnings("static-method")
	public void detach(MPart part, EModelService modelService) {
		modelService.detach(part, 20, 20, 400, 400);
	}
}
