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

import org.eclipse.core.databinding.observable.list.IObservableList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VirtualTreeNode implements TreeNode {
	private SimpleStringProperty label = new SimpleStringProperty();
	private SimpleStringProperty iconStyleclass = new SimpleStringProperty();
	private IObservableList children;
	
	public VirtualTreeNode(String label, IObservableList children) {
		this.label.set(label);
		this.children = children;
	}
	
	@Override
	public StringProperty labelProperty() {
		return label;
	}

	@Override
	public StringProperty iconStyleclassProperty() {
		return this.iconStyleclass;
	}

	public IObservableList getChildren() {
		return children;
	}
}
