package org.eclipse.fx.ui.controls.stage;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class FrameEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static EventType<FrameEvent> CLOSING = new EventType<>(Event.ANY, "CLOSING"); //$NON-NLS-1$
	public static EventType<FrameEvent> CLOSED = new EventType<>(Event.ANY, "CLOSED"); //$NON-NLS-1$
	
	public FrameEvent(Frame frame, EventType<? extends Event> eventType) {
		super(frame, frame, eventType);
	}

}
