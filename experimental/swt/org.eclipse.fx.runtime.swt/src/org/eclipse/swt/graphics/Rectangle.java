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


public class Rectangle {
	
	public int x;
	
	public int y;
	
	public int width;
	
	public int height;
	
	public Rectangle (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void add (Rectangle rect) {
//FIXME		if (rect == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		int left = x < rect.x ? x : rect.x;
		int top = y < rect.y ? y : rect.y;
		int lhs = x + width;
		int rhs = rect.x + rect.width;
		int right = lhs > rhs ? lhs : rhs;
		lhs = y + height;
		rhs = rect.y + rect.height;
		int bottom = lhs > rhs ? lhs : rhs;
		x = left;  y = top;  width = right - left;  height = bottom - top;
	}
	
	public boolean contains (int x, int y) {
		return (x >= this.x) && (y >= this.y) && x < (this.x + width) && y < (this.y + height);
	}
	
	public boolean contains (Point pt) {
//FIXME		if (pt == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		return contains(pt.x, pt.y);
	}
	
	public boolean equals (Object object) {
		if (object == this) return true;
		if (!(object instanceof Rectangle)) return false;
		Rectangle r = (Rectangle)object;
		return (r.x == this.x) && (r.y == this.y) && (r.width == this.width) && (r.height == this.height);
	}
	
	public int hashCode () {
		return x ^ y ^ width ^ height;
	}
	
	public void intersect (Rectangle rect) {
//FIXME		if (rect == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		if (this == rect) return;
		int left = x > rect.x ? x : rect.x;
		int top = y > rect.y ? y : rect.y;
		int lhs = x + width;
		int rhs = rect.x + rect.width;
		int right = lhs < rhs ? lhs : rhs;
		lhs = y + height;
		rhs = rect.y + rect.height;
		int bottom = lhs < rhs ? lhs : rhs;
		x = right < left ? 0 : left;
		y = bottom < top ? 0 : top;
		width = right < left ? 0 : right - left;
		height = bottom < top ? 0 : bottom - top;
	}
	
	public Rectangle intersection (Rectangle rect) {
//FIXME		if (rect == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		if (this == rect) return new Rectangle (x, y, width, height);
		int left = x > rect.x ? x : rect.x;
		int top = y > rect.y ? y : rect.y;
		int lhs = x + width;
		int rhs = rect.x + rect.width;
		int right = lhs < rhs ? lhs : rhs;
		lhs = y + height;
		rhs = rect.y + rect.height;
		int bottom = lhs < rhs ? lhs : rhs;
		return new Rectangle (
			right < left ? 0 : left,
			bottom < top ? 0 : top,
			right < left ? 0 : right - left,
			bottom < top ? 0 : bottom - top);
	}
	
	public boolean intersects (int x, int y, int width, int height) {
		return (x < this.x + this.width) && (y < this.y + this.height) &&
			(x + width > this.x) && (y + height > this.y);
	}
	
	public boolean intersects (Rectangle rect) {
//FIXME		if (rect == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		return rect == this || intersects (rect.x, rect.y, rect.width, rect.height);
	}
	
	public boolean isEmpty () {
		return (width <= 0) || (height <= 0);
	}
	
	public String toString () {
		return "Rectangle {" + x + ", " + y + ", " + width + ", " + height + "}"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
	
	public Rectangle union (Rectangle rect) {
//		if (rect == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		int left = x < rect.x ? x : rect.x;
		int top = y < rect.y ? y : rect.y;
		int lhs = x + width;
		int rhs = rect.x + rect.width;
		int right = lhs > rhs ? lhs : rhs;
		lhs = y + height;
		rhs = rect.y + rect.height;
		int bottom = lhs > rhs ? lhs : rhs;
		return new Rectangle (left, top, right - left, bottom - top);
	}
}
