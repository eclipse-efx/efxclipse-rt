package org.eclipse.fx.testcases.e4.lightweight;

import org.eclipse.fx.ui.controls.stage.DefaultFramePane;
import org.eclipse.fx.ui.panes.FillLayoutPane;

import javafx.scene.control.Button;

public class SimpleWindow extends DefaultFramePane {
	public SimpleWindow() {
		super(true);
		setTitle("Bla Bla Bla");
		FillLayoutPane fillLayoutPane = new FillLayoutPane();
		fillLayoutPane.setId("client-area");
		setContent(fillLayoutPane);
		setClientArea(new Button("Hello World!!!!"));
		setMaxSize(500, 500);
	}
}
