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

public final class TraverseEvent extends KeyEvent {

	public int detail;

	static final long serialVersionUID = 3257565105301239349L;

	public TraverseEvent(Event e) {
		super(e);
		this.detail = e.detail;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " detail=" + detail + "}";
	}
}