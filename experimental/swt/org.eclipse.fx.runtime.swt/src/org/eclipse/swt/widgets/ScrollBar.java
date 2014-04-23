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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.Util;

public class ScrollBar extends Widget {
	private Scrollable parent;
	
	ScrollBar(Scrollable parent, int style) {
		super(parent.getDisplay(), style);
		this.parent = parent;
	}
	
	ScrollBar(Scrollable parent, javafx.scene.control.ScrollBar nativeObject, int style) {
		super(parent.getDisplay(), nativeObject, style);
		this.parent = parent;
	}
	
	@Override
	protected javafx.scene.control.ScrollBar createWidget() {
		javafx.scene.control.ScrollBar scrollbar = new javafx.scene.control.ScrollBar();
		scrollbar.setOrientation((style & SWT.HORIZONTAL) == SWT.HORIZONTAL ? Orientation.HORIZONTAL : Orientation.VERTICAL);
		return scrollbar;
	}

	@Override
	public javafx.scene.control.ScrollBar internal_getNativeObject() {
		return (javafx.scene.control.ScrollBar) nativeObject;
	}
	
	@Override
	protected void initListeners() {
		super.initListeners();
		internal_getNativeObject().valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				Event evt = new Event();
				internal_sendEvent(SWT.Selection, evt, true);
			}
		});
	}
	
	public void addSelectionListener(SelectionListener listener) {
		checkWidget();
		if (listener == null) error (SWT.ERROR_NULL_ARGUMENT);
		TypedListener typedListener = new TypedListener(listener);
		addListener(SWT.Selection,typedListener);
		addListener(SWT.DefaultSelection,typedListener);
	}
	
	public boolean getEnabled () {
		return !internal_getNativeObject().isDisabled();
	}
	
	public int getIncrement () {
		return (int) internal_getNativeObject().getUnitIncrement();
	}
	
	public int getMaximum () {
		return (int) internal_getNativeObject().getMax();
	}
	
	public int getMinimum () {
		return (int) internal_getNativeObject().getMin();
	}
	
	public int getPageIncrement () {
		return (int) internal_getNativeObject().getBlockIncrement();
	}
	
	public Scrollable getParent () {
		return parent;
	}
	
	public int getSelection () {
		return (int) (internal_getNativeObject().getValue() * ((internal_getNativeObject().getMax() - internal_getNativeObject().getVisibleAmount()) / internal_getNativeObject().getMax()));
	}
	
	public Point getSize () {
		return new Point((int)internal_getNativeObject().getWidth(), (int)internal_getNativeObject().getHeight());
	}
	
	public int getThumb () {
		return (int) internal_getNativeObject().getVisibleAmount();
	}
	
	public Rectangle getThumbBounds () {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 10, 10);
	}
	
	public Rectangle getThumbTrackBounds () {
		Util.logNotImplemented();
		return new Rectangle(0, 0, 0, 0);
	}
	
	public boolean getVisible () {
		return internal_getNativeObject().isVisible();
	}
	
	public boolean isEnabled () {
		return ! internal_getNativeObject().isDisable();
	}
	
	public boolean isVisible () {
		return internal_getNativeObject().isVisible();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		removeListener(SWT.Selection,listener);
		removeListener(SWT.DefaultSelection,listener);
	}
	
	public void setIncrement (int value) {
		internal_getNativeObject().setUnitIncrement(value); 
	}
	
	public void setEnabled (boolean enabled) {
		internal_getNativeObject().setDisable(!enabled);
	}
	
	public void setMaximum (int value) {
		internal_getNativeObject().setMax(value);
	}
	
	public void setMinimum (int value) {
		internal_getNativeObject().setMin(value);
	}
	
	public void setPageIncrement (int value) {
		internal_getNativeObject().setBlockIncrement(value);
	}
	
	public void setSelection (int selection) {
		double max = internal_getNativeObject().getMax();
		if( max != 0.0 ) {
			double divider = ((internal_getNativeObject().getMax()-internal_getNativeObject().getVisibleAmount())/max);
			if( divider != 0 ) {
				double v = selection*1.0 / divider;
				internal_getNativeObject().setValue(v);
			}
		}
	}
	
	public void setThumb (int value) {
//		value = Math.min (value, (int)(scrollbar.getMax() - scrollbar.getMin()));
		internal_getNativeObject().setVisibleAmount(value);
	}
	
	public void setValues (int selection, int minimum, int maximum, int thumb, int increment, int pageIncrement) {
		setMinimum(minimum);
		setMaximum(maximum);
		setThumb(thumb);
		setIncrement(increment);
		setPageIncrement(pageIncrement);
		setSelection(selection);
	}
	
	public void setVisible (boolean visible) {
		internal_getNativeObject().setVisible(visible);
	}
}
