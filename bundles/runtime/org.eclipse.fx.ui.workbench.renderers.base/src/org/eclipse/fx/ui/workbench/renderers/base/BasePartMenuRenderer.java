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
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MDynamicMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;

/**
 * Base renderer for part menus
 * 
 * @param <N>
 */
public abstract class BasePartMenuRenderer<N> extends BaseRenderer<MMenu, WMenu<N>> implements ChildrenHandler<MMenu, MMenuElement> {

	@PostConstruct
	void init(IEventBroker eventBroker) {
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);
	}

	@Override
	protected void initWidget(final MMenu element, WMenu<N> widget) {
		super.initWidget(element, widget);
		widget.setShowingCallback(new Runnable() {

			@Override
			public void run() {
				handleShowing(element);
			}
		});
	}

	static void handleShowing(MMenu element) {
		for (MMenuElement e : element.getChildren()) {
			if (e.getRenderer() instanceof BaseItemRenderer) {
				@SuppressWarnings("unchecked")
				BaseItemRenderer<MMenuElement, ?> r = (BaseItemRenderer<MMenuElement, ?>) e.getRenderer();
				r.checkEnablement(e);
			}
		}
	}

	@Override
	public void doProcessContent(MMenu element) {
		// TODO Should we do this creation lazy????
		WMenu<N> menu = getWidget(element);
		if( menu == null ) {
			getLogger().error("No widget found for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
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
	protected boolean isChildAndRenderedVisible(MUIElement u) {
		return !(u instanceof MDynamicMenuContribution) && super.isChildAndRenderedVisible(u);
	}

	@Override
	public void handleChildrenRemove(MMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element.isToBeRendered() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}

	@Override
	public void handleChildrenAddition(MMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element.isToBeRendered()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}
	}

	@Override
	public void childRendered(MMenu parentElement, MUIElement element) {
		if (inContentProcessing(parentElement) || ! isChildAndRenderedVisible(element)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WMenu<N> menu = getWidget(parentElement);
		if( menu == null ) {
			getLogger().error("No widget found for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> menuElement = (WMenuElement<MMenuElement>) element.getWidget();
		if( menuElement != null ) {
			menu.addElement(idx, menuElement);
		} else {
			getLogger().error("The widget of element '"+element+"' is null");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	@Override
	public void hideChild(MMenu container, MUIElement changedObj) {
		WMenu<N> menu = getWidget(container);

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