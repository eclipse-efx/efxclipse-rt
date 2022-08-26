/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer.javafx.impl;

import java.util.AbstractList;

import org.eclipse.fx.ui.viewer.ContentProvider;

import javafx.beans.property.Property;

class LazyList<I, O> extends AbstractList<O> {
	private final Property<? extends ContentProvider<I, O>> prop;
	
	public LazyList(final Property<? extends ContentProvider<I, O>> prop) {
		this.prop = prop;
	}
	
	@Override
	public O get(int index) {
		return prop.getValue().getRootElement(index);
	}

	@Override
	public int size() {
		return prop.getValue().getSize();
	}

}