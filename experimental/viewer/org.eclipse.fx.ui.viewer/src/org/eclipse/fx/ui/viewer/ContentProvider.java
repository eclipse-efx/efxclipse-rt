package org.eclipse.fx.ui.viewer;

import java.util.List;

public interface ContentProvider<O,I> {
	public List<O> getRootElements(I input);
}