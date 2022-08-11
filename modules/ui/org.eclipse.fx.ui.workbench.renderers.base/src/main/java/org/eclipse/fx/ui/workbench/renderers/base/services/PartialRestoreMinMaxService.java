/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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
	 * Tag to prevent an element to get maximized
	 */
	public static final String TAG_NOT_MAXIMIZABLE = "efx_notMaximizable"; //$NON-NLS-1$
	
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
	 * Check if the element supports partial restoring
	 * 
	 * @param element
	 *            the element
	 * @return <code>true</code> if partial restore is supported
	 */
	public boolean supportPartialRestore(MUIElement element);

	/**
	 * Check if the element support maximization
	 * 
	 * @param element
	 *            the element
	 * 
	 * @return <code>true</code> if min-max is supported
	 */
	public boolean isMaximizable(MUIElement element);

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
