/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.renderers.fx.services;

/**
 * Service who provides the type used to present the save dialogs for dirty parts
 *
 * @since 2.3.0
 */
public interface SaveDialogPresenterTypeProvider {
	/**
	 * @return the type
	 */
	public Class<? extends SaveDialogPresenter> getType();
}
