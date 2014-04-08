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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.workbench.renderers.base.BaseAreaRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuItemRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuSeparatorRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BasePerspectiveRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BasePerspectiveStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BasePlaceholderRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BasePopupMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseSashRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolBarSeparatorRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolControlRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseToolItemRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseTrimBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseWindowRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseWorkbenchRendererFactory;

/**
 * Default factory for renderers
 */
public class DefWorkbenchRendererFactory extends BaseWorkbenchRendererFactory {

	/**
	 * Create a factory
	 * 
	 * @param context
	 *            the DI context
	 */
	@Inject
	public DefWorkbenchRendererFactory(IEclipseContext context) {
		super(context);
	}

	@Override
	protected Class<? extends BaseWindowRenderer<?>> getWindowRendererClass() {
		return DefWindowRenderer.class;
	}

	@Override
	protected Class<? extends BaseSashRenderer<?>> getSashRendererClass() {
		return DefSashRenderer.class;
	}

	@Override
	protected Class<? extends BaseMenuBarRenderer<?>> getMenuBarRendererClass() {
		return DefMenuBarRenderer.class;
	}

	@Override
	protected Class<? extends BaseTrimBarRenderer<?>> getTrimBarRendererClass() {
		return DefTrimBarRenderer.class;
	}

	@Override
	protected Class<? extends BaseToolBarRenderer<?>> getToolBarRendererClass() {
		return DefToolBarRenderer.class;
	}

	@Override
	protected Class<? extends BaseToolItemRenderer<?>> getToolItemRendererClass() {
		return DefToolItemRenderer.class;
	}

	@Override
	protected Class<? extends BaseStackRenderer<?, ?, ?>> getStackRendererClass() {
		return DefStackRenderer.class;
	}

	@Override
	protected Class<? extends BasePartRenderer<?, ?, ?>> getPartRendererClass() {
		return DefPartRenderer.class;
	}

	@Override
	protected Class<? extends BaseMenuRenderer<?>> getMenuRendererClass() {
		return DefMenuRenderer.class;
	}

	@Override
	protected Class<? extends BaseMenuItemRenderer<?>> getMenuItemRendererClass() {
		return DefMenuItemRenderer.class;
	}

	@Override
	protected Class<? extends BaseMenuSeparatorRenderer<?>> getMenuSeparatorRendererClass() {
		return DefMenuSeparatorRenderer.class;
	}

	@Override
	protected Class<? extends BaseMenuRenderer<?>> getToolItemMenuRendererClass() {
		return DefToolItemMenuRenderer.class;
	}

	@Override
	protected Class<? extends BasePerspectiveStackRenderer<?, ?, ?>> getPerspectiveStackRendererClass() {
		return DefPerspectiveStackRenderer.class;
	}

	@Override
	protected Class<? extends BasePerspectiveRenderer<?>> getPerspectiveRendererClass() {
		return DefPerspectiveRenderer.class;
	}

	@Override
	protected Class<? extends BasePlaceholderRenderer<?>> getPlaceholderRendererClass() {
		return DefPlaceholderRenderer.class;
	}

	@Override
	protected Class<? extends BaseToolControlRenderer<?>> getToolcontrolRendererClass() {
		return DefToolControlRenderer.class;
	}

	@Override
	protected Class<? extends BaseToolBarSeparatorRenderer<?>> getToolBarSeparatorRendererClass() {
		return DefToolBarSeparatorRenderer.class;
	}

	@Override
	protected Class<? extends BaseAreaRenderer<?>> getAreaRendererClass() {
		return DefAreaRenderer.class;
	}

	@Override
	protected Class<? extends BasePopupMenuRenderer<?>> getPopupMenuRendererClass() {
		return DefPopupMenuRenderer.class;
	}

	@Override
	protected Class<? extends BasePartMenuRenderer<?>> getPartMenuRenderer() {
		return DefPartMenuRenderer.class;
	}
}