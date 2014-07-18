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
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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

		if (changedElement.getWidget() instanceof WDragTargetWidget) {
			return (WDragTargetWidget) changedElement.getWidget();
		}
		return null;
	}
	
	private WStack<?, ?, ?> getSourceWidget(MUIElement changedElement) {
		if (changedElement instanceof MPlaceholder) {
			return getSourceWidget(((MPlaceholder) changedElement).getRef());
		}

		if (changedElement.getWidget() instanceof WDragSourceWidget) {
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
		
		WDragSourceWidget sourceWidget = getSourceWidget(changedElement);
		if( sourceWidget != null ) {
			sourceWidget.setDragStartCallback(this::dragStartHandler);
		}
	}
	
	private Void droppedHandler(DropData d) {
		@Nullable
		MUIElement reference = d.reference;
//		LEADS to an ArrayIndexOutOfBoundsException
//		@NonNull
		MUIElement sourceElement = d.sourceElement;
		
		if( d.dropType == DropType.INSERT ) {
			if( reference != null && reference instanceof MElementContainer<?> ) {
				@SuppressWarnings("unchecked")
				MElementContainer<MUIElement> c = (MElementContainer<MUIElement>) reference;
				c.getChildren().add(sourceElement); 
			}
		} else if( reference != null ) {
			MElementContainer<MUIElement> sourceContainer = sourceElement.getParent();
			MElementContainer<MUIElement> targetContainer = reference.getParent();
			
			if( sourceContainer == targetContainer ) {
				try {
					targetContainer.getTags().add(CSS_CLASS_STACK_MOVE);
					sourceElement.getTransientData().put(BaseStackRenderer.MAP_MOVE, Boolean.TRUE);
					List<MUIElement> children = targetContainer.getChildren();
					children.remove(sourceElement);
					
					int idx = targetContainer.getChildren().indexOf(reference);
					
					if( d.dropType == DropType.AFTER ) {
						idx += 1;
					}
					
					if( idx > targetContainer.getChildren().size() ) {
						targetContainer.getChildren().add(sourceElement);
					} else {
						targetContainer.getChildren().add(idx, sourceElement);
					}
					
				} finally {
					sourceElement.getTransientData().put(BaseStackRenderer.MAP_MOVE, Boolean.TRUE);
					targetContainer.getTags().remove(CSS_CLASS_STACK_MOVE);
				}
			} else {
				int idx = targetContainer.getChildren().indexOf(reference);
				if( d.dropType == DropType.AFTER ) {
					idx += 1;
				}
				
				if( idx < targetContainer.getChildren().size() ) {
					targetContainer.getChildren().add(idx, sourceElement);
				} else {
					targetContainer.getChildren().add(sourceElement);
				}
			}
			
			TimerTask t = new TimerTask() {
				
				@Override
				public void run() {
					DnDAddon.this.synchronize.asyncExec(new Runnable() {
						
						@Override
						public void run() {
							targetContainer.setSelectedElement(sourceElement);
						}
					});
				}
			};
			this.timer.schedule(t, 200);
		}
		
		return null;
	}
	
	@SuppressWarnings("null")
	@NonNull
	private Boolean dragStartHandler(@NonNull DragData d) {
		return Boolean.TRUE;
	}
	
	@PostConstruct
	void hookListeners() {
		this.eventBroker.subscribe(UIEvents.UIElement.TOPIC_WIDGET, this::handleWidget);
	}
}
