package org.eclipse.fx.code.compensator.project;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class ProjectSecondaryToolbar {
	@PostConstruct
	public void init(BorderPane parent) {
		parent.setTop(new Label("2nd TB"));
	}

}
