package org.eclipse.fx.testcases.e4.parts;

import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

public class TestFXMLBuilder {
	@PostConstruct
	public void init(BorderPane p, @FXMLLoader FXMLLoaderFactory factory) {
		FXMLBuilder<Node> b = factory.loadRequestorRelative("TestFXML.fxml");
		try {
			p.setCenter(b.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
