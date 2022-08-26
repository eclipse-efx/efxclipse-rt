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

import org.eclipse.swt.internal.SWTEventObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public class TypedEvent extends SWTEventObject {

	public Display display;

	public Widget widget;

	public int time;

	public Object data;

	static final long serialVersionUID = 3257285846578377524L;

	public TypedEvent(Object object) {
		super(object);
	}

	public TypedEvent(Event e) {
		super(e.widget);
		this.display = e.display;
		this.widget = e.widget;
		this.time = e.time;
		this.data = e.data;
	}

	String getName() {
		String string = getClass().getName();
		int index = string.lastIndexOf('.');
		if (index == -1)
			return string;
		return string.substring(index + 1, string.length());
	}

	public String toString() {
		return getName() + "{" + widget + " time=" + time + " data=" + data + "}";
	}
}
