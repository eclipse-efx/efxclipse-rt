package org.eclipse.fx.ui.controls.sample;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.ui.controls.form.DefaultForm;
import org.eclipse.fx.ui.controls.form.StatusNode;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;
import org.eclipse.fx.ui.controls.form.Form.BindingConfiguration;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ValidationSample extends Application {

	static class VM {
		private StringProperty firstname = new SimpleStringProperty(this, "firstname");
		private StringProperty lastname = new SimpleStringProperty(this, "lastname");

		public VM(String firstname, String lastname) {
			this.firstname.set(firstname);
			this.lastname.set(lastname);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridLayoutPane p = new GridLayoutPane();
		p.setNumColumns(2);

		DefaultForm form = new DefaultForm();
		Label title = new Label("My Form");
		title.setGraphic(new StatusNode(form.validationStatusProperty()));
		title.setStyle("-fx-font-size: 2em; -fx-font-weight: bold;");

		GridLayoutPane.setConstraint(title, new GridData(Alignment.FILL,Alignment.CENTER,true,false,2,1));
		p.getChildren().add(title);

		VM vm = new VM("Tom", "Schindl");

		{
			Label l = new Label("Vorname");
			p.getChildren().add(l);

			TextField field = new TextField();
			p.getChildren().add(form.builder("firstname",field.textProperty(), vm.firstname, BindingConfiguration.VALIDATE_TO_OPPOSITE).decoratedNode(field)
				.decoratedNodeMutator(new GridData(GridData.FILL_HORIZONTAL), GridLayoutPane::setConstraint)
				.validator( s -> s.isEmpty() ? Status.status(State.ERROR, -1, "Vorname muß befüllt sein", null) : Status.ok())
				.build()
				.nodeWithStatus());
		}

		{
			Label l = new Label("Nachname");
			p.getChildren().add(l);

			TextField field = new TextField();
			p.getChildren().add(form.builder("lastname",field.textProperty(), vm.lastname, BindingConfiguration.VALIDATE_TO_OPPOSITE).decoratedNode(field)
				.decoratedNodeMutator(new GridData(GridData.FILL_HORIZONTAL), GridLayoutPane::setConstraint)
				.validator( s -> s.isEmpty() ? Status.status(State.ERROR, -1, "Nachname muß befüllt sein", null) : Status.ok())
				.build()
				.nodeWithStatus());
		}

		primaryStage.setScene(new Scene(p,800,600));
		primaryStage.show();
	}

}
