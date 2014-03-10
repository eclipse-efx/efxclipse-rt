package org.eclipse.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Scrollable;

public class FillLayout extends Layout {
	public int type = SWT.HORIZONTAL;
	
 	public int marginWidth = 0;
 	
 	public int marginHeight = 0;
 	
	public int spacing = 0;

	public FillLayout() {
		
	}
	
	public FillLayout(int type) {
		this.type = type;
	}
	
	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		Control [] children = composite.getChildren ();
		int count = children.length;
		int maxWidth = 0, maxHeight = 0;
		for (int i=0; i<count; i++) {
			Control child = children [i];
			int w = wHint, h = hHint;
			if (count > 0) {
				if (type == SWT.HORIZONTAL && wHint != SWT.DEFAULT) {
					w = Math.max (0, (wHint - (count - 1) * spacing) / count);
				}
				if (type == SWT.VERTICAL && hHint != SWT.DEFAULT) {
					h = Math.max (0, (hHint - (count - 1) * spacing) / count);
				}
			}
			Point size = computeChildSize (child, w, h, flushCache);
			maxWidth = Math.max (maxWidth, size.x);
			maxHeight = Math.max (maxHeight, size.y);
		}
		int width = 0, height = 0;
		if (type == SWT.HORIZONTAL) {
			width = count * maxWidth;
			if (count != 0) width += (count - 1) * spacing;
			height = maxHeight;
		} else {
			width = maxWidth;
			height = count * maxHeight;
			if (count != 0) height += (count - 1) * spacing;
		}
		width += marginWidth * 2;
		height += marginHeight * 2;
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;
		return new Point (width, height);
	}
	
	Point computeChildSize (Control control, int wHint, int hHint, boolean flushCache) {
		FillData data = (FillData)control.getLayoutData ();
		if (data == null) {
			data = new FillData ();
			control.setLayoutData (data);
		}
		Point size = null;
		if (wHint == SWT.DEFAULT && hHint == SWT.DEFAULT) {
			size = data.computeSize (control, wHint, hHint, flushCache);
		} else {
			// TEMPORARY CODE
			int trimX, trimY;
			if (control instanceof Scrollable) {
				Rectangle rect = ((Scrollable) control).computeTrim (0, 0, 0, 0);
				trimX = rect.width;
				trimY = rect.height;
			} else {
				trimX = trimY = control.getBorderWidth () * 2;
			}
			int w = wHint == SWT.DEFAULT ? wHint : Math.max (0, wHint - trimX);
			int h = hHint == SWT.DEFAULT ? hHint : Math.max (0, hHint - trimY);
			size = data.computeSize (control, w, h, flushCache);
		}
		return size;
	}
	
	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Rectangle rect = composite.getClientArea ();
		System.err.println(rect);
		Control [] children = composite.getChildren ();
		int count = children.length;
		if (count == 0) return;
		int width = rect.width - marginWidth * 2;
		int height = rect.height - marginHeight * 2;
		if (type == SWT.HORIZONTAL) {
			width -= (count - 1) * spacing;
			int x = rect.x + marginWidth, extra = width % count;
			int y = rect.y + marginHeight, cellWidth = width / count;
			for (int i=0; i<count; i++) {
				Control child = children [i];
				int childWidth = cellWidth;
				if (i == 0) {
					childWidth += extra / 2;
				} else {
					if (i == count - 1) childWidth += (extra + 1) / 2;
				}
				child.setBounds (x, y, childWidth, height);
				x += childWidth + spacing;
			}
		} else {
			height -= (count - 1) * spacing;
			int x = rect.x + marginWidth, cellHeight = height / count;
			int y = rect.y + marginHeight, extra = height % count;
			for (int i=0; i<count; i++) {
				Control child = children [i];
				int childHeight = cellHeight;
				if (i == 0) {
					childHeight += extra / 2;
				} else {
					if (i == count - 1) childHeight += (extra + 1) / 2;
				}
				child.setBounds (x, y, width, childHeight);
				y += childHeight + spacing;
			}
		}
	}
}
