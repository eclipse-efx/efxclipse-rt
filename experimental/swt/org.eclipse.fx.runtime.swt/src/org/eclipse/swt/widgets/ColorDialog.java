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
package org.eclipse.swt.widgets;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.internal.Util;

import com.sun.javafx.tk.Toolkit;

public class ColorDialog extends Dialog {
	private RGB rgb;
	private ColorPicker picker;
	
	public ColorDialog(Shell parent) {
		this(parent, SWT.APPLICATION_MODAL);
	}

	public ColorDialog(Shell parent, int style) {
		super(parent,style);
	}
	
	public RGB getRGB() {
		return rgb;
	}
	
	public RGB[] getRGBs() {
		Util.logNotImplemented();
		return null;
	}
	
	@SuppressWarnings("restriction")
	public RGB open() {	
		final AtomicReference<RGB> rv = new AtomicReference<>();
		final com.sun.javafx.scene.control.skin.CustomColorDialog d = new com.sun.javafx.scene.control.skin.CustomColorDialog(getParent().internal_getWindow());
		if( rgb != null ) {
			d.setCurrentColor(Color.rgb(rgb.red, rgb.green, rgb.blue));
		}
		d.show();
		
		Stage stage = reflective_getStage(d);
		stage.setOnHidden(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				Toolkit.getToolkit().exitNestedEventLoop(d, null);
			}
		});
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				Color c = reflective_getCustomColor(d);
				rv.set(new RGB((int)(c.getRed()*255), (int)(c.getGreen()*255), (int)(c.getBlue()*255)));
			}
		};
		
		d.setOnSave(r);
		//TODO Remove Use-Button
		d.setOnUse(r); 
		Toolkit.getToolkit().enterNestedEventLoop(d);
		return rv.get();
	}
	
	private static Color reflective_getCustomColor(Object o) {
		try {
			Method m = o.getClass().getDeclaredMethod("getCustomColor");
			m.setAccessible(true);
			return (Color) m.invoke(o);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Stage reflective_getStage(Object o) {
		try {
			Field f = o.getClass().getDeclaredField("dialog");
			f.setAccessible(true);
			return (Stage) f.get(o);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setRGB(RGB rgb) {
		this.rgb = rgb;
	}
	
	public void setRGBs(RGB[] rgbs) {
		Util.logNotImplemented();
	}
}
