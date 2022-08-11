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
