/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.ui.workbench.renderers.base.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MGenericTile;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.ui.workbench.renderers.base.BaseWindowRenderer;
import org.osgi.service.event.Event;

/**
 * Addon which cleans up the model from empty containers
 */
public class CleanUpAddon {

	@Inject
	ThreadSynchronize synchronize;

	@Inject
	EModelService modelService;
	
	int inTearDown;

	@PostConstruct
	void init(IEventBroker broker) {
		broker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, this::handleChildrenModified);
		broker.subscribe(UIEvents.UIElement.TOPIC_TOBERENDERED, this::handleRenderingChanged);
	}

	@SuppressWarnings("unchecked")
	private void handleChildrenModified(Event event) {
		Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		if (UIEvents.isREMOVE(event)) {
			final MElementContainer<?> container = (MElementContainer<?>) changedObj;
			MUIElement containerParent = container.getParent();

			// Elements who will never be destroyed even when empty
			if (container instanceof MCompositePart || container instanceof MApplication || container instanceof MPerspectiveStack || container instanceof MMenuElement || container instanceof MTrimBar || container instanceof MToolBar || container instanceof MArea || container.getTags().contains(IPresentationEngine.NO_AUTO_COLLAPSE)) {
				return;
			}

			if (container instanceof MWindow
					&& containerParent instanceof MApplication) {
				if( ! container.getTags().contains(BaseWindowRenderer.TAG_SECONDARY_WINDOW) ) {
					return;
				}
			}

			Runnable runnable = () -> {
				int tbrCount = this.modelService.toBeRenderedCount(container);

				// Cache the value since setting the TBR may change the result
				boolean lastStack = isLastEditorStack(container);
				if (tbrCount == 0 && !lastStack) {
					container.setToBeRendered(false);
				}

				if (container.getChildren().isEmpty()) {
					container.setParent(null);
				} else if( /* we never collapse MCompositePart see 464328*/ (!(container instanceof MCompositePart)) && container instanceof MGenericTile<?> && container.getChildren().size() == 1 ) {
					final MGenericTile<MUIElement> tile = (MGenericTile<MUIElement>) container;
					int idx = container.getParent().getChildren().indexOf(container);

					String containerData = tile.getContainerData();
					MUIElement child = container.getChildren().remove(0);
					if( child != null ) {
						child.setContainerData(containerData);
						container.getParent().getChildren().add(idx,child);
						container.setParent(null);
					} else {
						LoggerCreator.createLogger(getClass()).error("Container has a NULL value as a child"); //$NON-NLS-1$
					}
				}
			};
			this.synchronize.scheduleExecution(200, runnable);
		}
	}

	private void handleRenderingChanged(Event event) {
		MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
		MElementContainer<MUIElement> container = null;
		if (changedObj.getCurSharedRef() != null)
			container = changedObj.getCurSharedRef().getParent();
		else
			container = changedObj.getParent();

		// this can happen for shared parts that aren't attached to any placeholders
		if (container == null) {
			return;
		}

		// never hide top-level windows
		MUIElement containerElement = container;
		if (containerElement instanceof MWindow && ! containerElement.getTags().contains(BaseWindowRenderer.TAG_SECONDARY_WINDOW) && containerElement.getParent() != null) {
			return;
		}

		// These elements should neither be shown nor hidden based on their containment state
		if (isLastEditorStack(containerElement) || containerElement instanceof MPerspective
				|| containerElement instanceof MPerspectiveStack)
			return;

		Boolean toBeRendered = (Boolean) event.getProperty(UIEvents.EventTags.NEW_VALUE);
		if (Boolean.TRUE.equals(toBeRendered)) {
			// Bring the container back if one of its children goes visible
			if (!container.isToBeRendered())
				container.setToBeRendered(true);
			if (!container.isVisible()
					&& !container.getTags().contains(IPresentationEngine.MINIMIZED))
				container.setVisible(true);
		} else {
			// Never hide the container marked as no_close
			if (container.getTags().contains(IPresentationEngine.NO_AUTO_COLLAPSE)) {
				return;
			}

			int visCount = this.modelService.countRenderableChildren(container);

			// Remove stacks with no visible children from the display (but not the
			// model)
			final MElementContainer<MUIElement> theContainer = container;
			if (visCount == 0) {
				Runnable runnable = () -> {
						this.inTearDown++;
						try {
							int _visCount = this.modelService.countRenderableChildren(theContainer);
							if (!isLastEditorStack(theContainer) && _visCount == 0) {
								theContainer.setToBeRendered(false);
							}
						} finally {
							this.inTearDown--;
						}
						
					};
				if( this.inTearDown > 0 ) {
					runnable.run();
				} else {
					this.synchronize.scheduleExecution(200, runnable);
				}
			} else {
				// if there are rendered elements but none are 'visible' we should
				// make the container invisible as well
				boolean makeInvisible = true;

				// OK, we have rendered children, are they 'visible' ?
				for (MUIElement kid : container.getChildren()) {
					if (!kid.isToBeRendered())
						continue;
					if (kid.isVisible()) {
						makeInvisible = false;
						break;
					}
				}

				if (makeInvisible) {
					container.setVisible(false);
				}
			}
		}
	}

	boolean isLastEditorStack(MUIElement element) {
		return this.modelService.isLastEditorStack(element);
	}
}
