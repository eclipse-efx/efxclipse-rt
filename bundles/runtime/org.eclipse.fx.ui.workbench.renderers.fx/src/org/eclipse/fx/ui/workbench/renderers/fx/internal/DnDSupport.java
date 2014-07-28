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
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.MarkerFeedback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.DropType;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.TabPaneDragFinishedEvent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.TabPaneDragStartEvent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.TabPaneDroppedEvent;
import org.eclipse.fx.ui.workbench.renderers.fx.internal.DnDTabPaneSkin.TabPaneFeedbackDragEvent;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Class implementing DnD
 */
public class DnDSupport {
	@NonNull
	private final WCallback<@Nullable Void, @Nullable WCallback<@NonNull DragData, @NonNull Boolean>> dragStartCallbackProvider;

	@NonNull
	private final WCallback<@Nullable Void, @Nullable WCallback<@NonNull DropData, @Nullable Void>> dropCallbackProvider;

	@NonNull
	private final DnDFeedbackService feedbackService;

	@NonNull
	private final MPartStack stack;

	@Nullable
	private static MarkerFeedback CURRENT_FEEDBACK = null;
	
	@NonNull
	private static final Logger LOGGER = LoggerCreator.createLogger(DnDSupport.class);

	/**
	 * Create a new dnd support instance
	 * 
	 * @param dragStartCallbackProvider
	 *            the start callback
	 * @param dropCallbackProvider
	 *            the drop callback
	 * @param feedbackService
	 *            the feedback service
	 * @param stack
	 *            the stack working for
	 */
	public DnDSupport(@NonNull WCallback<@Nullable Void, @Nullable WCallback<@NonNull DragData, @NonNull Boolean>> dragStartCallbackProvider, @NonNull WCallback<@Nullable Void, @Nullable WCallback<@NonNull DropData, @Nullable Void>> dropCallbackProvider, @NonNull DnDFeedbackService feedbackService,
			@NonNull MPartStack stack) {
		this.dragStartCallbackProvider = dragStartCallbackProvider;
		this.dropCallbackProvider = dropCallbackProvider;
		this.feedbackService = feedbackService;
		this.stack = stack;
	}

	/**
	 * Handle the drag start
	 * 
	 * @param event
	 *            the event
	 */
	public void handleDragStart(TabPaneDragStartEvent event) {
		WCallback<DragData, Boolean> dragStartCallback = this.dragStartCallbackProvider.call(null);
		if (dragStartCallback != null) {
			WStackItem<?, ?> item = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) event.tab.getUserData();
			MStackElement itemElement = item.getDomElement();
			if (itemElement == null) {
				return;
			}
			MPartStack itemContainer = (MPartStack) (MUIElement) itemElement.getParent();
			if (itemContainer != null) {
				DragData dragData = new DragData(itemContainer, itemElement);
				if (!dragStartCallback.call(dragData).booleanValue()) {
					event.consume();
				}
			} else {
				LOGGER.error("Stack element '" + itemElement + "' has no container"); //$NON-NLS-1$//$NON-NLS-2$
			}

		} else {
			event.consume();
		}
	}

	/**
	 * Handle the drop
	 * 
	 * @param event
	 *            the event
	 */
	@SuppressWarnings("all")
	public void handleDropped(TabPaneDroppedEvent event) {
		WCallback<DropData, Void> call = this.dropCallbackProvider.call(null);
		if (call != null) {
			WStackItem<?, ?> referenceItem = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) event.targetTab.getUserData();
			WStackItem<?, ?> sourceItem = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) event.sourceTab.getUserData();
			MStackElement domElement = sourceItem.getDomElement();
			if (domElement != null) {
				call.call(new DropData(referenceItem.getDomElement(), domElement, event.type == DropType.AFTER ? org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.AFTER : org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.BEFORE));
			} else {
				LOGGER.error("Source item '" + sourceItem + "' has no dom element attached"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Handle the feedback event
	 * 
	 * @param event
	 *            the event
	 */
	public void handleFeedback(TabPaneFeedbackDragEvent event) {
		if (event.dropType == DropType.NONE) {
			cleanup();
			return;
		}

		MStackElement reference = ((WStackItem<?, ?>) event.targetTab.getUserData()).getDomElement();
		MStackElement sourceReference = ((WStackItem<?, ?>) event.sourceTab.getUserData()).getDomElement();

		DnDFeedbackData data = new DnDFeedbackData(reference, sourceReference, event.dropType == DropType.AFTER ? org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.AFTER : org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType.BEFORE, this.stack,
				new DnDFeedbackService.Region(event.bounds.getMinX(), event.bounds.getMinY(), event.bounds.getWidth(), event.bounds.getHeight()));

		MarkerFeedback f = CURRENT_FEEDBACK;
		if (f == null || !f.equals(data)) {
			cleanup();
			CURRENT_FEEDBACK = this.feedbackService.showFeedback(data);
		}
	}

	/**
	 * Handle the finish event
	 * 
	 * @param event
	 *            the event
	 */
	@SuppressWarnings("static-method")
	public void handleFinished(TabPaneDragFinishedEvent event) {
		cleanup();
	}

	static void cleanup() {
		if (CURRENT_FEEDBACK != null) {
			CURRENT_FEEDBACK.hide();
			CURRENT_FEEDBACK = null;
		}
	}
}
