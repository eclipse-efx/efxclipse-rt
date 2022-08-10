/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Represent a text selection
 *
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 *
 * @noreference
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
	 * An empty selection
	 */
	@NonNull
	public static final TextSelection EMPTY = new TextSelection(0, 0);

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

	@Override
	public String toString() {
		return "TextSelection [offset=" + this.offset + ", length=" + this.length + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.length;
		result = prime * result + this.offset;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextSelection other = (TextSelection) obj;
		if (this.length != other.length)
			return false;
		if (this.offset != other.offset)
			return false;
		return true;
	}

	/**
	 * Added method to check if provided offset is contained
	 *
	 * @param checkOffset
	 *            the offset to check against
	 * @return <code>true</code> if offset is contained
	 */
	public boolean contains(int checkOffset) {
		return this.offset <= checkOffset && this.offset + this.length >= checkOffset;
	}

}
