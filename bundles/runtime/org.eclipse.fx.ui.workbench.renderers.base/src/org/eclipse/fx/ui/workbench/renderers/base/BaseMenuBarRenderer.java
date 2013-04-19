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

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;


@SuppressWarnings("restriction")
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
		for( MMenuElement e : element.getChildren() ) {
			Object widget = engineCreateWidget(e);
			if( widget instanceof WMenu ) {
				menuBar.addElement((WMenu<MMenuElement>)widget);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void childRendered(MMenu parentElement, MUIElement element) {
		if( inContentProcessing(parentElement) ) {
			return;
		}
		
		int idx = getRenderedIndex(parentElement, element);
		WMenuBar<N> menu = getWidget(parentElement);
		Object widget = (WMenuElement<MMenuElement>) element.getWidget();
		if( widget instanceof WMenu ) {
			menu.addElement(idx, (WMenu<MMenuElement>)widget);
		}
	}
	
	@Override
	public void hideChild(MMenu container, MUIElement changedObj) {
		WMenuBar<N> menu = getWidget(container);
		
		if( menu == null ) {
			return;
		}
		
		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> widget = (WMenuElement<MMenuElement>) changedObj.getWidget();
		if( widget != null ) {
			menu.removeElement(widget);
		}
	}
	
	@Override
	public void handleChildAddition(MMenu parent, MMenuElement element) {
		if (element.isToBeRendered() && element.isVisible()) {
			if( element.getWidget() == null ) {
				engineCreateWidget(element);	
			} else {
				childRendered(parent, element);
			}
		}
	}
	
	@Override
	public void handleChildRemove(MMenu parent, MMenuElement element) {
		if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
			hideChild(parent, element);
		}
	}
}
