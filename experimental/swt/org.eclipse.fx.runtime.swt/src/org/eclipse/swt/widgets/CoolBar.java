package org.eclipse.swt.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.internal.Util;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class CoolBar extends Composite {

	private Pane pane;
	
	static final int ROW_SPACING = 2;
	
	private List<CoolItem> items = new ArrayList<CoolItem>();
	
	public CoolBar(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected Pane createWidget() {
		pane = new FlowPane(0,2);
		return pane;
	}
	
//	@Override
//	public Point computeSize(int wHint, int hHint, boolean flushCache) {
//		return super.computeSize(wHint, hHint, flushCache);
//	}
	
	@Override
	public Pane internal_getNativeObject() {
		return pane;
	}
	
	@Override
	protected void internal_attachControl(Control c) {
		pane.getChildren().add(new CoolBarItem(c));
//		c.internal_getNativeObject().setManaged(false);
//		c.internal_getNativeObject().setVisible(false);
	}
	
	@Override
	protected void internal_attachControl(int idx, Control c) {
		pane.getChildren().add(idx, new CoolBarItem(c));
//		c.internal_getNativeObject().setManaged(false);
//		c.internal_getNativeObject().setVisible(false);
	}
	
	@Override
	protected void internal_detachControl(Control c) {
		pane.getChildren().remove(c.internal_getNativeObject());
	}
	
	void internal_registerItem(CoolItem item) {
		items.add(item);
//		pane.getChildren().add(item.getChevronNode());
	}

	void internal_registerItem(CoolItem item, int index) {
		items.add(index,item);
//		pane.getChildren().add(item.getChevronNode());
	}
	
	void internal_controlUpdated(CoolItem item) {
		int itemIdx = items.indexOf(item);
		int managedIndex = 0;
		CoolBarItem cItem = null;
		for( int i = 0; i < pane.getChildren().size(); i++ ) {
			CoolBarItem cbi = (CoolBarItem) pane.getChildren().get(i);
			if( cbi.control == item.getControl() ) {
				cItem = cbi;
				break;
			}
			if( cbi.isManaged() ) {
				managedIndex++;
			}
		}
		
		if( cItem != null ) {
			cItem.setCoolItem(item);
			if( itemIdx != managedIndex ) {
				System.err.println("DOES NOT MATCH");
			}
			
		}
	}
	
	void internal_unregisterItem(CoolItem item) {
		items.remove(item);
		if( item.getControl() != null ) {
//			item.getControl().internal_getNativeObject().setManaged(false);
//			item.getControl().internal_getNativeObject().setVisible(false);
		}
//		pane.getChildren().remove(item.getChevronNode());
	}
	
	public CoolItem getItem (int index) {
		return items.get(index);
	}
	
	public int getItemCount () {
		return items.size();
	}
	
	public CoolItem [] getItems () {
		return items.toArray(new CoolItem[0]);
	}
	
	public int indexOf (CoolItem item) {
		return items.indexOf(item);
	}
	
//	public int[] getItemOrder () {
//		
//	}
//	
//	public Point[] getItemSizes () {
//		
//	}
//	
	public boolean getLocked () {
		return false;
	}
	
	public int[] getWrapIndices () {
		Util.logNotImplemented();
		return new int[0];
	}
	
	public void setLocked (boolean locked) {
		Util.logNotImplemented();
	}
	
	public void setWrapIndices (int[] indices) {
		Util.logNotImplemented();
	}
//	
//	public void setCursor (Cursor cursor) {
//		
//	}
//	
//	public void setItemLayout (int[] itemOrder, int[] wrapIndices, Point[] sizes) {
//		
//	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
	private static class CoolBarItem extends HBox {
		private Control control;
		private CoolItem item;
		
		public CoolBarItem(Control control) {
			setManaged(false);
			setVisible(false);
			this.control = control;
			
			//FIXME We need to find a better L&F for the grabber
			StackPane r = new StackPane();
			r.setPadding(new Insets(0, 3, 0, 3));
			Line l = new Line(3,3,3,0);
			l.setStrokeWidth(2);
			l.getStrokeDashArray().addAll(3.0, 3.0);
			l.setStroke(Color.LIGHTGRAY);
			r.getChildren().add(l);
			r.setCursor(Cursor.HAND);
			Region region = (Region) control.internal_getNativeObject();
			getChildren().addAll(r, region);
			l.endYProperty().bind(region.heightProperty().subtract(6));
		}
		
		public void setCoolItem(CoolItem item) {
			setManaged(true);
			setVisible(true);
		}
	}
}
