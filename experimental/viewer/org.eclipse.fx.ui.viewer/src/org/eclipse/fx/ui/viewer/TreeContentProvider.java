package org.eclipse.fx.ui.viewer;

import java.util.List;

public interface TreeContentProvider<O,I> extends ContentProvider<O, I> {
	public List<O> getChildren(O parent);
	public O getParent(O element);
	public boolean hasChildren(O element);
}
