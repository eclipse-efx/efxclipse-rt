package org.eclipse.fx.ui.viewer.javafx.impl;

import java.util.function.Supplier;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

import org.eclipse.fx.ui.viewer.ContentProvider;
import org.eclipse.fx.ui.viewer.Viewer;
import org.eclipse.jdt.annotation.NonNull;

public abstract class FXViewer<I,O,C extends ContentProvider<I, O>> implements Viewer<I, O, C> {
	protected ObjectProperty<C> contentProvider = new SimpleObjectProperty<>();
	
	@Override
	public void setContentProvider(@NonNull Supplier<C> contentProvider) {
		this.contentProvider.set(contentProvider.get());
	}
	
	protected ObjectProperty<C> getContentProvider() {
		return contentProvider;
	}

	@Override
	public void setInput(Supplier<I> input) {
		this.contentProvider.get().setInput(input.get());
		
	}
	
	public abstract Node getNode();
}
