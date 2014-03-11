package org.eclipse.swt.custom;

import javafx.scene.layout.Region;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.TextStyle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class StyledText extends Canvas {
	private StyledTextArea nativeObject;
	
	public StyledText(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected Region createWidget() {
		nativeObject = new StyledTextArea();
		return nativeObject;
	}
	
	@Override
	public Region internal_getNativeObject() {
		return nativeObject;
	}

	public void setText(String string) {
		nativeObject.getContent().setText(string);
	}

	public void setStyleRange(StyleRange styleRange) {
		nativeObject.setStyleRange(toFXRange(styleRange));
	}

	public void setStyleRanges(int start, int length, int[] ranges, StyleRange[] styles) {
		nativeObject.setStyleRanges(start, length, ranges, toFXRanges(styles));
	}
	
	private static org.eclipse.fx.ui.controls.styledtext.StyleRange[] toFXRanges(StyleRange[] styles) {
		org.eclipse.fx.ui.controls.styledtext.StyleRange[] rv = new org.eclipse.fx.ui.controls.styledtext.StyleRange[styles.length];
		for( int i = 0; i < rv.length; i++ ) {
			rv[i] = toFXRange(styles[i]);
		}
		return rv;	
	}

	private static org.eclipse.fx.ui.controls.styledtext.StyleRange toFXRange(StyleRange swtRange) {
		TextStyle fxTextStyle = new TextStyle();
		fxTextStyle.background = swtRange.background != null ? swtRange.background.internal_getNativeObject() : null;
		fxTextStyle.borderColor = swtRange.borderColor != null ? swtRange.borderColor.internal_getNativeObject() : null;
		fxTextStyle.borderStyle = swtRange.borderStyle;
		fxTextStyle.data = swtRange.data;
		fxTextStyle.font = swtRange.font != null ? swtRange.font.internal_getNativeObject() : null;
		fxTextStyle.foreground = swtRange.foreground != null ? swtRange.foreground.internal_getNativeObject() : null;
		fxTextStyle.rise = swtRange.rise;
		fxTextStyle.strikeout = swtRange.strikeout;
		fxTextStyle.strikeoutColor = swtRange.strikeoutColor != null ? swtRange.strikeoutColor.internal_getNativeObject() : null;
		fxTextStyle.underline = swtRange.underline;
		fxTextStyle.underlineColor = swtRange.underlineColor != null ? swtRange.underlineColor.internal_getNativeObject() : null;
		fxTextStyle.underlineStyle = swtRange.underlineStyle;
		org.eclipse.fx.ui.controls.styledtext.StyleRange r = new org.eclipse.fx.ui.controls.styledtext.StyleRange(fxTextStyle);
		r.start = swtRange.start;
		r.length = swtRange.length;
		return r;
	}
}
