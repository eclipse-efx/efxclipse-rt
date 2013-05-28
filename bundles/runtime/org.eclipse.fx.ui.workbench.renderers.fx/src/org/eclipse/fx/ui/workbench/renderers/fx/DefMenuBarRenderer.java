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
import javax.inject.Named;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuBarRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WLayoutedWidgetImpl;


public class DefMenuBarRenderer extends BaseMenuBarRenderer<MenuBar> {

	@Override
	protected Class<? extends WMenuBar<MenuBar>> getWidgetClass(MMenu menu) {
		return WMenuBarImpl.class;
	}
	
	public static class WMenuBarImpl extends WLayoutedWidgetImpl<MenuBar, MenuBar, MMenu> implements WMenuBar<MenuBar> {
		private boolean nativeMenu;
		
		@Inject
		public WMenuBarImpl(@Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MMenu menu) {
			this.nativeMenu = menu.getPersistedState().get("fx.menubar.native") != null ? Boolean.parseBoolean(menu.getPersistedState().get("fx.menubar.native")) : false;
		}
		
		@Override
		protected MenuBar createWidget() {
			MenuBar b = new MenuBar();
			b.setUseSystemMenuBar(nativeMenu);
			return b;
		}

		@Override
		protected MenuBar getWidgetNode() {
			return getWidget();
		}

		@Override
		public void addElement(WMenu<MMenuElement> widget) {
			getWidget().getMenus().add((Menu) widget.getWidget());
		}

		@Override
		public void addElement(int idx, WMenu<MMenuElement> widget) {
			getWidget().getMenus().add(idx, (Menu) widget.getWidget());
		}

		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			getWidget().getMenus().remove(widget.getWidget());
		}
	}
}
