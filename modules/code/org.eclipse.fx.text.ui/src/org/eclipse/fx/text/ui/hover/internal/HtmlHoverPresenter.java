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
import org.eclipse.fx.text.hover.HtmlString;
import org.eclipse.fx.text.ui.hover.HoverPresenter;
import org.eclipse.fx.text.ui.internal.SimpleHtmlViewer;

import javafx.scene.Node;


@SuppressWarnings("javadoc")
public class HtmlHoverPresenter implements HoverPresenter {

	@Override
	public int getOrder() {
		return -900;
	}

	@Override
	public boolean isApplicable(HoverInfo hover) {
		return hover.getHoverContent() instanceof HtmlString;
	}

	@Override
	public Node createHoverContent(HoverInfo hover) {
		SimpleHtmlViewer v = new SimpleHtmlViewer();
		v.contentProperty().set((HtmlString) hover.getHoverContent());
		return v;
	}

}
