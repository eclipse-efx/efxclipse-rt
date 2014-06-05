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
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WSash;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Base renderer for {@link MPartSashContainer}
 * 
 * @param <N>
 *            the native widget
 */
public abstract class BaseSashRenderer<N> extends BaseRenderer<MPartSashContainer, WSash<N>> {
	@Inject
	RendererFactory factory;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPartSashContainer) {
					MPartSashContainer parent = (MPartSashContainer) changedObj;
					if (BaseSashRenderer.this == parent.getRenderer()) {
						if (UIEvents.isADD(event)) {
							handleChildrenAddition(parent, Util.<MPartSashContainerElement> asCollection(event, UIEvents.EventTags.NEW_VALUE));
						} else if (UIEvents.isREMOVE(event)) {
							handleChildrenRemove(parent, Util.<MPartSashContainerElement> asCollection(event, UIEvents.EventTags.OLD_VALUE));

						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPartSashContainer) {
					MPartSashContainer parent = (MPartSashContainer) changedObj;
					if (BaseSashRenderer.this == parent.getRenderer()) {
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
						if (BaseSashRenderer.this == parent.getRenderer()) {
							MPartSashContainer stack = (MPartSashContainer) parent;
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
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_CONTAINERDATA, new EventHandler() {
			
			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				if( changedObj != null && changedObj.getParent() != null && changedObj.getParent().getRenderer() == BaseSashRenderer.this ) {
					MElementContainer<MUIElement> parent = changedObj.getParent();
					if( parent != null && !inUIModification(parent) ) {
						@Nullable
						WSash<N> widget = getWidget((MPartSashContainer)(MUIElement)parent);
						if( widget != null ) {
							widget.updateLayout();	
						} else {
							getLogger().error("Could not find widget for '"+parent+"'");  //$NON-NLS-1$//$NON-NLS-2$
						}
					}
				}
			}
		});
	}

	@Override
	public void doProcessContent(MPartSashContainer element) {
		WSash<N> sash = getWidget(element);
		if( sash == null ) {
			getLogger().error("Could not find widget for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		List<WLayoutedWidget<MPartSashContainerElement>> list = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();

		for (MPartSashContainerElement e : element.getChildren()) {
			if (e.isToBeRendered()) {
				WLayoutedWidget<MPartSashContainerElement> widget = engineCreateWidget(e);
				if (widget != null && e.isVisible()) {
					list.add(widget);
				}
			}
		}

		sash.addItems(list);
	}

	@SuppressWarnings("null")
	@Override
	public void childRendered(MPartSashContainer parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WSash<N> sash = getWidget(parentElement);
		if( sash == null ) {
			getLogger().error("Could not find widget for '"+parentElement+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MPartSashContainerElement> w = (WLayoutedWidget<MPartSashContainerElement>) element.getWidget();
		if( w != null ) {
			List<@NonNull WLayoutedWidget<MPartSashContainerElement>> l = Collections.singletonList(w);
			sash.addItems(idx, l);	
		} else {
			this.logger.error("The widget for element '"+element+"' should not be null");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	@Override
	public void hideChild(MPartSashContainer container, MUIElement changedObj) {
		WSash<N> sash = getWidget(container);

		if (sash == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MPartSashContainerElement> widget = (WLayoutedWidget<MPartSashContainerElement>) changedObj.getWidget();
		if (widget != null) {
			sash.removeItem(widget);
		}
	}

	void handleChildrenAddition(@NonNull MPartSashContainer parent, Collection<MPartSashContainerElement> elements) {
		Iterator<MPartSashContainerElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MPartSashContainerElement element = (MPartSashContainerElement) iterator.next();

			if (element.isToBeRendered() && element.isVisible()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}

	}

	void handleChildrenRemove(@NonNull MPartSashContainer parent, Collection<MPartSashContainerElement> elements) {
		Iterator<MPartSashContainerElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MPartSashContainerElement element = (MPartSashContainerElement) iterator.next();
			if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}

	void handleSelectedElement(MPartSashContainer parent, MPartSashContainerElement oldElement, MPartSashContainerElement newElement) {
		// TODO Implement (is this needed the SWT renderes don't care about
		// this!)
	}
}
