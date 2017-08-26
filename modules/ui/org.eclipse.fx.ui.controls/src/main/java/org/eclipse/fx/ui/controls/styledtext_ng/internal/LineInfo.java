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