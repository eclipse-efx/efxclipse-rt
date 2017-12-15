/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.demo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.observable.FXObservableUtil;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Demo application used to present the demos
 */
public class ControlsDemoApp extends Application {
	private Map<ControlDemo, Node> demoMap = new HashMap<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane p = new BorderPane();

		ListView<ControlDemo> list = new ListView<>();
		list.setCellFactory( CellImpl::new );
		list.setItems(FXCollections.observableArrayList(ServiceUtils.getServiceList(ControlDemo.class)));
		FXObservableUtil.onChange(list.getSelectionModel().selectedItemProperty(), cd -> {
			p.setCenter(this.demoMap.computeIfAbsent(cd, ControlDemo::createNode));
		});
		p.setLeft(list);

		Scene s = new Scene(p, 1024, 768);
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	static class CellImpl extends ListCell<ControlDemo> {
		public CellImpl(ListView<ControlDemo> v) {
			// empty
		}

		@Override
		protected void updateItem(ControlDemo item, boolean empty) {
			super.updateItem(item, empty);
			if( item != null && ! empty ) {
				setText(item.getLabel().toString());
			} else {
				setText(null);
			}
		}
	}
}
