/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
