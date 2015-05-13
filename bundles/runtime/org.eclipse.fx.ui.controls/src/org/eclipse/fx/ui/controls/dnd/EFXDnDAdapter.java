/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.dnd;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.eclipse.fx.ui.controls.Util;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Allows a node to be adapted to the drag and drop system
 */
public class EFXDnDAdapter {
	private final Node node;
	private boolean dragInProgress;
	private boolean dragStartSend;
	private BiFunction<EFXDnDAdapter, MouseEvent, Boolean> dragStartValidator;
	private BiConsumer<EFXDnDAdapter, EFXDragEvent> dragStartConsumer;
	private BiConsumer<EFXDnDAdapter, EFXDragEvent> dragDoneConsumer;
	private Node eventTarget;

	/**
	 * Create a new adapter
	 * 
	 * @param node
	 *            the node itself
	 * @param doneEventTarget
	 *            the target the done event is sent to
	 */
	public EFXDnDAdapter(Node node, Node doneEventTarget) {
		this.node = node;
		this.eventTarget = doneEventTarget;
	}

	/**
	 * Enable dnd for the node
	 */
	public void enable() {
		this.node.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::handleMouseDragged);
		this.node.addEventHandler(MouseEvent.MOUSE_RELEASED, this::handleMouseReleased);
	}

	/**
	 * Disable dnd for the node
	 */
	public void disable() {
		this.node.removeEventHandler(MouseEvent.MOUSE_DRAGGED, this::handleMouseDragged);
		this.node.removeEventHandler(MouseEvent.MOUSE_RELEASED, this::handleMouseReleased);
	}

	/**
	 * Validate that the drag can start
	 * 
	 * @param dragStartValidator
	 *            a validator who can return false to veto the start of the drag
	 *            operation
	 */
	public void setDragStartValidator(BiFunction<EFXDnDAdapter, MouseEvent, Boolean> dragStartValidator) {
		this.dragStartValidator = dragStartValidator;
	}

	/**
	 * A consumer who is informed that the drag has started
	 * 
	 * @param dragStartConsumer
	 *            the consumer
	 */
	public void setDragStartConsumer(BiConsumer<EFXDnDAdapter, EFXDragEvent> dragStartConsumer) {
		this.dragStartConsumer = dragStartConsumer;
	}

	/**
	 * A consumer notified that the drag has finished
	 * 
	 * @param dragDoneConsumer
	 *            the consumer
	 */
	public void setDragDoneConsumer(BiConsumer<EFXDnDAdapter, EFXDragEvent> dragDoneConsumer) {
		this.dragDoneConsumer = dragDoneConsumer;
	}

	private void handleMouseDragged(MouseEvent e) {
		if (!this.dragStartSend) {
			if (this.dragStartValidator == null || !Boolean.FALSE.equals(this.dragStartValidator.apply(this, e))) {
				EFXDragEvent event = new EFXDragEvent(this.node, this.node, EFXDragEvent.DRAG_START, e.getScreenX(), e.getScreenY(), false);
				Event.fireEvent(this.node, event);
				this.dragStartSend = true;
				this.dragInProgress = event.getDraggedContent() != null;
				if (this.dragInProgress && this.dragStartConsumer != null) {
					this.dragStartConsumer.accept(this, event);
				}
			}
		}

		Node node = Util.findNode(this.node.getScene().getWindow(), e.getScreenX(), e.getScreenY());

		if (this.dragInProgress) {
			if (node != null) {
				Event.fireEvent(node, new EFXDragEvent(this.node, node, EFXDragEvent.DRAG_OVER, e.getScreenX(), e.getScreenY(), false));
			} else {
				EFXDragEvent.updateFeedbackLocation(e.getScreenX(), e.getScreenY());
			}
		}
	}

	private void handleMouseReleased(MouseEvent e) {
		this.dragStartSend = false;
		if (this.dragInProgress) {
			Node node = Util.findNode(this.node.getScene().getWindow(), e.getScreenX(), e.getScreenY());
			boolean isComplete = false;
			if (node != null) {
				EFXDragEvent event = new EFXDragEvent(node, node, EFXDragEvent.DRAG_DROPPED, e.getScreenX(), e.getScreenY(), false);
				Event.fireEvent(node, event);
				isComplete = event.isComplete();
			}
			EFXDragEvent event = new EFXDragEvent(this.eventTarget, this.eventTarget, EFXDragEvent.DRAG_DONE, e.getScreenX(), e.getScreenY(), isComplete);
			Event.fireEvent(this.eventTarget, event);
			if (this.dragDoneConsumer != null) {
				this.dragDoneConsumer.accept(this, event);
			}

		}
		this.dragInProgress = false;
	}
}
