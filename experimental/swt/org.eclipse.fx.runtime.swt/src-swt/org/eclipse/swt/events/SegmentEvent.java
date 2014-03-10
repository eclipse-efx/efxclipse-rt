package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public class SegmentEvent extends TypedEvent {

	public int lineOffset;

	public String lineText;

	public int[] segments;

	public char[] segmentsChars;

	static final long serialVersionUID = -2414889726745247762L;

	public SegmentEvent(Event e) {
		super(e);
		lineText = e.text;
		lineOffset = e.detail;
	}
}