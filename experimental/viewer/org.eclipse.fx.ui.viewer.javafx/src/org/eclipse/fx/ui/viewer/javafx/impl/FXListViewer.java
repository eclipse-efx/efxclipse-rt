package org.eclipse.fx.ui.viewer.javafx.impl;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import org.eclipse.fx.ui.viewer.ContentProvider;
import org.eclipse.fx.ui.viewer.ListViewer;
import org.eclipse.fx.ui.viewer.StyleRange;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class FXListViewer<I,O,C extends ContentProvider<I,O>> extends FXViewer<I, O, C> implements ListViewer<I, O, C> {
	private ListView<O> listView;
	
	private Function<@NonNull O, @Nullable String> textProvider;
	private Function<@NonNull O, @Nullable String> styleProvider;
	private Function<@NonNull O, @NonNull List<@NonNull StyleRange>> textStyleRangeProvider;
	private Function<@NonNull O, @Nullable String> graphicProvider;
	
	public FXListViewer() {
		this.listView = new ListView<>();
		this.listView.setCellFactory((v) -> new FXListCell());
	}
	
	@Override
	public ListViewer<I, O, C> textProvider(Function<@NonNull O, @Nullable String> converter) {
		this.textProvider = converter;
		return this;
	}

	@Override
	public ListViewer<I, O, C> styleProvider(Function<@NonNull O, @Nullable String> converter) {
		this.styleProvider = converter;
		return this;
	}

	@Override
	public ListViewer<I, O, C> textStyleRangeProvider(Function<@NonNull O, @NonNull List<@NonNull StyleRange>> converter) {
		this.textStyleRangeProvider = converter;
		return this;
	}

	@Override
	public ListViewer<I, O, C> graphicProvider(Function<@NonNull O, @Nullable String> converter) {
		this.graphicProvider = converter;
		return this;
	}
	
	@Override
	public void setInput(Supplier<I> input) {
		super.setInput(input);
		this.listView.setItems(FXCollections.observableArrayList(new LazyList<I,O>(contentProvider)));
	}
	
	@Override
	public Node getNode() {
		return this.listView;
	}
	
	class FXListCell extends ListCell<O> {
		
		@Override
		protected void updateItem(O item, boolean empty) {
			if( item != null && ! empty ) {
				if( textProvider != null ) {
					setText(textProvider.apply(item));
				}
//				if( graphicProvider != null ) {
//					setGraphic(value);
//				}
			} else {
				setText("");
				setGraphic(null);
			}
			super.updateItem(item, empty);
		}
	}
}