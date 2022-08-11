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

public final class MenuDetectEvent extends TypedEvent {

	public int x;

	public int y;

	public boolean doit;

	public int detail;

	private static final long serialVersionUID = -3061660596590828941L;

	public MenuDetectEvent(Event e) {
		super(e);
		this.x = e.x;
		this.y = e.y;
		this.doit = e.doit;
		this.detail = e.detail;
	}

	public String toString() {
		String string = super.toString();
		return string.substring(0, string.length() - 1) // remove trailing '}'
				+ " x=" + x + " y=" + y + " doit=" + doit + " detail=" + detail + "}";
	}
}