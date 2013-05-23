package org.eclipse.fx.demo.e4.parts;

import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

public class PersonDetailPart {

	@PostConstruct
	void init(BorderPane parent, @FXMLLoader FXMLLoaderFactory factory) {
		try {
			FXMLBuilder<Node> builder = factory.loadRequestorRelative("personform.fxml");
			parent.setCenter(builder.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
