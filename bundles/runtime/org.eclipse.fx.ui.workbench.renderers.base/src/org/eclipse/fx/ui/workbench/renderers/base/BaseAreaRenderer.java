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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WArea;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public abstract class BaseAreaRenderer<N> extends BaseRenderer<MArea, WArea<N>> {
	@Inject
	RendererFactory factory;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MArea) {
					MArea parent = (MArea) changedObj;
					if (BaseAreaRenderer.this == parent.getRenderer()) {
						if (UIEvents.isADD(event))
							handleChildrenAddition(parent, Util.<MUIElement> asCollection(event, UIEvents.EventTags.NEW_VALUE));
						else if (UIEvents.isREMOVE(event))
							handleChildrenRemove(parent, Util.<MUIElement> asCollection(event, UIEvents.EventTags.OLD_VALUE));

					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MArea) {
					MArea parent = (MArea) changedObj;
					if (BaseAreaRenderer.this == parent.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.SET.equals(eventType)) {
							MUIElement newValue = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							MUIElement oldValue = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							handleSelectedElement(parent, (MPartSashContainerElement) oldValue, (MPartSashContainerElement) newValue);
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
					MUIElement parent = changedObj.getParent();
					if (parent != null) {
						if (BaseAreaRenderer.this == parent.getRenderer()) {
							MArea stack = (MArea) parent;
							String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
							if (UIEvents.EventTypes.SET.equals(eventType)) {
								Boolean newValue = (Boolean) event.getProperty(UIEvents.EventTags.NEW_VALUE);
								if (newValue.booleanValue()) {
									// TODO Is childRendered not
									// dangerous to call
									// here??
									childRendered(stack, changedObj);
								} else {
									hideChild(stack, changedObj);
								}
							}
						}
					}
				}
			}
		});
	}

	@Override
	public void doProcessContent(MArea element) {
		WArea<N> sash = getWidget(element);
		List<WLayoutedWidget<MPartSashContainerElement>> list = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();

		for (MPartSashContainerElement e : element.getChildren()) {
			WLayoutedWidget<MPartSashContainerElement> widget = engineCreateWidget(e);
			if (widget != null) {
				list.add(widget);
			}
		}

		sash.addItems(list);
	}

	@Override
	public void childRendered(MArea parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WArea<N> sash = getWidget(parentElement);

		@SuppressWarnings("unchecked")
		List<WLayoutedWidget<MPartSashContainerElement>> l = Collections.singletonList((WLayoutedWidget<MPartSashContainerElement>) element.getWidget());
		sash.addItems(idx, l);
	}

	@Override
	public void hideChild(MArea container, MUIElement changedObj) {
		WArea<N> sash = getWidget(container);

		if (sash == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MPartSashContainerElement> widget = (WLayoutedWidget<MPartSashContainerElement>) changedObj.getWidget();
		if (widget != null) {
			sash.removeItem(widget);
		}
	}

	void handleChildrenAddition(MArea parent, Collection<MUIElement> elements) {

		Iterator<MUIElement> i = elements.iterator();
		MUIElement element;
		while (i.hasNext()) {
			element = i.next();
			if (element.isToBeRendered() && element.isVisible()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}

		}
	}

	void handleChildrenRemove(MArea parent, Collection<MUIElement> elements) {
		Iterator<MUIElement> i = elements.iterator();
		MUIElement element;
		while (i.hasNext()) {
			element = i.next();
			if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}

	void handleSelectedElement(MArea parent, MPartSashContainerElement oldElement, MPartSashContainerElement newElement) {
		// TODO Implement (is this needed the SWT renderes don't care about
		// this!)
	}
}
