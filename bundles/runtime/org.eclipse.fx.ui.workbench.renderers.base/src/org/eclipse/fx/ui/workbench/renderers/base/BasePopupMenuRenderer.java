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
package org.eclipse.fx.ui.workbench.renderers.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPopupMenu;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base renderer for {@link MPopupMenu}
 * 
 * @param <N>
 *            the native widget type
 */
public abstract class BasePopupMenuRenderer<N> extends BaseItemContainerRenderer<MPopupMenu, MMenuElement, WPopupMenu<N>> implements ChildrenHandler<MPopupMenu, MMenuElement> {
	private Set<MMenu> currentVisibleMenus = new HashSet<>();
	
	@Override
	protected void do_init(@NonNull IEventBroker broker) {
		// nothing to do
	}
	
	@Override
	protected void initWidget(final MPopupMenu element, WPopupMenu<N> widget) {
		super.initWidget(element, widget);
		widget.setShowingCallback(() -> handleShowing(element) );
		widget.setHidingCallback(() -> handleHiding(element));
	}

	void handleHiding(MPopupMenu element) {
		this.currentVisibleMenus.remove(element);
	}
	
	void handleShowing(MPopupMenu element) {
		this.currentVisibleMenus.add(element);
		//FIXME We need to deal with dynamics!!!!
		for (MMenuElement e : element.getChildren()) {
			if (e.getRenderer() instanceof BaseItemRenderer) {
				@SuppressWarnings("unchecked")
				BaseItemRenderer<MMenuElement, ?> r = (BaseItemRenderer<MMenuElement, ?>) e.getRenderer();
				r.checkEnablement(e);
			}
		}
	}

	
	
	@Override
	public void doProcessContent(MPopupMenu element) {
		// TODO Should we do this creation lazy????
		WPopupMenu<N> menu = getWidget(element);
		if( menu == null ) {
			getLogger().error("Could not find widget for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		for (MMenuElement e : element.getChildren()) {
			@SuppressWarnings("null")
			WMenuElement<MMenuElement> widget = engineCreateWidget(e);
			if (widget != null && isChildAndRenderedVisible(e)) {
				menu.addElement(widget);
			}
		}
	}

	@Override
	public void handleChildrenRemove(MPopupMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}

	@Override
	public void handleChildrenAddition(MPopupMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element.isToBeRendered() && element.isVisible()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}
	}

	@Override
	public void do_childRendered(MPopupMenu parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		WPopupMenu<N> menu = getWidget(parentElement);
		if( menu == null ) {
			getLogger().error("Could not find widget for '"+parentElement+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		
		int idx = getRenderedIndex(parentElement, element);
		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> menuElement = (WMenuElement<MMenuElement>) element.getWidget();
		menu.addElement(idx, menuElement);
	}

	@Override
	public void do_hideChild(MPopupMenu container, MUIElement changedObj) {
		WPopupMenu<N> menu = getWidget(container);

		if (menu == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> widget = (WMenuElement<MMenuElement>) changedObj.getWidget();
		if (widget != null) {
			menu.removeElement(widget);
		}
	}
}