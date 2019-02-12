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
import org.eclipse.e4.ui.model.application.ui.menu.MItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Helper class to attach event processors
 */
public class EventProcessor {
	/**
	 * Interface to implement by renderers who want their children to be
	 * processed
	 *
	 * @param <M>
	 *            the model element type
	 * @param <C>
	 *            the child element types
	 */
	public interface ChildrenHandler<M extends MUIElement, C extends MUIElement> {
		/**
		 * Called when children are added
		 *
		 * @param parent
		 *            the parent
		 * @param elements
		 *            the child elements
		 */
		public void handleChildrenAddition(@NonNull M parent, @NonNull Collection<@NonNull C> elements);

		/**
		 * Called when children are removed
		 *
		 * @param parent
		 *            the parent
		 * @param elements
		 *            the child elements
		 */
		public void handleChildrenRemove(@NonNull M parent, @NonNull Collection<@NonNull C> elements);
	}

	/**
	 * Attach child processing
	 *
	 * @param eventBroker
	 *            the event broker
	 * @param renderer
	 *            the renderer
	 * @param <C>
	 *            the child element type
	 * @param <M>
	 *            the container element type
	 * @param <R>
	 *            the renderer type
	 */
	public static <C extends MUIElement, M extends MElementContainer<C>, R extends BaseRenderer<M, ?> & ChildrenHandler<M, C>> void attachChildProcessor(IEventBroker eventBroker, final R renderer) {
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@SuppressWarnings({ "unchecked" })
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

	/**
	 * Attach visibility processing
	 *
	 * @param eventBroker
	 *            the even broker
	 * @param renderer
	 *            the renderer
	 * @param <M>
	 *            the container element type
	 * @param <R>
	 *            the renderer type
	 */
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
								Boolean current = (Boolean) changedObj.getTransientData().get(BaseRenderer.CALCULATED_VISIBILITY);
								boolean visibleWhen = BaseRenderer.checkVisibleWhen(changedObj, renderer.getModelContext(changedObj));
								if (current == null) {
									// FIXME Need to inform that the initial
									// visibility is not yet calculated
									current = Boolean.valueOf(!changedObj.isVisible() && visibleWhen);
								}

								boolean newVisibility = changedObj.isVisible() && visibleWhen;

								if (current.booleanValue() != newVisibility) {
									changedObj.getTransientData().put(BaseRenderer.CALCULATED_VISIBILITY, Boolean.valueOf(newVisibility));

									if (newVisibility) {
										renderer.showChild((M) parent, changedObj);
									} else {
										renderer.hideChild((M) parent, changedObj);
									}
								}
							}
						}
					}
				}
			}
		});
		eventBroker.subscribe(Constants.UPDATE_VISIBLE_WHEN_RESULT, new EventHandler() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				MUIElement element = (MUIElement) event.getProperty(IEventBroker.DATA);
				if (element.isToBeRendered()) {
					EObject parent = ((EObject) element).eContainer();
					if (parent instanceof MUIElement) {
						if (((MUIElement) parent).getRenderer() == renderer) {
							Boolean current = (Boolean) element.getTransientData().get(BaseRenderer.CALCULATED_VISIBILITY);
							boolean visibleWhen = BaseRenderer.checkVisibleWhen(element, renderer.getModelContext(element));

							if (current == null) {
								current = Boolean.valueOf(element.isVisible());
							}
							
							if( element.getTags().contains(BaseItemRenderer.TAG_HIDE_ON_DISABLE) ) {
								if( element instanceof MItem ) {
									MItem i = (MItem) element;
									Object renderer = element.getRenderer();
									if( renderer instanceof BaseItemRenderer ) {
										visibleWhen = visibleWhen && i.isEnabled()
												&& ((BaseItemRenderer) renderer).canExecute(element, ((BaseItemRenderer) renderer).getModelContext(element));
									}
								}
							}

							boolean newVisibility = element.isVisible() && visibleWhen;
							if (current.booleanValue() != newVisibility) {
								element.getTransientData().put(BaseRenderer.CALCULATED_VISIBILITY, Boolean.valueOf(newVisibility));

								if (newVisibility) {
									// TODO Is childRendered not dangerous to
									// call
									// here??
									renderer.childRendered((M) parent, element);
								} else {
									renderer.hideChild((M) parent, element);
								}
							}
						}
					}
				}
			}
		});
	}
}
