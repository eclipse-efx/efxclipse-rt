/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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

/**
 * default renderer for a toolbar separtor
 */
public class DefToolBarSeparatorRenderer extends BaseToolBarSeparatorRenderer<Separator> {

	@Override
	protected Class<? extends WToolBarSeparator<Separator>> getWidgetClass(MToolBarSeparator separator) {
		return ToolbarSeparatorImpl.class;
	}

	
	/**
	 * @noreference
	 */
	public static class ToolbarSeparatorImpl extends WWidgetImpl<Separator, MToolBarSeparator> implements WToolBarSeparator<Separator> {

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
		public void removeStyleClasses(List<String> classnames) {
			getWidget().getStyleClass().removeAll(classnames);
		}

		@Override
		public void removeStyleClasses(String... classnames) {
			getWidget().getStyleClass().removeAll(classnames);
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
