package org.eclipse.fx.testcases.e4.parts;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import org.eclipse.fx.core.fxml.FXMLDocument;

public class TestFXML extends FXMLDocument<HBox> {

	@Override
	public HBox load(URL location, ResourceBundle bundle,
			Callback<Class<?>, Object> controllerFactory) {
		HBox b = new HBox();
		b.getChildren().add(new Button("This is the Java class"));
		return b;
	}

	@Override
	public Object getController() {
		return null;
	}

}
