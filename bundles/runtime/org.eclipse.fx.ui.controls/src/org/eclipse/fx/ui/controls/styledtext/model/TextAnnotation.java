package org.eclipse.fx.ui.controls.styledtext.model;

import com.google.common.collect.Range;

public interface TextAnnotation extends Annotation {
	Range<Integer> getRange();
}