package org.eclipse.swt.widgets;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.internal.Util;

import javafx.scene.Parent;
import javafx.scene.control.Slider;

public class Spinner extends Composite {
	private javafx.scene.control.Slider slider;

	public Spinner(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void internal_attachControl(Control c) {
		throw new UnsupportedOperationException("Combo does not support children");
	}
	
	protected void internal_attachControl(int idx, Control c) {
		throw new UnsupportedOperationException("Combo does not support children");
	}
	
	@Override
	protected void internal_detachControl(Control c) {
		throw new UnsupportedOperationException("Combo does not support children");
	}

	@Override
	public Slider internal_getNativeObject() {
		return slider;
	}

	@Override
	protected Slider createWidget() {
		slider = new javafx.scene.control.Slider(0, 100, 0);
		slider.setMajorTickUnit(1);
		return slider;
	}

	@Override
	protected double internal_getHeight() {
		return slider.getHeight();
	}

	@Override
	protected double internal_getPrefHeight() {
		return slider.prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}

	@Override
	protected double internal_getPrefWidth() {
		return slider.prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
	}

	@Override
	protected double internal_getWidth() {
		return slider.getWidth();
	}

	public void addModifyListener(ModifyListener listener) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void addSelectionListener(SelectionListener listener) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void copy() {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void cut() {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public int getDigits() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public int getIncrement() {
		checkWidget();
		return (int) slider.getMajorTickUnit();
	}

	public int getMaximum() {
		checkWidget();
		return (int) slider.getMax();
	}

	public int getMinimum() {
		checkWidget();
		return (int) slider.getMin();
	}

	public int getPageIncrement() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public int getSelection() {
		checkWidget();
		return (int) slider.getValue();
	}

	public String getText() {
		// TODO Not implemented
		Util.logNotImplemented();
		return "";
	}

	public int getTextLimit() {
		// TODO Not implemented
		Util.logNotImplemented();
		return 0;
	}

	public void paste() {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void removeModifyListener(ModifyListener listener) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void removeSelectionListener(SelectionListener listener) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setDigits(int value) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setIncrement(int value) {
		checkWidget();
		slider.setMajorTickUnit(value);
	}

	public void setMaximum(int value) {
		checkWidget();
		slider.setMax(value);
	}

	public void setMinimum(int value) {
		checkWidget();
		slider.setMin(value);
	}

	public void setPageIncrement(int value) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setSelection(int value) {
		checkWidget();
		slider.setValue(value);
	}

	public void setTextLimit(int limit) {
		// TODO Not implemented
		Util.logNotImplemented();
	}

	public void setValues(int selection, int minimum, int maximum, int digits, int increment, int pageIncrement) {
		setMinimum(minimum);
		setMinimum(maximum);
		setDigits(digits);
		
		setSelection(selection);

		setIncrement(increment);
		setPageIncrement(pageIncrement);
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this,getFont());
	}
}
