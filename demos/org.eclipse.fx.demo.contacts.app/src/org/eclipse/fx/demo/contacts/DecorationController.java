package org.eclipse.fx.demo.contacts;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;

public class DecorationController {
	private double mouseDragOffsetX = 0;
	private double mouseDragOffsetY = 0;

	@FXML
	private ToolBar decorationArea;

	private Rectangle2D backupWindowBounds;

	public DecorationController() {
	}

	@PostConstruct
	void init() {
		decorationArea.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				mouseDragOffsetX = event.getSceneX();
				mouseDragOffsetY = event.getSceneY();
			}
		});
		decorationArea.setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Stage w = getStage();
				w.setX(event.getScreenX() - mouseDragOffsetX);
				w.setY(event.getScreenY() - mouseDragOffsetY);
			}
		});
	}

	public void handleClose(ActionEvent event) {
		Platform.exit();
	}

	public void handleMin(ActionEvent event) {
		getStage().setIconified(true);
	}

	public void handleMax(ActionEvent event) {
		Stage stage = getStage();
		final double stageY = stage.getY();
		final Screen screen = Screen.getScreensForRectangle(stage.getX(), stageY, 1, 1).get(0);
		Rectangle2D bounds = screen.getVisualBounds();
		if (bounds.getMinX() == stage.getX() && bounds.getMinY() == stageY && bounds.getWidth() == stage.getWidth()
				&& bounds.getHeight() == stage.getHeight()) {
			if (backupWindowBounds != null) {
				stage.setX(backupWindowBounds.getMinX());
				stage.setY(backupWindowBounds.getMinY());
				stage.setWidth(backupWindowBounds.getWidth());
				stage.setHeight(backupWindowBounds.getHeight());
			}
		} else {
			backupWindowBounds = new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());
			final double newStageY = screen.getVisualBounds().getMinY();
			stage.setX(screen.getVisualBounds().getMinX());
			stage.setY(newStageY);
			stage.setWidth(screen.getVisualBounds().getWidth());
			stage.setHeight(screen.getVisualBounds().getHeight());
		}
	}

	Stage getStage() {
		return (Stage) decorationArea.getScene().getWindow();
	}
}
