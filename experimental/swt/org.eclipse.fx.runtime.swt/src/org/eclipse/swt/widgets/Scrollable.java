/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;

public abstract class Scrollable extends Control {

	public Scrollable(Composite parent, int style) {
		super(parent,style);
	}

	Scrollable(Display display, int style) {
		super(display,style);
	}

	public Rectangle computeTrim(int x, int y, int width, int height) {
		// TODO We need to take the scrollbars into account!
		return new Rectangle(x, y, width, height);
	}

	public Rectangle getClientArea () {
		Region c = internal_getClientControl();
		return new Rectangle(0, 0, (int)c.getWidth(), (int)c.getHeight());
	}
	
	protected Region internal_getClientControl() {
		return internal_getNativeControl();
	}
	
	public ScrollBar getHorizontalBar () {
		Util.logNotImplemented();
		return null;
	}
	
	public int getScrollbarsMode () {
		Util.logNotImplemented();
		return SWT.NONE;
	}
	
	public ScrollBar getVerticalBar () {
		Util.logNotImplemented();
		return null;
	}
}
