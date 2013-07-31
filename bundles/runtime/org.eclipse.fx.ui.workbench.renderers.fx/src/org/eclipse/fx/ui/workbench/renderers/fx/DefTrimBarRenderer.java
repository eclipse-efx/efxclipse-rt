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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;
import org.eclipse.fx.ui.workbench.renderers.base.BaseTrimBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WTrimBar;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;


public class DefTrimBarRenderer extends BaseTrimBarRenderer<HBox> {

	@Override
	protected Class<? extends WTrimBar<HBox>> getWidgetClass(MTrimBar trimbar) {
		return WTrimBarImpl.class;
	}

	public static class WTrimBarImpl extends WLayoutedWidgetImpl<HBox, HBox, MTrimBar> implements WTrimBar<HBox> {

		@Override
		protected HBox createWidget() {
			HBox box = new HBox();
			return box;
		}

		@Override
		protected HBox getWidgetNode() {
			return getWidget();
		}
		
		@Override
		public void addChild(WLayoutedWidget<MTrimElement> trimElementWidget) {
			Node n = (Node) trimElementWidget.getStaticLayoutNode();
			if( trimElementWidget.getDomElement().getTags().contains(TAG_FILLSPACE) ) {
				HBox.setHgrow(n, Priority.ALWAYS);
			}
			getWidget().getChildren().add(n);
		}

		@Override
		public void addChild(int idx, WLayoutedWidget<MTrimElement> trimElementWidget) {
			Node n = (Node) trimElementWidget.getStaticLayoutNode();
			if( trimElementWidget.getDomElement().getTags().contains(TAG_FILLSPACE) ) {
				HBox.setHgrow(n, Priority.ALWAYS);
			}
			getWidget().getChildren().add(idx, n);
		}
		
		@Override
		public void removeChild(WLayoutedWidget<MTrimElement> trimElementWidget) {
			Node n = (Node) trimElementWidget.getStaticLayoutNode();
			getWidget().getChildren().remove(n);
		}
	}
}
