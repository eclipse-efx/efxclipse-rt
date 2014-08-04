/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.services.sync.UISynchronize;
import org.osgi.service.event.Event;

/**
 * Addon which cleans up the model from empty containers
 */
public class CleanUpAddon {

	@Inject
	UISynchronize synchronize;

	@PostConstruct
	void init(IEventBroker broker) {
		broker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, this::handleChildrenModified);
	}

	private void handleChildrenModified(Event event) {
		Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		if (UIEvents.isREMOVE(event)) {
			final MElementContainer<?> container = (MElementContainer<?>) changedObj;
			MUIElement containerParent = container.getParent();

			// Elements who will never be destroyed even when empty
			if (container instanceof MApplication || container instanceof MPerspectiveStack || container instanceof MMenuElement || container instanceof MTrimBar || container instanceof MToolBar || container instanceof MArea || container.getTags().contains(IPresentationEngine.NO_AUTO_COLLAPSE)) {
				return;
			}

			if (container instanceof MWindow && containerParent instanceof MApplication) {
				return;
			}

			this.synchronize.scheduleExecution(200, () -> {
				if (container.getChildren().isEmpty()) {
					container.setParent(null);
					
				} else if( container instanceof MGenericTile<?> && container.getChildren().size() == 1 ) {
					final MGenericTile<MUIElement> tile = (MGenericTile<MUIElement>) container;
					int idx = container.getParent().getChildren().indexOf(container);
					
					String containerData = tile.getContainerData();
					MUIElement child = container.getChildren().remove(0);
					child.setContainerData(containerData);
					container.getParent().getChildren().add(idx,child);
					container.setParent(null);
				}
			});
		}
	}
}
