/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.hover.internal;

import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.hover.HoverPresenter;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DefaultHoverPresenter implements HoverPresenter {

	@Override
	public int getOrder() {
		return -1000;
	}

	@Override
	public boolean isApplicable(HoverInfo hover) {
		return true;
	}

	@Override
	public Node createHoverContent(HoverInfo hover) {
		HBox b = new HBox();
		b.setSpacing(10);

		Label icon = new Label();
		icon.setText("*");

		Label content = new Label();
		content.setText(hover.getHoverText());

		b.getChildren().setAll(icon, content);

		return b;
	}

}
