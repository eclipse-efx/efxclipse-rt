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
package org.eclipse.fx.code.compensator.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation.Status;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.service.event.Event;

public class ApplicationDecorationController implements Initializable {
	@Inject
	private IEventBroker broker;
	
	@FXML 
	Label messageCenter;

	private VBox box;
	
	private boolean clearOnChange;

	private TranslateTransition pendingMessageAnimation;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Tooltip tip = new Tooltip();
		tip.setOnShown(this::handleShow);
		box = new VBox();
//		box.getChildren().add(new Label("No messages pending"));
		tip.setGraphic(box);
		messageCenter.setTooltip(tip);
		
		broker.subscribe("org/eclipse/fx/code/compensator/editor/Language/installed", this::handleLanguageInstall);
		broker.subscribe("org/eclipse/fx/code/compensator/cibundleinfo", this::handleCiBuild);
	}

	private void handleLanguageInstall(Event event) {
		Platform.runLater(() -> {
			Label l = new Label();
			l.setText("New syntax highlight for '"+event.getProperty(IEventBroker.DATA)+"' has been installed");
			l.getStyleClass().add("message-center-info");
			addMessage(l);			
		});
	}
	
	private void handleCiBuild(Event event) {
		Platform.runLater(() -> {
			Label l = new Label();
			if( "success".equals(event.getProperty(IEventBroker.DATA))) {
				l.setText("CI Build succeeded");
				l.getStyleClass().add("message-center-info");
			} else {
				l.setText("CI Build failed");
				l.getStyleClass().add("message-center-error");
			}
			
			
			l.getStyleClass().add("message-center-info");
			addMessage(l);
		});
	}
	
	private void handleShow(WindowEvent evt) {
		clearOnChange = true;
		if( pendingMessageAnimation != null ) {
			pendingMessageAnimation.stop();
			messageCenter.setTranslateY(0);
		}
		
		messageCenter.getStyleClass().remove("infopending");
	}
	
	private void addMessage(Node node) {
		if( clearOnChange ) {
			box.getChildren().clear();
			clearOnChange = false;			
		}
		
		if( pendingMessageAnimation == null || pendingMessageAnimation.getStatus() == Status.STOPPED ) {
			messageCenter.getStyleClass().add("infopending");
			pendingMessageAnimation = new TranslateTransition(Duration.millis(500),messageCenter);
			pendingMessageAnimation.setByY(-5);
			pendingMessageAnimation.setCycleCount(TranslateTransition.INDEFINITE);
			pendingMessageAnimation.setAutoReverse(true);
			pendingMessageAnimation.play();
		}
		
		box.getChildren().add(node);
	}
}
