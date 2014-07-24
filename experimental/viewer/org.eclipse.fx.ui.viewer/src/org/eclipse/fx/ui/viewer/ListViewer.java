package org.eclipse.fx.ui.viewer;

import java.util.List;
import java.util.function.Function;

public interface ListViewer<O,I,C extends ContentProvider<O, I>> extends Viewer<O, I, C> {
	public ListViewer<O, I, C> styleProvider(Function<O, String> converter);
	public ListViewer<O, I, C> textProvider(Function<O, String> converter);
	public ListViewer<O, I, C> textStyleRangeProvider(Function<O, List<StyleRange>> converter);
	public ListViewer<O, I, C> graphicProvider(Function<O, String> converter);
}
