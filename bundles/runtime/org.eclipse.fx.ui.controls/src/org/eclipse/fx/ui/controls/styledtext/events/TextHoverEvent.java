/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

/**
 * A text hover event sent when hovering text
 * <p>
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 *
 * @noreference
 */
public class TextHoverEvent extends MouseEvent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Hover event type
	 */
	public static final EventType<TextHoverEvent> HOVER = new EventType<TextHoverEvent>(Event.ANY, "STYLED_TEXT_HOVER"); //$NON-NLS-1$

	private final int offsetTokenStart;
	private final int offsetTokenEnd;
	private final String tokenText;
	private final int offset;

	/**
	 * Create a new hover event from the original mouse event
	 *
	 * @param event
	 *            the event
	 * @param offsetTokenStart
	 *            the start offset from the token hovering (might be -1 to
	 *            indicate no valid region was found)
	 * @param offsetTokenEnd
	 *            the end offset from the token hovering (might be -1 to
	 *            indicate no valid region was found)
	 * @param offset
	 *            the offset in the text (might be -1 to indicate no valid
	 *            region was found)
	 * @param tokenText
	 *            the token text
	 */
	public TextHoverEvent(MouseEvent event, int offsetTokenStart, int offsetTokenEnd, int offset, String tokenText) {
		super(HOVER, event.getSceneX(), event.getSceneY(), event.getScreenX(), event.getScreenY(), event.getButton(), event.getClickCount(), event.isShiftDown(), event.isControlDown(), event.isAltDown(), event.isMetaDown(), event.isPrimaryButtonDown(), event.isMiddleButtonDown(),
				event.isSecondaryButtonDown(), event.isSynthesized(), event.isPopupTrigger(), event.isStillSincePress(), event.getPickResult());
		this.offsetTokenStart = offsetTokenStart;
		this.offsetTokenEnd = offsetTokenEnd;
		this.tokenText = tokenText;
		this.offset = offset;
	}

	/**
	 * @return the start offset from the token hovering (might be -1 to indicate
	 *         no valid region was found)
	 */
	public int getOffsetTokenStart() {
		return this.offsetTokenStart;
	}

	/**
	 * @return the end offset from the token hovering (might be -1 to indicate
	 *         no valid region was found)
	 */
	public int getOffsetTokenEnd() {
		return this.offsetTokenEnd;
	}

	/**
	 * @return the token text
	 */
	public String getTokenText() {
		return this.tokenText;
	}

	/**
	 * @return the offset in the text (might be -1 to indicate no valid region
	 *         was found)
	 */
	public int getOffset() {
		return this.offset;
	}
}
