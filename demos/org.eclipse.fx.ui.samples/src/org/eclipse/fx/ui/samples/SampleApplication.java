package org.eclipse.fx.ui.samples;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.form.DefaultForm;
import org.eclipse.fx.ui.controls.form.Form.BindingConfiguration;
import org.eclipse.fx.ui.controls.form.StatusNode;
import org.eclipse.fx.ui.controls.stage.FrameEvent;
import org.eclipse.fx.ui.dialogs.TitleAreaDialog;
import org.eclipse.fx.ui.panes.GridData;
import org.eclipse.fx.ui.panes.GridData.Alignment;
import org.eclipse.fx.ui.panes.GridLayoutPane;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

@SuppressWarnings("restriction")
public class SampleApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TabPane pane = new TabPane();
		pane.getTabs().add(createHeavyWeightDialogs(primaryStage));
		pane.getTabs().add(createLWWeightDialogs());
		pane.getTabs().add(createValidation());
		primaryStage.setScene(new Scene(pane, 800, 600));
		primaryStage.show();
	}

	static class VM {
		private StringProperty firstname = new SimpleStringProperty(this, "firstname");
		private StringProperty lastname = new SimpleStringProperty(this, "lastname");

		public VM(String firstname, String lastname) {
			this.firstname.set(firstname);
			this.lastname.set(lastname);
		}
	}

	private Tab createValidation() {
		Tab t = new Tab("Validation");

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

		t.setContent(p);

		return t;
	}

	private Tab createLWWeightDialogs() {
		Tab t = new Tab("LW-weight Dialogs");

		StackPane pane = new StackPane();
		HBox container = new HBox();

		{
			Button b = new Button("LW Dialog");
			b.setOnAction(e -> {
				SampleLWTitleAreaDialog d = new SampleLWTitleAreaDialog();
				d.addEventHandler(FrameEvent.CLOSED, ev -> {
					pane.getChildren().remove(d);
				});
				pane.getChildren().add(d);
			});
			container.getChildren().add(b);
		}

		pane.getChildren().add(container);

		t.setContent(pane);

		return t;
	}

	private Tab createHeavyWeightDialogs(Stage s) {
		Tab t = new Tab("Heavy-weight Dialogs");

		HBox container = new HBox();

		{
			Button b = new Button("Show TitleArea Dialog");
			b.setOnAction(e -> new SampleHeavyTitleAreaDialog(s).open());
			container.getChildren().add(b);
		}

		t.setContent(container);

		return t;
	}


	static class SampleLWTitleAreaDialog extends org.eclipse.fx.ui.controls.dialog.TitleAreaDialog {
		private Subscription currentTempMessage;
		public SampleLWTitleAreaDialog() {
			super("Sample Dialog", "Sample Dialog", "This is a sample dialog");
			setPrefSize(500, 300);
			setClientArea(createClientArea());
			addDefaultButtons();
		}

		private Node createClientArea() {
			HBox box = new HBox();

			{
				Button b = new Button("Error");
				b.setOnAction(e -> currentTempMessage = showTemporaryErrorMessage("This is an error message"));
				box.getChildren().add(b);
			}

			{
				Button b = new Button("Warning");
				b.setOnAction(e -> currentTempMessage = showTemporaryWarningMessage("This is an warning message"));
				box.getChildren().add(b);
			}

			{
				Button b = new Button("Info");
				b.setOnAction(e -> currentTempMessage = showTemporaryInfoMessage("This is an info message"));
				box.getChildren().add(b);
			}

			{
				Button b = new Button("Reset");
				b.setOnAction(e -> {
					if (currentTempMessage != null) {
						currentTempMessage.dispose();
						currentTempMessage = null;
					}
				});
				box.getChildren().add(b);
			}
			return box;
		}
	}

	static class SampleHeavyTitleAreaDialog extends TitleAreaDialog {
		private Subscription currentTempMessage;

		public SampleHeavyTitleAreaDialog(Window parent) {
			super(parent, "Sample Dialog", "Sample Dialog", "This is a sample dialog", "sample-title-icon");
		}

		@Override
		protected Node createDialogContent() {
			HBox box = new HBox();

			{
				Button b = new Button("Error");
				b.setOnAction(e -> currentTempMessage = showTemporaryErrorMessage("This is an error message"));
				box.getChildren().add(b);
			}

			{
				Button b = new Button("Warning");
				b.setOnAction(e -> currentTempMessage = showTemporaryWarningMessage("This is an warning message"));
				box.getChildren().add(b);
			}

			{
				Button b = new Button("Info");
				b.setOnAction(e -> currentTempMessage = showTemporaryInfoMessage("This is an info message"));
				box.getChildren().add(b);
			}

			{
				Button b = new Button("Reset");
				b.setOnAction(e -> {
					if (currentTempMessage != null) {
						currentTempMessage.dispose();
						currentTempMessage = null;
					}
				});
				box.getChildren().add(b);
			}

			return box;
		}

	}
}
