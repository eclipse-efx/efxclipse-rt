package org.eclipse.swt.widgets;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;

public class Link extends Control {
	private String text;

	public Link(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public DrawableGC internal_new_GC() {
		return new Device.NoOpDrawableGC(this, getFont());
	}

	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}

	@Override
	public Region internal_getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object createWidget() {
		StackPane p = new StackPane();
		TextFlow flow = new TextFlow();
		p.getChildren().add(flow);
		return p;
	}
	
	public void addSelectionListener (SelectionListener listener) {
		
	}
	
	public String getText () {
		return text;
	}

	public void removeSelectionListener (SelectionListener listener) {
		
	}
	
	public void setText (String string) {
//		while( string.indexOf("<a") != -1 ) {
//			int start = string.indexOf("<a");
//			int end = string.indexOf('>', start);
//			String linkBegin = string.substring(start, end);
//			linkBegin.substring(linkBegin.indexOf('"'), linkBegin.lastIndexOf('"'));
//		}
	}
}
