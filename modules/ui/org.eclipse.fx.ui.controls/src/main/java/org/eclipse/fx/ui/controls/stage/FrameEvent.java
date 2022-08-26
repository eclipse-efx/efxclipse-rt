/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.stage;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Event published by {@link Frame}
 * 
 * @since 2.0
 */
public class FrameEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Event delivered when the frame is about to close. If the event is
	 * consumed the closing is vetoed
	 */
	public static EventType<FrameEvent> CLOSING = new EventType<>(Event.ANY, "CLOSING"); //$NON-NLS-1$
	/**
	 * Event delivered when the frame is closed
	 */
	public static EventType<FrameEvent> CLOSED = new EventType<>(Event.ANY, "CLOSED"); //$NON-NLS-1$

	/**
	 * Create a new event
	 * 
	 * @param frame
	 *            the frame sending the event
	 * @param eventType
	 *            the event type
	 */
	public FrameEvent(Frame frame, EventType<? extends Event> eventType) {
		super(frame, frame, eventType);
	}

}
