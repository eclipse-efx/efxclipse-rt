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

import javax.inject.Inject;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolControlRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolControl;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.CustomContainerSupport;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;

/**
 * default renderer for tool control
 */
public class DefToolControlRenderer extends BaseToolControlRenderer<Parent> {

	@Override
	protected Class<? extends WToolControl<Parent>> getWidgetClass(MToolControl control) {
		return WToolControlImpl.class;
	}

	/**
	 * Tool control implementation
	 */
	public static class WToolControlImpl extends WLayoutedWidgetImpl<Parent, Parent, MToolControl> implements WToolControl<Parent> {
		@Inject
		@NonNull
		IEclipseContext context;

		@Override
		protected Parent createWidget() {
			Pane p = CustomContainerSupport.createContainerPane(this.logger, this.context);
			return p == null ? new Group() : p;
		}

		@Override
		protected void setUserData(WWidgetImpl<Parent, MToolControl> widget) {
			getWidget().setUserData(widget);
		}

		@Override
		protected Parent getWidgetNode() {
			return getWidget();
		}
	}
}
