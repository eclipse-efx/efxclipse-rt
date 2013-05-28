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

import javafx.scene.Group;

import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolControlRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolControl;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;


public class DefToolControlRenderer extends BaseToolControlRenderer<Group> {

	@Override
	protected Class<? extends WToolControl<Group>> getWidgetClass(MToolControl control) {
		return WToolControlImpl.class;
	}
	
	public static class WToolControlImpl extends WWidgetImpl<Group, MToolControl> implements WToolControl<Group> {

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
		protected Group createWidget() {
			return new Group();
		}

		@Override
		protected void setUserData(WWidgetImpl<Group, MToolControl> widget) {
			getWidget().setUserData(widget);
		}
		
	}
}
