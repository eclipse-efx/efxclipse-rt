package org.eclipse.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.internal.Util;

public class FontDialog extends Dialog {

	public FontDialog(Shell parent) {
		super(parent, SWT.APPLICATION_MODAL);
	}

	public FontDialog(Shell parent,int style) {
		super(parent, style);
	}
	
	public boolean getEffectsVisible () {
		Util.logNotImplemented();
		return false;
	}
	
	public FontData getFontData () {
		Util.logNotImplemented();
		return null;
	}
	
	public FontData [] getFontList () {
		Util.logNotImplemented();
		return null;
	}
	
	public RGB getRGB () {
		Util.logNotImplemented();
		return null;
	}
	
	public FontData open () {
		Util.logNotImplemented();
		return null;
	}
	
	public void setEffectsVisible(boolean visible) {
		Util.logNotImplemented();
	}
	
	public void setFontData (FontData fontData) {
		Util.logNotImplemented();
	}
	
	public void setFontList (FontData [] fontData) {
		Util.logNotImplemented();
	}
	
	public void setRGB (RGB rgb) {
		Util.logNotImplemented();
	}
}
