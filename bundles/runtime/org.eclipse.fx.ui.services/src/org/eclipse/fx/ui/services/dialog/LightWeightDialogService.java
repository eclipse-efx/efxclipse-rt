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

public interface LightWeightDialogService {
	public enum ModalityScope {
		// APPLICATION,
		WINDOW,
		PERSPECTIVE,
		PART
	}
	
	public <T extends Node & Frame> T openDialog(Class<T> dialogClass, ModalityScope scope);
	public <T extends Node & Frame> void openDialog(T dialog, ModalityScope scope);
}
