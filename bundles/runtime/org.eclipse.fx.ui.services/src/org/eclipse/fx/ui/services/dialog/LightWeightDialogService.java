/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.dialog;

import org.eclipse.fx.ui.controls.stage.Frame;

import javafx.scene.Node;

/**
 * Service to open a lightweight dialog
 */
@SuppressWarnings("restriction")
public interface LightWeightDialogService {
	/**
	 * The modality scope
	 */
	public enum ModalityScope {
		// APPLICATION,
		/**
		 * Window modal
		 */
		WINDOW, /**
				 * Perspective modal
				 */
		PERSPECTIVE, /**
						 * Part modal
						 */
		PART
	}

	/**
	 * Open the given dialog class
	 *
	 * @param dialogClass
	 *            the dialog to open
	 * @param scope
	 *            the scope
	 * @return the dialog instance
	 */
	public <T extends Node & Frame> T openDialog(Class<T> dialogClass, ModalityScope scope);

	/**
	 * Open the given dialog instance in the given scope
	 *
	 * @param dialog
	 *            the dialog
	 * @param scope
	 *            the scope
	 */
	public <T extends Node & Frame> void openDialog(T dialog, ModalityScope scope);
}
