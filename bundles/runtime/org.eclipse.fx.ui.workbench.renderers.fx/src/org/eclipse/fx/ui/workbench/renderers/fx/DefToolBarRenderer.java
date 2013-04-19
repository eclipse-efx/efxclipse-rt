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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;

import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;


@SuppressWarnings("restriction")
public class DefToolBarRenderer extends BaseToolBarRenderer<ToolBar> {

	@Override
	protected Class<? extends WToolBar<ToolBar>> getWidgetClass(MToolBar toolbar) {
		return WToolBarImpl.class;
	}

	public static class WToolBarImpl extends WLayoutedWidgetImpl<ToolBar, ToolBar, MToolBar> implements WToolBar<ToolBar> {
		private ToggleGroup group;
		
		@Override
		protected ToolBar createWidget() {
			ToolBar b = new ToolBar();
			return b;
		}

		@Override
		protected ToolBar getWidgetNode() {
			return getWidget();
		}

		@Override
		public void addChild(WWidget<MToolBarElement> itemWidget) {
			if( itemWidget.getWidget() instanceof Toggle ) {
				if( group == null ) {
					group = new ToggleGroup();
				}
				group.getToggles().add((Toggle) itemWidget.getWidget());
			}
			getWidget().getItems().add((Node) itemWidget.getWidget());
		}

		@Override
		public void addChild(int idx, WWidget<MToolBarElement> widget) {
			if( widget.getWidget() instanceof Toggle ) {
				if( group == null ) {
					group = new ToggleGroup();
				}
				group.getToggles().add((Toggle) widget.getWidget());
			}
			
			getWidget().getItems().add(idx, (Node) widget.getWidget());
		}

		@Override
		public void removeChild(WWidget<MToolBarElement> widget) {
			if( widget.getWidget() instanceof Toggle ) {
				((Toggle)widget.getWidget()).setToggleGroup(null);
			}
			getWidget().getItems().remove((Node) widget.getWidget());
		}
	}
}
