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

	private Region control;
	private TextHoverEvent lastHover;

	private TextHoverEvent curHover;

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
		Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
		this.lastHover = null;
		this.curHover = null;
	}

	private void onMouseMoved(MouseEvent event) {
//		if (this.lastHover != null) {
//			TextHoverEvent hoverEvent = createHoverEvent(event);
//			if (this.lastHover.getOffsetTokenStart() != hoverEvent.getOffsetTokenStart()) {
//				Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
//				this.lastHover = null;
//			}
//		}

		if (this.curHover != null) {
			List<HoverTarget> hoverTargets = ((ContentView)this.control).findHoverTargets(new Point2D(event.getX(), event.getY()));
			TextHoverEvent e = new TextHoverEvent(event, hoverTargets);
			if (!e.equals(curHover)) {
				Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
				this.curHover = null;
			}
		}



	}

	private void onMousePressed(MouseEvent event) {
		if (this.lastHover != null) {
			Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
			this.lastHover = null;
			curHover = null;
		}
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
	 * @param e the event
	 */
	protected void handleHover(MouseEvent event) {
//		TextHoverEvent event = createHoverEvent(e);
//		if (this.lastHover == null || this.lastHover.getOffsetTokenStart() != event.getOffsetTokenStart()) {
//			Event.fireEvent(this.control, event);
//			if (event.getOffset() == -1) {
//				this.lastHover = null;
//			} else {
//				this.lastHover = event;
//			}
//		}


		List<HoverTarget> hoverTargets = ((ContentView)this.control).findHoverTargets(new Point2D(event.getX(), event.getY()));
		TextHoverEvent e = new TextHoverEvent(event, hoverTargets);
		if (this.curHover == null || !e.equals(curHover)) {
			System.err.println("FIRING HOVER");
			Event.fireEvent(this.control, e);
			curHover = e;
		}
	}

}
