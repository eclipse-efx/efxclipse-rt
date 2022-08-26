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
package org.eclipse.swt.graphics;

public class FontMetrics {
	private final int ascent;
	private final int descent;
	private final int averageCharWidth;
	private final int leading;
	private final int height;
	
	public FontMetrics(int ascent, int descent, int averageCharWidth, int leading, int height) {
		this.ascent = ascent;
		this.descent = descent;
		this.averageCharWidth = averageCharWidth;
		this.leading = leading;
		this.height = height;
	}
	
	public int getAscent() {
		return ascent;
	}
	
	public int getDescent() {
		return descent;
	}
	
	public int getAverageCharWidth() {
		return averageCharWidth;
	}

	public int getLeading() {
		return leading;
	}
	
	public int getHeight() {
		return height;
	}
}
