/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at, EclipseSource and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API
 *     Camille Letavernier <cletavernier@eclipsesource.com> - initial implementation
 *******************************************************************************/
package org.eclipse.fx.ui.preferences.page;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * <p>
 * A Field editor for color preferences.
 * </p>
 */
public class ColorFieldEditor extends FieldEditor<Color> {

	private static final Logger LOGGER = LoggerCreator.createLogger(ColorFieldEditor.class);

	private final ColorPicker colorPicker;

	public ColorFieldEditor(String name, String label) {
		super(name, label);
		this.colorPicker = new ColorPicker();
		getChildren().add(colorPicker);
	}

	public ColorFieldEditor(String name) {
		this(name, null);
	}

	@Override
	protected void doLoad() {
		String color = getMemento().get(getName(), ""); //$NON-NLS-1$
		this.colorPicker.setValue(parseColor(color));
	}

	@Override
	protected void doRestoreDefaults() {
		String defaultColor = getMemento().getDefaultString(getName());
		this.colorPicker.setValue(parseColor(defaultColor));
	}

	// Parses a JavaFX Color from a String. The String is compatible with
	// JFace preference format for RGB, with an optional alpha value.
	// The color must be in the format 255,255,255 or 255,255,255,1.0
	// If the color is null, empty or invalid, this method returns null
	private Color parseColor(String color) {
		if (color == null || color.isEmpty()) {
			return null;
		}
		StringTokenizer tokenizer = new StringTokenizer(color, ",");
		try {
			String red = tokenizer.nextToken().trim();
			String green = tokenizer.nextToken().trim();
			String blue = tokenizer.nextToken().trim();
			// Alpha is optional, for backwards compatibility with JFace
			String alpha = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "1.0";

			try {
				int r = Integer.parseInt(red);
				int g = Integer.parseInt(green);
				int b = Integer.parseInt(blue);
				double a = Double.parseDouble(alpha);
				return new Color(toDouble(r), toDouble(g), toDouble(b), a); // Will throw if the values are out of range
			} catch (Exception ex) {
				LOGGER.error("An error occurred when trying to load the color value for " + getName(), ex);
			}
		} catch (IllegalArgumentException ex) {
			LOGGER.error("An error occurred when trying to load the color value for " + getName(), ex);
		} catch (NoSuchElementException ex) {
			LOGGER.error("An error occurred when trying to load the color value for " + getName(), ex);
		}
		return null;
	}

	private static double toDouble(int intColor) {
		return intColor / 255.;
	}

	@Override
	protected void doPersist() {
		Color color = this.colorPicker.getValue();
		getMemento().put(getName(), toString(color));
	}

	private static String toString(Color color) {
		return String.format("%s,%s,%s,%s", toInt(color.getRed()), toInt(color.getGreen()), toInt(color.getBlue()),
				color.getOpacity());
	}

	private static int toInt(double color) {
		return (int) Math.round(color * 255);
	}

	@Override
	public ObservableValue<Color> getValue() {
		return this.colorPicker.valueProperty();
	}
	
	protected final ColorPicker getColorPicker() {
		return this.colorPicker;
	}

}
