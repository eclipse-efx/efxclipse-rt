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
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MDynamicMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.lifecycle.ELifecycleService;
import org.eclipse.fx.ui.lifecycle.annotations.PreClose;
import org.eclipse.fx.ui.lifecycle.annotations.PreShow;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;

public abstract class BaseMenuRenderer<N> extends BaseRenderer<MMenu, WMenu<N>> implements ChildrenHandler<MMenu, MMenuElement> {

	@Inject
	private ELifecycleService lifecycleService;
	
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
		widget.setHidingCallback(new Runnable() {
			
			@Override
			public void run() {
				IEclipseContext context = getModelContext(element).createChild("lifecycle");
				context.set(MMenu.class, element);
				lifecycleService.validateAnnotation(PreClose.class, element, context);
				context.dispose();
			}
		});
//		for (MApplicationElement m: element.getChildren()) {
//			if (!(m instanceof MDynamicMenuContribution)) continue;
//			MDynamicMenuContribution c = (MDynamicMenuContribution) m;
//			lifecycleService.registerLifecycleURI(element, c.getContributionURI());
//		}
	}

	void handleShowing(MMenu element) {
		IEclipseContext context = getModelContext(element).createChild("lifecycle");
		context.set(MMenu.class, element);
		lifecycleService.validateAnnotation(PreShow.class, element, context);
		
		for (MMenuElement e : element.getChildren()) {
			if (e.getRenderer() instanceof BaseItemRenderer) {
				@SuppressWarnings("unchecked")
				BaseItemRenderer<MMenuElement, ?> r = (BaseItemRenderer<MMenuElement, ?>) e.getRenderer();
				r.checkEnablement(e);
			}
		}
		
		context.dispose();
	}
	

	@Override
	public void doProcessContent(MMenu element) {
		// TODO Should we do this creation lazy????
		WMenu<N> menu = getWidget(element);
		for (MMenuElement e : element.getChildren()) {
			WMenuElement<MMenuElement> widget = engineCreateWidget(e);
			if (widget != null) {
				menu.addElement(widget);
			}
		}
	}

	public void handleChildrenRemove(MMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
//			if (element instanceof MDynamicMenuContribution) {
//				MDynamicMenuContribution c = (MDynamicMenuContribution) element;
//				lifecycleService.unregisterLifecycleContribution(element, c.getObject());
//				continue;
//			}
			if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}

	public void handleChildrenAddition(MMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
//			if (element instanceof MDynamicMenuContribution) {
//				MDynamicMenuContribution c = (MDynamicMenuContribution) element;
//				lifecycleService.registerLifecycleURI(element, c.getContributionURI());
//				continue;
//			}
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
	public void childRendered(MMenu parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WMenu<N> menu = getWidget(parentElement);
		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> menuElement = (WMenuElement<MMenuElement>) element.getWidget();
		menu.addElement(idx, menuElement);
	}

	@Override
	protected int getRenderedIndex(MUIElement parent, MUIElement element) {
		EObject eElement = (EObject) element;
		
		EObject container = eElement.eContainer();
		@SuppressWarnings("unchecked")
		List<MUIElement> list = (List<MUIElement>) container.eGet(eElement.eContainmentFeature());
		int idx = 0;
		for( MUIElement u : list ) {
			if( u.isToBeRendered() && u.isVisible() && !(u instanceof MDynamicMenuContribution) ) {
				if( u == element ) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
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
