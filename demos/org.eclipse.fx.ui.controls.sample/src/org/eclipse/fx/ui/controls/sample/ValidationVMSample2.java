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
package org.eclipse.fx.ui.controls.sample;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.property.StatusAggregator;
import org.eclipse.fx.core.property.ValidatedSimpleStringProperty;
import org.eclipse.fx.core.property.ValidatedStringProperty;
import org.eclipse.fx.ui.controls.form.NodeDecorator;
import org.eclipse.fx.ui.controls.form.StatusNode;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ValidationVMSample2 extends Application {

	static class VM {
		private final ValidatedStringProperty firstname;
		private final ValidatedStringProperty lastname;
		private final StatusAggregator aggregator;

		public VM(String firstname, String lastname) {
			this.firstname = new ValidatedSimpleStringProperty(new SimpleStringProperty(this, "firstname",firstname));
			this.firstname.registerValidator(s -> s.isEmpty() ? Status.status(State.ERROR, -1, "Vorname muß befüllt sein", null) : Status.ok());

			this.lastname = new ValidatedSimpleStringProperty(new SimpleStringProperty(this, "lastname", lastname));
			this.lastname.registerValidator(s -> s.isEmpty() ? Status.status(State.ERROR, -1, "Nachname muß befüllt sein", null) : Status.ok());

			this.aggregator = new StatusAggregator(this.firstname,this.lastname);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridLayoutPane p = new GridLayoutPane();
		p.setNumColumns(2);

		VM vm = new VM("Tom", "Schindl");

		Label title = new Label("My Form");
		title.setGraphic(new StatusNode(vm.aggregator.statusProperty()));
		title.setStyle("-fx-font-size: 2em; -fx-font-weight: bold;");

		GridLayoutPane.setConstraint(title, new GridData(Alignment.FILL,Alignment.CENTER,true,false,2,1));
		p.getChildren().add(title);


		{
			Label l = new Label("Vorname");
			p.getChildren().add(l);

			TextField field = new TextField();
			field.textProperty().bindBidirectional(vm.firstname.bindProperty());
			GridLayoutPane.setConstraint(field, new GridData(GridData.FILL_HORIZONTAL));

			NodeDecorator.apply(field, vm.firstname);
			p.getChildren().add(field);
		}

		{
			Label l = new Label("Nachname");
			p.getChildren().add(l);

			TextField field = new TextField();
			field.textProperty().bindBidirectional(vm.lastname.bindProperty());
			GridLayoutPane.setConstraint(field, new GridData(GridData.FILL_HORIZONTAL));

			NodeDecorator.apply(field, vm.lastname);
			p.getChildren().add(field);
		}

		primaryStage.setScene(new Scene(p,800,600));
		primaryStage.show();
	}
}
