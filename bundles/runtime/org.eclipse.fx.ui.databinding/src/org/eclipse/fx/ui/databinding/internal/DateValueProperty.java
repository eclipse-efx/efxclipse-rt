package org.eclipse.fx.ui.databinding.internal;

import java.time.LocalDate;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.Property;
import javafx.scene.control.DatePicker;

@SuppressWarnings("javadoc")
public class DatePickerValueProperty extends ControlPropertyValueProperty<@NonNull DatePicker,LocalDate> {

	@Override
	public Object getValueType() {
		return LocalDate.class;
	}

	@SuppressWarnings("null")
	@Override
	protected Property<LocalDate> getProperty(DatePicker source) {
		return source.valueProperty();
	}

}
