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

import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class VerifyEvent extends InputEvent {
	 public static final EventType<VerifyEvent> VERIFY =
	            new EventType<VerifyEvent>(InputEvent.ANY, "VERIFY");
	/**
	 * 
	 */
	private static final long serialVersionUID = -4592943665566096149L;
	private String character;
	private String text;
	private KeyCode code;
	private boolean shiftDown;
	private boolean controlDown;
	private boolean altDown;
	private boolean metaDown; 
	
	public VerifyEvent(Object source, EventTarget target, KeyEvent event) {
		super(source,target,VERIFY);
		boolean isKeyTyped = event.getEventType() == KeyEvent.KEY_TYPED;
		
		this.character = isKeyTyped ? event.getCharacter() : KeyEvent.CHAR_UNDEFINED;
        this.text = isKeyTyped ? "" : event.getText();
        this.code = isKeyTyped ? KeyCode.UNDEFINED : event.getCode();
        this.shiftDown = event.isShiftDown();
        this.controlDown = event.isControlDown();
        this.altDown = event.isAltDown();
        this.metaDown = event.isMetaDown();
	}

	public String getCharacter() {
		return character;
	}
	
	public String getText() {
		return text;
	}
	
	public KeyCode getCode() {
		return code;
	}
	
	public boolean isShiftDown() {
		return shiftDown;
	}
	
	public boolean isControlDown() {
		return controlDown;
	}
	
	public boolean isAltDown() {
		return altDown;
	}
	
	public boolean isMetaDown() {
		return metaDown;
	}
}
