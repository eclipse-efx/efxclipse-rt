package org.eclipse.fx.ui.dialogs.sample;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.stage.FrameEvent;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LwDialogSample extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
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
		primaryStage.setScene(new Scene(pane,800,600));
		primaryStage.show();
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
}
