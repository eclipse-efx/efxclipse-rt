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

import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.internal.Util;

public class DateTime extends Composite {

	public DateTime(Composite parent, int style) {
		super(parent, style);
	}

	public void addSelectionListener (SelectionListener listener) {
		TypedListener typedListener = new TypedListener (listener);
		addListener (SWT.Selection, typedListener);
		addListener (SWT.DefaultSelection, typedListener);
	}
	
	@Override
	protected Region createWidget() {
		// TODO Auto-generated method stub
		return super.createWidget();
	}
	
	public int getDay () {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getHours () {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getMinutes () {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getMonth () {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getSeconds () {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getYear () {
		Util.logNotImplemented();
		return 0;
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		unregisterListener (SWT.Selection, listener);
		unregisterListener (SWT.DefaultSelection, listener);	
	}
	
	public void setDate (int year, int month, int day) {
		Util.logNotImplemented();
	}
	
	public void setDay (int day) {
		Util.logNotImplemented();
	}
	
	public void setHours (int hours) {
		Util.logNotImplemented();
	}
	
	public void setMinutes (int minutes) {
		Util.logNotImplemented();
	}
	
	public void setMonth (int month) {
		Util.logNotImplemented();
	}
	
	public void setSeconds (int seconds) {
		Util.logNotImplemented();
	}
	
	public void setTime (int hours, int minutes, int seconds) {
		Util.logNotImplemented();
	}
	
	public void setYear (int year) {
		Util.logNotImplemented();
	}
}
