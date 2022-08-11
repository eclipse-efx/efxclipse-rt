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

import javafx.scene.control.Slider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.internal.Util;

public class Scale extends Control {

	private Slider nativeWidget;

	public Scale(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}

	@Override
	public Slider internal_getNativeObject() {
		return nativeWidget;
	}

	@Override
	protected Slider createWidget() {
		nativeWidget = new Slider();
		return nativeWidget;
	}

	public void addSelectionListener(SelectionListener listener) {
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Selection,typedListener);
		addListener(SWT.DefaultSelection,typedListener);
	}
	
	public int getIncrement () {
		return (int) nativeWidget.getMajorTickUnit(); 
	}
	
	public int getMaximum () {
		return (int) nativeWidget.getMax();
	}
	
	public int getMinimum () {
		return (int) nativeWidget.getMin();
	}
	
	public int getPageIncrement () {
		Util.logNotImplemented();
		return 0;
	}
	
	public int getSelection () {
		return (int) nativeWidget.getValue();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		removeListener(SWT.Selection, listener);
		removeListener(SWT.DefaultSelection, listener);
	}
	
	public void setIncrement (int increment) {
		nativeWidget.setMajorTickUnit(increment);
	}
	
	public void setMaximum (int value) {
		nativeWidget.setMax(value); 
	}
	
	public void setMinimum (int value) {
		nativeWidget.setMin(value); 
	}
	
	public void setPageIncrement (int pageIncrement) {
		Util.logNotImplemented();
	}
	
	public void setSelection (int value) {
		nativeWidget.setValue(value); 
	}
}
