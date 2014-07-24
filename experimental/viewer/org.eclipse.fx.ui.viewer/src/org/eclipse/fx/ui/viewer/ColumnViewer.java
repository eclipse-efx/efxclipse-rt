package org.eclipse.fx.ui.viewer;

import java.util.function.Function;

public interface ColumnViewer<O, I, C extends ContentProvider<O, I>> extends Viewer<O, I, C> {
	public <T> ViewerColumn<O,T> createColumn(String id, Function<O, T> cellDataProvider);
}
