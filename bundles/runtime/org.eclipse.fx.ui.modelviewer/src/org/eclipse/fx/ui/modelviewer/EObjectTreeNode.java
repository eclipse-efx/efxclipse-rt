/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.modelviewer;

import java.text.MessageFormat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.e4.ui.model.application.MApplicationElement;

public class EObjectTreeNode implements TreeNode {
	private MApplicationElement object;
	
	private SimpleStringProperty label = new SimpleStringProperty();
	private SimpleStringProperty iconStyleclass = new SimpleStringProperty();
	private IObservableValue[] values;
	
	public EObjectTreeNode(MApplicationElement object, String label) {
		this.object = object;
		this.label.set(label); 
	}
	
	public EObjectTreeNode(MApplicationElement object, String labelTemplate, IValueProperty... labelProperties) {
		this.object = object;
		values = new IObservableValue[labelProperties.length];
		for( int i = 0; i < labelProperties.length; i++ ) {
			values[i] = labelProperties[i].observe(object);
			values[i].addChangeListener(new IChangeListener() {
				
				@Override
				public void handleChange(ChangeEvent event) {
					labelProperty().set(calculateLabel(labelTemplate, object, labelProperties));
				}
			});
		}
		this.label.set(calculateLabel(labelTemplate, object, labelProperties));
	}
	
	private static String calculateLabel(String template, MApplicationElement object, IValueProperty... labelProperties) {
		Object[] args = new Object[labelProperties.length];
		for( int i = 0; i < labelProperties.length; i++ ) {
			args[i] = labelProperties[i].getValue(object);
		}
		return MessageFormat.format(template, args);
	}
	
	public MApplicationElement getObject() {
		return object;
	}
	
	@Override
	public StringProperty labelProperty() {
		return label;
	}

	@Override
	public StringProperty iconStyleclassProperty() {
		return iconStyleclass;
	}

}
