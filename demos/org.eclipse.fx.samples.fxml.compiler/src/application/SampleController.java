package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SampleController {

	@FXML Button myButton;

	@FXML public void helloWorld(ActionEvent event) {
		myButton.setText("Wow you pressed the button");
	}
	
}
