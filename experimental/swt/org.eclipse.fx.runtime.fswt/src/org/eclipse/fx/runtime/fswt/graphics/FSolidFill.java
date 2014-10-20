/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.runtime.fswt.graphics;

public final class FSolidFill implements FFill {
	public final int red;
	public final int green;
	public final int blue;
	public final double opacity;

	public FSolidFill(int red, int green, int blue, double opacity) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.opacity = opacity;
	}
}
