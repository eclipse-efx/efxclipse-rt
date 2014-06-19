package org.eclipse.fx.code.compensator.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StyledString {
	private StringBuffer value;
	private List<StyleRange> styleRange;
	
	public StyledString(String initial, StyleRange... styles) {
		this.value = new StringBuffer(initial);
		styleRange = new ArrayList<>(Arrays.asList(styles));
	}
	
	public void append(String value, StyleRange... styles) {
		this.value.append(value);
		styleRange.addAll(Arrays.asList(styles));
	}
	
	public String getString() {
		return value.toString();
	}
	
	public List<StyleRange> getStyleRanges() {
		return Collections.unmodifiableList(styleRange);
	}
	
	public static class StyleRange {
		public final int start;
		public final int end;
		public final String style;
		
		public StyleRange(int start, int end, String style) {
			this.start = start;
			this.end = end;
			this.style = style;
		}
	}
}
