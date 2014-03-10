package org.eclipse.swt.widgets;

public class Dialog {
	private Shell parent;
	private int style;
	private String title;
	
	public Dialog (Shell parent) {
		this.parent = parent;
	}
	
	public Dialog (Shell parent, int style) {
		this.parent = parent;
		this.style = style;
	}
	
	public Shell getParent () {
		return parent;
	}
	
	public int getStyle () {
		return style;
	}
	
	public String getText () {
		return title;
	}
	
	public void setText (String string) {
		this.title = string;
	}
}
