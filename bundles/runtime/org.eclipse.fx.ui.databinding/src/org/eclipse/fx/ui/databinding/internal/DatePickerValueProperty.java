package org.eclipse.fx.ui.databinding.internal;

import java.time.LocalDate;

import javafx.beans.property.Property;
import javafx.scene.control.DatePicker;

/**
 *
 */
public class DatePickerValueProperty extends ControlPropertyValueProperty<LocalDate> {

	@Override
	public Object getValueType() {
		return LocalDate.class;
	}

	@Override
	protected Property<LocalDate> getProperty(Object source) {
		DatePicker p = (DatePicker) source;
		return p.valueProperty();
	}

}
