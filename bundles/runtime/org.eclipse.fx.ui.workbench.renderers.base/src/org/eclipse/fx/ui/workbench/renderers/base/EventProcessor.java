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

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class EventProcessor {
	public interface ChildrenHandler<M extends MUIElement, C extends MUIElement> {
		public void handleChildrenAddition(M parent, Collection<C> elements);

		public void handleChildrenRemove(M parent, Collection<C> elements);
	}

	public static <C extends MUIElement, M extends MElementContainer<C>, R extends BaseRenderer<M, ?> & ChildrenHandler<M, C>> void attachChildProcessor(IEventBroker eventBroker, final R renderer) {
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				MUIElement parent = (MUIElement) changedObj;

				if (parent.getRenderer() == renderer) {
					if (UIEvents.isADD(event))
						renderer.handleChildrenAddition((M) parent, Util.<C> asCollection(event, UIEvents.EventTags.NEW_VALUE));
					else if (UIEvents.isREMOVE(event))
						renderer.handleChildrenRemove((M) parent, Util.<C> asCollection(event, UIEvents.EventTags.OLD_VALUE));
				}
			}
		});
	}

	public static <M extends MUIElement, R extends BaseRenderer<M, ?>> void attachVisibleProcessor(IEventBroker eventBroker, final R renderer) {
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_VISIBLE, new EventHandler() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj.isToBeRendered()) {
					EObject parent = ((EObject) changedObj).eContainer();
					if (parent instanceof MUIElement) {
						if (((MUIElement) parent).getRenderer() == renderer) {
							String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
							if (UIEvents.EventTypes.SET.equals(eventType)) {
								Boolean newValue = (Boolean) event.getProperty(UIEvents.EventTags.NEW_VALUE);
								if (newValue.booleanValue()) {
									// TODO Is childRendered not dangerous to
									// call
									// here??
									renderer.childRendered((M) parent, changedObj);
								} else {
									renderer.hideChild((M) parent, changedObj);
								}
							}
						}
					}
				}
			}
		});
	}
}
