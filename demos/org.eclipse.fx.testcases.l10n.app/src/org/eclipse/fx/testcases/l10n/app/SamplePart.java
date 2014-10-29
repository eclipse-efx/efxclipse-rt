package org.eclipse.fx.testcases.l10n.app;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class SamplePart {
	@PostConstruct
	void init(BorderPane parent) {
		parent.setCenter(new Label("Hello World"));
	}
}
