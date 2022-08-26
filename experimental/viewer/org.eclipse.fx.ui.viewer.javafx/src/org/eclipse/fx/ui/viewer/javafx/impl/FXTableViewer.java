/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer.javafx.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import org.eclipse.fx.ui.viewer.ContentProvider;
import org.eclipse.fx.ui.viewer.StyleRange;
import org.eclipse.fx.ui.viewer.TableViewer;
import org.eclipse.fx.ui.viewer.ViewerColumn;

public class FXTableViewer<I, O, C extends ContentProvider<I, O>> extends FXColumnViewer<I, O, C> implements TableViewer<I, O, C> {
	private final TableView<O> tableView;
	
	public FXTableViewer() {
		tableView = new TableView<>();
	}
	
	@Override
	public <T> ViewerColumn<O, T> createColumn(String id, Function<O, T> cellDataProvider) {
		return new FXTableColumn<>(tableView, cellDataProvider);
	}
	
	@Override
	public void setInput(Supplier<I> input) {
		super.setInput(input);
		this.tableView.setItems(FXCollections.observableArrayList(new LazyList<I,O>(contentProvider)));
	}
	
	@Override
	public Node getNode() {
		return tableView;
	}

	private static class FXTableColumn<O,T> implements ViewerColumn<O, T> {
		private final TableView<O> tableView;
		private final TableColumn<O, String> tableColumn;
		private final Function<O, T> cellDataProvider;
		
		private BiFunction<O, T, String> textProvider;
		
		public FXTableColumn(TableView<O> tableView, Function<O, T> cellDataProvider) {
			this.tableView = tableView;
			this.cellDataProvider = cellDataProvider;
			
			this.tableColumn = new TableColumn<>();
			this.tableView.getColumns().add(tableColumn);
			this.tableColumn.setCellValueFactory(this::cellValueFactory);
		}
		
		private ObservableValue<String> cellValueFactory(CellDataFeatures<O, String> param) {
			T t = cellDataProvider.apply(param.getValue());
			String s = "";
			if( textProvider != null ) {
				s = textProvider.apply(param.getValue(), t);
			} else if( t != null ) {
				s = t.toString();
			}
			return new SimpleObjectProperty<String>(s);
		}
		
		@Override
		public ViewerColumn<O, T> setLabel(String label) {
			tableColumn.setText(label);
			return this;
		}

		@Override
		public ViewerColumn<O, T> styleProvider(BiFunction<O, T, String> converter) {
			// TODO Auto-generated method stub
			return this;
		}
		
		@Override
		public ViewerColumn<O, T> textProvider(Function<T, String> converter) {
			textProvider((o,t) -> converter.apply(t));
			return this;
		}

		@Override
		public ViewerColumn<O, T> textProvider(BiFunction<O, T, String> converter) {
			this.textProvider = converter;
			return this;
		}

		@Override
		public ViewerColumn<O, T> textStyleRangeProvider(BiFunction<O, T, List<StyleRange>> converter) {
			// TODO Auto-generated method stub
			return this;
		}

		@Override
		public ViewerColumn<O, T> graphicProvider(BiFunction<O, T, String> converter) {
			// TODO Auto-generated method stub
			return this;
		}
		
	}
}
