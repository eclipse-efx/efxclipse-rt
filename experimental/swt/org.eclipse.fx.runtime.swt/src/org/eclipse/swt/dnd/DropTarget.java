package org.eclipse.swt.dnd;

import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

public class DropTarget extends Widget {
	private Transfer[] transfers;
	private Control control;
	
	public DropTarget(Control control, int style) {
		super(control.getDisplay(), style);
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

	public void addDropListener(DropTargetListener listener) {
		DNDListener typedListener = new DNDListener (listener);
		typedListener.dndWidget = this;
		addListener (DND.DragEnter, typedListener);
		addListener (DND.DragLeave, typedListener);
		addListener (DND.DragOver, typedListener);
		addListener (DND.DragOperationChanged, typedListener);
		addListener (DND.Drop, typedListener);
		addListener (DND.DropAccept, typedListener);
	}
	
	public Control getControl () {
		return control;
	}

//	public DropTargetListener[] getDropListeners() {
//		
//	}
	
	public DropTargetEffect getDropTargetEffect() {
		Util.logNotImplemented();
		return null;
	}
	
	public Transfer[] getTransfer() {
		return transfers;
	}
	
	public void removeDropListener(DropTargetListener listener) {
		removeListener (DND.DragEnter, listener);
		removeListener (DND.DragLeave, listener);
		removeListener (DND.DragOver, listener);
		removeListener (DND.DragOperationChanged, listener);
		removeListener (DND.Drop, listener);
		removeListener (DND.DropAccept, listener);
	}
	
	public void setTransfer(Transfer[] transferAgents){
		this.transfers = transferAgents;
	}
}
