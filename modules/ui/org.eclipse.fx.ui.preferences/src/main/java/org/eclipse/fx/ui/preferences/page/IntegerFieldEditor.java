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
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.eclipse.fx.ui.controls.form.NodeDecorator;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * <p>
 * A Field editor for integer preferences.
 * </p>
 */
public class IntegerFieldEditor extends FieldEditor<Integer> {
	private static final Logger LOGGER = LoggerCreator.createLogger(IntegerFieldEditor.class);

	private final TextField textField;
	private SimpleIntegerProperty value = new SimpleIntegerProperty(this, "value");

	public IntegerFieldEditor(String name, String label) {
		super(name, label);
		this.textField = new TextField();
		getChildren().add(textField);

		NodeDecorator.apply(this.textField, statusProperty());
		FXObservableUtil.onChange(this.textField.textProperty(), newValue -> {
			try {
				value.set(Integer.parseInt(newValue));
			} catch (NumberFormatException ex) {
				return;
			}
		});
	}

	public IntegerFieldEditor(String name) {
		this(name, null);
	}

	@Override
	protected ObjectExpression<Status> createStatusBinding() {
		ObjectExpression<Status> parentStatus = super.createStatusBinding();
		return Bindings.createObjectBinding(() -> {
			try {
				Integer.parseInt(textField.getText());
				return parentStatus.get();
			} catch (NumberFormatException ex) {
				return Status.status(State.ERROR, Status.UNKNOWN_RETURN_CODE, "The value must be a valid integer", ex);
			}
		}, parentStatus, textField.textProperty());

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
	
	protected final TextField geTextField() {
		return this.textField;
	}

	protected int getIntValue() throws NumberFormatException {
		return Integer.parseInt(textField.getText());
	}

	@Override
	public ObservableValue<Integer> getValue() {
		return this.value.asObject();
	}

}
