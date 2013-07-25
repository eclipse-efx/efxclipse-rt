package org.eclipse.fx.testcases.fxgraph.realworld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

public class GoogleGroupSample {
	@FXML
	private Label message;

	@FXML
	private PasswordField pb;

	@FXML
	public void onAction(ActionEvent event) {
		if (!pb.getText().equals("T2f$Ay!")) {
			message.setText("Your password is incorrect!");
			message.setTextFill(Color.rgb(210, 39, 30));
		} else {
			message.setText("Your password has been confirmed");
			message.setTextFill(Color.rgb(21, 117, 84));
		}
		pb.setText("");
	}
}
