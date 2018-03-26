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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * <p>A Field editor for color preferences.</p>
 */
public class ColorFieldEditor extends FieldEditor {

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
	void load() {
		String color = getMemento().get(getName(), "0;0;0;1");
		this.colorPicker.setValue(parseColor(color));
	}

	/** RGBA Format: 255;255;255;1.0 */
	private static Pattern colorRegex = Pattern.compile("(\\d{1,3});(\\d{1,3});(\\d{1,3});(\\d(\\.\\d+)?)");
	
	private Color parseColor(String color) {
		Matcher matcher = colorRegex.matcher(color);
		if (matcher.matches()) {
			String red = matcher.group(1);
			String green = matcher.group(2);
			String blue = matcher.group(3);
			String alpha = matcher.group(4);
			try {
				int r = Integer.parseInt(red);
				int g = Integer.parseInt(green);
				int b = Integer.parseInt(blue);
				double a = Double.parseDouble(alpha);
				return new Color(toDouble(r), toDouble(g), toDouble(b), a); //Will throw if the values are out of range
			} catch (Exception ex) {
				ex.printStackTrace(); //TODO Log
				return Color.BLACK;
			}
		}
		return null;
	}

	private static double toDouble(int intColor) {
		return intColor/255.;
	}

	@Override
	void persist() {
		Color color = this.colorPicker.getValue();
		getMemento().put(getName(), toString(color));
	}
	
	private static String toString(Color color) {
		return String.format("%s;%s;%s;%s", toInt(color.getRed()), toInt(color.getGreen()), toInt(color.getBlue()), color.getOpacity());
	}

	private static int toInt(double color) {
		return (int)Math.round(color*255);
	}
	
	

}
