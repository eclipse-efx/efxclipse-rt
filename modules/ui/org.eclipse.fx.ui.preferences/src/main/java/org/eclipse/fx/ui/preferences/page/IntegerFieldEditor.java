/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at, EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API
 *     Camille Letavernier <cletavernier@eclipsesource.com> - initial implementation
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
 * A Field editor for integer preferences.
 * </p>
 */
public class IntegerFieldEditor extends FieldEditor {

	private static final Logger LOGGER = LoggerCreator.createLogger(IntegerFieldEditor.class);

	private final TextField textField;

	public IntegerFieldEditor(String name, String label) {
		super(name, label);
		this.textField = new TextField();
		getChildren().add(textField);

		configureValidation(this.textField);
	}

	public IntegerFieldEditor(String name) {
		this(name, null);
	}

	private void configureValidation(TextField textField) {
		SimpleObjectProperty<Status> status = new SimpleObjectProperty<Status>(Status.ok());
		NodeDecorator.apply(this.textField, status);
		this.textField.textProperty().addListener((obs, oldText, newText) -> {
			try {
				Integer.parseInt(newText);
				status.set(Status.ok());
			} catch (NumberFormatException ex) {
				status.set(Status.status(State.ERROR, Status.UNKNOWN_RETURN_CODE, "The value must be a valid integer",
						ex));
			}
		});
	}

	@Override
	protected void doLoad() {
		this.textField.setText(Integer.toString(getMemento().get(getName(), 0)));
	}

	@Override
	protected void doRestoreDefaults() {
		this.textField.setText(Integer.toString(getMemento().getDefaultInteger(getName())));
	}

	@Override
	protected void doPersist() {
		try {
			getMemento().put(getName(), getIntValue());
		} catch (NumberFormatException ex) {
			// Don't persist when the current value is incorrect
			LOGGER.error("An error occurred when trying to persist the integer value for " + getName(), ex);
		}
	}

	private int getIntValue() throws NumberFormatException {
		return Integer.parseInt(textField.getText());
	}

	@Override
	protected ObservableValue<?> getValue() {
		return this.textField.textProperty();
	}

}
