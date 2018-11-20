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
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPopupMenu;

/**
 * Popup menu service implementation
 */
public class PartPopupMenuServiceImpl implements EMenuService {
	
	private final MPart part;
	
	@Inject
	PartPopupMenuServiceImpl(MPart part) {
		this.part = part;
	}

	@Override
	public boolean registerContextMenu(Object w, String id) {
		if( ! (w instanceof Control) ) {
			return false;
		}
		
		Control widget = (Control) w;
		for (MMenu mmenu : this.part.getMenus()) {
			if (id.equals(mmenu.getElementId()) && mmenu instanceof MPopupMenu) {
				ContextMenu menu = registerMenu(widget, (MPopupMenu) mmenu, this.part);
				if (menu != null) {
					widget.setContextMenu(menu);
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private static ContextMenu registerMenu(Control widget, MPopupMenu menu, MPart part) {
		if (menu.getWidget() != null) {
			WPopupMenu<ContextMenu> c = (WPopupMenu<ContextMenu>) menu.getWidget();
			return (ContextMenu) c.getWidget();
		}

		IPresentationEngine engine = part.getContext().get(IPresentationEngine.class);
		return (ContextMenu) ((WPopupMenu<ContextMenu>) engine.createGui(menu)).getWidget();
	}

}
