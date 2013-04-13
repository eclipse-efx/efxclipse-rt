/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.panes;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class AbstractLayoutPane<D> extends Pane {
	public static final int FX_DEFAULT = -1;
	public static final int FX_BEGINNING = 1;
	public static final int FX_FILL = 4;
	public static final int FX_LEFT = 16384;
	public static final int FX_END = 16777224;
	public static final int FX_RIGHT = 131072;
	public static final int FX_CENTER = 16777216;
	public static final int FX_BOTTOM = 1024;
	public static final int FX_TOP = 128;
	public static final int FX_HORIZONTAL = 256;
	
	static class Size {
		public final double width;
		public final double height;
		
		public Size(double width, double height) {
			this.width = width;
			this.height = height;
		}
	}
	
	protected abstract Size computeSize(double width, double height, boolean flushCache);
	
	protected static void setConstraint(Node node, Object key, Object value) {
        if (value == null) {
            node.getProperties().remove(key);
        } else {
            node.getProperties().put(key, value);
        }
        if (node.getParent() != null) {
            node.getParent().requestLayout();
        }
    }

	protected static Object getConstraint(Node node, Object key) {
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
