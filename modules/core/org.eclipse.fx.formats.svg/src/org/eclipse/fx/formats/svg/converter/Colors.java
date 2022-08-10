/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.formats.svg.converter;

/**
 * Colors
 */
public enum Colors {
	/**
	 * white
	 */
	WHITE("#ffffff"), //$NON-NLS-1$
	/**
	 * black
	 */
	BLACK("#000000"); //$NON-NLS-1$

	/**
	 * the hex value
	 */
	public final String hexvalue;
	/**
	 * rgb red
	 */
	public final double red;
	/**
	 * rgb green
	 */
	public final double green;
	/**
	 * rgb blue
	 */
	public final double blue;

	private Colors(String hex) {
		this.hexvalue = hex;
		this.red = hexRed(hex);
		this.green = hexGreen(hex);
		this.blue = hexBlue(hex);
	}

	/**
	 * Red part of the hex
	 * 
	 * @param color
	 *            the color
	 * @return the value
	 */
	public static double hexRed(String color) {
		if (color.length() == 4) {
			return Integer.parseInt(color.substring(1, 2) + color.substring(1, 2), 16) / 255.0;
		}
		return Integer.parseInt(color.substring(1, 3), 16) / 255.0;
	}

	/**
	 * Green part of the hex
	 * 
	 * @param color
	 *            the color
	 * @return the value
	 */
	public static double hexGreen(String color) {
		if (color.length() == 4) {
			return Integer.parseInt(color.substring(2, 3) + color.substring(2, 3), 16) / 255.0;
		}
		return Integer.parseInt(color.substring(3, 5), 16) / 255.0;
	}

	/**
	 * Blue part of the hex
	 * 
	 * @param color
	 *            the color
	 * @return the value
	 */
	public static double hexBlue(String color) {
		if (color.length() == 4) {
			return Integer.parseInt(color.substring(3, 4) + color.substring(3, 4), 16) / 255.0;
		}
		return Integer.parseInt(color.substring(5, 7), 16) / 255.0;
	}

	/**
	 * Find the color by the hex value
	 * 
	 * @param hex
	 *            the hex value
	 * @return the color
	 */
	public static Colors findColorByHex(String hex) {
		for (Colors c : values()) {
			if (c.hexvalue.equals(hex)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Find the color by name
	 * 
	 * @param name
	 *            the name
	 * @return the color
	 */
	public static Colors findColorByName(String name) {
		for (Colors c : values()) {
			if (c.name().toUpperCase().equals(name.toUpperCase())) {
				return c;
			}
		}
		return null;
	}
}
