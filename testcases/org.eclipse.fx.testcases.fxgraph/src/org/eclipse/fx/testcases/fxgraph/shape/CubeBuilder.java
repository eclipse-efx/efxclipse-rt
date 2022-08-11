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
package org.eclipse.fx.testcases.fxgraph.shape;

import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.paint.Color;

public class CubeBuilder<B extends GroupBuilder<B>> extends GroupBuilder<B> {
	private Color color = Color.GREEN;
	private double size;
	private double shade;
	
	@SuppressWarnings("unchecked")
	public B color(Color color) {
		this.color = color;
		return (B) this;
	}
	
	@SuppressWarnings("unchecked")
	public B size(double size) {
		this.size = size;
		return (B) this;
	}
	
	@SuppressWarnings("unchecked")
	public B shade(double shade) {
		this.shade = shade;
		return (B) this;
	}
	
	@Override
	public Group build() {
		Cube c = new Cube(size, color, shade);
		applyTo(c);
		return c;
	}
	
	@SuppressWarnings("rawtypes")
	public static CubeBuilder<?> create() {
		return new CubeBuilder();
	}
}
