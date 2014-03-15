/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import javafx.beans.property.Property;

/**
 * @param <O>
 */
public abstract class ControlPropertyValueProperty<O> extends ControlReadOnlyPropertyValueProperty<O> {
	@Override
	protected abstract Property<O> getProperty(Object source);
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doSetValue(Object source, Object value) {
		Property<O> p = getProperty(source);
		p.setValue((O) value);
	}
	
}
