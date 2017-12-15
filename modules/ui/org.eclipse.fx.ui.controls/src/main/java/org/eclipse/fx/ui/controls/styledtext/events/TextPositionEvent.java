/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

/**
 * A text position event
 * <p>
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 *
 * @noreference
 */
public class TextPositionEvent extends MouseEvent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final EventType<TextPositionEvent> TEXT_POSITION_CLICKED = new EventType<TextPositionEvent>(Event.ANY, "STYLED_TEXT_TEXT_POSITION_CLICKED"); //$NON-NLS-1$
	public static final EventType<TextPositionEvent> TEXT_POSITION_PRESSED = new EventType<TextPositionEvent>(Event.ANY, "STYLED_TEXT_TEXT_POSTION_PRESSED"); //$NON-NLS-1$
	public static final EventType<TextPositionEvent> TEXT_POSITION_RELEASED = new EventType<TextPositionEvent>(Event.ANY, "STYLED_TEXT_TEXT_POSTION_RELEASED"); //$NON-NLS-1$
	public static final EventType<TextPositionEvent> TEXT_POSITION_MOVED = new EventType<TextPositionEvent>(Event.ANY, "STYLED_TEXT_TEXT_POSTION_MOVED"); //$NON-NLS-1$
	public static final EventType<TextPositionEvent> TEXT_POSITION_DRAG_DETECTED = new EventType<TextPositionEvent>(Event.ANY, "STYLED_TEXT_TEXT_POSTION_DRAG_DETECTED"); //$NON-NLS-1$
	public static final EventType<TextPositionEvent> TEXT_POSITION_DRAGGED = new EventType<TextPositionEvent>(Event.ANY, "STYLED_TEXT_TEXT_POSTION_DRAGGED"); //$NON-NLS-1$


	private final int offset;

	private static EventType<TextPositionEvent> convert(EventType<? extends MouseEvent> t) {
		if (t == MouseEvent.MOUSE_CLICKED) {
			return TEXT_POSITION_CLICKED;
		}
		else if (t == MouseEvent.MOUSE_PRESSED) {
			return TEXT_POSITION_PRESSED;
		}
		else if (t == MouseEvent.MOUSE_RELEASED) {
			return TEXT_POSITION_RELEASED;
		}
		else if (t == MouseEvent.MOUSE_MOVED) {
			return TEXT_POSITION_MOVED;
		}
		else if (t == MouseEvent.DRAG_DETECTED) {
			return TEXT_POSITION_DRAG_DETECTED;
		}
		else if (t == MouseEvent.MOUSE_DRAGGED) {
			return TEXT_POSITION_DRAGGED;
		}

		throw new IllegalArgumentException();
	}

	/**
	 * Create a new text position event
	 *
	 * @param event
	 *            the source mouse event
	 * @param offset
	 *            the offset in the text (might be -1 to indicate no valid
	 *            region was found)
	 */
	public TextPositionEvent(MouseEvent event, int offset) {
		super(convert(event.getEventType()), event.getSceneX(), event.getSceneY(), event.getScreenX(), event.getScreenY(), event.getButton(), event.getClickCount(), event.isShiftDown(), event.isControlDown(), event.isAltDown(), event.isMetaDown(), event.isPrimaryButtonDown(), event.isMiddleButtonDown(),
				event.isSecondaryButtonDown(), event.isSynthesized(), event.isPopupTrigger(), event.isStillSincePress(), event.getPickResult());

		this.offset = offset;
	}

	/**
	 * @return the offset in the text (might be -1 to indicate no valid region
	 *         was found)
	 */
	public int getOffset() {
		return this.offset;
	}
}
