/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import org.eclipse.swt.internal.Util;

public class Tray extends Widget {

	Tray(Display display, int style) {
		super(display, style);
	}

	@Override
	protected Object createWidget() {
		Util.logNotImplemented();
		return null;
	}

	@Override
	public Object internal_getNativeObject() {
		Util.logNotImplemented();
		return null;
	}

	public TrayItem getItem (int index) {
		Util.logNotImplemented();
		return null;
	}
	
	public int getItemCount () {
		Util.logNotImplemented();
		return 0;
	}
	
	public TrayItem [] getItems () {
		Util.logNotImplemented();
		return new TrayItem[0];
	}
}
