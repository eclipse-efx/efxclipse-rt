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
