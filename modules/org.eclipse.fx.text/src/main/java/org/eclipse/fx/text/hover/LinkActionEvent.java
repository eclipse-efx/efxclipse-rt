package org.eclipse.fx.text.hover;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
	 * An {@link Event} representing some type of action. This event type is widely
	 * used to represent a variety of things, such as when a {@link javafx.scene.control.Button}
	 * has been fired, when a {@link javafx.animation.KeyFrame} has finished, and other
	 * such usages.
	 * @since JavaFX 2.0
	 */
	public class LinkActionEvent extends Event {

	    private static final long serialVersionUID = 20121107L;
	    
	    public static final EventType<LinkActionEvent> LINK =
	            new EventType<LinkActionEvent>(Event.ANY, "LINK");
	    
	    public static final EventType<LinkActionEvent> LINK_ACTION =
	            new EventType<LinkActionEvent>(LINK, "LINK_ACTION");

	    public static final EventType<LinkActionEvent> LINK_CONTEXT =
	            new EventType<LinkActionEvent>(LINK, "LINK_CONTEXT");

	    
	    private String linkTarget;
	    
	    private double screenX;
	    private double screenY;
	    
	    public LinkActionEvent(EventType<LinkActionEvent> type, String linkTarget, double screenX, double screenY) {
	        super(type);
	        this.linkTarget = linkTarget;
	        this.screenX = screenX;
	        this.screenY = screenY;
	    }

	    /**
	     * Construct a new {@code ActionEvent} with the specified event source and target.
	     * If the source or target is set to {@code null}, it is replaced by the
	     * {@code NULL_SOURCE_TARGET} value. All ActionEvents have their type set to
	     * {@code ACTION}.
	     *
	     * @param source    the event source which sent the event
	     * @param target    the event target to associate with the event
	     */
	    public LinkActionEvent(Object source, EventTarget target, EventType<LinkActionEvent> type) {
	        super(source, target, type);
	    }

	    @Override
	    public LinkActionEvent copyFor(Object newSource, EventTarget newTarget) {
	        return (LinkActionEvent) super.copyFor(newSource, newTarget);
	    }

	    @Override
	    public EventType<? extends LinkActionEvent> getEventType() {
	        return (EventType<? extends LinkActionEvent>) super.getEventType();
	    }
	    
	    public String getLinkTarget() {
	    	return linkTarget;
	    }
	    
	    public double getScreenX() {
			return screenX;
		}
	    
	    public double getScreenY() {
			return screenY;
		}
	    
	}