package org.eclipse.fx.text.hover;

import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public class HtmlString implements CharSequence {

	private List<EventHandler<LinkActionEvent>> linkActionHandlers = new ArrayList<>();
	private List<EventHandler<LinkActionEvent>> linkContextHandlers = new ArrayList<>();

	public final <T extends Event> void addEventHandler(
            final EventType<T> eventType,
            final EventHandler<? super T> eventHandler) {
		if (eventType == LinkActionEvent.LINK_ACTION) {
    		linkActionHandlers.add((EventHandler<LinkActionEvent>)eventHandler);
    	}
    	else if (eventType == LinkActionEvent.LINK_CONTEXT) {
    		linkContextHandlers.add((EventHandler<LinkActionEvent>)eventHandler);
    	}
    }

    public final <T extends Event> void removeEventHandler(
            final EventType<T> eventType,
            final EventHandler<? super T> eventHandler) {
    	if (eventType == LinkActionEvent.LINK_ACTION) {
    		linkActionHandlers.remove(eventHandler);
    	}
    	else if (eventType == LinkActionEvent.LINK_CONTEXT) {
    		linkContextHandlers.remove(eventHandler);
    	}
    }
    
    public final void fireEvent(Event event) {
        if (event instanceof LinkActionEvent) {
        	if (event.getEventType() == LinkActionEvent.LINK_ACTION) {
        		for (EventHandler<LinkActionEvent> h : linkActionHandlers) {
        			h.handle((LinkActionEvent)event);
        		}
        	}
        	else if (event.getEventType() == LinkActionEvent.LINK_CONTEXT) {
        		for (EventHandler<LinkActionEvent> h : linkContextHandlers) {
        			h.handle((LinkActionEvent)event);
        		}
        	}
        }
    }
	
	private String html;
	
	public HtmlString(String html) {
		this.html = html;
	}
	
	@Override
	public int length() {
		return html.length();
	}

	@Override
	public char charAt(int index) {
		return html.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return html.subSequence(start, end);
	}
	
	@Override
	public String toString() {
		return html;
	}
	
}
