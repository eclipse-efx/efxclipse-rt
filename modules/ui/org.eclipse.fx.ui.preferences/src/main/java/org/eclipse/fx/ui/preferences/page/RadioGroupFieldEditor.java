/*******************************************************************************
 * Copyright (c) 2018 EclipseSource and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Camille Letavernier <cletavernier@eclipsesource.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.preferences.page;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * <p>
 * A FieldEditor for Enumerated Values preferences, presented as a grid of Radio
 * buttons
 * </p>
 */
public class RadioGroupFieldEditor extends FieldEditor<String> {
	
	/**
	 * CSS Style Class for the {@link GridPane} of this {@link RadioGroupFieldEditor}
	 */
	public static final String RADIO_GRID_STYLE = "radio-field-grid"; //$NON-NLS-1$
	
	private final StringProperty currentValue = new SimpleStringProperty(this, "currentValue");
	private Map<String, RadioButton> valueToRadio = new HashMap<>();
	private ToggleGroup radioGroup;

	public RadioGroupFieldEditor(String name, String label, int numColumns, String[][] labelAndValues) {
		super(name, label);

		GridPane grid = new GridPane();
		grid.getStyleClass().add(RADIO_GRID_STYLE);
		int column = 0;
		int row = 0;

		radioGroup = new ToggleGroup();
		for (String[] labelAndValue : labelAndValues) {
			String radioLabel = labelAndValue[0];
			String value = labelAndValue[1];
			RadioButton radio = new RadioButton(radioLabel);
			valueToRadio.put(value, radio);
			radio.setToggleGroup(radioGroup);
			radio.selectedProperty().addListener((obs, old, newSelected) -> {
				if (newSelected) {
					this.currentValue.set(value);
				}
			});
			grid.add(radio, column, row);
			column++;
			if (column == numColumns) {
				column = 0;
				row++;
			}
		}

		getChildren().add(grid);
	}

	@Override
	protected void doLoad() {
		String value = getMemento().get(getName(), "");
		RadioButton radio = valueToRadio.get(value);
		if (radio != null) {
			radio.setSelected(true);
		}
	}

	@Override
	protected void doRestoreDefaults() {
		String value = getMemento().getDefaultString(getName());
		RadioButton radio = valueToRadio.get(value);
		if (radio != null) {
			radio.setSelected(true);
		} else {
			radioGroup.selectToggle(null);
		}
	}

	@Override
	protected void doPersist() {
		if (currentValue.getValue() == null) {
			getMemento().remove(getName());
		} else {
			getMemento().put(getName(), currentValue.getValue());
		}
	}

	@Override
	public ObservableValue<String> getValue() {
		return currentValue;
	}
	
}
