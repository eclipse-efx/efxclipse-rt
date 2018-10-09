/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Christoph Caks <ccaks@bestsolution.at> - improved editor behavior
 *	Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.behavior;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.events.TextPositionEvent;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * Manage text positions
 */
public class TextPositionSupport {

	private StyledTextArea textArea;
	private Region control;

	/**
	 * Create a new position support
	 *
	 * @param control
	 *            the control
	 * @param textArea
	 *            the text area
	 */
	public TextPositionSupport(Region control, StyledTextArea textArea) {
		this.control = control;
		this.textArea = textArea;
	}

	/**
	 * Install the position trackers
	 */
	protected void install() {
		this.control.addEventHandler(MouseEvent.MOUSE_CLICKED, this::onMouseEvent);
		this.control.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMouseEvent);
		this.control.addEventHandler(MouseEvent.DRAG_DETECTED, this::onMouseEvent);
		this.control.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onMouseEvent);
		this.control.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onMouseEvent);
		this.control.addEventFilter(MouseEvent.MOUSE_MOVED, this::onMouseEvent);
	}

	/**
	 * Install the text position support
	 *
	 * @param control
	 *            the control
	 * @param textArea
	 *            the text area
	 * @return the position support
	 */
	public static TextPositionSupport install(Region control, StyledTextArea textArea) {
		TextPositionSupport support = new TextPositionSupport(control, textArea);
		support.install();
		return support;
	}

	private void onMouseEvent(MouseEvent event) {
		Event.fireEvent(this.textArea, new TextPositionEvent(event, computeCursorOffset(event)));
	}

	/**
	 * computes the text offset under the mouse cursor.
	 *
	 * @param event the event
	 * @return the offset
	 */
	protected int computeCursorOffset(MouseEvent event) {
		return this.textArea.getOffsetAtPosition(event.getX(), event.getY());
	}

}
