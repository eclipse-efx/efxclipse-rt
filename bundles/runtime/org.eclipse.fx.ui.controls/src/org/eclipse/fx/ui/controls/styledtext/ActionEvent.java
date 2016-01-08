/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * An action event
 *
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * @noreference
 */
public class ActionEvent extends Event {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Event type
	 */
	public static final EventType<ActionEvent> ACTION = new EventType<ActionEvent>(Event.ANY, "STYLED_TEXT_ACTION"); //$NON-NLS-1$

	/**
	 * The type
	 */
	public enum ActionType {
		/**
		 * Action to delete previous word
		 */
		DELETE_WORD_PREVIOUS,
		/**
		 * Action to delete next word
		 */
		DELETE_WORD_NEXT,

		// NAVIGATION
		/**
		 * Action to go to the next word
		 */
		WORD_NEXT,
		/**
		 * Action to go to the previous word
		 */
		WORD_PREVIOUS,
		/**
		 * Action to go to the line start
		 */
		LINE_START,
		/**
		 * Action to go to the line end
		 */
		LINE_END,
		/**
		 * Action to go the start of the text
		 */
		TEXT_START,
		/**
		 * Action to go the end of the text
		 */
		TEXT_END,

		// SELECT
		/**
		 * Action to select the next word
		 */
		SELECT_WORD_NEXT,
		/**
		 * Action to select the previous word
		 */
		SELECT_WORD_PREVIOUS,
		/**
		 * Action to select the word at the current cursor
		 */
		SELECT_WORD,
		/**
		 * Action to select until the start of the line
		 */
		SELECT_LINE_START,
		/**
		 * Action to select until the end of the line
		 */
		SELECT_LINE_END,
		/**
		 * Action to select to the start of the text
		 */
		SELECT_TEXT_START,
		/**
		 * Action to select to the end of the text
		 */
		SELECT_TEXT_END,

		// Editing
		/**
		 * Action to create a new line
		 */
		NEW_LINE
//		,
//		CUT,
//		COPY,
//		PASTE
	}

	/**
	 * The type
	 */
	public final ActionType type;

	/**
	 * Create a new action event
	 *
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @param type
	 *            the type
	 */
	public ActionEvent(Object source, EventTarget target, ActionType type) {
		super(source, target, ACTION);
		this.type = type;
	}
}
