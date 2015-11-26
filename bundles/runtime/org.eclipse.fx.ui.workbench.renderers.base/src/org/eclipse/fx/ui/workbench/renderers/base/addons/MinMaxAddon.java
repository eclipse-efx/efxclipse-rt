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
package org.eclipse.fx.ui.workbench.renderers.base.addons;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.workbench.renderers.base.services.MaximizationService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget.WMinMaxState;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;

/**
 * Addon for a MinMax support
 */
public class MinMaxAddon {
	static String MINIMIZED = IPresentationEngine.MINIMIZED;
	static String MAXIMIZED = IPresentationEngine.MAXIMIZED;

	private final EModelService modelService;

	@Inject
	MinMaxAddon(IEventBroker eventBroker, EModelService modelService) {
		this.modelService = modelService;
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_WIDGET, this::handleWidget);
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, this::handleChildrenChanged);
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_TOBERENDERED, this::handleVisibleChildrenChanged);
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_VISIBLE, this::handleVisibleChildrenChanged);
	}

	void handleChildrenChanged(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
		if( changedElement instanceof MElementContainer<?> ) {
			// TODO we also need to check for visiblity!!!!
			if( this.modelService.toBeRenderedCount((MElementContainer<?>) changedElement) == 0 ) {
				handleMinMaxCallback(WMinMaxState.RESTORE, changedElement);
			}
		}
	}

	void handleVisibleChildrenChanged(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
		if( ! changedElement.isToBeRendered() || ! changedElement.isVisible() ) {
			handleMinMaxCallback(WMinMaxState.RESTORE, changedElement);
		}

		if( changedElement.getParent() != null ) {
			// TODO we also need to check for visiblity!!!!
			if( this.modelService.toBeRenderedCount((MElementContainer<?>) changedElement.getParent()) == 0 ) {
				handleMinMaxCallback(WMinMaxState.RESTORE, changedElement.getParent());
			}
		}
	}

	void handleWidget(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
		if( changedElement != null ) {
			WMinMaxableWidget widget = getTargetWidget(changedElement);

			if( widget != null ) {
				widget.setMinMaxCallback( s -> handleMinMaxCallback(s, changedElement) );
			}
		}
	}

	Void handleMinMaxCallback( WMinMaxState state, @NonNull MUIElement changedElement ) {
		IEclipseContext context;
		if( changedElement instanceof MContext ) {
			context = ((MContext)changedElement).getContext();
		} else {
			context = this.modelService.getContainingContext(changedElement);
		}

		MaximizationService maximizationService = context.get(MaximizationService.class);
		if( state == WMinMaxState.TOGGLE ) {
			if( maximizationService.isMaximized(changedElement) ) {
				maximizationService.restore();
			} else {
				maximizationService.maximize(changedElement);
			}
		} else if( state == WMinMaxState.MAXIMIZE ) {
			if( ! maximizationService.isMaximized(changedElement) ) {
				maximizationService.maximize(changedElement);
			}
		} else {
			if( maximizationService.isMaximized(changedElement) ) {
				maximizationService.restore();
			}
		}

		return null;
	}

	private WMinMaxableWidget getTargetWidget(MUIElement changedElement) {
		if (changedElement instanceof MPlaceholder) {
			return getTargetWidget(((MPlaceholder) changedElement).getRef());
		}

		if (changedElement.getWidget() instanceof WMinMaxableWidget) {
			return (WMinMaxableWidget) changedElement.getWidget();
		}
		return null;
	}
}
