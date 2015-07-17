package org.eclipse.jface.viewers;

import javafx.scene.layout.AnchorPane;

public abstract class Viewer extends AnchorPane {
	protected void inputChanged(Object input, Object oldInput) {
    }
	
	public abstract void setInput(Object input);
}
