/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

@SuppressWarnings("javadoc")
public class Row {
	public BooleanProperty selected = new SimpleBooleanProperty(this, "selected", true); //$NON-NLS-1$
	public ObjectProperty<MPart> element = new SimpleObjectProperty<MPart>(this, "element"); //$NON-NLS-1$

	public Row(MPart element) {
		this.element.set(element);
	}

	public boolean isSelected() {
		return this.selected.get();
	}

	public void setSelected(boolean value) {
		this.selected.set(value);
	}

	public BooleanProperty selectedProperty() {
		return this.selected;
	}

	public MPart getElement() {
		return this.element.get();
	}

	public void setElement(MPart value) {
		this.element.set(value);
	}

	public ObjectProperty<MPart> elementProperty() {
		return this.element;
	}
}