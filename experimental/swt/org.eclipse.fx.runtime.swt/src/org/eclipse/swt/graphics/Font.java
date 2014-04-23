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

import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import org.eclipse.swt.SWT;

public class Font extends Resource {
	private javafx.scene.text.Font font;
	private FontData fd;
	
	public Font(Device device, FontData fd) {
		this(device, fd.getName(), fd.getHeightD(), fd.getStyle(), fd.getFXName());
	}
	
	public Font(Device device, FontData[] fd) {
		this(device,fd[0]);
	}
	
	public Font(Device device, String name, int height, int style) {
		this(device,name,height,style,null);
	}
	
	Font(Device device, String name, double height, int style, String fxName) {
		this(device, createFont(name, height, style, fxName));
		fd = new FontData();
		fd.setName(name);
		fd.setHeight(height);
		fd.setStyle(style);
		fd.setFXName(font.getName());
	}
	
	public javafx.scene.text.Font internal_getNativeObject() {
		return font;
	}

	private static javafx.scene.text.Font createFont(String name, double height, int style, String fxName) {
		if( fxName != null ) {
			return javafx.scene.text.Font.font(fxName, height);
		} else {
			return javafx.scene.text.Font.font(name, 
					(style & SWT.BOLD) == SWT.BOLD ? FontWeight.BOLD : FontWeight.NORMAL, 
							(style & SWT.ITALIC) == SWT.ITALIC ? FontPosture.ITALIC : FontPosture.REGULAR, height);
		}
	}
	
	public Font(Device device, javafx.scene.text.Font font) {
		super(device);
		this.font = font;
		fd = new FontData();
		fd.setName(font.getFamily());
		fd.setHeight(font.getSize());
		fd.setStyle(getStyle(font.getName()));
		fd.setFXName(font.getName());
	}
	
	private static int getStyle(String name) {
		int style = SWT.NORMAL;
		name = name.toLowerCase();
		if( name.contains("bold") ) {
			style |= SWT.BOLD;
		}
		if( name.contains("italic") || name.contains("obilique") ) {
			style |= SWT.ITALIC;
		}
		return style;
	}
	
	
	public FontData[] getFontData() {
		return new FontData[] { fd };
	}
	
	@Override
	public void dispose() {
		font = null;
	}

	@Override
	public boolean isDisposed() {
		return font == null;
	}

	public String internal_getAsCSSString() {
		StringBuffer b = new StringBuffer("-fx-font-family: " + fd.getName() + "; -fx-font-size: " + fd.getHeight() +";");
		if( (fd.getStyle() & SWT.ITALIC) == SWT.ITALIC ) {
			b.append("-fx-font-style: italic;" );
		}
		if( (fd.getStyle() & SWT.BOLD) == SWT.BOLD ) {
			b.append("-fx-font-weight: bold;" );
		}
		return b.toString();
	}

}
