package org.eclipse.swt.dnd;

import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public class DragSource extends Widget {
	private Transfer[] transfers;
	private Control control;

	public DragSource(Control control, int style) {
		super(control.getDisplay(), style);
		this.control = control;
	}

	@Override
	protected Object createWidget() {
		Util.logNotImplemented();
		return this;
	}

	@Override
	public Object internal_getNativeObject() {
		Util.logNotImplemented();
		return this;
	}

	public void addDragListener(DragSourceListener listener) {
		DNDListener typedListener = new DNDListener (listener);
		typedListener.dndWidget = this;
		addListener (DND.DragStart, typedListener);
		addListener (DND.DragSetData, typedListener);
		addListener (DND.DragEnd, typedListener);
	}
	
	public Control getControl () {
		return control;
	}
//	
//	public DragSourceListener[] getDragListeners() {
//		
//	}
//	
	public DragSourceEffect getDragSourceEffect() {
		Util.logNotImplemented();
		return null;
	}
	
	public Transfer[] getTransfer(){
		return transfers;
	}
	
	public void removeDragListener(DragSourceListener listener) {
		removeListener (DND.DragStart, listener);
		removeListener (DND.DragSetData, listener);
		removeListener (DND.DragEnd, listener);		
	}
	public void setDragSourceEffect(DragSourceEffect effect) {
		Util.logNotImplemented();
	}
	
	public void setTransfer(Transfer[] transferAgents){
		this.transfers = transferAgents;
	}
}
