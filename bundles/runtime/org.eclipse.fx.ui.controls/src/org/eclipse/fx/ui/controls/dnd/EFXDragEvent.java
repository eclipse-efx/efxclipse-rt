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

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.Node;

/**
 * A custom drag event
 */
public class EFXDragEvent extends Event {
	private static Object DRAGGED_CONTENT = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Base type for all events
	 */
	public static final EventType<EFXDragEvent> ANY = new EventType<EFXDragEvent>(Event.ANY, "DRAG"); //$NON-NLS-1$

	/**
	 * Event fired on a drag start
	 */
	public static EventType<EFXDragEvent> DRAG_START = new EventType<>(Event.ANY, "DRAG_START"); //$NON-NLS-1$

	/**
	 * Event fired while dragging over a node
	 */
	public static EventType<EFXDragEvent> DRAG_OVER = new EventType<>(EFXDragEvent.ANY, "DRAG_OVER"); //$NON-NLS-1$

	/**
	 * Event fired when dropped
	 */
	public static final EventType<EFXDragEvent> DRAG_DROPPED = new EventType<EFXDragEvent>(EFXDragEvent.ANY, "DRAG_DROPPED"); //$NON-NLS-1$

	/**
	 * Event fired when drag is done
	 */
	public static final EventType<EFXDragEvent> DRAG_DONE = new EventType<EFXDragEvent>(EFXDragEvent.ANY, "DRAG_DONE"); //$NON-NLS-1$

	private final double screenX;
	private final double screenY;

	private final State state = new State();

	static class State {
		boolean complete = false;
	}

	/**
	 * Create a new drag event
	 * 
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @param eventType
	 *            the event type
	 * @param screenX
	 *            the screen x
	 * @param screenY
	 *            the screen y
	 * @param complete
	 *            <code>true</code> when completed
	 */
	public EFXDragEvent(Object source, EventTarget target, EventType<? extends Event> eventType, double screenX, double screenY, boolean complete) {
		super(source, target, eventType);
		this.screenX = screenX;
		this.screenY = screenY;
		this.state.complete = complete;
		if (eventType == DRAG_START) {
			DRAGGED_CONTENT = null;
		}
	}

	/**
	 * @return the screen x coordinate
	 */
	public double getScreenX() {
		return this.screenX;
	}

	/**
	 * @return the screen y coordinate
	 */
	public double getScreenY() {
		return this.screenY;
	}

	/**
	 * @return the screen x relative to the source
	 */
	public double getX() {
		return ((Node) getSource()).screenToLocal(this.screenX, this.screenY).getX();
	}

	/**
	 * @return the screen y relative to the source
	 */
	public double getY() {
		return ((Node) getSource()).screenToLocal(this.screenX, this.screenY).getY();
	}

	/**
	 * Setting the drag content
	 * 
	 * @param content
	 *            the content
	 */
	public void setDraggedContent(Object content) {
		if (getEventType() == DRAG_START) {
			DRAGGED_CONTENT = content;
		}
	}

	/**
	 * @return the current drag content
	 */
	@SuppressWarnings("static-method")
	public Object getDraggedContent() {
		return DRAGGED_CONTENT;
	}

	/**
	 * Set the drag to be complete. Only to call when {@link #DRAG_DROPPED}
	 * 
	 * @param complete
	 *            <code>true</code> when completed
	 */
	public void setComplete(boolean complete) {
		if (getEventType() == DRAG_DROPPED) {
			this.state.complete = complete;
		}
	}
	
	/**
	 * @return <code>true</code> if drag is completed
	 */
	public boolean isComplete() {
		return this.state.complete;
	}
}