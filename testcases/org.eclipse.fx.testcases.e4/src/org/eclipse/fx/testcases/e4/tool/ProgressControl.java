package org.eclipse.fx.testcases.e4.tool;

import javax.annotation.PostConstruct;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class ProgressControl {
	@PostConstruct
	public void init(Group g) {
		HBox b = new HBox();
		ProgressBar bar = new ProgressBar();
		b.getChildren().add(new Label("Bla Bla"));
		b.getChildren().add(bar);
		g.getChildren().add(b);
	}
}
