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