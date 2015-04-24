package org.eclipse.fx.testcases.e4.lightweight;

import org.eclipse.fx.ui.controls.stage.DefaultFramePane;
import org.eclipse.fx.ui.panes.FillLayoutPane;

import javafx.scene.control.Button;

public class SimpleWindow extends DefaultFramePane {
	public SimpleWindow() {
		super(new FillLayoutPane(),true);
		setTitle("Bla Bla Bla");
		setClientArea(new Button("Hello World!!!!"));
		setMaxSize(500, 500);
	}
}
