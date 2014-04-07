package org.eclipse.fx.testcases.e4.parts;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import org.eclipse.fx.core.fxml.FXMLDocument;

public class TestFXML extends FXMLDocument<HBox> {

	@Override
	public Object getController() {
		return null;
	}

	@Override
	public HBox load(org.eclipse.fx.core.fxml.FXMLDocument.LoadData<HBox> data) {
		HBox b = new HBox();
		b.getChildren().add(new Button("This is the Java class"));
		return b;
	}

}
