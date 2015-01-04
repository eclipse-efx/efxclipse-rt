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

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MGenericTile;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Implementation of splitting with DnD
 *
 * @param <M>
 *            the domain model type
 */
public class SplitDnDSupport<M extends MUIElement> extends BaseDnDSupport {
	private final WLayoutedWidget<M> widget;

	@NonNull
	private EModelService modelService;

	/**
	 * Create new instance
	 *
	 * @param modelService
	 *            the model service
	 * @param feedbackService
	 *            the feedback service
	 * @param widget
	 *            the widget
	 */
	public SplitDnDSupport(@NonNull EModelService modelService, @NonNull DnDFeedbackService feedbackService, WLayoutedWidget<M> widget) {
		super(feedbackService);
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

	/**
	 * Handling the drag over
	 *
	 * @param e
	 *            the event
	 */
	public void handleDragOver(DragEvent e) {
		if (this.widget.getDropDroppedCallback() != null) {
			if (!DndTabPaneFactory.hasDnDContent(e)) {
				return;
			}

			@Nullable
			M m = this.widget.getDomElement();

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
					e.acceptTransferModes(TransferMode.MOVE);
					e.consume();
				} else {
					updateFeedback(new DnDFeedbackData(null, null, getSplitType(e), c, null));
					e.acceptTransferModes(TransferMode.MOVE);
					e.consume();
				}
			}
		}
	}

	/**
	 * Handle the drag
	 *
	 * @param e
	 *            the event
	 */
	public void handleDragDropped(DragEvent e) {
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

			@Nullable
			M m = this.widget.getDomElement();
			if (m instanceof MGenericTile<?>) {
				// Tiles are not split
				e.consume();
			} else if (m instanceof MPart && isSplit(e)) {
				e.consume();
				if ((MUIElement) m.getParent() instanceof MPartStack) {
					DropData d = new DropData(this.widget.getDomElement(), draggedElement, getSplitType(e));
					dropDroppedCallback.call(d);
				}
			} else if (m instanceof MElementContainer<?>) {
				MElementContainer<?> c = (MElementContainer<?>) m;
				if (this.modelService.countRenderableChildren(c) == 0) {
					@SuppressWarnings("all")
					DropData d = new DropData(this.widget.getDomElement(), draggedElement, DropType.INSERT);
					dropDroppedCallback.call(d);
					e.consume();
					e.setDropCompleted(true);
				}
			}
		}
	}

	@SuppressWarnings("all")
	private @NonNull DropType getSplitType(DragEvent e) {
		SplitAreas areas = calculateSplitAreas();

		if (areas.left.contains(e.getX(), e.getY())) {
			return DropType.SPLIT_LEFT;
		} else if (areas.right.contains(e.getX(), e.getY())) {
			return DropType.SPLIT_RIGHT;
		} else if (areas.top.contains(e.getX(), e.getY())) {
			return DropType.SPLIT_TOP;
		} else if (areas.bottom.contains(e.getX(), e.getY())) {
			return DropType.SPLIT_BOTTOM;
		}

		return DropType.SPLIT_BOTTOM;
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

	private boolean isSplit(DragEvent e) {
		Bounds boundsInLocal = ((Node) this.widget.getStaticLayoutNode()).getBoundsInLocal();
		boundsInLocal = new BoundingBox(boundsInLocal.getMinX() + SPLIT_PADDING, boundsInLocal.getMinY() + SPLIT_PADDING, boundsInLocal.getWidth() - SPLIT_PADDING * 2, boundsInLocal.getHeight() - SPLIT_PADDING * 2);
		return boundsInLocal.contains(e.getX(), e.getY());
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
