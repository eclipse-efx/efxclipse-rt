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

public class SegmentEvent extends TypedEvent {

	public int lineOffset;

	public String lineText;

	public int[] segments;

	public char[] segmentsChars;

	static final long serialVersionUID = -2414889726745247762L;

	public SegmentEvent(Event e) {
		super(e);
		lineText = e.text;
		lineOffset = e.detail;
	}
}