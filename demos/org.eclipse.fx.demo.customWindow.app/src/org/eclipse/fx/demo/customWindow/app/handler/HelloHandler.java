 
package org.eclipse.fx.demo.customWindow.app.handler;

import org.eclipse.e4.core.di.annotations.Execute;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class HelloHandler {
	
	@Execute
	public void execute() {
		new Alert(AlertType.INFORMATION, "Hello!", ButtonType.OK).showAndWait();
	}
		
}