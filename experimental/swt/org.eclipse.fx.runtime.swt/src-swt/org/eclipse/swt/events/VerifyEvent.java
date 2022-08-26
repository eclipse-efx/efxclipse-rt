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
package org.eclipse.swt.events;

import org.eclipse.swt.widgets.Event;

public final class VerifyEvent extends KeyEvent {

	public int start, end;

	public String text;

	static final long serialVersionUID = 3257003246269577014L;

	public VerifyEvent(Event e) {
		super(e);
		this.start = e.start;
		this.end = e.end;
		this.text = e.text;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " start=" + start + " end=" + end + " text=" + text + "}";
	}
}