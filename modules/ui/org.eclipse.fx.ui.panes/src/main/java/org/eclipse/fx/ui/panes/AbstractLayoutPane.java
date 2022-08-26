/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.panes;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Abstract layout pane
 * 
 * @param <D>
 *            the constraint
 */
public abstract class AbstractLayoutPane<D> extends Pane {
	/**
	 * default
	 */
	public static final int FX_DEFAULT = -1;

	static class Size {
		public final double width;
		public final double height;

		public Size(double width, double height) {
			this.width = width;
			this.height = height;
		}
	}

	/**
	 * Compute the size
	 * 
	 * @param width
	 *            the available width
	 * @param height
	 *            the available height
	 * @param flushCache
	 *            flush cached informations
	 * @return the size
	 */
	protected abstract @NonNull Size computeSize(double width, double height, boolean flushCache);

	/**
	 * Remember a layout constraint
	 * 
	 * @param node
	 *            the node
	 * @param key
	 *            the constraint key
	 * @param value
	 *            the value
	 */
	protected static void setConstraint(@NonNull Node node, @NonNull Object key, @Nullable Object value) {
		if (value == null) {
			node.getProperties().remove(key);
		} else {
			node.getProperties().put(key, value);
		}
		if (node.getParent() != null) {
			node.getParent().requestLayout();
		}
	}

	/**
	 * Access the current constraint value
	 * 
	 * @param node
	 *            the node
	 * @param key
	 *            the key
	 * @return the value if associated
	 */
	protected static @Nullable Object getConstraint(@NonNull Node node, @NonNull Object key) {
		if (node.hasProperties()) {
			Object value = node.getProperties().get(key);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	@Override
	protected double computeMinHeight(double width) {
		return 0;
	}

	@Override
	protected double computeMinWidth(double height) {
		return 0;
	}

	@Override
	protected double computePrefHeight(double width) {
		return computeSize(FX_DEFAULT, FX_DEFAULT, true).height;
	}

	@Override
	protected double computePrefWidth(double height) {
		return computeSize(FX_DEFAULT, FX_DEFAULT, true).width;
	}
}
