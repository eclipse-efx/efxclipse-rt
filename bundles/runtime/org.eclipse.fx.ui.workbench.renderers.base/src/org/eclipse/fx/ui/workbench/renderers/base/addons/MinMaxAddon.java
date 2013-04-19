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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget.WMinMaxState;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;


@SuppressWarnings("restriction")
public class MinMaxAddon {
	@Inject
	IEventBroker eventBroker;
	
	private static String MINIMIZED = IPresentationEngine.MINIMIZED;
	private static String MAXIMIZED = IPresentationEngine.MAXIMIZED;

	
	private EventHandler widgetListener = new EventHandler() {

		@Override
		public void handleEvent(Event event) {
			final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);
			
			if (!(changedElement instanceof MPartStack) && !(changedElement instanceof MArea))
				return;
			
			WMinMaxableWidget widget = getWidget(changedElement);
			
			if( widget == null ) {
				return;
			}
			
			adjustState(changedElement, widget);
			widget.setMinMaxCallback(new WCallback<WMinMaxableWidget.WMinMaxState, Void>() {
				
				@Override
				public Void call(WMinMaxState param) {
					return null;
				}
			});
		}
		
		private void adjustState(MUIElement changedElement, WMinMaxableWidget widget) {
			if( changedElement.getTags().contains(MAXIMIZED) ) {
				widget.setMinMaxState(WMinMaxState.MAXIMIZED);
			} else if( changedElement.getTags().contains(MINIMIZED) ) {
				widget.setMinMaxState(WMinMaxState.MINIMIZED);
			} else {
				widget.setMinMaxState(WMinMaxState.RESTORED);
			}
		}

		
//		private void adjustState(MUIElement element) {
//			if (!(element instanceof MPartStack) && !(element instanceof MPlaceholder))
//				return;
//
//			WMinMaxableWidget ctf = getWidget(element);
//			if (ctf == null)
//				return;
//
//			if (element instanceof MPlaceholder) {
//				setCTFButtons(ctf, element, false);
//			} else {
//				MArea area = getAreaFor((MPartStack) element);
//				if (area == null) {
//					setCTFButtons(ctf, element, false);
//				}
//			}
//		}
//		
//		private void setCTFButtons(WMinMaxableWidget ctf, MUIElement stateElement, boolean hideButtons) {
//			if (hideButtons) {
//				ctf.setMinMaxState();
//				ctf.setMinimizeVisible(false);
//				ctf.setMaximizeVisible(false);
//			} else {
//				if (stateElement.getTags().contains(MINIMIZED)) {
//					ctf.setMinimizeVisible(false);
//					ctf.setMaximizeVisible(true);
//					ctf.setMaximized(true);
//				} else if (stateElement.getTags().contains(MAXIMIZED)) {
//					ctf.setMinimizeVisible(true);
//					ctf.setMaximizeVisible(true);
//					ctf.setMaximized(true);
//				} else {
//					ctf.setMinimizeVisible(true);
//					ctf.setMaximizeVisible(true);
//					ctf.setMinimized(false);
//					ctf.setMaximized(false);
//					ctf.layout();
//				}
//			}
//		}

		
		private WMinMaxableWidget getWidget(MUIElement changedElement) {
			if( changedElement instanceof MPlaceholder ) {
				return getWidget(((MPlaceholder) changedElement).getRef());
			}
			
			if( changedElement.getWidget() instanceof WMinMaxableWidget ) {
				return (WMinMaxableWidget) changedElement.getWidget();
			}
			return null;
		}
		
		
		
	};
	
	@PostConstruct
	void hookListeners() {
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_WIDGET, widgetListener);
	}
}
