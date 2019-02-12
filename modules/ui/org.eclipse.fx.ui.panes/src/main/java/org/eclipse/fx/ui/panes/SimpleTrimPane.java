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
package org.eclipse.fx.ui.panes;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

/**
 * A simple implementation of a {@link TrimPane} based upon a {@link BorderPane}
 * 
 * @since 3.5.0
 */
public class SimpleTrimPane extends BorderPane implements TrimPane {
	@Override
	public Region getPane() {
		return this;
	}
}
