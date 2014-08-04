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
		LINE_END
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
