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
import java.util.Collections;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.jdt.annotation.NonNull;
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

	@SuppressWarnings("null")
	@PostConstruct
	void init(@NonNull IEventBroker eventBroker) {
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_ICONURI);
		
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LOCALIZED_LABEL);
		
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LOCALIZED_TOOLTIP);
		
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

		eventBroker.subscribe(UIEvents.Part.TOPIC_TOOLBAR, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				MUIElement parent = (MUIElement) changedObj;
				if (parent.getRenderer() == BasePartRenderer.this) {
					if (UIEvents.isSET(event)) {
						Object newValue = event.getProperty(UIEvents.EventTags.NEW_VALUE);
						if (newValue != null) {
							handleToolbarAddition((MPart) parent, (MToolBar) newValue);
						} else {
							handleToolbarRemove((MPart) parent, (MToolBar) event.getProperty(UIEvents.EventTags.OLD_VALUE));
						}
					}
				}
			}
		});

		eventBroker.subscribe(UIEvents.UIElement.TOPIC_VISIBLE, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj.isToBeRendered()) {
					MUIElement parent = (MUIElement) ((EObject) changedObj).eContainer();
					if (parent != null) {
						if (BasePartRenderer.this == parent.getRenderer()) {
							MPart part = (MPart) parent;
							String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
							if (UIEvents.EventTypes.SET.equals(eventType)) {
								Boolean newValue = (Boolean) event.getProperty(UIEvents.EventTags.NEW_VALUE);
								if (newValue.booleanValue()) {
									childRendered(part, changedObj);
								} else {
									hideChild(part, changedObj);
								}
							}
						}
					}
				}
			}
		});
	}

	void handleToolbarRemove(@NonNull MPart parent, @NonNull MToolBar toolbar) {
		WPart<N, T, M> widget = getWidget(parent);
		if (widget == null) {
			return;
		}

		if (widget.getToolbar() == toolbar.getWidget()) {
			widget.setToolbar(null);
		}
	}

	void handleToolbarAddition(@NonNull MPart parent, @NonNull MToolBar toolbar) {
		WPart<N, T, M> widget = getWidget(parent);
		if (widget == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WToolBar<T> wtoolbar = (WToolBar<T>) getPresentationEngine().createGui(toolbar);
		widget.setToolbar(wtoolbar);
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

	/**
	 * Check if the activated part needs focus called
	 * 
	 * @param widget
	 *            the widget
	 * @return <code>true</code> if activation should call {@link Focus}
	 */
	protected abstract boolean requiresFocus(@NonNull WPart<N, T, M> widget);

	@Override
	public void doProcessContent(@NonNull MPart element) {
		WPart<N, T, M> widget = getWidget(element);
		if (widget == null) {
			getLogger().error("No widget found for '" + element + "'"); //$NON-NLS-1$//$NON-NLS-2$
			return;
		}

		MToolBar mToolBar = element.getToolbar();
		if (mToolBar != null) {
			WToolBar<T> toolbar = engineCreateWidget(mToolBar);
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

	void handleMenuAddition(@NonNull MPart parent, Collection<MMenu> elements) {
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

	void handleMenuRemove(@NonNull MPart parent, Collection<MMenu> elements) {
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
		if (inContentProcessing(parentElement) || !element.isVisible()) {
			return;
		}

		if (element instanceof MToolBar) {
			handleToolbarAddition(parentElement, (MToolBar) element);
		} else if (element instanceof MMenu) {
			handleMenuAddition(parentElement, Collections.singletonList((MMenu) element));
		}
	}

	@Override
	public void hideChild(MPart container, MUIElement changedObj) {
		if (changedObj instanceof MToolBar) {
			handleToolbarRemove(container, (MToolBar) changedObj);
		} else if (changedObj instanceof MMenu) {
			handleMenuRemove(container, Collections.singletonList((MMenu) changedObj));
		}
	}

}
