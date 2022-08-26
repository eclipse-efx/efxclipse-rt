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
package org.eclipse.fx.ui.workbench.renderers.base;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base renderer for a {@link MMenu} representing a menu-bar
 * 
 * @param <N>
 *            the native widget type
 */
public abstract class BaseMenuBarRenderer<N> extends BaseRenderer<MMenu, WMenuBar<N>> implements ChildrenHandler<MMenu, MMenuElement> {

	@PostConstruct
	void init(IEventBroker eventBroker) {
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doProcessContent(MMenu element) {
		WMenuBar<N> menuBar = getWidget(element);
		if (menuBar == null) {
			getLogger().error("No widget found for '" + element + "'"); //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		for (MMenuElement e : element.getChildren()) {
			if (e.isToBeRendered()) {
				Object widget = engineCreateWidget(e);
				if (widget != null && isChildRenderedAndVisible(e)) {
					menuBar.addElement((WMenuElement<MMenuElement>) widget);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void childRendered(MMenu parentElement, MUIElement element) {
		if (inContentProcessing(parentElement) || !isChildRenderedAndVisible(element)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WMenuBar<N> menu = getWidget(parentElement);
		if (menu == null) {
			getLogger().error("No widget for '" + menu + "'"); //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		Object widget = (WMenuElement<MMenuElement>) element.getWidget();
		if (widget != null) {
			menu.addElement(idx, (WMenuElement<MMenuElement>) widget);
		}
	}

	@Override
	public boolean isChildRenderedAndVisible(@NonNull MUIElement u) {
		return isChildElementAllowed(u) && super.isChildRenderedAndVisible(u);
	}

	/**
	 * Check if the element is allowed as a child of the {@link WMenuBar}
	 * <p>
	 * The default implementation only allows children of type {@link MMenu} but
	 * subclasses my overwrite if their control supports direct placement of
	 * {@link MMenuItem}
	 * </p>
	 * 
	 * @param u
	 *            the element
	 * @return <code>true</code> if element is allowed as a child
	 */
	protected boolean isChildElementAllowed(@NonNull MUIElement u) {
		if( !(u instanceof MMenu) ) {
			getLogger().info(getClass() + " does not allow an element of type '"+u.getClass()+"' as its child" );  //$NON-NLS-1$//$NON-NLS-2$
			return false;
		}
		return true;
	}

	@Override
	public void hideChild(MMenu container, MUIElement changedObj) {
		WMenuBar<N> menu = getWidget(container);

		if (menu == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> widget = (WMenuElement<MMenuElement>) changedObj.getWidget();
		if (widget != null) {
			menu.removeElement(widget);
		}
	}

	@Override
	public void handleChildrenAddition(MMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element.isToBeRendered() && isChildElementAllowed(element)) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}
	}

	@Override
	public void handleChildrenRemove(MMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}
}
