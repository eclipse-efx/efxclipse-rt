package org.eclipse.fx.ui.viewer;

import java.util.function.Consumer;

public interface ViewerFactory {
	public <O,I,C extends ContentProvider<O, I>, V extends TableViewer<O,I,C>,W> V createTableViewerViewer(W ownerWidget, Consumer<V> setup);
}
