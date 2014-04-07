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
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Base renderer for {@link MPart}
 * 
 * @param <N>
 *            the native widget
 * @param <T>
 *            the native toolbar widget
 * @param <M>
 *            the native menu widget
 */
@SuppressWarnings("restriction")
public abstract class BasePartRenderer<N, T, M> extends BaseRenderer<MPart, WPart<N, T, M>> {
	/**
	 * Tag used to mark a menu as the view menu
	 */
	public static final String VIEW_MENU_TAG = "ViewMenu"; //$NON-NLS-1$

	@PostConstruct
	void init(IEventBroker eventBroker) {
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_ICONURI);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(eventBroker, UIEvents.Dirtyable.TOPIC_DIRTY);
		eventBroker.subscribe(UIEvents.Part.TOPIC_MENUS, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				MUIElement parent = (MUIElement) changedObj;
				if (parent.getRenderer() == BasePartRenderer.this) {
					if (UIEvents.isADD(event)) {
						handleMenuAddition((MPart) parent, Util.<MMenu> asCollection(event, UIEvents.EventTags.NEW_VALUE));
					} else if (UIEvents.isREMOVE(event)) {
						handleMenuRemove((MPart) parent, Util.<MMenu> asCollection(event, UIEvents.EventTags.OLD_VALUE));
					}
				}
			}
		});
	}

	@Override
	protected void initWidget(final MPart element, final WPart<N, T, M> widget) {
		super.initWidget(element, widget);
		widget.registerActivationCallback(new WCallback<Boolean, Void>() {

			@Override
			public Void call(Boolean param) {
				if (param.booleanValue()) {
					boolean requiresFocus = requiresFocus(widget);
					if (requiresFocus) {
						activate(element, true);
					} else {
						activate(element, false);
					}
				}
				return null;
			}
		});
	}

	protected abstract boolean requiresFocus(WPart<N, T, M> widget);

	@Override
	public void doProcessContent(MPart element) {
		WPart<N, T, M> widget = getWidget(element);

		if (element.getToolbar() != null) {
			WToolBar<T> toolbar = engineCreateWidget(element.getToolbar());
			widget.setToolbar(toolbar);
		}

		for (MMenu m : element.getMenus()) {
			if (m.getTags().contains(VIEW_MENU_TAG)) {
				WMenu<M> menu = engineCreateWidget(m);
				widget.setMenu(menu);
				break;
			}
		}

		Class<?> cl = widget.getWidget().getClass();
		do {
			element.getContext().set(cl.getName(), widget.getWidget());
			cl = cl.getSuperclass();
		} while (!cl.getName().equals("java.lang.Object")); //$NON-NLS-1$

		IContributionFactory contributionFactory = element.getContext().get(IContributionFactory.class);
		Object newPart = contributionFactory.create(element.getContributionURI(), element.getContext());
		element.setObject(newPart);

	}

	void handleMenuAddition(MPart parent, Collection<MMenu> elements) {
		WPart<N, T, M> widget = getWidget(parent);
		if (widget == null) {
			return;
		}

		for (MUIElement e : elements) {
			if (e.getTags().contains(VIEW_MENU_TAG)) {
				if (widget.getMenu() == null) {
					@SuppressWarnings("unchecked")
					WMenu<M> menu = (WMenu<M>) getPresentationEngine().createGui(e);
					widget.setMenu(menu);
				}
				break;
			}
		}
	}

	void handleMenuRemove(MPart parent, Collection<MMenu> elements) {
		WPart<N, T, M> widget = getWidget(parent);
		if (widget == null) {
			return;
		}

		for (MMenu e : elements) {
			if (e.getTags().contains(VIEW_MENU_TAG)) {
				if (widget.getMenu() == e.getWidget()) {
					widget.setMenu(null);
				}
			}
		}
	}

	@Override
	public void childRendered(MPart parentElement, MUIElement element) {
		// No children
	}

	@Override
	public void hideChild(MPart container, MUIElement changedObj) {
		// No children
	}

}
