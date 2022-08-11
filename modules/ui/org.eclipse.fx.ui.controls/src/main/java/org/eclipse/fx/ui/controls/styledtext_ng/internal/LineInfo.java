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
package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import javafx.scene.paint.Color;

class LineInfo {
	int flags;
	Color background;
	int alignment;
	int indent;
	int wrapIndent;
	boolean justify;
	int[] segments;
	char[] segmentsChars;
	int[] tabStops;

	public LineInfo() {
	}

	public LineInfo(LineInfo info) {
		if (info != null) {
			this.flags = info.flags;
			this.background = info.background;
			this.alignment = info.alignment;
			this.indent = info.indent;
			this.wrapIndent = info.wrapIndent;
			this.justify = info.justify;
			this.segments = info.segments;
			this.segmentsChars = info.segmentsChars;
			this.tabStops = info.tabStops;
		}
	}
}