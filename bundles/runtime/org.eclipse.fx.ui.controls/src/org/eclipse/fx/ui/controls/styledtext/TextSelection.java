/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

/**
 * Represent a text selection
 */
public class TextSelection {
	/**
	 * The offset
	 */
	public final int offset;
	/**
	 * The length
	 */
	public final int length;

	/**
	 * Create a new selection
	 * 
	 * @param offset
	 *            the offset
	 * @param length
	 *            the length
	 */
	public TextSelection(int offset, int length) {
		this.offset = offset;
		this.length = length;
	}
}
