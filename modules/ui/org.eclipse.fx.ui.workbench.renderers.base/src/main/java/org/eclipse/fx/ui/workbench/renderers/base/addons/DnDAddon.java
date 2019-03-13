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
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.workbench.renderers.base.BaseStackRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragSourceWidget.DragData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropLocation;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation;
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
	UISynchronize synchronize;

	@Inject
	EModelService modelService;

	@Inject
	@Optional
	DnDService dndService;

	// FIXME This is workaround because of TabFolder problems
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

		if (acceptWidget != null) {
			acceptWidget.setDragDroppedCallback(this::droppedHandler);
		}

		if (!(changedElement instanceof MPartStack) && !(changedElement instanceof MArea))
			return;

		WDragSourceWidget sourceWidget = getSourceWidget(changedElement);
		if (sourceWidget != null) {
			sourceWidget.setDragStartCallback(this::dragStartHandler);
		}
	}

	private Void droppedHandler(DropData d) {
		@Nullable
		MUIElement reference = d.reference;
		@NonNull
		MUIElement sourceElement = d.sourceElement;

		if( d.dropType.isReorder() ) {
			if (reference != null ) {
				if( this.dndService == null || (this.dndService.reorderAllowed(reference, sourceElement, d.dropType)) && ! this.dndService.handleReorder(reference, sourceElement, d.dropType)) {
					if( d.dropType instanceof BasicDropLocation ) {
						handleReorder(reference, sourceElement, (@NonNull BasicDropLocation) d.dropType);
					}
				}
			}
		} else if( d.dropType.isDetach() ) {
			if( this.dndService == null || (this.dndService.detachAllowed(sourceElement) && ! this.dndService.handleDetach(d.x, d.y, sourceElement)) ) {
				handleDetach(d.x, d.y,sourceElement);
			}
		} else if( d.dropType.isInsert() ) {
			if (reference != null) {
				if( this.dndService == null || (this.dndService.insertAllowed(reference, sourceElement)) && ! this.dndService.handleInsert(reference, sourceElement)) {
					handleInsert(reference, sourceElement);
				}
			}
		} else if( d.dropType.isSplit() ) {
			if (reference != null) {
				if( this.dndService == null || (this.dndService.splitAllowed(reference, sourceElement, d.dropType)) && ! this.dndService.handleSplit(reference, sourceElement, d.dropType)) {
					handleSplit(reference, sourceElement, d.dropType);
				}
			}
		}

		return null;
	}

	private void handleDetach(double x, double y, @NonNull MUIElement sourceElement) {
		this.modelService.detach((MPartSashContainerElement) sourceElement, (int)x, (int)y, 800, 600);
	}

	private static void handleInsert(@NonNull MUIElement reference, @NonNull MUIElement sourceElement) {
		if (reference instanceof MElementContainer<?>) {
			@SuppressWarnings("unchecked")
			MElementContainer<MUIElement> c = (MElementContainer<MUIElement>) reference;
			c.getChildren().add(sourceElement);
		}
	}

	private void handleSplit(@NonNull MUIElement reference, @NonNull MUIElement sourceElement, @NonNull DropLocation dropType) {
		MElementContainer<MUIElement> parent = reference.getParent();
		if( (MUIElement)parent instanceof MPartStack ) {
			split(parent, sourceElement, dropType );
		}
	}

	private void split(MUIElement toSplit, MUIElement child, @NonNull DropLocation dropType) {
		// remove the moved element from its parent
		child.setParent(null);

		// remember the index to insert
		MElementContainer<MUIElement> owner = toSplit.getParent();
		int index = owner.getChildren().indexOf(toSplit);

		// remove the split from the parent
		owner.getChildren().remove(toSplit);

		MPartSashContainer container = this.modelService.createModelElement(MPartSashContainer.class);
		container.setElementId(UUID.randomUUID().toString());
		container.setContainerData(toSplit.getContainerData());

		MPartStack childContainer = this.modelService.createModelElement(MPartStack.class);
		childContainer.setElementId(UUID.randomUUID().toString());
		childContainer.getChildren().add((MStackElement) child);

		toSplit.setContainerData(null);
		childContainer.setContainerData(null);

		container.setToBeRendered(true);
		container.setVisible(true);
		container.setHorizontal(dropType == BasicDropLocation.SPLIT_LEFT || dropType == BasicDropLocation.SPLIT_RIGHT);
		if( dropType == BasicDropLocation.SPLIT_TOP || dropType == BasicDropLocation.SPLIT_LEFT ) {
			container.getChildren().add((MPartSashContainerElement) childContainer);
			container.getChildren().add((MPartSashContainerElement) toSplit);
		} else {
			container.getChildren().add((MPartSashContainerElement) toSplit);
			container.getChildren().add((MPartSashContainerElement) childContainer);
		}
		owner.getChildren().add(index, container);
	}

	private void handleReorder(@NonNull MUIElement reference, @NonNull MUIElement sourceElement, @NonNull BasicDropLocation dropType) {
		MElementContainer<MUIElement> sourceContainer = sourceElement.getParent();
		MElementContainer<MUIElement> targetContainer = reference.getParent();

		if (sourceContainer == targetContainer) {
			try {
				targetContainer.getTags().add(CSS_CLASS_STACK_MOVE);
				sourceElement.getTransientData().put(BaseStackRenderer.MAP_MOVE, Boolean.TRUE);
				List<MUIElement> children = targetContainer.getChildren();
				children.remove(sourceElement);

				int idx = targetContainer.getChildren().indexOf(reference);

				if (dropType == BasicDropLocation.AFTER) {
					idx += 1;
				}

				if (idx > targetContainer.getChildren().size()) {
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
			if (dropType == BasicDropLocation.AFTER) {
				idx += 1;
			}

			if (idx < targetContainer.getChildren().size()) {
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

	@SuppressWarnings("null")
	@NonNull
	private Boolean dragStartHandler(@NonNull DragData d) {
		return Boolean.valueOf(this.dndService == null || this.dndService.dragAllowed(d.container, d.item));
	}

	@PostConstruct
	void hookListeners() {
		this.eventBroker.subscribe(UIEvents.UIElement.TOPIC_WIDGET, this::handleWidget);
	}
}
