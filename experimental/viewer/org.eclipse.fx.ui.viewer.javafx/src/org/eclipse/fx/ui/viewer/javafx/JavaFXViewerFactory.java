package org.eclipse.fx.ui.viewer.javafx;

import java.util.function.Consumer;

import javafx.scene.layout.BorderPane;

import org.eclipse.fx.ui.viewer.ContentProvider;
import org.eclipse.fx.ui.viewer.ListViewer;
import org.eclipse.fx.ui.viewer.TableViewer;
import org.eclipse.fx.ui.viewer.ViewerFactory;
import org.eclipse.fx.ui.viewer.javafx.impl.FXListViewer;
import org.eclipse.fx.ui.viewer.javafx.impl.FXTableViewer;

public class JavaFXViewerFactory implements ViewerFactory {

	@Override
	public <I, O, C extends ContentProvider<I, O>, V extends TableViewer<I, O, C>, W> V createTableViewer(W ownerWidget, Consumer<V> setup) {
		FXTableViewer<I, O, C> fxTableViewer = new FXTableViewer<>();
		V v = (V) fxTableViewer;
		setup.accept(v);
		((BorderPane)ownerWidget).setCenter(fxTableViewer.getNode());
		return v;
	}

	@Override
	public <I, O, C extends ContentProvider<I, O>, V extends ListViewer<I, O, C>, W> V createListViewer(W ownerWidget, Consumer<V> setup) {
		FXListViewer<I, O, C> fxListViewer = new FXListViewer<>();
		V v = (V) fxListViewer;
		setup.accept(v);
		((BorderPane)ownerWidget).setCenter(fxListViewer.getNode());
		return v;
	}


}
