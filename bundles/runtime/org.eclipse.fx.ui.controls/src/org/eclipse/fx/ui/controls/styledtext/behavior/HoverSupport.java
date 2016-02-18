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

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.events.TextHoverEvent;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.util.Duration;

/**
 * manages hover support
 * @author ccaks
 *
 */
public class HoverSupport {

	private Region control;
	private TextHoverEvent lastHover;

	public HoverSupport(Region control) {
		this.control = control;
	}

	protected void install() {
		this.control.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
		this.control.addEventHandler(MouseEvent.MOUSE_MOVED, this::onMouseMoved);
		this.control.addEventHandler(MouseEvent.MOUSE_EXITED, this::onMouseExited);
		Util.installHoverCallback(this.control, Duration.millis(1000), this::handleHover);
	}


	public static HoverSupport install(Region control) {
		HoverSupport support = new HoverSupport(control);
		support.install();
		return support;
	}

	private void onMouseExited(MouseEvent event) {
		if( this.lastHover != null ) {
			Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
			this.lastHover = null;
		}
	}

	private void onMouseMoved(MouseEvent event) {
		System.err.println("moved " + event.getTarget());
		if( this.lastHover != null ) {
			TextHoverEvent hoverEvent = createHoverEvent(event);
			if( this.lastHover.getOffsetTokenStart() != hoverEvent.getOffsetTokenStart() ) {
				Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
				this.lastHover = null;
			}
		}
	}

	private void onMousePressed(MouseEvent event) {
		if( this.lastHover != null ) {
			Event.fireEvent(this.control, new TextHoverEvent(event, -1, -1, -1, "")); //$NON-NLS-1$
			this.lastHover = null;
		}
	}


	protected static TextHoverEvent createHoverEvent(MouseEvent e) {

		System.err.println("createHover for " + e.getTarget());

		// TODO fix hover event
//		if (e.getTarget() instanceof Annotation)

		return new TextHoverEvent(e, -1, -1, -1, "");
//		Parent parent = ((Node)e.getTarget()).getParent();
//		if( parent instanceof StyledTextNode ) {
//			StyledTextNode n = (StyledTextNode) parent;
//			if( n.getParent() == null || n.getParent().getParent() == null ) {
//				return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
//			}
//			StyledTextLayoutContainer lc = (StyledTextLayoutContainer) n.getParent().getParent();
//			int start = lc.getStartOffset() +  n.getStartOffset();
//			int end = lc.getStartOffset() + n.getEndOffset();
//			String text = n.getText();
//
//			int offset = n.getCaretIndexAtPoint(n.sceneToLocal(e.getSceneX(), e.getSceneY()));
//			return new TextHoverEvent(e, start, end, start + offset, text);
//		} else {
//			return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
//		}
	}

	protected void handleHover(MouseEvent e) {
		TextHoverEvent event = createHoverEvent(e);
		System.err.println("hoverEvent " + event);
		if( this.lastHover == null || this.lastHover.getOffsetTokenStart() != event.getOffsetTokenStart() ) {
			Event.fireEvent(control, event);
			if( event.getOffset() == -1 ) {
				this.lastHover = null;
			} else {
				this.lastHover = event;
			}
		}
	}

}
