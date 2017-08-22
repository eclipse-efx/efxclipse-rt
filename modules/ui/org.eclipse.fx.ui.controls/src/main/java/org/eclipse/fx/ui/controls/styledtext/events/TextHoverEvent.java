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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Range;

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

	private final List<HoverTarget> hoverTargets;



	public TextHoverEvent(MouseEvent source, List<HoverTarget> hoverTargets) {
		super(HOVER, source.getSceneX(), source.getSceneY(), source.getScreenX(), source.getScreenY(), source.getButton(), source.getClickCount(), source.isShiftDown(), source.isControlDown(), source.isAltDown(), source.isMetaDown(), source.isPrimaryButtonDown(), source.isMiddleButtonDown(),
				source.isSecondaryButtonDown(), source.isSynthesized(), source.isPopupTrigger(), source.isStillSincePress(), source.getPickResult());

		this.hoverTargets = Collections.unmodifiableList(hoverTargets);

		Optional<Range<Integer>> range = this.hoverTargets.stream().map(t->t.textRange).findFirst();

		// TODO remove me
		this.tokenText = null;
		this.offsetTokenStart = range.isPresent() ? range.get().lowerEndpoint() : 0;;
		this.offsetTokenEnd = range.isPresent() ? range.get().upperEndpoint() : 0;;
		this.offset = range.isPresent() ? range.get().lowerEndpoint() : 0;
	}

	public List<HoverTarget> getHoverTargets() {
		return this.hoverTargets;
	}

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

		this.hoverTargets = null;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoverTargets == null) ? 0 : hoverTargets.hashCode());
		result = prime * result + offset;
		result = prime * result + offsetTokenEnd;
		result = prime * result + offsetTokenStart;
		result = prime * result + ((tokenText == null) ? 0 : tokenText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextHoverEvent other = (TextHoverEvent) obj;
		if (hoverTargets == null) {
			if (other.hoverTargets != null)
				return false;
		} else if (!hoverTargets.equals(other.hoverTargets))
			return false;
		if (offset != other.offset)
			return false;
		if (offsetTokenEnd != other.offsetTokenEnd)
			return false;
		if (offsetTokenStart != other.offsetTokenStart)
			return false;
		if (tokenText == null) {
			if (other.tokenText != null)
				return false;
		} else if (!tokenText.equals(other.tokenText))
			return false;
		return true;
	}




}
