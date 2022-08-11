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
package org.eclipse.fx.testcases.e4.decoration;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;

@SuppressWarnings("restriction")
public class DecorationController implements Initializable {
	private double mouseDragOffsetX = 0;
	private double mouseDragOffsetY = 0;

	@FXML
	private ToolBar decorationArea;
	
	private Rectangle2D backupWindowBounds;
	
	@Inject
	@Named("fx.rendering.domElement")
	@Optional
	MWindow window;
	
	public DecorationController() {
		System.err.println("Creating controller ....");
	}

	public void initialize(URL location, ResourceBundle resources) {
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
	
	@FXML
	public void handleFullScreen(MouseEvent event) {
		if( event.getClickCount() > 1 ) {
			String fullscreen = window.getPersistedState().get("efx.window.fullscreen");
			boolean current = fullscreen != null && Boolean.parseBoolean(fullscreen);
			System.err.println("New value: " + Boolean.valueOf(!current).toString());
			window.getPersistedState().put("efx.window.fullscreen", Boolean.valueOf(!current).toString());
		}
	}
	
	@FXML
	public void handleClose(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	public void handleMin(ActionEvent event) {
		getStage().setIconified(true);
	}
	
	@FXML
	public void handleMax(ActionEvent event) {
		Stage stage = getStage();
		final double stageY = stage.getY();
        final Screen screen = Screen.getScreensForRectangle(stage.getX(), stageY, 1, 1).get(0);
        Rectangle2D bounds = screen.getVisualBounds();
        if (bounds.getMinX() == stage.getX() && bounds.getMinY() == stageY &&
                bounds.getWidth() == stage.getWidth() && bounds.getHeight() == stage.getHeight()) {
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
