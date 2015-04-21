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
import org.eclipse.e4.ui.model.application.ui.MGenericTile;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.ui.controls.dnd.EFXDragEvent;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.event.Event;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

/**
 * Implementation of splitting with DnD
 *
 * @param <M>
 *            the domain model type
 */
public class SplitDnDSupport<M extends MUIElement> extends BaseDnDSupport {
	private final WLayoutedWidget<M> widget;

	@NonNull
	private final EModelService modelService;

	@Nullable
	private final DnDService constraintService;

	/**
	 * Create new instance
	 *
	 * @param modelService
	 *            the model service
	 * @param constraintService
	 *            the constraint service
	 * @param feedbackService
	 *            the feedback service
	 * @param widget
	 *            the widget
	 */
	public SplitDnDSupport(@NonNull EModelService modelService, @Nullable DnDService constraintService, @NonNull DnDFeedbackService feedbackService, WLayoutedWidget<M> widget) {
		super(feedbackService);
		this.constraintService = constraintService;
		this.modelService = modelService;
		this.widget = widget;
	}

	/**
	 * Handle exiting of the drag
	 *
	 * @param e
	 *            the event
	 */
	@SuppressWarnings("static-method")
	public void handleDragExit(DragEvent e) {
		cleanup();
	}

	private MUIElement findElement(String objectId) {
		EObject eo = (EObject) this.widget.getDomElement();
		EObject rv = null;
		if (eo != null) {
			rv = ((XMIResource) eo.eResource()).getEObject(objectId);
		}
		if (rv instanceof MUIElement) {
			return (MUIElement) rv;
		}
		return null;
	}

	public void handleDragOver(EFXDragEvent e) {
		_handleDragOver(e);
	}

	public void handleDragOver(DragEvent e) {
		_handleDragOver(e);
	}

	/**
	 * Handling the drag over
	 *
	 * @param e
	 *            the event
	 */
	private void _handleDragOver(Event e) {
		@Nullable
		M m = this.widget.getDomElement();
		
		if( m != null && this.constraintService != null && ! this.constraintService.splitAllowed(m) ) {
			return;
		}
		
		if (this.widget.getDropDroppedCallback() != null) {
			if (!DndTabPaneFactory.hasDnDContent(e)) {
				return;
			}

			if (m instanceof MGenericTile<?>) {
				// Tiles are not split
				e.consume();
			} else if (m instanceof MPart && isSplit(e)) {
				// Do not support spliting of none tab parts
				// if( (MUIElement)m.getParent() instanceof MGenericTile<?> ) {
				// e.consume();
				// e.acceptTransferModes(TransferMode.MOVE);
				// showSplitFeedback();
				// }
			} else if (m instanceof MElementContainer<?>) {
				MElementContainer<?> c = (MElementContainer<?>) m;
				if (this.modelService.countRenderableChildren(c) == 0) {
					setAcceptTransferModes(e, TransferMode.MOVE);
					e.consume();
				} else {
					updateFeedback(new DnDFeedbackData(null, null, getSplitType(e), c, null));
					setAcceptTransferModes(e, TransferMode.MOVE);
					e.consume();
				}
			}
		}
	}

	public void handleDragDropped(EFXDragEvent e) {
		_handleDragDropped(e);
	}

	public void handleDragDropped(DragEvent e) {
		_handleDragDropped(e);
	}

	/**
	 * Handle the drag
	 *
	 * @param e
	 *            the event
	 */
	private void _handleDragDropped(Event e) {
		@Nullable
		M m = this.widget.getDomElement();
		
		if( m != null && this.constraintService != null && ! this.constraintService.splitAllowed(m) ) {
			return;
		}
		
		@Nullable
		WCallback<@NonNull DropData, @Nullable Void> dropDroppedCallback = this.widget.getDropDroppedCallback();
		if (dropDroppedCallback != null) {
			if (!DndTabPaneFactory.hasDnDContent(e)) {
				return;
			}

			String objectId = DndTabPaneFactory.getDnDContent(e);

			MUIElement draggedElement = findElement(objectId);
			if (draggedElement == null) {
				return;
			}

			if (m instanceof MGenericTile<?>) {
				// Tiles are not split
				e.consume();
			} else if (m instanceof MPart && isSplit(e)) {
				e.consume();
				if ((MUIElement) m.getParent() instanceof MPartStack) {
					DropData d = new DropData(screenX(e), screenY(e), this.widget.getDomElement(), draggedElement, getSplitType(e));
					dropDroppedCallback.call(d);
					setDropComplete(e, true);
				}
			} else if (m instanceof MElementContainer<?>) {
				MElementContainer<?> c = (MElementContainer<?>) m;
				if (this.modelService.countRenderableChildren(c) == 0) {
					@SuppressWarnings("all")
					DropData d = new DropData(screenX(e), screenY(e), this.widget.getDomElement(), draggedElement, DropType.INSERT);
					dropDroppedCallback.call(d);
					e.consume();
					setDropComplete(e, true);
				}
			}
		}
	}

	@SuppressWarnings("all")
	private @NonNull DropType getSplitType(Event e) {
		SplitAreas areas = calculateSplitAreas();

		if (areas.left.contains(x(e), y(e))) {
			return DropType.SPLIT_LEFT;
		} else if (areas.right.contains(x(e), y(e))) {
			return DropType.SPLIT_RIGHT;
		} else if (areas.top.contains(x(e), y(e))) {
			return DropType.SPLIT_TOP;
		} else if (areas.bottom.contains(x(e), y(e))) {
			return DropType.SPLIT_BOTTOM;
		}

		return DropType.SPLIT_BOTTOM;
	}

	private static double x(Event e) {
		if (e instanceof DragEvent) {
			return ((DragEvent) e).getX();
		}
		return ((EFXDragEvent) e).getX();
	}

	private static double y(Event e) {
		if (e instanceof DragEvent) {
			return ((DragEvent) e).getY();
		}
		return ((EFXDragEvent) e).getY();
	}
	
	private static double screenX(Event e) {
		if (e instanceof DragEvent) {
			return ((DragEvent) e).getScreenX();
		}
		return ((EFXDragEvent) e).getScreenX();
	}

	private static double screenY(Event e) {
		if (e instanceof DragEvent) {
			return ((DragEvent) e).getScreenY();
		}
		return ((EFXDragEvent) e).getScreenY();
	}

	private static void setDropComplete(Event e, boolean complete) {
		if (e instanceof EFXDragEvent) {
			((EFXDragEvent) e).setComplete(complete);
		} else {
			((DragEvent) e).setDropCompleted(complete);
		}
	}

	private static void setAcceptTransferModes(Event e, TransferMode mode) {
		if (e instanceof DragEvent) {
			((DragEvent) e).acceptTransferModes(mode);
		}
	}

	private SplitAreas calculateSplitAreas() {
		Bounds bounds = ((Node) this.widget.getStaticLayoutNode()).getBoundsInLocal();

		double hSplitWidth = (bounds.getWidth() - SPLIT_PADDING * 2) / 5;
		double hSplitHeight = bounds.getHeight() - SPLIT_PADDING * 2;

		double vSplitWidth = bounds.getWidth() - SPLIT_PADDING * 2;
		double vSplitHeight = (bounds.getHeight() - SPLIT_PADDING * 2) / 2;

		Bounds leftSplit = new BoundingBox(SPLIT_PADDING, SPLIT_PADDING, hSplitWidth, hSplitHeight);
		Bounds rightSplit = new BoundingBox(bounds.getWidth() - SPLIT_PADDING - hSplitWidth, SPLIT_PADDING, hSplitWidth, hSplitHeight);

		Bounds topSplit = new BoundingBox(SPLIT_PADDING, SPLIT_PADDING, vSplitWidth, vSplitHeight);
		Bounds bottomSplit = new BoundingBox(SPLIT_PADDING, SPLIT_PADDING + vSplitHeight, vSplitWidth, vSplitHeight);

		return new SplitAreas(leftSplit, rightSplit, topSplit, bottomSplit);
	}

	private static int SPLIT_PADDING = 20;

	private boolean isSplit(Event e) {
		Bounds boundsInLocal = ((Node) this.widget.getStaticLayoutNode()).getBoundsInLocal();
		boundsInLocal = new BoundingBox(boundsInLocal.getMinX() + SPLIT_PADDING, boundsInLocal.getMinY() + SPLIT_PADDING, boundsInLocal.getWidth() - SPLIT_PADDING * 2, boundsInLocal.getHeight() - SPLIT_PADDING * 2);
		return boundsInLocal.contains(x(e), y(e));
	}

	private static class SplitAreas {
		final Bounds left;
		final Bounds right;
		final Bounds top;
		final Bounds bottom;

		SplitAreas(Bounds left, Bounds right, Bounds top, Bounds bottom) {
			this.left = left;
			this.right = right;
			this.bottom = bottom;
			this.top = top;
		}
	}
}
