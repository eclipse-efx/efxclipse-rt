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

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DropType;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.DroppedData;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory.FeedbackData;
import org.eclipse.fx.ui.controls.tabpane.GenericTab;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Class implementing DnD
 */
public class DnDSupport extends BaseDnDSupport {
	@NonNull
	private final WCallback<@Nullable Void, @Nullable WCallback<@NonNull DragData, @NonNull Boolean>> dragStartCallbackProvider;

	@NonNull
	private final WCallback<@Nullable Void, @Nullable WCallback<@NonNull DropData, @Nullable Void>> dropCallbackProvider;

	@NonNull
	private final MPartStack stack;

	@NonNull
	private static final Logger LOGGER = LoggerCreator.createLogger(DnDSupport.class);

	@Nullable
	private final DnDService dndService;

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
	 * @param dndService
	 *            the dnd service
	 */
	public DnDSupport(@NonNull WCallback<@Nullable Void, @Nullable WCallback<@NonNull DragData, @NonNull Boolean>> dragStartCallbackProvider, @NonNull WCallback<@Nullable Void, @Nullable WCallback<@NonNull DropData, @Nullable Void>> dropCallbackProvider, @NonNull DnDFeedbackService feedbackService,
			@NonNull MPartStack stack, @Nullable DnDService dndService) {
		super(feedbackService);
		this.dndService = dndService;
		this.dragStartCallbackProvider = dragStartCallbackProvider;
		this.dropCallbackProvider = dropCallbackProvider;
		this.stack = stack;
	}

	/**
	 * Function to serialize tab
	 *
	 * @param tab
	 *            the tab
	 * @return the tab
	 */
	@SuppressWarnings({ "static-method" })
	public @NonNull String clipboardDataFunction(@NonNull GenericTab tab) {
		MStackElement domElement = ((WStackItem<?, ?>) tab.getUserData()).getDomElement();
		String rv = null;
		if (domElement != null) {
			EObject eo = (EObject) domElement;
			rv = ((XMIResource) eo.eResource()).getID(eo);
		}
		if (rv != null) {
			return rv;
		}
		return System.identityHashCode(tab) + ""; //$NON-NLS-1$
	}

	/**
	 * Handle the drag start
	 *
	 * @param tab
	 *            the tab
	 * @return <code>true</code> if drag can start
	 *
	 */
	@SuppressWarnings("null")
	public @NonNull Boolean handleDragStart(@NonNull GenericTab tab) {
		WCallback<DragData, Boolean> dragStartCallback = this.dragStartCallbackProvider.call(null);
		if (dragStartCallback != null) {
			WStackItem<?, ?> item = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) tab.getUserData();
			MStackElement itemElement = item.getDomElement();
			if (itemElement == null) {
				return Boolean.FALSE;
			}
			MPartStack itemContainer = (MPartStack) (MUIElement) itemElement.getParent();
			if (itemContainer != null) {
				DragData dragData = new DragData(itemContainer, itemElement);
				if (!dragStartCallback.call(dragData).booleanValue()) {
					return Boolean.TRUE;
				}
			} else {
				LOGGER.error("Stack element '" + itemElement + "' has no container"); //$NON-NLS-1$//$NON-NLS-2$
			}

		}
		return Boolean.TRUE;
	}

	/**
	 * Handle the drop
	 *
	 * @param event
	 *            the event
	 */
	@SuppressWarnings("all")
	public void handleDropped(DroppedData data) {
		WCallback<DropData, Void> call = this.dropCallbackProvider.call(null);
		if (call != null) {
			if (data.dropType == DropType.DETACH) {
				WStackItem<?, ?> sourceItem = (org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem<?, ?>) data.draggedTab.getUserData();
				MStackElement domElement = sourceItem.getDomElement();
				if (domElement != null) {
					call.call(new DropData(data.x,data.y,null, domElement, org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation.DETACH));
				}
			} else {
				MStackElement reference = ((WStackItem<?, ?>) data.targetTab.getUserData()).getDomElement();
				MStackElement sourceReference = ((WStackItem<?, ?>) data.draggedTab.getUserData()).getDomElement();
								
				MElementContainer<MUIElement> parentRef = reference != null ? reference.getParent() : null;
				MElementContainer<MUIElement> parentSource = sourceReference != null ? sourceReference.getParent() : null;
				
				if( parentRef != parentSource && sourceReference != null && this.dndService != null && ! this.dndService.repartentAllowed(sourceReference) ) {
					cleanup();
					return;
				}
				
				if (sourceReference != null) {
					call.call(new DropData(data.x, data.y, reference, sourceReference, data.dropType == DropType.AFTER ? org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation.AFTER : org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation.BEFORE));
				} else {
					LOGGER.error("Source item '" + data.draggedTab.getUserData() + "' has no dom element attached"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
	}

	/**
	 * Handle the feedback event
	 *
	 * @param data
	 *            the data
	 *
	 */
	public void handleFeedback(FeedbackData data) {
		if (data.dropType == DropType.NONE) {
			cleanup();
			return;
		}
		
		MStackElement reference = ((WStackItem<?, ?>) data.targetTab.getUserData()).getDomElement();
		MStackElement sourceReference = ((WStackItem<?, ?>) data.draggedTab.getUserData()).getDomElement();
		
		MElementContainer<MUIElement> parentRef = reference != null ? reference.getParent() : null;
		MElementContainer<MUIElement> parentSource = sourceReference != null ? sourceReference.getParent() : null;
		
		if( parentRef != parentSource && sourceReference != null && this.dndService != null && ! this.dndService.repartentAllowed(sourceReference) ) {
			cleanup();
			return;
		}
		
		updateFeedback(new DnDFeedbackData(reference, sourceReference, data.dropType == DropType.AFTER ? org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation.AFTER : org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation.BEFORE, this.stack,
				new DnDFeedbackService.Region(data.bounds.getMinX(), data.bounds.getMinY(), data.bounds.getWidth(), data.bounds.getHeight())));
	}

	/**
	 * Handle the finish event
	 *
	 * @param tab
	 *            the tab
	 *
	 */
	@SuppressWarnings("static-method")
	public void handleFinished(GenericTab tab) {
		cleanup();
	}

}
