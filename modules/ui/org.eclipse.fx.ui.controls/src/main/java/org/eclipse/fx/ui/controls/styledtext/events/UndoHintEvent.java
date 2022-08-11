/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.events;

import javafx.event.Event;
import javafx.event.EventType;

public class UndoHintEvent extends Event {

	public static final EventType<UndoHintEvent> UNDO_HINT_BEGIN_COMPOUND_CHANGE = new EventType<UndoHintEvent>(Event.ANY, "UNDO_HINT_BEGIN_COMPOUND_CHANGE"); //$NON-NLS-1$

	public static final EventType<UndoHintEvent> UNDO_HINT_END_COMPOUND_CHANGE = new EventType<UndoHintEvent>(Event.ANY, "UNDO_HINT_END_COMPOUND_CHANGE"); //$NON-NLS-1$


	private UndoHintEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}

	public static UndoHintEvent createBeginCompoundChangeEvent() {
		return new UndoHintEvent(UNDO_HINT_BEGIN_COMPOUND_CHANGE);
	}

	public static UndoHintEvent createEndCompoundChangeEvent() {
		return new UndoHintEvent(UNDO_HINT_END_COMPOUND_CHANGE);
	}

}
