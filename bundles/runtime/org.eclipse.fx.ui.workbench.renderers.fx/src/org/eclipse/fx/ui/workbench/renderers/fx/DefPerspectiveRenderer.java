/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.fx.ui.panes.FillLayoutPane;
import org.eclipse.fx.ui.workbench.renderers.base.BasePerspectiveRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspective;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;


@SuppressWarnings("restriction")
public class DefPerspectiveRenderer extends BasePerspectiveRenderer<FillLayoutPane> {

	@Override
	protected Class<? extends WPerspective<FillLayoutPane>> getWidgetClass(MPerspective perspective) {
		return PerspectiveWidgetImpl.class;
	}

	public static class PerspectiveWidgetImpl extends WLayoutedWidgetImpl<FillLayoutPane, FillLayoutPane, MPerspective> implements WPerspective<FillLayoutPane> {

		@Override
		protected FillLayoutPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected FillLayoutPane createWidget() {
			return new FillLayoutPane();
		}

		@Override
		public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list) {
			List<Node> l = new ArrayList<Node>(list.size());
			for( WLayoutedWidget<MPartSashContainerElement> w : list ) {
				l.add((Node) w.getStaticLayoutNode());
			}
			getWidget().getChildren().addAll(l);
		}

		@Override
		public void addItem(int index, WLayoutedWidget<MPartSashContainerElement> widget) {
			getWidget().getChildren().add(index, (Node) widget.getStaticLayoutNode());
		}

		@Override
		public void removeItem(WLayoutedWidget<MUIElement> widget) {
			getWidget().getChildren().remove(widget.getStaticLayoutNode());
		}
		
	}
}
