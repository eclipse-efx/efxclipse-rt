package org.eclipse.fx.ui.dialogs.sample;

import java.util.Optional;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.eclipse.fx.ui.dialogs.TaskProgressDialog;

public class TaskDialogDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(createContent(primaryStage), 420, 200));
		primaryStage.show();
	}

	private Parent createContent(Stage stage) {
		CheckBox cbCancelable = new CheckBox("Cancelable?");
		cbCancelable.setSelected(true);

		TextField stepInput = new TextField();
		stepInput.setPromptText("Enter a Number 1 - 100 to throw an Exception on that Step");
		IntegerBinding stepBinding = Bindings.createIntegerBinding(() -> {
			try {
				return Integer.parseInt(stepInput.getText());
			} catch (Exception e) {
				return 0;
			}
		}, stepInput.textProperty());

		Button openDlgBtn = new Button("Start long running task");
		openDlgBtn.setMaxWidth(Double.MAX_VALUE);
		openDlgBtn.setOnAction((event) -> {
			openDialog(stage, cbCancelable.isSelected(), stepBinding.get());
		});

		VBox box = new VBox(6);
		box.setPadding(new Insets(24));
		box.getChildren().addAll(openDlgBtn, cbCancelable, stepInput);
		return new BorderPane(box);
	}

	private void openDialog(Stage stage, boolean cancelable, int exceptionStep) {
		System.out.println("Opening Dialog ...");
		LongRunningTask task = new LongRunningTask();
		task.setExceptionStep(exceptionStep);

		TaskProgressDialog<Boolean> dialog = new TaskProgressDialog<Boolean>(stage, task);
		dialog.setCancelable(cancelable);
		dialog.setFailedHandler(exception -> {
			exception.printStackTrace();
			new Alert(AlertType.ERROR, exception.getMessage(), ButtonType.OK).showAndWait();
			return false;
		});
		Optional<Boolean> result = dialog.showAndWait();
		System.out.println("Result: " + result);
	}
}

class LongRunningTask extends Task<Boolean> {
	private IntegerProperty exceptionStep = new SimpleIntegerProperty(0);

	@Override
	protected Boolean call() throws Exception {
		System.out.println("Starting long running task ...");
		updateTitle("Long Runnning Task");
		for (int i = 0; i < 100; i++) {
			if (isCancelled())
				return false;
			if (i > 20) {
				updateTitle("Long Runnning Task - Rest");
				updateMessage("Processing Step Nr. "
						+ i
						+ " Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.");
			} else {
				updateTitle("Long Runnning Task - Step Nr. " + i);
				updateMessage("Processing Step Nr. " + i);
			}
			if (exceptionStep.getValue() > 0 && i == exceptionStep.getValue()) {
				throw new Exception("Exception on Step: " + i);
			}
			Thread.sleep(100);
			updateProgress(i + 1, 100);
		}
		System.out.println("Finished long running task.");
		return true;
	}

	public final IntegerProperty exceptionStepProperty() {
		return this.exceptionStep;
	}

	public final int getExceptionStep() {
		return this.exceptionStepProperty().get();
	}

	public final void setExceptionStep(final int exceptionStep) {
		this.exceptionStepProperty().set(exceptionStep);
	}
}
