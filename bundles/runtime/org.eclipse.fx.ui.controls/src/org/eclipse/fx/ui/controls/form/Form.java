package org.eclipse.fx.ui.controls.form;

import org.eclipse.fx.core.Status;

import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectProperty;

public interface Form {
	enum BindingConfiguration {
		VALIDATE_TO_OPPOSITE,
		OPPOSITE_TO_VALIDATE
	}

	public ReadOnlyObjectProperty<Status> validationStatusProperty();

	public <T> BindingBuilder builder( String id, Property<T> validatedProperty, Property<T> oppositeProperty, BindingConfiguration type );
}
