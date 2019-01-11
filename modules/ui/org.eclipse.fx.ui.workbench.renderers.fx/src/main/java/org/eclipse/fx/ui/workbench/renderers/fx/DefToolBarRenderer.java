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

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;

import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;

/**
 * default renderer for {@link MToolBar}
 */
public class DefToolBarRenderer extends BaseToolBarRenderer<ToolBar> {

	@Override
	protected Class<? extends WToolBar<ToolBar>> getWidgetClass(MToolBar toolbar) {
		return WToolBarImpl.class;
	}

	
	/**
	 * @noreference
	 */
	public static class WToolBarImpl extends WLayoutedWidgetImpl<ToolBar, ToolBar, MToolBar> implements WToolBar<ToolBar> {
		private ToggleGroup group;
		private ToolBar toolbar;
		private InvalidationListener orientationSync;

		@Override
		protected ToolBar createWidget() {
			ToolBar b = new ToolBar();
			this.orientationSync = this::syncOrientation;
			b.parentProperty().addListener(this.orientationSync);
			return b;
		}

		private void syncOrientation(Observable o) {
			MToolBar element = getDomElement();
			if (element != null && ((EObject) element).eContainer() instanceof MTrimBar) {
				MTrimBar bar = (MTrimBar) ((EObject) element).eContainer();
				switch (bar.getSide()) {
				case LEFT:
				case RIGHT:
					getWidget().setOrientation(Orientation.VERTICAL);
					break;
				default:
					getWidget().setOrientation(Orientation.HORIZONTAL);
					break;
				}
			}
		}

		@Override
		protected void doCleanup() {
			super.doCleanup();
			if (this.toolbar != null && this.orientationSync != null) {
				this.toolbar.parentProperty().removeListener(this.orientationSync);
			}
		}

		@Override
		public ToolBar getWidgetNode() {
			return getWidget();
		}

		@Override
		public void addChild(WWidget<MToolBarElement> itemWidget) {
			if (itemWidget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				this.group.getToggles().add((Toggle) itemWidget.getWidget());
			}
			getWidget().getItems().add((Node) itemWidget.getWidget());
		}

		@Override
		public void addChild(int idx, WWidget<MToolBarElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				this.group.getToggles().add((Toggle) widget.getWidget());
			}

			getWidget().getItems().add(idx, (Node) widget.getWidget());
		}

		@Override
		public void removeChild(WWidget<MToolBarElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				((Toggle) widget.getWidget()).setToggleGroup(null);
			}
			getWidget().getItems().remove((Node) widget.getWidget());
		}
		
		@Override
		protected void initDnd(Pane staticLayoutGroup) {
			// needs different dnd
		}
	}
}
