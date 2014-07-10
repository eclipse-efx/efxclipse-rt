/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx;

import javafx.scene.Node;
import javafx.scene.control.SplitPane;

import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.fx.ui.workbench.renderers.base.BaseCompositePartRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCompositePart;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * Renderer for a composite part
 */
public class DefCompositePartRenderer extends BaseCompositePartRenderer<Node> {

	@Override
	protected Class<? extends WCompositePart<Node>> getWidgetClass(MCompositePart element) {
		return CompositePartWidgetImpl.class;
	}

	static class CompositePartWidgetImpl extends WLayoutedWidgetImpl<SplitPane, SplitPane, MCompositePart> implements WCompositePart<Node> {

		@Override
		protected SplitPane getWidgetNode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected SplitPane createWidget() {
			throw new UnsupportedOperationException();
		}

	}
}
