package org.eclipse.fx.testcases.fxgraph;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MyController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.err.println("The controller is created!!!");
	}

	/**
	 * This the click 1 method
	 * 
	 * @param event
	 *            the event
	 */
	@FXML
	public void clicked(ActionEvent event) {

	}

	/**
	 * This is the click 2 method
	 * 
	 * @param event
	 *            the event
	 */
	@FXML
	public void clicked2(ActionEvent event) {

	}

//	@FXML
//	public void clicked(String event) {
//
//	}
//
//	@FXML
//	public void clicked() {
//
//	}
}
