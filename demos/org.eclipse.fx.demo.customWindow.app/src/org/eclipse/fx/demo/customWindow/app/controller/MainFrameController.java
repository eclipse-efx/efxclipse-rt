package org.eclipse.fx.demo.customWindow.app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.eclipse.fx.core.event.EventBus;
import org.eclipse.fx.demo.customWindow.app.CustomWindowDemoConstants;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class MainFrameController implements Initializable {
	
	@Inject private EventBus eventBus;
	
	@FXML TextField searchField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		searchField.textProperty().addListener((o, oV, nV) -> {
			eventBus.publish(CustomWindowDemoConstants.TOPIC_SEARCH, nV, true);
		});
	}

}
