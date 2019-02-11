/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

/**
 * Service to handle partial min-max parts
 * 
 * <p>
 * This is a provisional API and might change
 * </p>
 * 
 * @since 3.5
 * @noreference
 * @noimplement
 */
public interface PartialRestoreMinMaxService {
	/**
	 * Find the trimbar who holds the model element
	 * 
	 * @param modelService
	 *            the model service
	 * @param element
	 *            the element
	 * @param window
	 *            the window
	 * @return the trimbar
	 */
	public MTrimBar findTrimBarForElement(EModelService modelService, MUIElement element, MTrimmedWindow window);

	/**
	 * @return class representing a trim stack
	 */
	public Class<? extends TrimStack> getTrimStackType();

	/**
	 * A trim stack
	 */
	public interface TrimStack {
		/**
		 * Show the stack
		 * 
		 * @param visible
		 *            <code>true</code> to show the original stack
		 */
		void showStack(boolean visible);

		/**
		 * Restore the original stack on screen
		 */
		void restoreStack();
	}
}
