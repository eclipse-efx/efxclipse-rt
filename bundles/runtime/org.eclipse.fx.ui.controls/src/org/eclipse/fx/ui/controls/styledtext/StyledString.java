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

import javafx.beans.WeakInvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A string with styling informations
 *
 * @since 1.2
 */
public class StyledString implements CharSequence {
	@Nullable
	private StringBuffer buffer;

	@SuppressWarnings("null")
	@NonNull
	private ObservableList<@NonNull StyledStringSegment> segmentList = FXCollections.observableArrayList();

	/**
	 * Create a styled string
	 */
	public StyledString() {
		this.segmentList.addListener(new WeakInvalidationListener((o) -> this.buffer = null ));
	}

	private final StringBuffer buffer() {
		StringBuffer rv = this.buffer;
		if( rv == null ) {
			rv = this.buffer = new StringBuffer();
			for( StyledStringSegment s : this.segmentList ) {
				rv.append(s.getText());
			}
		}
		return rv;
	}

	@Override
	public int length() {
		return buffer().length();
	}

	@Override
	public char charAt(int index) {
		return buffer().charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return buffer().subSequence(start, end);
	}

	@Override
	public String toString() {
		return buffer().toString();
	}

	/**
	 * @return list of segments
	 */
	public @NonNull ObservableList<@NonNull StyledStringSegment> getSegmentList() {
		return this.segmentList;
	}
}
