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

/**
 * Key event sent
 */
public class VerifyEvent extends InputEvent {
	/**
	 * the event type
	 */
	public static final EventType<VerifyEvent> VERIFY = new EventType<VerifyEvent>(InputEvent.ANY, "VERIFY"); //$NON-NLS-1$
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

	/**
	 * The event
	 *
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @param event
	 *            the key
	 */
	public VerifyEvent(Object source, EventTarget target, KeyEvent event) {
		super(source, target, VERIFY);
		boolean isKeyTyped = event.getEventType() == KeyEvent.KEY_TYPED;

		this.character = isKeyTyped ? event.getCharacter() : KeyEvent.CHAR_UNDEFINED;
		this.text = isKeyTyped ? "" : event.getText(); //$NON-NLS-1$
		this.code = isKeyTyped ? KeyCode.UNDEFINED : event.getCode();
		this.shiftDown = event.isShiftDown();
		this.controlDown = event.isControlDown();
		this.altDown = event.isAltDown();
		this.metaDown = event.isMetaDown();
	}

	/**
	 * @return the character
	 */
	public String getCharacter() {
		return this.character;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * @return the key code
	 */
	public KeyCode getCode() {
		return this.code;
	}

	/**
	 * @return <code>true</code> when shift key is down
	 */
	public boolean isShiftDown() {
		return this.shiftDown;
	}

	/**
	 * @return <code>true</code> when control key is down
	 */
	public boolean isControlDown() {
		return this.controlDown;
	}

	/**
	 * @return <code>true</code> when alt key is down
	 */
	public boolean isAltDown() {
		return this.altDown;
	}

	/**
	 * @return <code>true</code> when meta key is down
	 */
	public boolean isMetaDown() {
		return this.metaDown;
	}
}
