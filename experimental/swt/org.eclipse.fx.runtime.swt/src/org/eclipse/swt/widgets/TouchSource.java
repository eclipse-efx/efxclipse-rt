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

import org.eclipse.swt.graphics.Rectangle;

public class TouchSource {
	int /* long */handle;
	boolean direct;
	Rectangle bounds;

	TouchSource(int /* long */handle, boolean direct, Rectangle bounds) {
		this.handle = handle;
		this.direct = direct;
		this.bounds = bounds;
	}

	public boolean isDirect() {
		return direct;
	}

	public Rectangle getBounds() {
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	public String toString() {
		return "TouchSource {handle=" + handle + " direct=" + direct + " bounds=" + bounds + "}";
	}
}
