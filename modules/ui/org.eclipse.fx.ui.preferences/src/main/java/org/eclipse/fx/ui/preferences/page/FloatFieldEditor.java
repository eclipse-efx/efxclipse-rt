/*******************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Camille Letavernier <cletavernier@eclipsesource.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.preferences.page;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.eclipse.fx.ui.controls.form.NodeDecorator;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * <p>
 * A Field editor for float preferences.
 * </p>
 */
public class FloatFieldEditor extends FieldEditor<Float> {
	private static final Logger LOGGER = LoggerCreator.createLogger(FloatFieldEditor.class);
	
	private final TextField textField;
	private SimpleFloatProperty value = new SimpleFloatProperty(this, "value");

	public FloatFieldEditor(String name, String label) {
		super(name, label);
		this.textField = new TextField();
		getChildren().add(textField);

		NodeDecorator.apply(this.textField, statusProperty());
		
		FXObservableUtil.onChange(this.textField.textProperty(), newValue -> {
			try {
				value.set(Float.parseFloat(newValue));
			} catch (NumberFormatException ex) {
				return;
			}
		});
	}

	public FloatFieldEditor(String name) {
		this(name, null);
	}

	@Override
	protected ObjectExpression<Status> createStatusBinding() {
		ObjectExpression<Status> parentStatus = super.createStatusBinding();
		return Bindings.createObjectBinding(() -> {
			try {
				Float.parseFloat(textField.getText());
				return parentStatus.get();
			} catch (NumberFormatException ex) {
				return Status.status(State.ERROR, Status.UNKNOWN_RETURN_CODE, "The value must be a valid float", ex);
			}
		}, parentStatus, textField.textProperty());

	}

	@Override
	protected void doLoad() {
		this.textField.setText(getDisplayValue((float) getMemento().get(getName(), 0f)));
	}

	@Override
	protected void doRestoreDefaults() {
		this.textField.setText(getDisplayValue((float) getMemento().getDefaultDouble(getName())));
	}

	/**
	 * Hook point to override the display/formatting of floats
	 * 
	 * @param floatValue
	 *            The float value to display
	 * @return The String to be displayed in the text field for this float value
	 */
	protected String getDisplayValue(float floatValue) {
		return Float.toString(floatValue);
	}

	@Override
	protected void doPersist() {
		try {
			getMemento().put(getName(), getValue().getValue());
		} catch (NumberFormatException ex) {
			// Don't persist when the current value is incorrect
			LOGGER.error("An error occurred when trying to persist the float value for " + getName(), ex);
		}
	}

	protected final TextField getTextField() {
		return this.textField;
	}

	@Override
	public ObservableValue<Float> getValue() {
		return value.asObject();
	}
}
