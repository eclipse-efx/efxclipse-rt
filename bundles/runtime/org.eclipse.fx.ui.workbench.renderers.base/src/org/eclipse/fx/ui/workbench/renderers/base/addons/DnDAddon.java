/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.addons;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.workbench.renderers.base.BaseStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack;
import org.osgi.service.event.Event;

/**
 * Addon who enables drag for {@link MPartStack}
 */
public class DnDAddon {
	private static String CSS_CLASS_STACK_MOVE = "stack-move"; //$NON-NLS-1$
	
	@Inject
	IEventBroker eventBroker;
	
	@Inject
	EPartService partService;
	
	@Inject
	UISynchronize synchronize;
	
	//FIXME This is workaround because of TabFolder problems
	private Timer timer;
	
	/**
	 * Create an instance
	 */
	public DnDAddon() {
		this.timer = new Timer(true);
	}
	
	private WDragTargetWidget getTargetWidget(MUIElement changedElement) {
		if (changedElement instanceof MPlaceholder) {
			return getTargetWidget(((MPlaceholder) changedElement).getRef());
		}

		if (changedElement.getWidget() instanceof WMinMaxableWidget) {
			return (WDragTargetWidget) changedElement.getWidget();
		}
		return null;
	}
	
	private WStack<?, ?, ?> getSourceWidget(MUIElement changedElement) {
		if (changedElement instanceof MPlaceholder) {
			return getSourceWidget(((MPlaceholder) changedElement).getRef());
		}

		if (changedElement.getWidget() instanceof WMinMaxableWidget) {
			return (WStack<?, ?, ?>) changedElement.getWidget();
		}
		return null;
	}
	
	private void handleWidget(Event event) {
		final MUIElement changedElement = (MUIElement) event.getProperty(EventTags.ELEMENT);

		WDragTargetWidget acceptWidget = getTargetWidget(changedElement);

		if( acceptWidget != null ) {
			acceptWidget.setDragDroppedCallback(this::droppedHandler);
		}
		
		if (!(changedElement instanceof MPartStack) && !(changedElement instanceof MArea))
			return;
		
		WStack<?, ?, ?> sourceWidget = getSourceWidget(changedElement);
		if( sourceWidget != null ) {
			sourceWidget.setDragStartCallback(this::dragStartHandler);
		}
	}
	
	private Void droppedHandler(DropData d) {
		MElementContainer<MUIElement> sourceContainer = d.sourceElement.getParent();
		MElementContainer<MUIElement> targetContainer = d.reference.getParent();
		
		if( sourceContainer == targetContainer ) {
			try {
				targetContainer.getTags().add(CSS_CLASS_STACK_MOVE);
				d.sourceElement.getTransientData().put(BaseStackRenderer.MAP_MOVE, Boolean.TRUE);
				List<MUIElement> children = targetContainer.getChildren();
				children.remove(d.sourceElement);
				int idx = targetContainer.getChildren().indexOf(d.reference);
				
				if( d.dropType == DropType.AFTER ) {
					idx += 1;
				}
				
				if( idx > targetContainer.getChildren().size() ) {
					targetContainer.getChildren().add(d.sourceElement);
				} else {
					targetContainer.getChildren().add(idx, d.sourceElement);
				}
			} finally {
				d.sourceElement.getTransientData().put(BaseStackRenderer.MAP_MOVE, Boolean.TRUE);
				targetContainer.getTags().remove(CSS_CLASS_STACK_MOVE);
			}
		} else {
			int idx = targetContainer.getChildren().indexOf(d.reference);
			if( d.dropType == DropType.AFTER ) {
				idx += 1;
			}
			
			if( idx < targetContainer.getChildren().size() ) {
				targetContainer.getChildren().add(idx, d.sourceElement);
			} else {
				targetContainer.getChildren().add(d.sourceElement);
			}
		}
		
		TimerTask t = new TimerTask() {
			
			@Override
			public void run() {
				synchronize.asyncExec(new Runnable() {
					
					@Override
					public void run() {
						targetContainer.setSelectedElement(d.sourceElement);
					}
				});
			}
		};
		timer.schedule(t, 200);
		
		return null;
	}
	
	private Boolean dragStartHandler(DragData d) {
		return Boolean.TRUE;
	}
	
	@PostConstruct
	void hookListeners() {
		this.eventBroker.subscribe(UIEvents.UIElement.TOPIC_WIDGET, this::handleWidget);
	}
}
