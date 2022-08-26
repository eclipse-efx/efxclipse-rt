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
package org.eclipse.swt.internal;

import javafx.geometry.Bounds;

import org.eclipse.swt.graphics.Rectangle;

public class Converter {
	public static Rectangle fromBounds(Bounds b) {
		return new Rectangle((int)b.getMinX(), (int)b.getMinY(), (int)b.getWidth(), (int)b.getHeight());
	}
}
