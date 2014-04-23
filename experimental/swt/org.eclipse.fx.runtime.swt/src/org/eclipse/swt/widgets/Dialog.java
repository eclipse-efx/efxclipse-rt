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

public class Dialog {
	private Shell parent;
	private int style;
	private String title;
	
	public Dialog (Shell parent) {
		this.parent = parent;
	}
	
	public Dialog (Shell parent, int style) {
		this.parent = parent;
		this.style = style;
	}
	
	public Shell getParent () {
		return parent;
	}
	
	public int getStyle () {
		return style;
	}
	
	public String getText () {
		return title;
	}
	
	public void setText (String string) {
		this.title = string;
	}
}
