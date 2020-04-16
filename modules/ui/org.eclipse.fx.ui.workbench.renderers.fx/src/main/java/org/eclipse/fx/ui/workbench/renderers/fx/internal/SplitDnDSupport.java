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

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MGenericTile;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.controls.dnd.EFXDragEvent;
import org.eclipse.fx.ui.controls.tabpane.DndTabPaneFactory;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.BasicDropLocation;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropData;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropLocation;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.services.ModelService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.event.Event;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
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

	@NonNull
	private ModelService efxModelService;

	private int splitPadding = 20;

	/**
	 * Create new instance
	 *
	 * @param efxModelService
	 *            efx model service
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
	public SplitDnDSupport(@NonNull ModelService efxModelService, @NonNull EModelService modelService, @Nullable DnDService constraintService, @NonNull DnDFeedbackService feedbackService, WLayoutedWidget<M> widget) {
		super(feedbackService);
		this.efxModelService = efxModelService;
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

	/**
	 * Handle exiting of the drag
	 *
	 * @param e
	 *            the event
	 */
	@SuppressWarnings("static-method")
	public void handleDragExit(MouseDragEvent e) {
		cleanup();
	}

	private @Nullable MUIElement findElement(String objectId) {
		@Nullable
		M domElement = this.widget.getDomElement();
		if (domElement != null) {
			MApplication root = this.efxModelService.getRoot(domElement);
			if (root != null && objectId != null) {
				return this.efxModelService.getElementInstance(root, objectId);
			}
		}
		return null;
	}

	/**
	 * Handle the drag over
	 *
	 * @param e
	 *            the event
	 */
	public void handleDragOver(EFXDragEvent e) {
		_handleDragOver(e);
	}

	/**
	 * Handle the drag over
	 *
	 * @param e
	 *            the event
	 */
	public void handleDragOver(DragEvent e) {
		_handleDragOver(e);
	}

	/**
	 * Handle the drop
	 *
	 * @param e
	 *            the event
	 */
	public void handleDragDropped(EFXDragEvent e) {
		_handleDragDropped(e);
	}

	/**
	 * Handle the drop
	 *
	 * @param e
	 *            the event
	 */
	public void handleDragDropped(DragEvent e) {
		_handleDragDropped(e);
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

		String content = DndTabPaneFactory.getDnDContent(e);
		if (content == null) {
			return;
		}

		MUIElement findElement = findElement(content);

		if (findElement == null) {
			return;
		}

		if (m != null && this.constraintService != null && !this.constraintService.splitAllowed(m, findElement, getSplitType(e))) {
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

	/**
	 * Handle the drag
	 *
	 * @param e
	 *            the event
	 */
	private void _handleDragDropped(Event e) {
		@Nullable
		M m = this.widget.getDomElement();

		String content = DndTabPaneFactory.getDnDContent(e);

		if (content == null) {
			return;
		}

		MUIElement findElement = findElement(content);
		if (findElement == null) {
			return;
		}

		if (m != null && this.constraintService != null && !this.constraintService.splitAllowed(m, findElement, getSplitType(e))) {
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
				MPart part = (MPart) m;
				// If parent is NULL it is a shared part
				if( m.getParent() == null && part.getCurSharedRef() != null && (MUIElement)part.getCurSharedRef().getParent() instanceof MPartStack ) {
					DropData d = new DropData(screenX(e), screenY(e), part.getCurSharedRef(), draggedElement, getSplitType(e));
					dropDroppedCallback.call(d);
					setDropComplete(e, true);
				} else if ((MUIElement) m.getParent() instanceof MPartStack) {
					DropData d = new DropData(screenX(e), screenY(e), this.widget.getDomElement(), draggedElement, getSplitType(e));
					dropDroppedCallback.call(d);
					setDropComplete(e, true);
				}
			} else if (m instanceof MElementContainer<?>) {
				MElementContainer<?> c = (MElementContainer<?>) m;
				if (this.modelService.countRenderableChildren(c) == 0) {
					@SuppressWarnings("all")
					DropData d = new DropData(screenX(e), screenY(e), this.widget.getDomElement(), draggedElement, BasicDropLocation.INSERT);
					dropDroppedCallback.call(d);
					e.consume();
					setDropComplete(e, true);
				}
			}
		}
	}

	@SuppressWarnings("all")
	private @NonNull DropLocation getSplitType(Event e) {
		SplitAreas areas = calculateSplitAreas();

		if (areas.left.contains(x(e), y(e))) {
			return BasicDropLocation.SPLIT_LEFT;
		} else if (areas.right.contains(x(e), y(e))) {
			return BasicDropLocation.SPLIT_RIGHT;
		} else if (areas.top.contains(x(e), y(e))) {
			return BasicDropLocation.SPLIT_TOP;
		} else if (areas.bottom.contains(x(e), y(e))) {
			return BasicDropLocation.SPLIT_BOTTOM;
		}

		return BasicDropLocation.SPLIT_BOTTOM;
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

	/**
	 * Returns the padding considered when detecting a split and determining the
	 * split type.
	 * 
	 * @return padding considered when detecting split and split type
	 */
	public int getSplitPadding() {
		return this.splitPadding;
	}

	/**
	 * Sets the padding considered when detecting a split and determining the
	 * split type.
	 * 
	 * @param splitPadding
	 *            padding in pixels
	 */
	public void setSplitPadding(int splitPadding) {
		this.splitPadding = splitPadding;
	}

	private SplitAreas calculateSplitAreas() {
		Bounds bounds = ((Node) this.widget.getStaticLayoutNode()).getBoundsInLocal();

		double hSplitWidth = (bounds.getWidth() - getSplitPadding() * 2) / 5;
		double hSplitHeight = bounds.getHeight() - getSplitPadding() * 2;

		double vSplitWidth = bounds.getWidth() - getSplitPadding() * 2;
		double vSplitHeight = (bounds.getHeight() - getSplitPadding() * 2) / 2;

		Bounds leftSplit = new BoundingBox(getSplitPadding(), getSplitPadding(), hSplitWidth, hSplitHeight);
		Bounds rightSplit = new BoundingBox(bounds.getWidth() - getSplitPadding() - hSplitWidth, getSplitPadding(), hSplitWidth, hSplitHeight);

		Bounds topSplit = new BoundingBox(getSplitPadding(), getSplitPadding(), vSplitWidth, vSplitHeight);
		Bounds bottomSplit = new BoundingBox(getSplitPadding(), getSplitPadding() + vSplitHeight, vSplitWidth, vSplitHeight);

		return new SplitAreas(leftSplit, rightSplit, topSplit, bottomSplit);
	}

	private boolean isSplit(Event e) {
		Bounds boundsInLocal = ((Node) this.widget.getStaticLayoutNode()).getBoundsInLocal();
		boundsInLocal = new BoundingBox(boundsInLocal.getMinX() + getSplitPadding(), boundsInLocal.getMinY() + getSplitPadding(), boundsInLocal.getWidth() - getSplitPadding() * 2, boundsInLocal.getHeight() - getSplitPadding() * 2);
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
