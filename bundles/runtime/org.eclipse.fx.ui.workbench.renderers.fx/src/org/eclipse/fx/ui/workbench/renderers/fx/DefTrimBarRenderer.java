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
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.SideValue;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.renderers.base.BaseTrimBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WTrimBar;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * Default implementation of a trim renderer
 */
public class DefTrimBarRenderer extends BaseTrimBarRenderer<Pane> {

	@Override
	protected Class<? extends WTrimBar<Pane>> getWidgetClass(MTrimBar trimbar) {
		return WTrimBarImpl.class;
	}

	/**
	 * TrimBar widget
	 */
	public static class WTrimBarImpl extends WLayoutedWidgetImpl<Pane, Pane, MTrimBar> implements WTrimBar<Pane> {
		private SideValue sideValue;

		/**
		 * Create an instance of trimbar
		 * 
		 * @param sideValue
		 *            the side value
		 */
		@Inject
		public WTrimBarImpl(@Named(UIEvents.GenericTrimContainer.SIDE) SideValue sideValue) {
			this.sideValue = sideValue;
		}

		@Override
		protected Pane createWidget() {
			// TODO Can we get dynamic here, what when the orientation changes
			if (isVertical()) {
				VBox box = new VBox();
				return box;
			} else {
				HBox box = new HBox();
				return box;
			}
		}

		private boolean isVertical() {
			return this.sideValue == SideValue.LEFT || this.sideValue == SideValue.RIGHT;
		}

		@Override
		protected Pane getWidgetNode() {
			return getWidget();
		}

		@Override
		public void addChild(WLayoutedWidget<MTrimElement> trimElementWidget) {
			Node n = (Node) trimElementWidget.getStaticLayoutNode();
			MTrimElement element = trimElementWidget.getDomElement();
			if (element != null && element.getTags().contains(TAG_FILLSPACE)) {
				if (isVertical()) {
					VBox.setVgrow(n, Priority.ALWAYS);
				} else {
					HBox.setHgrow(n, Priority.ALWAYS);
				}
			}
			getWidget().getChildren().add(n);
		}

		@Override
		public void addChild(int idx, WLayoutedWidget<MTrimElement> trimElementWidget) {
			Node n = (Node) trimElementWidget.getStaticLayoutNode();
			MTrimElement element = trimElementWidget.getDomElement();
			if (element != null && element.getTags().contains(TAG_FILLSPACE)) {
				if (isVertical()) {
					VBox.setVgrow(n, Priority.ALWAYS);
				} else {
					HBox.setHgrow(n, Priority.ALWAYS);
				}
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
