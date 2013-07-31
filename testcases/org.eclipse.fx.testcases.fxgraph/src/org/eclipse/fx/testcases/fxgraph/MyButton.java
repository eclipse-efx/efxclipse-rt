package org.eclipse.fx.testcases.fxgraph;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Button;

public class MyButton extends Button {
	private SimpleDoubleProperty scaleFactor = new SimpleDoubleProperty(this,
			"scaleFactor", 1.0);

	public MyButton() {
		setText("This is my bu");
	}
	
	public final SimpleDoubleProperty scaleFactorProperty() {
		return scaleFactor;
	}

	public double getScaleFactor() {
		return scaleFactor.get();
	}

	public void setScaleFactor(double scale) {
		scaleFactor.set(scale);
	}
}
