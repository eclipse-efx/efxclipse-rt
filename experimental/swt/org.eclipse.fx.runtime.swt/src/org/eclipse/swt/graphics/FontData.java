/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.graphics;

import org.eclipse.swt.SWT;

public class FontData {
	private String name;
	private String fxName;
	private int style;
	private double height;
	private String lang;
	private String  country;
	private String variant;
	
	public FontData () {
		this("",12,SWT.NORMAL);
	}
	
	public FontData(String string) {
		if (string == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		int start = 0;
		int end = string.indexOf('|');
		if (end == -1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		String version1 = string.substring(start, end);
		try {
			if (Integer.parseInt(version1) != 1) SWT.error(SWT.ERROR_INVALID_ARGUMENT); 
		} catch (NumberFormatException e) {
			SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		}
		
		start = end + 1;
		end = string.indexOf('|', start);
		if (end == -1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		String name = string.substring(start, end);
		
		start = end + 1;
		end = string.indexOf('|', start);
		if (end == -1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		double height = 0;
		try {
			height = Double.parseDouble(string.substring(start, end));
		} catch (NumberFormatException e) {
			SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		}
		
		start = end + 1;
		end = string.indexOf('|', start);
		if (end == -1) SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		int style = 0;
		try {
			style = Integer.parseInt(string.substring(start, end));
		} catch (NumberFormatException e) {
			SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		}

		start = end + 1;
		end = string.indexOf('|', start);
		setName(name);
		setHeight(height);
		setStyle(style);
		if (end == -1) return;
		String platform = string.substring(start, end);

		start = end + 1;
		end = string.indexOf('|', start);
		if (end == -1) return;
		String version2 = string.substring(start, end);

		if (platform.equals("COCOA") && version2.equals("1")) {
			start = end + 1;
			end = string.length();
			if (start < end) fxName = string.substring(start, end);
		}
	}
	
	public FontData(String name, int height, int style) {
		this.name = name;
		this.height = height;
		this.style = style;
		fxName = null;
	}
	
	public int getHeight() {
		return (int) height;
	}
	
	double getHeightD() {
		return height;
	}
	
	void setHeight(double height) {
		this.height = height;
	}
	
	public String getLocale () {
		StringBuilder buffer = new StringBuilder ();
		char sep = '_';
		if (lang != null) {
			buffer.append (lang);
			buffer.append (sep);
		}
		if (country != null) {
			buffer.append (country);
			buffer.append (sep);
		}
		if (variant != null) {
			buffer.append (variant);
		}
		
		String result = buffer.toString ();
		int length = result.length ();
		if (length > 0) {
			if (result.charAt (length - 1) == sep) {
				result = result.substring (0, length - 1);
			}
		} 
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStyle() {
		return style;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setLocale(String locale) {
		lang = country = variant = null;
		if (locale != null) {
			char sep = '_';
			int length = locale.length();
			int firstSep, secondSep;
			
			firstSep = locale.indexOf(sep);
			if (firstSep == -1) {
				firstSep = secondSep = length;
			} else {
				secondSep = locale.indexOf(sep, firstSep + 1);
				if (secondSep == -1) secondSep = length;
			}
			if (firstSep > 0) lang = locale.substring(0, firstSep);
			if (secondSep > firstSep + 1) country = locale.substring(firstSep + 1, secondSep);
			if (length > secondSep + 1) variant = locale.substring(secondSep + 1);
		}
	}
	
	public void setName(String name) {
		this.name = name;
		fxName = null;
	}
	
	public void setStyle(int style) {
		this.style = style;
		fxName = null;
	}
	
	String getFXName() {
		return fxName;
	}
	
	void setFXName(String name) {
		this.fxName = name;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder(128);
		buffer.append("1|");
		buffer.append(getName());
		buffer.append("|");
		buffer.append(getHeightD());
		buffer.append("|");
		buffer.append(getStyle());
		buffer.append("|");
		buffer.append("FX|1|");
		if (fxName != null) buffer.append(fxName);
		return buffer.toString();
	}
}
