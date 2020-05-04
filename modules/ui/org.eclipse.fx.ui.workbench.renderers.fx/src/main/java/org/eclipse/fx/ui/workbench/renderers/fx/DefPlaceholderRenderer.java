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

import javafx.scene.Node;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.fx.ui.panes.FillLayoutPane;
import org.eclipse.fx.ui.workbench.renderers.base.BasePlaceholderRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPlaceholderWidget;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * default renderer for {@link MPlaceholder}
 */
public class DefPlaceholderRenderer extends BasePlaceholderRenderer<FillLayoutPane> {

	@Override
	protected Class<? extends WPlaceholderWidget> getWidgetClass(MPlaceholder placeholder) {
		return PlaceholderWidget.class;
	}

	
	/**
	 * @noreference
	 */
	public static class PlaceholderWidget extends WLayoutedWidgetImpl<FillLayoutPane, FillLayoutPane, MPlaceholder> implements WPlaceholderWidget {

		@Override
		public void setContent(WLayoutedWidget<? extends MUIElement> contentWidget) {
			if (contentWidget == null) {
				getWidget().getChildren().clear();
			} else {
				getWidget().getChildren().setAll((Node) contentWidget.getStaticLayoutNode());
			}
		}

		@Override
		public FillLayoutPane getWidgetNode() {
			return getWidget();
		}

		@Override
		protected FillLayoutPane createWidget() {
			FillLayoutPane pane = new FillLayoutPane();
//			pane.getChildren().addListener(this::collectChanges);
			return pane;
		}

//		private void collectChanges(Change<? extends Node> c) {
//			while( c.next() ) {
//				System.err.println("ADDED: " + c.getAddedSubList());
//				System.err.println("REMOVED: " + c.getRemoved());
//				if( ! c.getRemoved().isEmpty() ) {
//					Thread.dumpStack();
//				}
//			}
//		}
	}
}