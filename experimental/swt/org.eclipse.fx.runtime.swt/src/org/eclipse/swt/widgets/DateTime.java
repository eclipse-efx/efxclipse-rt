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

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.internal.Util;

public class DateTime extends Composite {
	private DatePicker datePicker;

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
		if( (style & SWT.TIME) == SWT.TIME ) {
			throw new UnsupportedOperationException("Currentl SWT.TIME is not supported");
		} else if( (style & SWT.DATE) == SWT.DATE ) {
			datePicker = new DatePicker();
			datePicker.setValue(LocalDate.now());
			datePicker.addEventHandler(ActionEvent.ACTION, (e) -> {
				internal_sendEvent(SWT.Selection, new Event(), true);
			});
			return datePicker;
		} else {
			datePicker = new DatePicker();
			datePicker.setValue(LocalDate.now());
			datePicker.addEventHandler(ActionEvent.ACTION, (e) -> {
				internal_sendEvent(SWT.Selection, new Event(), true);
			});
			return datePicker;
		}
//		return super.createWidget();
	}

	@Override
	public DatePicker internal_getNativeObject() {
		return datePicker;
	}

	@Override
	public Region internal_getNativeControl() {
		return datePicker;
	}

	public int getDay () {
		return datePicker.getValue().getDayOfMonth();
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
		return datePicker.getValue().getMonthValue()-1;
	}

	public int getSeconds () {
		Util.logNotImplemented();
		return 0;
	}

	public int getYear () {
		return datePicker.getValue().getYear();
	}

	public void removeSelectionListener (SelectionListener listener) {
		unregisterListener (SWT.Selection, listener);
		unregisterListener (SWT.DefaultSelection, listener);
	}

	public void setDate (int year, int month, int day) {
		datePicker.setValue(LocalDate.of(year, month+1, day));
	}

	public void setDay (int day) {
		datePicker.setValue(datePicker.getValue().withDayOfMonth(day));
	}

	public void setHours (int hours) {
		Util.logNotImplemented();
	}

	public void setMinutes (int minutes) {
		Util.logNotImplemented();
	}

	public void setMonth (int month) {
		datePicker.setValue(datePicker.getValue().withMonth(month+1));
	}

	public void setSeconds (int seconds) {
		Util.logNotImplemented();
	}

	public void setTime (int hours, int minutes, int seconds) {
		Util.logNotImplemented();
	}

	public void setYear (int year) {
		datePicker.setValue(datePicker.getValue().withYear(year));
	}
}
