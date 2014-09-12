package org.eclipse.fx.sample.e4swt.fx;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class FXView {
	@PostConstruct
	void init(BorderPane p) {
		p.setCenter(new Button("Hello JavaFX!"));
	}
}
