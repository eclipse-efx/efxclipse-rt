package org.eclipse.swt.widgets;

import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.Util;

public class TrayItem extends Item {
	private Tray parent;
	
	public TrayItem(Tray parent, int style) {
		super(parent, style);
		this.parent = parent;
	}

	public void addMenuDetectListener (MenuDetectListener listener) {
		Util.logNotImplemented();
	}
	
	public void addSelectionListener(SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public Image getHighlightImage () {
		Util.logNotImplemented();
		return null;
	}
	
	public Tray getParent () {
		return parent;
	}
	
	public ToolTip getToolTip () {
		Util.logNotImplemented();
		return null;
	}
	
	public String getToolTipText () {
		Util.logNotImplemented();
		return null;
	}
	
	public boolean getVisible () {
		Util.logNotImplemented();
		return true;
	}
	
	public void removeMenuDetectListener (MenuDetectListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeSelectionListener (SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public void setImage (Image image) {
		Util.logNotImplemented();
	}
	
	public void setHighlightImage (Image image) {
		Util.logNotImplemented();
	}
	
	public void setToolTip (ToolTip toolTip) {
		Util.logNotImplemented();
	}
	
	public void setToolTipText (String string) {
		Util.logNotImplemented();
	}
	
	public void setVisible (boolean visible) {
		Util.logNotImplemented();
	}
}