package org.eclipse.fx.ui.viewer;

import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;



public interface Viewer<O, I, C extends ContentProvider<O, I>> {
	public void setContentProvider(@NonNull Supplier<C> contentProvider);
	public void setInput(@NonNull Supplier<I> input);
}
