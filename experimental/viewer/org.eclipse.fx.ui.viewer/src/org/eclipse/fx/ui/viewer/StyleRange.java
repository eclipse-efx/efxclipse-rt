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
