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

import java.util.function.Consumer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * A custom drag event
 */
public class EFXDragEvent extends Event {
	private static Object DRAGGED_CONTENT = null;
	private static DragFeedback DRAG_FEEDBACK = null;

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
	 * Event fired when drag exits the area
	 */
	public static final EventType<EFXDragEvent> DRAG_EXITED = new EventType<EFXDragEvent>(EFXDragEvent.ANY, "DRAG_EXITED"); //$NON-NLS-1$

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

	static class DragFeedback {
		PopupWindow stage;
		double screenX;
		double screenY;
		Node n;

		public DragFeedback(Node n) {
			this.n = n;
			this.stage = new PopupWindow() {
				// Empty
			};
			this.stage.setAutoFix(false);
			this.stage.setUserData("findNodeExclude"); //$NON-NLS-1$
//			this.stage.setAlwaysOnTop(true);
			StackPane root = new StackPane();
			root.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
//			Scene value = new Scene(root);
//			value.setFill(Color.TRANSPARENT);
//			this.stage.setScene(value);
			this.stage.getScene().getStylesheets().setAll(n.getScene().getStylesheets());
			this.stage.getScene().setRoot(root);
		}

		public void updateCoordinates(double screenX, double screenY) {
			this.stage.setX(screenX - this.stage.getWidth() / 2);
			this.stage.setY(screenY + 20);
		}

		public void updateFeedback(Consumer<StackPane> consumer) {
			consumer.accept((StackPane) this.stage.getScene().getRoot());
			this.stage.sizeToScene();
			this.stage.setX(this.screenX - this.stage.getWidth() / 2);
			this.stage.setY(this.screenY + 20);
			this.stage.show(n.getScene().getWindow());
		}

		public void dispose() {
			this.stage.hide();
		}
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
			if( canShowFeedbackDragFeedback() ) {
				DRAG_FEEDBACK = new DragFeedback((Node) source);
			}
		} else if (eventType == DRAG_DONE) {
			if (DRAG_FEEDBACK != null) {
				DRAG_FEEDBACK.dispose();
				DRAG_FEEDBACK = null;
			}
		}

		if (DRAG_FEEDBACK != null) {
			DRAG_FEEDBACK.updateCoordinates(screenX, screenY);
		}
	}

	/**
	 * Update the drag feedback
	 *
	 * @param consumer
	 *            the consumer
	 */
	@SuppressWarnings("static-method")
	public void updateFeedback(Consumer<StackPane> consumer) {
		if (DRAG_FEEDBACK != null) {
			DRAG_FEEDBACK.updateFeedback(consumer);
		}
	}

	/**
	 * Update the screen location while no drag over events occur
	 *
	 * @param screenX
	 *            the screen x
	 * @param screenY
	 *            the screen y
	 */
	public static void updateFeedbackLocation(double screenX, double screenY) {
		if (DRAG_FEEDBACK != null) {
			DRAG_FEEDBACK.updateCoordinates(screenX, screenY);
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

	/**
	 * @return check if showing drag feedback is possible
	 */
	@SuppressWarnings("static-method")
	public boolean canShowFeedbackDragFeedback() {
		if( "Linux".equals(System.getProperty("os.name"))) { //$NON-NLS-1$ //$NON-NLS-2$
			return false;
		}
		return true;
	}
}