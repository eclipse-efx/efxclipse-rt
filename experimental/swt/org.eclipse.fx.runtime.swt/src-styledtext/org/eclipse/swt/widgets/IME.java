/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Widget;

public class IME extends Widget {
	Canvas parent;
	int caretOffset;
	int startOffset;
	int commitCount;
	String text;
	int [] ranges;
	TextStyle [] styles;
	
	static final int UNDERLINE_THICK = 1 << 16;

	public IME(Canvas parent, int style) {
		super(parent.getDisplay(), style);
		text = "";
		startOffset = -1;
		if (parent.getIME () == null) {
			parent.setIME (this);
		}
	}

	@Override
	protected Object createWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object internal_getNativeObject() {
		return this;
	}

	public int getCaretOffset () {
		return startOffset + caretOffset;
	}
	
	public int getCommitCount () {
		return commitCount;
	}
	
	public int getCompositionOffset () {
		return startOffset;
	}
	
	public int [] getRanges () {
		if (ranges == null) {
			return new int [0];
		}
		int [] result = new int [ranges.length];
		for (int i = 0; i < result.length; i++) {
			result [i] = ranges [i] + startOffset; 
		}
		return result;
	}
	
	public TextStyle [] getStyles () {
		if (styles == null) {
			return new TextStyle [0];
		}
		TextStyle [] result = new TextStyle [styles.length];
		System.arraycopy (styles, 0, result, 0, styles.length);
		return result;
	}
	
	public String getText () {
		return text;
	}
	
	public boolean getWideCaret() {
		return false;
	}
	
	public void setCompositionOffset (int offset) {
		checkWidget ();
		if (offset < 0) return;
		if (startOffset != -1) {
			startOffset = offset;
		}
	}

}
