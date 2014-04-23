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

import org.eclipse.swt.SWT;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Pane;


class FXLayoutPane extends Pane {
	private SimpleObjectProperty<Layout> layoutProperty = new SimpleObjectProperty<Layout>();
	private Composite composite;
	
	public FXLayoutPane(Composite composite) {
		this.composite = composite;
	}
	
	public void setLayout(Layout layout) {
		layoutProperty.set(layout);
	}
	
	public Layout getLayout() {
		return layoutProperty().get();
	}
	
	public ObjectProperty<Layout> layoutProperty() {
		return layoutProperty;
	}
	
	@Override 
	protected double computeMinWidth(double height) {
		if( layoutProperty.get() != null ) {
			return layoutProperty.get().computeSize(composite, 0, 0, true).x;
		}
		return super.computeMinWidth(height);
	}
	
	@Override
	protected double computeMinHeight(double width) {
		if( layoutProperty.get() != null ) {
			return layoutProperty.get().computeSize(composite, 0, 0, true).y;
		}
		return super.computeMinHeight(width);
	}
	
	@Override
	protected double computeMaxHeight(double width) {
		if( layoutProperty.get() != null ) {
			return layoutProperty.get().computeSize(composite, Integer.MAX_VALUE, Integer.MAX_VALUE, true).y;
		}
		return super.computeMaxHeight(width);
	}
	
	@Override
	protected double computeMaxWidth(double height) {
		if( layoutProperty.get() != null ) {
			return layoutProperty.get().computeSize(composite, Integer.MAX_VALUE, Integer.MAX_VALUE, true).x;
		}
		return super.computeMaxWidth(height);
	}
	
	@Override
	protected double computePrefHeight(double width) {
		if( layoutProperty.get() != null ) {
			return layoutProperty.get().computeSize(composite, SWT.DEFAULT, SWT.DEFAULT, true).y;
		}
		return super.computePrefHeight(width);
	}
	
	@Override
	protected double computePrefWidth(double height) {
		if( layoutProperty.get() != null ) {
			return layoutProperty.get().computeSize(composite, SWT.DEFAULT, SWT.DEFAULT, true).x;
		}
		return super.computePrefWidth(height);
	}
	
	@Override
	protected void layoutChildren() {
		if( layoutProperty.get() != null ) {
			layoutProperty.get().layout(composite, true);
		} else {
			//Do not call super else nodes resized absolutely are
			//are resized to their minimal value			
		}
	}
}
