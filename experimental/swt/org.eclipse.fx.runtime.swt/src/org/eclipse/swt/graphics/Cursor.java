package org.eclipse.swt.graphics;

import javafx.scene.ImageCursor;

import org.eclipse.swt.SWT;

public class Cursor extends Resource {
	private javafx.scene.Cursor nativeObject;
	
	public Cursor(Device device, int style) {
		super(device);
		switch (style) {
		case SWT.CURSOR_HAND: 			nativeObject = javafx.scene.Cursor.HAND; break;
		case SWT.CURSOR_ARROW: 			nativeObject = javafx.scene.Cursor.DEFAULT; break; //TODO is this correct
		case SWT.CURSOR_WAIT: 			nativeObject = javafx.scene.Cursor.WAIT; break;
		case SWT.CURSOR_CROSS:	 		nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_APPSTARTING: 	nativeObject = javafx.scene.Cursor.DEFAULT; break;
		case SWT.CURSOR_HELP: 			nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_SIZEALL: 		nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_SIZENESW: 		nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_SIZEWE:			nativeObject = javafx.scene.Cursor.H_RESIZE; break;
		case SWT.CURSOR_SIZENWSE: 		nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_SIZENS: 		nativeObject = javafx.scene.Cursor.V_RESIZE; break;
		case SWT.CURSOR_SIZEN: 			nativeObject = javafx.scene.Cursor.N_RESIZE; break;
		case SWT.CURSOR_SIZES: 			nativeObject = javafx.scene.Cursor.S_RESIZE; break;
		case SWT.CURSOR_SIZEE: 			nativeObject = javafx.scene.Cursor.E_RESIZE; break;
		case SWT.CURSOR_SIZEW: 			nativeObject = javafx.scene.Cursor.W_RESIZE; break;
		case SWT.CURSOR_SIZENE: 		nativeObject = javafx.scene.Cursor.NE_RESIZE; break;
		case SWT.CURSOR_SIZESE: 		nativeObject = javafx.scene.Cursor.SE_RESIZE; break;
		case SWT.CURSOR_SIZESW: 		nativeObject = javafx.scene.Cursor.SW_RESIZE; break;
		case SWT.CURSOR_SIZENW: 		nativeObject = javafx.scene.Cursor.NW_RESIZE; break;
		case SWT.CURSOR_UPARROW: 		nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_IBEAM: 			nativeObject = javafx.scene.Cursor.CROSSHAIR; break;
		case SWT.CURSOR_NO: 			nativeObject = javafx.scene.Cursor.NONE; break;
		default:
			SWT.error(SWT.ERROR_INVALID_ARGUMENT);
		}
	}
	
	public Cursor(Device device, ImageData source, ImageData mask, int hotspotX, int hotspotY) {
		super(device);
		Image img = new Image(device, source, mask);
		nativeObject = new ImageCursor(img.internal_getImage(), hotspotX, hotspotY);
		img.dispose();
	}
	
	public Cursor(Device device, ImageData source, int hotspotX, int hotspotY) {
		super(device);
		Image img = new Image(device, source);
		nativeObject = new ImageCursor(img.internal_getImage(), hotspotX, hotspotY);
		img.dispose();
	}
	
	public javafx.scene.Cursor internal_getNativeObject() {
		return nativeObject;
	}

	@Override
	public void dispose() {
		nativeObject = null;
	}

	@Override
	public boolean isDisposed() {
		return nativeObject != null;
	}

}
