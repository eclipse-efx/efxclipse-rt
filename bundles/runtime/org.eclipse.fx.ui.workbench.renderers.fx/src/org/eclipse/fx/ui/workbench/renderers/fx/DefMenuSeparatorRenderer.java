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

import javafx.scene.control.SeparatorMenuItem;

import org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuSeparatorRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuSeparator;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;


public class DefMenuSeparatorRenderer extends BaseMenuSeparatorRenderer<SeparatorMenuItem> {

	@Override
	protected Class<? extends WMenuSeparator<SeparatorMenuItem>> getWidgetClass(MMenuSeparator separator) {
		return MenuSeparatorImpl.class;
	}

	public static class MenuSeparatorImpl extends WWidgetImpl<SeparatorMenuItem, MMenuSeparator> implements WMenuSeparator<SeparatorMenuItem> {

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
		protected SeparatorMenuItem createWidget() {
			SeparatorMenuItem item = new SeparatorMenuItem();
			return item;
		}
		
		@Override
		protected void setUserData(WWidgetImpl<SeparatorMenuItem, MMenuSeparator> widget) {
			getWidget().setUserData(widget);
		}
	}
}
