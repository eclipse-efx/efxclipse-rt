/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

@SuppressWarnings("javadoc")
public class MultiMessageDialogContent extends BorderPane {
		public final ListView<Row> tabView;

		public MultiMessageDialogContent(String message, Collection<MPart> parts, GraphicsLoader graphicsLoader) {
			Label l = new Label(message);
			setTop(l);

			this.tabView = new ListView<>();
			this.tabView.setCellFactory(v -> {
				return new CheckboxCell(graphicsLoader);
			});

			List<Row> list = new ArrayList<Row>();
			for (MPart m : parts) {
				list.add(new Row(m));
			}
			this.tabView.setItems(FXCollections.observableArrayList(list));
			setCenter(this.tabView);
		}
		
		static class CheckboxCell extends ListCell<Row> {
			private CheckBox checkbox = new CheckBox();
			private Row row;
			private GraphicsLoader loader;
			
			public CheckboxCell(GraphicsLoader loader) {
				this.loader = loader;
			}
			
			@SuppressWarnings("null")
			@Override
			protected void updateItem(Row item, boolean empty) {
				super.updateItem(item, empty);
				if( this.row != null ) {
					this.checkbox.selectedProperty().unbindBidirectional(this.row.selectedProperty());
				}
				this.row = item;
				if( this.row != null && ! empty ) {
					this.checkbox.selectedProperty().bindBidirectional(this.row.selectedProperty());
					String uri = item.getElement().getIconURI();
					Node n = null;
					if (uri != null) {
						n = this.loader.getGraphicsNode(new EMFUri(URI.createURI(uri)));
					}
					setGraphic(new HBox(this.checkbox,new Label(this.row.getElement().getLocalizedLabel(),n)));
				}
			}
		}
		
	}