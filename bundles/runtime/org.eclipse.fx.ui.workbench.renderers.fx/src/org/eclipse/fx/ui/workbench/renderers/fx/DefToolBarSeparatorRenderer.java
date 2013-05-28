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

import java.util.List;

import javafx.scene.control.Separator;

import org.eclipse.e4.ui.model.application.ui.menu.MToolBarSeparator;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolBarSeparatorRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBarSeparator;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;


public class DefToolBarSeparatorRenderer extends BaseToolBarSeparatorRenderer<Separator> {

	@Override
	protected Class<? extends WToolBarSeparator<Separator>> getWidgetClass(MToolBarSeparator separator) {
		return ToolbarSeparatorImpl.class;
	}

	static class ToolbarSeparatorImpl extends WWidgetImpl<Separator, MToolBarSeparator> implements WToolBarSeparator<Separator> {

		@Override
		public void addStyleClasses(List<String> classnames) {
			getWidget().getStyleClass().addAll(classnames);
		}

		@Override
		public void addStyleClasses(String... classnames) {
			getWidget().getStyleClass().addAll(classnames);
		}

		@Override
		public void setStyleId(String id) {
			getWidget().setId(id);
		}

		@Override
		protected Separator createWidget() {
			return new Separator();
		}

		@Override
		protected void setUserData(WWidgetImpl<Separator, MToolBarSeparator> widget) {
			getWidget().setUserData(widget);
		}
		
	}
}
