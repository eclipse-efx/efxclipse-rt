package org.eclipse.fx.ui.controls.styledtext.behavior;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledTextLayoutContainer;
import org.eclipse.fx.ui.controls.styledtext.StyledTextNode;
import org.eclipse.fx.ui.controls.styledtext.events.TextHoverEvent;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class HoverSupport {

	private Control control;
	private TextHoverEvent lastHover;

	public HoverSupport(Control control) {
		this.control = control;
	}

	protected void install() {
		this.control.addEventHandler(MouseEvent.MOUSE_PRESSED, this::onMousePressed);
		this.control.addEventHandler(MouseEvent.MOUSE_MOVED, this::onMouseMoved);
		this.control.addEventHandler(MouseEvent.MOUSE_EXITED, this::onMouseExited);
		Util.installHoverCallback(this.control, Duration.millis(1000), this::handleHover);
	}


	public static HoverSupport install(Control control) {
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
		Parent parent = ((Node)e.getTarget()).getParent();
		if( parent instanceof StyledTextNode ) {
			StyledTextNode n = (StyledTextNode) parent;
			if( n.getParent() == null || n.getParent().getParent() == null ) {
				return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
			}
			StyledTextLayoutContainer lc = (StyledTextLayoutContainer) n.getParent().getParent();
			int start = lc.getStartOffset() +  n.getStartOffset();
			int end = lc.getStartOffset() + n.getEndOffset();
			String text = n.getText();

			int offset = n.getCaretIndexAtPoint(n.sceneToLocal(e.getSceneX(), e.getSceneY()));
			return new TextHoverEvent(e, start, end, start + offset, text);
		} else {
			return new TextHoverEvent(e, -1, -1, -1, ""); //$NON-NLS-1$
		}
	}

	protected void handleHover(MouseEvent e) {
		TextHoverEvent event = createHoverEvent(e);
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
