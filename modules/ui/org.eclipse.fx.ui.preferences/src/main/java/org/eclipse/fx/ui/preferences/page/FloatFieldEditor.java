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
import org.eclipse.fx.ui.controls.form.NodeDecorator;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * <p>
 * A Field editor for float preferences.
 * </p>
 */
public class FloatFieldEditor extends FieldEditor {
	private final TextField textField;

	private static final Logger LOGGER = LoggerCreator.createLogger(FloatFieldEditor.class);

	public FloatFieldEditor(String name, String label) {
		super(name, label);
		this.textField = new TextField();
		getChildren().add(textField);

		configureValidation(this.textField);
	}

	public FloatFieldEditor(String name) {
		this(name, null);
	}

	private void configureValidation(TextField textField) {
		SimpleObjectProperty<Status> status = new SimpleObjectProperty<Status>(Status.ok());
		NodeDecorator.apply(this.textField, status);
		this.textField.textProperty().addListener((obs, oldText, newText) -> {
			try {
				Float.parseFloat(newText);
				status.set(Status.ok());
			} catch (NumberFormatException ex) {
				status.set(
						Status.status(State.ERROR, Status.UNKNOWN_RETURN_CODE, "The value must be a valid float", ex));
			}
		});
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
			getMemento().put(getName(), getFloatValue());
		} catch (NumberFormatException ex) {
			// Don't persist when the current value is incorrect
			LOGGER.error("An error occurred when trying to persist the float value for " + getName(), ex);
		}
	}

	private float getFloatValue() throws NumberFormatException {
		return Float.parseFloat(textField.getText());
	}

	@Override
	protected ObservableValue<?> getValue() {
		return this.textField.textProperty();
	}
}
