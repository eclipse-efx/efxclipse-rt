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

import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;



@SuppressWarnings("restriction")
public abstract class BasePartRenderer<N,T,M> extends BaseRenderer<MPart, WPart<N,T,M>> {
	public static final String VIEW_MENU_TAG = "ViewMenu";
	
	@PostConstruct
	void init(IEventBroker broker) {
		registerEventListener(broker, UIEvents.UILabel.TOPIC_ICONURI);
		registerEventListener(broker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(broker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(broker, UIEvents.Dirtyable.TOPIC_DIRTY);
	}
	
	@Override
	protected void initWidget(final MPart element, final WPart<N,T,M> widget) {
		super.initWidget(element, widget);				
		widget.registerActivationCallback(new WCallback<Boolean, Void>() {
			
			@Override
			public Void call(Boolean param) {
				if( param.booleanValue() ) {
					boolean requiresFocus = requiresFocus(widget);
					if(requiresFocus) {
						activate(element, true);
					} else {
						activate(element, false);
					}
				}
				return null;
			}
		});
	}
	
	protected abstract boolean requiresFocus(WPart<N,T,M> widget);
	
	@Override
	public void doProcessContent(MPart element) {
		WPart<N,T,M> widget = getWidget(element);
		
		if( element.getToolbar() != null ) {
			WToolBar<T> toolbar = engineCreateWidget(element.getToolbar());
			widget.setToolbar(toolbar);
		}
		
		for( MMenu m : element.getMenus() ) {
			if( m.getTags().contains(VIEW_MENU_TAG) ) {
				WMenu<M> menu = engineCreateWidget(m);
				widget.setMenu(menu);
				break;
			}
		}
		
		Class<?> cl = widget.getWidget().getClass();
		do {
			element.getContext().set(cl.getName(), widget.getWidget());
			cl = cl.getSuperclass();
		} while( ! cl.getName().equals("java.lang.Object") );
		
		IContributionFactory contributionFactory = (IContributionFactory) element.getContext().get(IContributionFactory.class
				.getName());
		Object newPart = contributionFactory.create(element.getContributionURI(), element.getContext());
		element.setObject(newPart);
		
	}
	
	@Override
	public void childRendered(MPart parentElement, MUIElement element) {
		
	}
	
	@Override
	public void hideChild(MPart container, MUIElement changedObj) {
		
	}

}
