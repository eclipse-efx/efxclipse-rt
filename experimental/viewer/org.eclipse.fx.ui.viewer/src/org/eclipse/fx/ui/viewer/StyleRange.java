/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;

public class StyleRange {
	public final int from;
	public final int to;
	public final String styleClass;
	
	public StyleRange(int from, int to, String styleClass) {
		this.from = from;
		this.to = to;
		this.styleClass = styleClass;
	}
}
