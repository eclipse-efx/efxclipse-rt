package org.eclipse.fx.ui.databinding.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.Property;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextInputControl;

@SuppressWarnings("javadoc")
public class TextValueProperty<S> extends ControlPropertyValueProperty<S,String> {

	@Override
	public Object getValueType() {
		return String.class;
	}

	@SuppressWarnings("null")
	@Override
	protected @NonNull Property<String> getProperty(S source) {
		if( source instanceof TextInputControl ) {
			TextInputControl field = (TextInputControl) source;
			return field.textProperty();
		} else if( source instanceof ComboBox<?> ) {
			return ((ComboBox<?>) source).getEditor().textProperty();
		} else if( source instanceof Cell<?> ) {
			return ((Cell<?>) source).textProperty();
		} else if( source instanceof Tab ) {
			return ((Tab) source).textProperty();
		} else {
			try {
				return (@NonNull Property<String>) source.getClass().getMethod("textProperty").invoke(source);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

}
