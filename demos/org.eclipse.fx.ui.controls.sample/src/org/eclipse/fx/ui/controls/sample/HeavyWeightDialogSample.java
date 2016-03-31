package org.eclipse.fx.ui.controls.sample;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.dialogs.TitleAreaDialog;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HeavyWeightDialogSample extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox container = new HBox();

		{
			Button b = new Button("Show TitleArea Dialog");
			b.setOnAction(e -> new SampleHeavyTitleAreaDialog(primaryStage).open());
			container.getChildren().add(b);
		}

		primaryStage.setScene(new Scene(container, 800, 600));
		primaryStage.show();
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
