package org.eclipse.fx.ui.controls.sceneviewer;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Node;

public class OpenItemEvent extends Event {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final EventType<OpenItemEvent> OPEN_ITEM =
	            new EventType<OpenItemEvent>(Event.ANY, "OPEN_ITEM");
	
	private final Node itemNode;
	
	public OpenItemEvent(Node itemNode) {
		super(OPEN_ITEM);
		this.itemNode = itemNode;
	}

	public Node getItemNode() {
		return itemNode;
	}
}
