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

import java.util.List;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.events.HoverTarget;
import org.eclipse.fx.ui.controls.styledtext.events.TextHoverEvent;
import org.eclipse.fx.ui.controls.styledtext.internal.ContentView;

import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.util.Duration;

/**
 * Manage hovers on a region
 */
public class HoverSupport {

	private static boolean DEBUG_HOVER = Boolean.getBoolean("org.eclipse.fx.ui.controls.styledtext.debug"); //$NON-NLS-1$

	private Region control;
	private TextHoverEvent lastHover;

	private TextHoverEvent curHover;
	private long curHoverTimeout;

	/**
	 * Create a hover support instance
	 *
	 * @param control
	 *            the control
	 */
	public HoverSupport(Region control) {
		this.control = control;
	}

	/**
	 * Installation of the hover support
	 */
	protected void install() {
		this.control.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
		this.control.addEventHandler(MouseEvent.MOUSE_MOVED, this::onMouseMoved);
		this.control.addEventHandler(MouseEvent.MOUSE_EXITED, this::onMouseExited);
		Util.installHoverCallback(this.control, Duration.millis(300), this::handleHover);
	}

	private void fireHoverEvent(MouseEvent event, List<HoverTarget> hoverTargets) {
		if (hoverTargets == null) {
			if (DEBUG_HOVER) System.err.println("fireHoverEvent " + hoverTargets);
			Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
		}
		else {
			if (DEBUG_HOVER) System.err.println("fireHoverEvent " + hoverTargets);
			Event.fireEvent(this.control, new TextHoverEvent(event, hoverTargets));
		}
	}

	/**
	 * Install the hover support on the provided control
	 *
	 * @param control
	 *            the control
	 * @return the hoversupport
	 */
	public static HoverSupport install(Region control) {
		HoverSupport support = new HoverSupport(control);
		support.install();
		return support;
	}

	private void onMouseExited(MouseEvent event) {
		if (DEBUG_HOVER) System.err.println("HoverManager: onMouseExited"); //$NON-NLS-1$
		// Work-Around for windows where the exit occurs
		if( ! this.control.getBoundsInLocal().contains(event.getX(),event.getY()) ) {
			fireHoverEvent(event, null);
		}
	}

	private void onMouseMoved(MouseEvent event) {
//		System.err.println("HoverManager: onMouseMoved");
//		List<HoverTarget> hoverTargets = ((ContentView)this.control).findHoverTargets(new Point2D(event.getX(), event.getY()));
//		fireHoverEvent(event, hoverTargets);
	}

	private void onMousePressed(MouseEvent event) {
		if (DEBUG_HOVER) System.err.println("HoverManager: onMousePressed"); //$NON-NLS-1$
		fireHoverEvent(event, null);
	}

	/**
	 * Create a hover event from the mouse event
	 *
	 * @param e
	 *            the mouse event
	 * @return the hover event
	 */
	protected static TextHoverEvent createHoverEvent(MouseEvent e) {

		// TODO fix hover event
		// if (e.getTarget() instanceof Annotation)

		return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
		// Parent parent = ((Node)e.getTarget()).getParent();
		// if( parent instanceof StyledTextNode ) {
		// StyledTextNode n = (StyledTextNode) parent;
		// if( n.getParent() == null || n.getParent().getParent() == null ) {
		// return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
		// }
		// StyledTextLayoutContainer lc = (StyledTextLayoutContainer)
		// n.getParent().getParent();
		// int start = lc.getStartOffset() + n.getStartOffset();
		// int end = lc.getStartOffset() + n.getEndOffset();
		// String text = n.getText();
		//
		// int offset = n.getCaretIndexAtPoint(n.sceneToLocal(e.getSceneX(),
		// e.getSceneY()));
		// return new TextHoverEvent(e, start, end, start + offset, text);
		// } else {
		// return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
		// }
	}

	/**
	 * Create a hover even from the hover mouse event
	 * @param event the event
	 */
	protected void handleHover(MouseEvent event) {
		if (DEBUG_HOVER) System.err.println("HoverManager: handleHover"); //$NON-NLS-1$
		List<HoverTarget> hoverTargets = ((ContentView)this.control).findHoverTargets(new Point2D(event.getX(), event.getY()));
		fireHoverEvent(event, hoverTargets);
	}

}
