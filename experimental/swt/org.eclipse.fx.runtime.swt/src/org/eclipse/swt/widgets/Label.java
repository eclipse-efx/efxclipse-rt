package org.eclipse.swt.widgets;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device.NoOpDrawableGC;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.Util;

public class Label extends Control {
	private javafx.scene.control.Label control;
	private Separator separator;
	private Image image;
	
	public Label(Composite parent, int style) {
		super(parent,style);
	}

	@Override
	protected Node createWidget() {
		if( (style & SWT.SEPARATOR) != 0 ) {
			separator = new Separator();
			separator.setOrientation((style & SWT.VERTICAL) == SWT.VERTICAL ? Orientation.VERTICAL : Orientation.HORIZONTAL);
			return separator;
		} else {
			control = new javafx.scene.control.Label();
			control.setWrapText((style & SWT.WRAP) == SWT.WRAP);
			return control;
		}
	}
	
	public Point computeSize(int wHint, int hHint, boolean flushCache) {
		checkWidget ();
		forceSizeProcessing();
		int width = (int) internal_getNativeObject().prefWidth(javafx.scene.control.Control.USE_COMPUTED_SIZE);
		int height = (int) internal_getNativeObject().prefHeight(javafx.scene.control.Control.USE_COMPUTED_SIZE);

		if (wHint != SWT.DEFAULT)
			width = wHint;
		if (hHint != SWT.DEFAULT)
			height = hHint;

		Point p = new Point(width, height);
		return p;
	}

	@Override
	public Region internal_getNativeObject() {
		return control == null ? separator : control;
	}

	public int getAlignment () {
		checkWidget ();
		if ((style & SWT.SEPARATOR) != 0) return 0;
		if ((style & SWT.LEFT) != 0) return SWT.LEFT;
		if ((style & SWT.CENTER) != 0) return SWT.CENTER;
		if ((style & SWT.RIGHT) != 0) return SWT.RIGHT;
		return SWT.LEFT;
	}
	
	public String getText () {
		checkWidget ();
		if ((style & SWT.SEPARATOR) != 0) return "";
		return notNullString(control.getText());
	}
	
	public void setAlignment (int alignment) {
		checkWidget ();
		if ((style & SWT.SEPARATOR) != 0) return;
		if ((alignment & (SWT.LEFT | SWT.RIGHT | SWT.CENTER)) == 0) return;
		style &= ~(SWT.LEFT | SWT.RIGHT | SWT.CENTER);
		style |= alignment & (SWT.LEFT | SWT.RIGHT | SWT.CENTER);
		
		Pos p;
		switch (alignment) {
		case SWT.RIGHT:
			p = Pos.CENTER_RIGHT;
			break;
		case SWT.CENTER:
			p = Pos.CENTER;
			break;
		default:
			p = Pos.CENTER_LEFT;
			break;
		}
		control.setAlignment(p);
	}
	
	public void setText (String string) {
		checkWidget ();
		if (string == null) error (SWT.ERROR_NULL_ARGUMENT);
		if ((style & SWT.SEPARATOR) != 0) return;
		control.setText(string);
	}
	
	public Image getImage () {
		return image;
	}
	
	public void setImage (Image image) {
		if ((style & SWT.SEPARATOR) != 0) return;
		control.setGraphic(image == null ? null : new ImageView(image.internal_getImage()));
	}
	
	@Override
	protected Font getDefaultFont() {
		if( control.getFont() != null ) {
			return new Font(getDisplay(), control.getFont());	
		}
		return super.getDefaultFont();
	}
	
	@Override
	public void internal_dispose_GC(DrawableGC gc) {
		
	}
	
	@Override
	public DrawableGC internal_new_GC() {
		return new NoOpDrawableGC(this,getFont());
	}
}
