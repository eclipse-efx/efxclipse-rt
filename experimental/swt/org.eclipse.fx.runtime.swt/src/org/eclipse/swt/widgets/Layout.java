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

import org.eclipse.swt.graphics.Point;

public abstract class Layout {
	protected abstract void layout (Composite composite, boolean flushCache);
	protected abstract Point computeSize (Composite composite, int wHint, int hHint, boolean flushCache);
	
	protected boolean flushCache(Control child) {
		return false;
	}
}
