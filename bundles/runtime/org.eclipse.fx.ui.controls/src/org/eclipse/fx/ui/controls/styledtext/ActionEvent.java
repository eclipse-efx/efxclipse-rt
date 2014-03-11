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

public class ActionEvent extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final EventType<ActionEvent> ACTION =
            new EventType<ActionEvent>(Event.ANY, "STYLED_TEXT_ACTION");
	
	public enum ActionType {
		DELETE_WORD_PREVIOUS,
		DELETE_WORD_NEXT,
		
		WORD_NEXT,
		WORD_PREVIOUS,
		
		LINE_START,
		LINE_END
	}
	
	public final ActionType type;
	
	public ActionEvent(Object source, EventTarget target, ActionType type) {
		super(source, target, ACTION);
		this.type = type;
	}
}
