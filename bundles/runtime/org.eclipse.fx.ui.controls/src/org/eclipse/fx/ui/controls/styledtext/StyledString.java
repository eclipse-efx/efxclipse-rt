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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A string with styling informations
 *
 * @since 1.2
 */
public class StyledString implements CharSequence {
	@NonNull
	private final StringBuffer stringBuffer;
	@NonNull
	private List<@NonNull StyleRange> rangeList = new ArrayList<>();

	/**
	 * Create a new styled string
	 *
	 * @param s
	 *            the initial char sequence
	 */
	public StyledString(@NonNull CharSequence s) {
		this.stringBuffer = new StringBuffer(s);
		if (s instanceof StyledString) {
			this.rangeList.addAll(((StyledString) s).rangeList);
		}
	}

	/**
	 * Append a char sequence
	 *
	 * <p>
	 * If the sequence is a {@link StyledString} the styles are appended as well
	 * </p>
	 *
	 * @param s
	 *            the sequence to append
	 */
	public void append(CharSequence s) {
		int l = this.stringBuffer.length();

		this.stringBuffer.append(s);
		if (s instanceof StyledString) {
			for( StyleRange r : ((StyledString) s).rangeList ) {
				StyleRange clone = (StyleRange) r.clone();
				clone.start += l;
				this.rangeList.add(clone);
			}
		}
	}

	/**
	 * @return unmodifiable list of ranges
	 */
	@SuppressWarnings("null")
	public @NonNull List<@NonNull StyleRange> getRanges() {
		return Collections.unmodifiableList(this.rangeList);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String toString() {
		return this.stringBuffer.toString();
	}

	@Override
	public int length() {
		return this.stringBuffer.length();
	}

	@Override
	public char charAt(int index) {
		return this.stringBuffer.charAt(index);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull CharSequence subSequence(int start, int end) {
		return this.stringBuffer.subSequence(start, end);
	}
}
