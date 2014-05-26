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
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.MarkerFeedback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane.DropType;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane.TabPaneDragFinishedEvent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane.TabPaneDragStartEvent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane.TabPaneDroppedEvent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPane.TabPaneFeedbackDragEvent;

@SuppressWarnings("javadoc")
public class DnDSupport {
	private final WCallback<Void, WCallback<DragData, Boolean>> dragStartCallbackProvider;
	private final WCallback<Void, WCallback<DropData, Void>> dropCallbackProvider;
	private final DnDFeedbackService feedbackService;
	private final MPartStack stack;
	
	private static MarkerFeedback CURRENT_FEEDBACK = null;

	public DnDSupport(
			WCallback<Void, WCallback<DragData, Boolean>> dragStartCallbackProvider,
			WCallback<Void, WCallback<DropData, Void>> dropCallbackProvider,
			DnDFeedbackService feedbackService,
			MPartStack stack) {
		this.dragStartCallbackProvider = dragStartCallbackProvider;
		this.dropCallbackProvider = dropCallbackProvider;
		this.feedbackService = feedbackService;
		this.stack = stack;
	}
	
	public void handleDragStart(TabPaneDragStartEvent event) {
		WCallback<DragData, Boolean> dragStartCallback = this.dragStartCallbackProvider.call(null);
		if( dragStartCallback != null ) {
			WStackItem<?, ?> item = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) event.tab.getUserData();
			MStackElement itemElement = item.getDomElement();
			if( itemElement == null ) {
				return;
			}
			MPartStack itemContainer = (MPartStack)(MUIElement)itemElement.getParent();
			DragData dragData = new DragData(itemContainer, itemElement);
			if( ! dragStartCallback.call(dragData).booleanValue() ) {
				event.consume();
			}
		} else {
			event.consume();
		}
	}
	
	public void handleDropped(TabPaneDroppedEvent event) {
		WCallback<DropData, Void> call = this.dropCallbackProvider.call(null);
		if( call != null ) {
			WStackItem<?, ?> referenceItem = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) event.targetTab.getUserData();
			WStackItem<?, ?> sourceItem = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) event.sourceTab.getUserData();
			call.call(new DropData(referenceItem.getDomElement(), sourceItem.getDomElement(), event.type == DropType.AFTER ? org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.AFTER : org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.BEFORE));
		}
	}
	
	public void handleFeedback(TabPaneFeedbackDragEvent event) {
		if( event.dropType == DropType.NONE ) {
			cleanup();
			return;
		}
		
		MStackElement reference = ((WStackItem<?, ?>)event.targetTab.getUserData()).getDomElement();
		MStackElement sourceReference = ((WStackItem<?, ?>)event.sourceTab.getUserData()).getDomElement();
		
		DnDFeedbackData data = new DnDFeedbackData(
				reference, 
				sourceReference, 
				event.dropType == DropType.AFTER ? org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.AFTER : org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.BEFORE,
				this.stack,
				new DnDFeedbackService.Region(event.bounds.getMinX(), event.bounds.getMinY(), event.bounds.getWidth(), event.bounds.getHeight())
				);
		
		if( CURRENT_FEEDBACK == null || ! CURRENT_FEEDBACK.equals(data) ) {
			cleanup();
			CURRENT_FEEDBACK = this.feedbackService.showFeedback(data);
		}
	}
	
	@SuppressWarnings("static-method")
	public void handleFinished(TabPaneDragFinishedEvent event) {
		cleanup();
	}
	
	static void cleanup() {
		if( CURRENT_FEEDBACK != null ) {
			CURRENT_FEEDBACK.hide();
			CURRENT_FEEDBACK = null;
		}
	}
}
